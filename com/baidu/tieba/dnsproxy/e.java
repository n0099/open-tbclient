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
    private static e ifo = null;
    private static final Random random = new Random();
    private final String KR = "c.tieba.baidu.com";
    private HashSet<String> ifp = new HashSet<>();
    private Map<String, List<DnsProxyResponseData.DnsProxyIpData>> ifq = new ConcurrentHashMap();
    private Map<String, List<DnsProxyResponseData.DnsProxyIpData>> ifr = new ConcurrentHashMap();
    private Map<String, List<DnsProxyResponseData.DnsProxyIpData>> ifs = new ConcurrentHashMap();
    private BroadcastReceiver ift = new BroadcastReceiver() { // from class: com.baidu.tieba.dnsproxy.e.1
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
                            e.this.ifr.clear();
                            e.this.ifr.putAll(concurrentHashMap);
                            e.this.oL(true);
                        }
                    }
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    d.cpV().eG("dpm_broadcast", th.getMessage());
                }
            }
        }
    };
    private CustomMessageListener ifu = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.dnsproxy.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable()) {
                com.baidu.tieba.dnsproxy.a.d.cqj().cqk();
                e.this.cpX();
            }
        }
    };
    private CustomMessageListener ifv = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.dnsproxy.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(e.this.ifw);
                    DnsProxyStatic.cqb();
                    DnsProxyStatic.cqc();
                    com.baidu.tieba.dnsproxy.a.c.cqf().cqh();
                    return;
                }
                e.this.cpX();
            }
        }
    };
    private Handler mHandler = null;
    private HandlerThread handlerThread = new HandlerThread(getClass().getName());
    private Runnable ifw = new Runnable() { // from class: com.baidu.tieba.dnsproxy.e.7
        @Override // java.lang.Runnable
        public void run() {
            e.this.cpX();
        }
    };
    private long ifx = 0;
    private c ify = null;

    public static final e cpW() {
        if (ifo == null) {
            synchronized (e.class) {
                if (ifo == null) {
                    ifo = new e();
                }
            }
        }
        return ifo;
    }

    private e() {
        this.handlerThread.start();
    }

    public void s(final Runnable runnable) {
        if (runnable != null) {
            if (this.mHandler == null) {
                if (this.handlerThread.getLooper() != null) {
                    this.mHandler = new Handler(this.handlerThread.getLooper());
                    this.mHandler.post(runnable);
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.dnsproxy.e.6
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.s(runnable);
                    }
                }, 100L);
                return;
            }
            this.mHandler.post(runnable);
        }
    }

    protected void cpX() {
        cpY();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.ifw);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.ifw, 300000L);
    }

    private void cpY() {
        new g() { // from class: com.baidu.tieba.dnsproxy.e.8
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: E */
            public void onPostExecute(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
                super.onPostExecute(hashMap);
                e.this.ifs.clear();
                if (hashMap != null) {
                    e.this.ifs.putAll(hashMap);
                    e.this.oL(false);
                }
            }
        }.execute(new HashSet(this.ifp));
    }

    public void oK(final boolean z) {
        if (z || TbadkCoreApplication.getInst().isMainProcess(false)) {
            if (!l.isMainThread()) {
                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.dnsproxy.e.9
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.oK(z);
                    }
                });
            } else if (this.ify == null && System.currentTimeMillis() - this.ifx >= 5000) {
                if (!z) {
                    this.ifx = System.currentTimeMillis();
                }
                this.ify = new c(z) { // from class: com.baidu.tieba.dnsproxy.e.10
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    /* renamed from: E */
                    public void onPostExecute(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
                        super.onPostExecute(hashMap);
                        e.this.ify = null;
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
                            } else if (this.useCache) {
                                e.this.ify = null;
                                e.this.oK(false);
                            }
                        } else if (this.useCache) {
                            e.this.ify = null;
                            e.this.oK(false);
                        }
                    }

                    private void F(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
                        e.this.ifr.clear();
                        if (hashMap != null) {
                            e.this.ifr.putAll(hashMap);
                            e.this.oL(true);
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
                this.ify.execute(new HashSet(this.ifp));
            }
        }
    }

    public void start() {
        this.ifp.add("c.tieba.baidu.com");
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().unRegisterListener(this.ifu);
            MessageManager.getInstance().registerListener(this.ifu);
        }
        MessageManager.getInstance().unRegisterListener(this.ifv);
        MessageManager.getInstance().registerListener(this.ifv);
        com.baidu.tieba.dnsproxy.a.d.cqj().open();
        com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.dnsproxy.e.11
            @Override // java.lang.Runnable
            public void run() {
                e.this.cpX();
            }
        });
        oK(true);
        if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.ift);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.dnsproxy.dnsproxydata");
            TbadkCoreApplication.getInst().registerReceiver(this.ift, intentFilter);
        }
    }

    public void close() {
        this.ifp.clear();
        com.baidu.tieba.dnsproxy.a.d.cqj().close();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.ifw);
        MessageManager.getInstance().unRegisterListener(this.ifu);
        MessageManager.getInstance().unRegisterListener(this.ifv);
        TbadkCoreApplication.getInst().unregisterReceiver(this.ift);
    }

    public String aJ(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.ifp.contains(str)) {
            String a2 = a(str, this.ifq, z);
            if (TextUtils.isEmpty(a2)) {
                return a(str, this.ifr, z);
            }
            return a2;
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
                if (random.nextFloat() < com.baidu.tieba.dnsproxy.a.d.cqj().eH("c.tieba.baidu.com", ip)) {
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
                                    return com.baidu.tieba.dnsproxy.a.d.cqj().eI(str, dnsProxyIpData.getIp()) - com.baidu.tieba.dnsproxy.a.d.cqj().eI(str, dnsProxyIpData2.getIp()) < 0.0f ? -1 : 1;
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
                                    return com.baidu.tieba.dnsproxy.a.d.cqj().eH(str, dnsProxyIpData.getIp()) - com.baidu.tieba.dnsproxy.a.d.cqj().eH(str, dnsProxyIpData2.getIp()) < 0.0f ? 1 : -1;
                                }
                                return 1;
                            }
                            return -1;
                        }
                    });
                }
                for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : list) {
                    if (dnsProxyIpData != null && h.Jm(dnsProxyIpData.getIp())) {
                        String ip2 = dnsProxyIpData.getIp();
                        if (random.nextFloat() < com.baidu.tieba.dnsproxy.a.d.cqj().eH("c.tieba.baidu.com", ip2)) {
                            return ip2;
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oL(boolean z) {
        Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map;
        Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map2;
        if (z) {
            Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map3 = this.ifr;
            map = this.ifs;
            map2 = map3;
        } else {
            Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map4 = this.ifs;
            map = this.ifr;
            map2 = map4;
        }
        for (String str : map2.keySet()) {
            List<DnsProxyResponseData.DnsProxyIpData> list = map2.get(str);
            List<DnsProxyResponseData.DnsProxyIpData> list2 = map.get(str);
            HashSet<String> hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            if (list != null) {
                for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : list) {
                    if (dnsProxyIpData != null && h.Jm(dnsProxyIpData.getIp())) {
                        hashSet2.add(dnsProxyIpData.getIp());
                    }
                }
            }
            if (list2 != null) {
                for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData2 : list2) {
                    if (dnsProxyIpData2 != null && h.Jm(dnsProxyIpData2.getIp()) && hashSet2.contains(dnsProxyIpData2.getIp())) {
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
            this.ifq.put(str, arrayList);
        }
    }
}
