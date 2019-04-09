package com.baidu.tieba.dnsproxy.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.adp.lib.g.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.dnsproxy.e;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class d {
    private static d eyK = null;
    private BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.baidu.tieba.dnsproxy.a.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("ip");
                boolean booleanExtra = intent.getBooleanExtra("result", false);
                int intExtra = intent.getIntExtra("speed", -1);
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (intExtra == -1) {
                        d.this.h(stringExtra, booleanExtra, false);
                    } else {
                        d.this.a(stringExtra, intExtra, booleanExtra, false);
                    }
                }
            }
        }
    };
    private Object eyL = new Object();
    private Map<String, a> eyM = null;
    private a eyN = null;
    private boolean eyO = false;

    public static final d aVk() {
        if (eyK == null) {
            synchronized (d.class) {
                if (eyK == null) {
                    eyK = new d();
                }
            }
        }
        return eyK;
    }

    private d() {
    }

    public void open() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.receiver);
            TbadkCoreApplication.getInst().registerReceiver(this.receiver, new IntentFilter("action_sub_process_ip_data_change"));
        } else {
            TbadkCoreApplication.getInst().unregisterReceiver(this.receiver);
            TbadkCoreApplication.getInst().registerReceiver(this.receiver, new IntentFilter("action_main_process_ip_data_change"));
        }
        if (!this.eyO) {
            c.aVg().a(new k<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.aUX().m(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HashMap hashMap = new HashMap();
                            if (writeHistroyDataReqIdl != null) {
                                for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                                    a a = a.a(connectPointData);
                                    if (a != null) {
                                        hashMap.put(a.name, a);
                                    }
                                }
                            }
                            synchronized (d.this.eyL) {
                                if (d.this.eyM == null) {
                                    d.this.eyM = new ConcurrentHashMap();
                                }
                                d.this.eyM.clear();
                                d.this.eyM.putAll(hashMap);
                            }
                            d.this.eyO = true;
                            d.this.aVm();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.eyM.entrySet()) {
                                if (d.this.eyN != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).eyy > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.aUW().R("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.eyM.remove(aVar.name);
                            }
                        }
                    });
                }
            });
        }
    }

    public void close() {
        TbadkCoreApplication.getInst().unregisterReceiver(this.receiver);
    }

    public void aVl() {
        aVm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVm() {
        if (this.eyO) {
            String aVf = a.aVf();
            if (!TextUtils.isEmpty(aVf)) {
                if (!this.eyM.containsKey(aVf)) {
                    e.aUX().ir(false);
                    return;
                }
                this.eyN = this.eyM.get(aVf);
                if (this.eyN == null) {
                    e.aUX().ir(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.eyN.eyz > 3600000 && currentTimeMillis - this.eyN.eyy < 3600000) {
                    e.aUX().ir(false);
                }
            }
        }
    }

    public float cx(String str, String str2) {
        if (!this.eyO || this.eyN == null) {
            return 0.0f;
        }
        b bVar = this.eyN.eyw.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.eyA;
    }

    public float cy(String str, String str2) {
        if (!this.eyO || this.eyN == null) {
            return 10000.0f;
        }
        b bVar = this.eyN.eyx.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.eyA;
    }

    public void ab(String str, boolean z) {
        h(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final String str, final boolean z, final boolean z2) {
        if (this.eyO && !TextUtils.isEmpty(str)) {
            e.aUX().m(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.eyN != null) {
                        b bVar = d.this.eyN.eyw.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.eyN.eyw.put(str, bVar);
                        }
                        bVar.oO(z ? 1 : 0);
                        synchronized (d.this.eyL) {
                            hashMap = new HashMap(d.this.eyM);
                        }
                        c.aVg().u(hashMap);
                    }
                    if (z2) {
                        Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                        intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                        intent.putExtra("ip", str);
                        intent.putExtra("result", z);
                        f.g(TbadkCoreApplication.getInst().getContext(), intent);
                    }
                }
            });
        }
    }

    public void c(String str, int i, boolean z) {
        a(str, i, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final int i, final boolean z, final boolean z2) {
        if (this.eyO && !TextUtils.isEmpty(str)) {
            e.aUX().m(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.eyN == null) {
                        String aVf = a.aVf();
                        if (!TextUtils.isEmpty(aVf)) {
                            a aVar = new a();
                            aVar.name = aVf;
                            d.this.eyN = aVar;
                            d.this.eyM.put(aVf, aVar);
                        }
                    }
                    if (d.this.eyN != null) {
                        b bVar = d.this.eyN.eyw.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.eyN.eyw.put(str, bVar);
                        }
                        bVar.oO(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.eyN.eyx.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.eyN.eyx.put(str, bVar2);
                            }
                            bVar2.oO(i);
                        }
                        synchronized (d.this.eyL) {
                            hashMap = new HashMap(d.this.eyM);
                        }
                        c.aVg().u(hashMap);
                    }
                    if (z2) {
                        Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                        intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                        intent.putExtra("ip", str);
                        intent.putExtra("result", z);
                        intent.putExtra("speed", i);
                        f.g(TbadkCoreApplication.getInst().getContext(), intent);
                    }
                }
            });
        }
    }
}
