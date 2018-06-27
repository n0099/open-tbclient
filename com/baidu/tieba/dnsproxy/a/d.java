package com.baidu.tieba.dnsproxy.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.adp.lib.g.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.h;
import com.baidu.tieba.dnsproxy.e;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class d {
    private static d cMY = null;
    private BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.baidu.tieba.dnsproxy.a.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("ip");
                boolean booleanExtra = intent.getBooleanExtra("result", false);
                int intExtra = intent.getIntExtra("speed", -1);
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (intExtra == -1) {
                        d.this.e(stringExtra, booleanExtra, false);
                    } else {
                        d.this.a(stringExtra, intExtra, booleanExtra, false);
                    }
                }
            }
        }
    };
    private Object cMZ = new Object();
    private Map<String, a> cNa = null;
    private a cNb = null;
    private boolean cNc = false;

    public static final d anl() {
        if (cMY == null) {
            synchronized (d.class) {
                if (cMY == null) {
                    cMY = new d();
                }
            }
        }
        return cMY;
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
        if (!this.cNc) {
            c.anh().a(new h<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.amY().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.cMZ) {
                                if (d.this.cNa == null) {
                                    d.this.cNa = new ConcurrentHashMap();
                                }
                                d.this.cNa.clear();
                                d.this.cNa.putAll(hashMap);
                            }
                            d.this.cNc = true;
                            d.this.ann();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.cNa.entrySet()) {
                                if (d.this.cNb != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).cMM > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.amX().x("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.cNa.remove(aVar.name);
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

    public void anm() {
        ann();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ann() {
        if (this.cNc) {
            String ang = a.ang();
            if (!TextUtils.isEmpty(ang)) {
                if (!this.cNa.containsKey(ang)) {
                    e.amY().eZ(false);
                    return;
                }
                this.cNb = this.cNa.get(ang);
                if (this.cNb == null) {
                    e.amY().eZ(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.cNb.cMN > 3600000 && currentTimeMillis - this.cNb.cMM < 3600000) {
                    e.amY().eZ(false);
                }
            }
        }
    }

    public float aT(String str, String str2) {
        if (!this.cNc || this.cNb == null) {
            return 0.0f;
        }
        b bVar = this.cNb.cMK.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.cMO;
    }

    public float aU(String str, String str2) {
        if (!this.cNc || this.cNb == null) {
            return 10000.0f;
        }
        b bVar = this.cNb.cML.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.cMO;
    }

    public void y(String str, boolean z) {
        e(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final boolean z, final boolean z2) {
        if (this.cNc && !TextUtils.isEmpty(str)) {
            e.amY().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.cNb != null) {
                        b bVar = d.this.cNb.cMK.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.cNb.cMK.put(str, bVar);
                        }
                        bVar.jm(z ? 1 : 0);
                        synchronized (d.this.cMZ) {
                            hashMap = new HashMap(d.this.cNa);
                        }
                        c.anh().m(hashMap);
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
        if (this.cNc && !TextUtils.isEmpty(str)) {
            e.amY().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.cNb == null) {
                        String ang = a.ang();
                        if (!TextUtils.isEmpty(ang)) {
                            a aVar = new a();
                            aVar.name = ang;
                            d.this.cNb = aVar;
                            d.this.cNa.put(ang, aVar);
                        }
                    }
                    if (d.this.cNb != null) {
                        b bVar = d.this.cNb.cMK.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.cNb.cMK.put(str, bVar);
                        }
                        bVar.jm(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.cNb.cML.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.cNb.cML.put(str, bVar2);
                            }
                            bVar2.jm(i);
                        }
                        synchronized (d.this.cMZ) {
                            hashMap = new HashMap(d.this.cNa);
                        }
                        c.anh().m(hashMap);
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
