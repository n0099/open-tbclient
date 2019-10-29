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
import com.baidu.tieba.model.ReportUserInfoModel;
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
/* loaded from: classes2.dex */
public class e {
    private static e eXl = null;
    private static final Random random = new Random();
    private final String oa = "c.tieba.baidu.com";
    private HashSet<String> eXm = new HashSet<>();
    private Map<String, List<DnsProxyResponseData.DnsProxyIpData>> eXn = new ConcurrentHashMap();
    private Map<String, List<DnsProxyResponseData.DnsProxyIpData>> eXo = new ConcurrentHashMap();
    private Map<String, List<DnsProxyResponseData.DnsProxyIpData>> eXp = new ConcurrentHashMap();
    private BroadcastReceiver eXq = new BroadcastReceiver() { // from class: com.baidu.tieba.dnsproxy.e.1
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
                            e.this.eXo.clear();
                            e.this.eXo.putAll(concurrentHashMap);
                            e.this.ja(true);
                        }
                    }
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    d.bcJ().ci("dpm_broadcast", th.getMessage());
                }
            }
        }
    };
    private CustomMessageListener eXr = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.dnsproxy.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                com.baidu.tieba.dnsproxy.a.d.bcX().bcY();
                e.this.bcL();
            }
        }
    };
    private CustomMessageListener eXs = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.dnsproxy.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(e.this.eXu);
                    DnsProxyStatic.bcP();
                    DnsProxyStatic.bcQ();
                    com.baidu.tieba.dnsproxy.a.c.bcT().bcV();
                    return;
                }
                e.this.bcL();
            }
        }
    };
    private Handler mHandler = null;
    private HandlerThread eXt = new HandlerThread(getClass().getName());
    private Runnable eXu = new Runnable() { // from class: com.baidu.tieba.dnsproxy.e.7
        @Override // java.lang.Runnable
        public void run() {
            e.this.bcL();
        }
    };
    private long eXv = 0;
    private c eXw = null;

    public static final e bcK() {
        if (eXl == null) {
            synchronized (e.class) {
                if (eXl == null) {
                    eXl = new e();
                }
            }
        }
        return eXl;
    }

    private e() {
        this.eXt.start();
    }

    public void m(final Runnable runnable) {
        if (runnable != null) {
            if (this.mHandler == null) {
                if (this.eXt.getLooper() != null) {
                    this.mHandler = new Handler(this.eXt.getLooper());
                    this.mHandler.post(runnable);
                }
                com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.dnsproxy.e.6
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.m(runnable);
                    }
                }, 100L);
                return;
            }
            this.mHandler.post(runnable);
        }
    }

    protected void bcL() {
        bcM();
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.eXu);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.eXu, ReportUserInfoModel.TIME_INTERVAL);
    }

    private void bcM() {
        new g() { // from class: com.baidu.tieba.dnsproxy.e.8
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: p */
            public void onPostExecute(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
                super.onPostExecute(hashMap);
                e.this.eXp.clear();
                if (hashMap != null) {
                    e.this.eXp.putAll(hashMap);
                    e.this.ja(false);
                }
            }
        }.execute(new HashSet(this.eXm));
    }

    public void iZ(final boolean z) {
        if (z || TbadkCoreApplication.getInst().isMainProcess(false)) {
            if (!l.isMainThread()) {
                com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.dnsproxy.e.9
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.iZ(z);
                    }
                });
            } else if (this.eXw == null && System.currentTimeMillis() - this.eXv >= 5000) {
                if (!z) {
                    this.eXv = System.currentTimeMillis();
                }
                this.eXw = new c(z) { // from class: com.baidu.tieba.dnsproxy.e.10
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    /* renamed from: p */
                    public void onPostExecute(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
                        super.onPostExecute(hashMap);
                        e.this.eXw = null;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    /* renamed from: a */
                    public void onProgressUpdate(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>>... hashMapArr) {
                        super.onProgressUpdate(hashMapArr);
                        if (hashMapArr != null && hashMapArr.length > 0) {
                            if (hashMapArr[0] != null) {
                                q(hashMapArr[0]);
                            } else if (this.eXj) {
                                e.this.eXw = null;
                                e.this.iZ(false);
                            }
                        } else if (this.eXj) {
                            e.this.eXw = null;
                            e.this.iZ(false);
                        }
                    }

                    private void q(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
                        e.this.eXo.clear();
                        if (hashMap != null) {
                            e.this.eXo.putAll(hashMap);
                            e.this.ja(true);
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
                                com.baidu.adp.lib.g.f.sendBroadcast(TbadkCoreApplication.getInst().getContext(), intent);
                            }
                        }
                    }
                };
                this.eXw.execute(new HashSet(this.eXm));
            }
        }
    }

    public void start() {
        this.eXm.add("c.tieba.baidu.com");
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().unRegisterListener(this.eXr);
            MessageManager.getInstance().registerListener(this.eXr);
        }
        MessageManager.getInstance().unRegisterListener(this.eXs);
        MessageManager.getInstance().registerListener(this.eXs);
        com.baidu.tieba.dnsproxy.a.d.bcX().open();
        com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.dnsproxy.e.11
            @Override // java.lang.Runnable
            public void run() {
                e.this.bcL();
            }
        });
        iZ(true);
        if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.eXq);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.dnsproxy.dnsproxydata");
            TbadkCoreApplication.getInst().registerReceiver(this.eXq, intentFilter);
        }
    }

    public void close() {
        this.eXm.clear();
        com.baidu.tieba.dnsproxy.a.d.bcX().close();
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.eXu);
        MessageManager.getInstance().unRegisterListener(this.eXr);
        MessageManager.getInstance().unRegisterListener(this.eXs);
        TbadkCoreApplication.getInst().unregisterReceiver(this.eXq);
    }

    public String ac(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.eXm.contains(str)) {
            String a = a(str, this.eXn, z);
            if (TextUtils.isEmpty(a)) {
                return a(str, this.eXo, z);
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
                if (random.nextFloat() < com.baidu.tieba.dnsproxy.a.d.bcX().cz("c.tieba.baidu.com", ip)) {
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
                                    return com.baidu.tieba.dnsproxy.a.d.bcX().cA(str, dnsProxyIpData.getIp()) - com.baidu.tieba.dnsproxy.a.d.bcX().cA(str, dnsProxyIpData2.getIp()) < 0.0f ? -1 : 1;
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
                                    return com.baidu.tieba.dnsproxy.a.d.bcX().cz(str, dnsProxyIpData.getIp()) - com.baidu.tieba.dnsproxy.a.d.bcX().cz(str, dnsProxyIpData2.getIp()) < 0.0f ? 1 : -1;
                                }
                                return 1;
                            }
                            return -1;
                        }
                    });
                }
                for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : list) {
                    if (dnsProxyIpData != null && h.uN(dnsProxyIpData.getIp())) {
                        String ip2 = dnsProxyIpData.getIp();
                        if (random.nextFloat() < com.baidu.tieba.dnsproxy.a.d.bcX().cz("c.tieba.baidu.com", ip2)) {
                            return ip2;
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja(boolean z) {
        Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map;
        Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map2;
        if (z) {
            Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map3 = this.eXo;
            map = this.eXp;
            map2 = map3;
        } else {
            Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map4 = this.eXp;
            map = this.eXo;
            map2 = map4;
        }
        for (String str : map2.keySet()) {
            List<DnsProxyResponseData.DnsProxyIpData> list = map2.get(str);
            List<DnsProxyResponseData.DnsProxyIpData> list2 = map.get(str);
            HashSet<String> hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            if (list != null) {
                for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : list) {
                    if (dnsProxyIpData != null && h.uN(dnsProxyIpData.getIp())) {
                        hashSet2.add(dnsProxyIpData.getIp());
                    }
                }
            }
            if (list2 != null) {
                for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData2 : list2) {
                    if (dnsProxyIpData2 != null && h.uN(dnsProxyIpData2.getIp()) && hashSet2.contains(dnsProxyIpData2.getIp())) {
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
            this.eXn.put(str, arrayList);
        }
    }
}
