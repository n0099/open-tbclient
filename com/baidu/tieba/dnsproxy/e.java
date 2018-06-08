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
import com.baidu.tbadk.TbConfig;
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
/* loaded from: classes3.dex */
public class e {
    private static e cOy = null;
    private static final Random random = new Random();
    private final String yj = "c.tieba.baidu.com";
    private HashSet<String> cOz = new HashSet<>();
    private Map<String, List<DnsProxyResponseData.DnsProxyIpData>> cOA = new ConcurrentHashMap();
    private Map<String, List<DnsProxyResponseData.DnsProxyIpData>> cOB = new ConcurrentHashMap();
    private Map<String, List<DnsProxyResponseData.DnsProxyIpData>> cOC = new ConcurrentHashMap();
    private BroadcastReceiver cOD = new BroadcastReceiver() { // from class: com.baidu.tieba.dnsproxy.e.1
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
                            e.this.cOB.clear();
                            e.this.cOB.putAll(concurrentHashMap);
                            e.this.fa(true);
                        }
                    }
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    d.anD().aS("dpm_broadcast", th.getMessage());
                }
            }
        }
    };
    private CustomMessageListener cOE = new CustomMessageListener(2000994) { // from class: com.baidu.tieba.dnsproxy.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.jD()) {
                com.baidu.tieba.dnsproxy.a.d.anR().anS();
                e.this.anF();
            }
        }
    };
    private CustomMessageListener cOF = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.dnsproxy.e.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    com.baidu.adp.lib.g.e.im().removeCallbacks(e.this.cOH);
                    DnsProxyStatic.anJ();
                    DnsProxyStatic.anK();
                    com.baidu.tieba.dnsproxy.a.c.anN().anP();
                    return;
                }
                e.this.anF();
            }
        }
    };
    private Handler mHandler = null;
    private HandlerThread cOG = new HandlerThread(getClass().getName());
    private Runnable cOH = new Runnable() { // from class: com.baidu.tieba.dnsproxy.e.7
        @Override // java.lang.Runnable
        public void run() {
            e.this.anF();
        }
    };
    private long cOI = 0;
    private c cOJ = null;

    public static final e anE() {
        if (cOy == null) {
            synchronized (e.class) {
                if (cOy == null) {
                    cOy = new e();
                }
            }
        }
        return cOy;
    }

    private e() {
        this.cOG.start();
    }

    public void g(final Runnable runnable) {
        if (runnable != null) {
            if (this.mHandler == null) {
                if (this.cOG.getLooper() != null) {
                    this.mHandler = new Handler(this.cOG.getLooper());
                    this.mHandler.post(runnable);
                }
                com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.dnsproxy.e.6
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.g(runnable);
                    }
                }, 100L);
                return;
            }
            this.mHandler.post(runnable);
        }
    }

    protected void anF() {
        anG();
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.cOH);
        com.baidu.adp.lib.g.e.im().postDelayed(this.cOH, ReportUserInfoModel.TIME_INTERVAL);
    }

    private void anG() {
        new g() { // from class: com.baidu.tieba.dnsproxy.e.8
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: j */
            public void onPostExecute(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
                super.onPostExecute(hashMap);
                e.this.cOC.clear();
                if (hashMap != null) {
                    e.this.cOC.putAll(hashMap);
                    e.this.fa(false);
                }
            }
        }.execute(new HashSet(this.cOz));
    }

    public void eZ(final boolean z) {
        if (z || TbadkCoreApplication.getInst().isMainProcess(false)) {
            if (!l.jT()) {
                com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.dnsproxy.e.9
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.eZ(z);
                    }
                });
            } else if (this.cOJ == null && System.currentTimeMillis() - this.cOI >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                if (!z) {
                    this.cOI = System.currentTimeMillis();
                }
                this.cOJ = new c(z) { // from class: com.baidu.tieba.dnsproxy.e.10
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    /* renamed from: j */
                    public void onPostExecute(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
                        super.onPostExecute(hashMap);
                        e.this.cOJ = null;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                    /* renamed from: a */
                    public void onProgressUpdate(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>>... hashMapArr) {
                        super.onProgressUpdate(hashMapArr);
                        if (hashMapArr != null && hashMapArr.length > 0) {
                            if (hashMapArr[0] != null) {
                                k(hashMapArr[0]);
                            } else if (this.cOw) {
                                e.this.cOJ = null;
                                e.this.eZ(false);
                            }
                        } else if (this.cOw) {
                            e.this.cOJ = null;
                            e.this.eZ(false);
                        }
                    }

                    private void k(HashMap<String, List<DnsProxyResponseData.DnsProxyIpData>> hashMap) {
                        e.this.cOB.clear();
                        if (hashMap != null) {
                            e.this.cOB.putAll(hashMap);
                            e.this.fa(true);
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
                                com.baidu.adp.lib.g.f.g(TbadkCoreApplication.getInst().getContext(), intent);
                            }
                        }
                    }
                };
                this.cOJ.execute(new HashSet(this.cOz));
            }
        }
    }

    public void start() {
        this.cOz.add("c.tieba.baidu.com");
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().unRegisterListener(this.cOE);
            MessageManager.getInstance().registerListener(this.cOE);
        }
        MessageManager.getInstance().unRegisterListener(this.cOF);
        MessageManager.getInstance().registerListener(this.cOF);
        com.baidu.tieba.dnsproxy.a.d.anR().open();
        com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.dnsproxy.e.11
            @Override // java.lang.Runnable
            public void run() {
                e.this.anF();
            }
        });
        eZ(true);
        if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.cOD);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.dnsproxy.dnsproxydata");
            TbadkCoreApplication.getInst().registerReceiver(this.cOD, intentFilter);
        }
    }

    public void close() {
        this.cOz.clear();
        com.baidu.tieba.dnsproxy.a.d.anR().close();
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.cOH);
        MessageManager.getInstance().unRegisterListener(this.cOE);
        MessageManager.getInstance().unRegisterListener(this.cOF);
        TbadkCoreApplication.getInst().unregisterReceiver(this.cOD);
    }

    public String x(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.cOz.contains(str)) {
            String a = a(str, this.cOA, z);
            if (TextUtils.isEmpty(a)) {
                return a(str, this.cOB, z);
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
                if (random.nextFloat() < com.baidu.tieba.dnsproxy.a.d.anR().aT("c.tieba.baidu.com", ip)) {
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
                                    return com.baidu.tieba.dnsproxy.a.d.anR().aU(str, dnsProxyIpData.getIp()) - com.baidu.tieba.dnsproxy.a.d.anR().aU(str, dnsProxyIpData2.getIp()) < 0.0f ? -1 : 1;
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
                                    return com.baidu.tieba.dnsproxy.a.d.anR().aT(str, dnsProxyIpData.getIp()) - com.baidu.tieba.dnsproxy.a.d.anR().aT(str, dnsProxyIpData2.getIp()) < 0.0f ? 1 : -1;
                                }
                                return 1;
                            }
                            return -1;
                        }
                    });
                }
                for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : list) {
                    if (dnsProxyIpData != null && h.lw(dnsProxyIpData.getIp())) {
                        String ip2 = dnsProxyIpData.getIp();
                        if (random.nextFloat() < com.baidu.tieba.dnsproxy.a.d.anR().aT("c.tieba.baidu.com", ip2)) {
                            return ip2;
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fa(boolean z) {
        Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map;
        Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map2;
        if (z) {
            Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map3 = this.cOB;
            map = this.cOC;
            map2 = map3;
        } else {
            Map<String, List<DnsProxyResponseData.DnsProxyIpData>> map4 = this.cOC;
            map = this.cOB;
            map2 = map4;
        }
        for (String str : map2.keySet()) {
            List<DnsProxyResponseData.DnsProxyIpData> list = map2.get(str);
            List<DnsProxyResponseData.DnsProxyIpData> list2 = map.get(str);
            HashSet<String> hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            if (list != null) {
                for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData : list) {
                    if (dnsProxyIpData != null && h.lw(dnsProxyIpData.getIp())) {
                        hashSet2.add(dnsProxyIpData.getIp());
                    }
                }
            }
            if (list2 != null) {
                for (DnsProxyResponseData.DnsProxyIpData dnsProxyIpData2 : list2) {
                    if (dnsProxyIpData2 != null && h.lw(dnsProxyIpData2.getIp()) && hashSet2.contains(dnsProxyIpData2.getIp())) {
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
            this.cOA.put(str, arrayList);
        }
    }
}
