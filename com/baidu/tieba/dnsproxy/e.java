package com.baidu.tieba.dnsproxy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tieba.dnsproxy.DnsProxyResponseData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
/* loaded from: classes13.dex */
public class e {
    private static e hdQ = null;
    private static final Random random = new Random();
    private final String JP = "c.tieba.baidu.com";
    private HashSet<String> hdR = new HashSet<>();
    private Map<String, List<DnsProxyResponseData.DnsProxyIpData>> hdS = new ConcurrentHashMap();
    private Map<String, List<DnsProxyResponseData.DnsProxyIpData>> hdT = new ConcurrentHashMap();
    private Map<String, List<DnsProxyResponseData.DnsProxyIpData>> hdU = new ConcurrentHashMap();
    private BroadcastReceiver hdV = new BroadcastReceiver() { // from class: com.baidu.tieba.dnsproxy.e.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "com.baidu.tieba.dnsproxy.dnsproxydata".equals(intent.getAction())) {
                try {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                        for (String str : extras.keySet()) {
                            JSONArray jSONArray = new JSONArray(extras.getString(str));
                            int length = jSONArray.length();
                            ArrayList arrayList = new ArrayList();
                            for (int i = 0; i < length; i++) {
                                DnsProxyResponseData.DnsProxyIpData dnsProxyIpData = (DnsProxyResponseData.DnsProxyIpData) DnsProxyResponseData.DnsProxyIpData.objectWithJson(jSONArray.getJSONObject(i), DnsProxyResponseData.DnsProxyIpData.class);
                                if (dnsProxyIpData != null) {
                                    arrayList.add(dnsProxyIpData);
                                }
                            }
                            concurrentHashMap.put(str, arrayList);
                        }
                        if (concurrentHashMap.size() > 0) {
                            e.this.hdT.clear();
                            e.this.hdT.putAll(concurrentHashMap);
                            e.this.mT(true);
                        }
                    }
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    d.bTp().dY("dpm_broadcast", th.getMessage());
                }
            }
        }
    };
    private CustomMessageListener hdW = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.dnsproxy.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                com.baidu.tieba.dnsproxy.a.d.bTD().bTE();
                e.this.bTr();
            }
        }
    };
    private CustomMessageListener hdX = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.dnsproxy.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(e.this.hdZ);
                    DnsProxyStatic.bTv();
                    DnsProxyStatic.bTw();
                    com.baidu.tieba.dnsproxy.a.c.bTz().bTB();
                    return;
                }
                e.this.bTr();
            }
        }
    };
    private Handler mHandler = null;
    private HandlerThread hdY = new HandlerThread(getClass().getName());
    private Runnable hdZ = new Runnable() { // from class: com.baidu.tieba.dnsproxy.e.7
        @Override // java.lang.Runnable
        public void run() {
            e.this.bTr();
        }
    };
    private long hea = 0;
    private c heb = null;

    public static final e bTq() {
        if (hdQ == null) {
            synchronized (e.class) {
                if (hdQ == null) {
                    hdQ = new e();
                }
            }
        }
        return hdQ;
    }

    private e() {
        this.hdY.start();
    }

    public void v(final Runnable runnable) {
        if (runnable != null) {
            if (this.mHandler == null) {
                if (this.hdY.getLooper() != null) {
                    this.mHandler = new Handler(this.hdY.getLooper());
                    this.mHandler.post(runnable);
                }
                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.dnsproxy.e.6
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.v(runnable);
                    }
                }, 100L);
                return;
            }
            this.mHandler.post(runnable);
        }
    }

    protected void bTr() {
        bTs();
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.hdZ);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.hdZ, 300000L);
    }

    private void bTs() {
        new g() { // from class: com.baidu.tieba.dnsproxy.e.8
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: E */
            public void onPostExecute(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
                super.onPostExecute(hashMap);
                e.this.hdU.clear();
                if (hashMap != null) {
                    e.this.hdU.putAll(hashMap);
                    e.this.mT(false);
                }
            }
        }.execute(new HashSet(this.hdR));
    }

    public void mS(final boolean z) {
        if (z || TbadkCoreApplication.getInst().isMainProcess(false)) {
            if (!l.isMainThread()) {
                com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.dnsproxy.e.9
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.mS(z);
                    }
                });
            } else if (this.heb == null && System.currentTimeMillis() - this.hea >= 5000) {
                if (!z) {
                    this.hea = System.currentTimeMillis();
                }
                this.heb = new c(z) { // from class: com.baidu.tieba.dnsproxy.e.10
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    /* renamed from: E */
                    public void onPostExecute(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
                        super.onPostExecute(hashMap);
                        e.this.heb = null;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    /* renamed from: a */
                    public void onProgressUpdate(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>>... hashMapArr) {
                        super.onProgressUpdate(hashMapArr);
                        if (hashMapArr != null && hashMapArr.length > 0) {
                            if (hashMapArr[0] != null) {
                                F(hashMapArr[0]);
                            } else if (this.aqU) {
                                e.this.heb = null;
                                e.this.mS(false);
                            }
                        } else if (this.aqU) {
                            e.this.heb = null;
                            e.this.mS(false);
                        }
                    }

                    private void F(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
                        e.this.hdT.clear();
                        if (hashMap != null) {
                            e.this.hdT.putAll(hashMap);
                            e.this.mT(true);
                            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                                Intent intent = new Intent();
                                intent.setAction("com.baidu.tieba.dnsproxy.dnsproxydata");
                                for (Map.Entry<String, List<DnsProxyResponseData.DnsProxyIpData>> entry : hashMap.entrySet()) {
                                    JSONArray jSONArray = new JSONArray();
                                    for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : entry.getValue()) {
                                        try {
                                            jSONArray.put(DnsProxyResponseData.DnsProxyIpData.jsonWithObject(dnsProxyIpData));
                                        } catch (Throwable th) {
                                            BdLog.detailException(th);
                                        }
                                    }
                                    intent.putExtra(entry.getKey(), jSONArray.toString());
                                }
                                intent.setPackage(TbadkCoreApplication.getInst().getContext().getPackageName());
                                com.baidu.adp.lib.f.f.sendBroadcast(TbadkCoreApplication.getInst().getContext(), intent);
                            }
                        }
                    }
                };
                this.heb.execute(new HashSet(this.hdR));
            }
        }
    }

    public void start() {
        this.hdR.add("c.tieba.baidu.com");
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().unRegisterListener(this.hdW);
            MessageManager.getInstance().registerListener(this.hdW);
        }
        MessageManager.getInstance().unRegisterListener(this.hdX);
        MessageManager.getInstance().registerListener(this.hdX);
        com.baidu.tieba.dnsproxy.a.d.bTD().open();
        com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.dnsproxy.e.11
            @Override // java.lang.Runnable
            public void run() {
                e.this.bTr();
            }
        });
        mS(true);
        if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.hdV);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.dnsproxy.dnsproxydata");
            TbadkCoreApplication.getInst().registerReceiver(this.hdV, intentFilter);
        }
    }

    public void close() {
        this.hdR.clear();
        com.baidu.tieba.dnsproxy.a.d.bTD().close();
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.hdZ);
        MessageManager.getInstance().unRegisterListener(this.hdW);
        MessageManager.getInstance().unRegisterListener(this.hdX);
        TbadkCoreApplication.getInst().unregisterReceiver(this.hdV);
    }

    public String az(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.hdR.contains(str)) {
            String a = a(str, this.hdS, z);
            if (TextUtils.isEmpty(a)) {
                return a(str, this.hdT, z);
            }
            return a;
        }
        return null;
    }

    private String a(final String str, Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map, boolean z) {
        if (TextUtils.isEmpty(str) || map == null) {
            return null;
        }
        List<DnsProxyResponseData.DnsProxyIpData> list = map.get(str);
        if (list != null && list.size() > 0) {
            if (list.size() == 1) {
                String ip = list.get(0).getIp();
                if (random.nextFloat() < com.baidu.tieba.dnsproxy.a.d.bTD().dZ("c.tieba.baidu.com", ip)) {
                    return ip;
                }
            } else {
                if (z) {
                    Collections.sort(list, new Comparator<DnsProxyResponseData.DnsProxyIpData>() { // from class: com.baidu.tieba.dnsproxy.e.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        /* renamed from: a */
                        public int compare(DnsProxyResponseData.DnsProxyIpData dnsProxyIpData, DnsProxyResponseData.DnsProxyIpData dnsProxyIpData2) {
                            if (dnsProxyIpData == null && dnsProxyIpData2 == null) {
                                return 0;
                            }
                            if (dnsProxyIpData != null || dnsProxyIpData2 == null) {
                                if (dnsProxyIpData == null || dnsProxyIpData2 != null) {
                                    return com.baidu.tieba.dnsproxy.a.d.bTD().ea(str, dnsProxyIpData.getIp()) - com.baidu.tieba.dnsproxy.a.d.bTD().ea(str, dnsProxyIpData2.getIp()) < 0.0f ? -1 : 1;
                                }
                                return -1;
                            }
                            return 1;
                        }
                    });
                } else {
                    Collections.sort(list, new Comparator<DnsProxyResponseData.DnsProxyIpData>() { // from class: com.baidu.tieba.dnsproxy.e.3
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        /* renamed from: a */
                        public int compare(DnsProxyResponseData.DnsProxyIpData dnsProxyIpData, DnsProxyResponseData.DnsProxyIpData dnsProxyIpData2) {
                            if (dnsProxyIpData == null && dnsProxyIpData2 == null) {
                                return 0;
                            }
                            if (dnsProxyIpData != null || dnsProxyIpData2 == null) {
                                if (dnsProxyIpData == null || dnsProxyIpData2 != null) {
                                    return com.baidu.tieba.dnsproxy.a.d.bTD().dZ(str, dnsProxyIpData.getIp()) - com.baidu.tieba.dnsproxy.a.d.bTD().dZ(str, dnsProxyIpData2.getIp()) < 0.0f ? 1 : -1;
                                }
                                return 1;
                            }
                            return -1;
                        }
                    });
                }
                for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : list) {
                    if (dnsProxyIpData != null && h.EM(dnsProxyIpData.getIp())) {
                        String ip2 = dnsProxyIpData.getIp();
                        if (random.nextFloat() < com.baidu.tieba.dnsproxy.a.d.bTD().dZ("c.tieba.baidu.com", ip2)) {
                            return ip2;
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mT(boolean z) {
        Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map;
        Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map2;
        if (z) {
            Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map3 = this.hdT;
            map = this.hdU;
            map2 = map3;
        } else {
            Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map4 = this.hdU;
            map = this.hdT;
            map2 = map4;
        }
        for (String str : map2.keySet()) {
            List<DnsProxyResponseData.DnsProxyIpData> list = map2.get(str);
            List<DnsProxyResponseData.DnsProxyIpData> list2 = map.get(str);
            HashSet<String> hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            if (list != null) {
                for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : list) {
                    if (dnsProxyIpData != null && h.EM(dnsProxyIpData.getIp())) {
                        hashSet2.add(dnsProxyIpData.getIp());
                    }
                }
            }
            if (list2 != null) {
                for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData2 : list2) {
                    if (dnsProxyIpData2 != null && h.EM(dnsProxyIpData2.getIp()) && hashSet2.contains(dnsProxyIpData2.getIp())) {
                        hashSet.add(dnsProxyIpData2.getIp());
                    }
                }
            }
            ArrayList arrayList = new ArrayList(hashSet.size());
            for (String str2 : hashSet) {
                DnsProxyResponseData.DnsProxyIpData dnsProxyIpData3 = new DnsProxyResponseData.DnsProxyIpData();
                dnsProxyIpData3.setIp(str2);
                arrayList.add(dnsProxyIpData3);
            }
            this.hdS.put(str, arrayList);
        }
    }
}
