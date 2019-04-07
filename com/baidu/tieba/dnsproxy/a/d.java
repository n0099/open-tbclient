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
    private static d eyJ = null;
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
    private Object eyK = new Object();
    private Map<String, a> eyL = null;
    private a eyM = null;
    private boolean eyN = false;

    public static final d aVk() {
        if (eyJ == null) {
            synchronized (d.class) {
                if (eyJ == null) {
                    eyJ = new d();
                }
            }
        }
        return eyJ;
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
        if (!this.eyN) {
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
                            synchronized (d.this.eyK) {
                                if (d.this.eyL == null) {
                                    d.this.eyL = new ConcurrentHashMap();
                                }
                                d.this.eyL.clear();
                                d.this.eyL.putAll(hashMap);
                            }
                            d.this.eyN = true;
                            d.this.aVm();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.eyL.entrySet()) {
                                if (d.this.eyM != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).eyx > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.aUW().R("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.eyL.remove(aVar.name);
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
        if (this.eyN) {
            String aVf = a.aVf();
            if (!TextUtils.isEmpty(aVf)) {
                if (!this.eyL.containsKey(aVf)) {
                    e.aUX().ir(false);
                    return;
                }
                this.eyM = this.eyL.get(aVf);
                if (this.eyM == null) {
                    e.aUX().ir(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.eyM.eyy > 3600000 && currentTimeMillis - this.eyM.eyx < 3600000) {
                    e.aUX().ir(false);
                }
            }
        }
    }

    public float cx(String str, String str2) {
        if (!this.eyN || this.eyM == null) {
            return 0.0f;
        }
        b bVar = this.eyM.eyv.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.eyz;
    }

    public float cy(String str, String str2) {
        if (!this.eyN || this.eyM == null) {
            return 10000.0f;
        }
        b bVar = this.eyM.eyw.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.eyz;
    }

    public void ab(String str, boolean z) {
        h(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final String str, final boolean z, final boolean z2) {
        if (this.eyN && !TextUtils.isEmpty(str)) {
            e.aUX().m(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.eyM != null) {
                        b bVar = d.this.eyM.eyv.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.eyM.eyv.put(str, bVar);
                        }
                        bVar.oO(z ? 1 : 0);
                        synchronized (d.this.eyK) {
                            hashMap = new HashMap(d.this.eyL);
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
        if (this.eyN && !TextUtils.isEmpty(str)) {
            e.aUX().m(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.eyM == null) {
                        String aVf = a.aVf();
                        if (!TextUtils.isEmpty(aVf)) {
                            a aVar = new a();
                            aVar.name = aVf;
                            d.this.eyM = aVar;
                            d.this.eyL.put(aVf, aVar);
                        }
                    }
                    if (d.this.eyM != null) {
                        b bVar = d.this.eyM.eyv.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.eyM.eyv.put(str, bVar);
                        }
                        bVar.oO(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.eyM.eyw.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.eyM.eyw.put(str, bVar2);
                            }
                            bVar2.oO(i);
                        }
                        synchronized (d.this.eyK) {
                            hashMap = new HashMap(d.this.eyL);
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
