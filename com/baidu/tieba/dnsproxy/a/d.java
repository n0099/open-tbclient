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
    private static d cVv = null;
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
    private Object cVw = new Object();
    private Map<String, a> cVx = null;
    private a cVy = null;
    private boolean cVz = false;

    public static final d apz() {
        if (cVv == null) {
            synchronized (d.class) {
                if (cVv == null) {
                    cVv = new d();
                }
            }
        }
        return cVv;
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
        if (!this.cVz) {
            c.apv().a(new h<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.apm().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.cVw) {
                                if (d.this.cVx == null) {
                                    d.this.cVx = new ConcurrentHashMap();
                                }
                                d.this.cVx.clear();
                                d.this.cVx.putAll(hashMap);
                            }
                            d.this.cVz = true;
                            d.this.apB();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.cVx.entrySet()) {
                                if (d.this.cVy != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).cVj > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.apl().y("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.cVx.remove(aVar.name);
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

    public void apA() {
        apB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apB() {
        if (this.cVz) {
            String apu = a.apu();
            if (!TextUtils.isEmpty(apu)) {
                if (!this.cVx.containsKey(apu)) {
                    e.apm().fr(false);
                    return;
                }
                this.cVy = this.cVx.get(apu);
                if (this.cVy == null) {
                    e.apm().fr(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.cVy.cVk > 3600000 && currentTimeMillis - this.cVy.cVj < 3600000) {
                    e.apm().fr(false);
                }
            }
        }
    }

    public float aZ(String str, String str2) {
        if (!this.cVz || this.cVy == null) {
            return 0.0f;
        }
        b bVar = this.cVy.cVh.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.cVl;
    }

    public float ba(String str, String str2) {
        if (!this.cVz || this.cVy == null) {
            return 10000.0f;
        }
        b bVar = this.cVy.cVi.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.cVl;
    }

    public void y(String str, boolean z) {
        e(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final boolean z, final boolean z2) {
        if (this.cVz && !TextUtils.isEmpty(str)) {
            e.apm().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.cVy != null) {
                        b bVar = d.this.cVy.cVh.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.cVy.cVh.put(str, bVar);
                        }
                        bVar.jW(z ? 1 : 0);
                        synchronized (d.this.cVw) {
                            hashMap = new HashMap(d.this.cVx);
                        }
                        c.apv().n(hashMap);
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
        if (this.cVz && !TextUtils.isEmpty(str)) {
            e.apm().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.cVy == null) {
                        String apu = a.apu();
                        if (!TextUtils.isEmpty(apu)) {
                            a aVar = new a();
                            aVar.name = apu;
                            d.this.cVy = aVar;
                            d.this.cVx.put(apu, aVar);
                        }
                    }
                    if (d.this.cVy != null) {
                        b bVar = d.this.cVy.cVh.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.cVy.cVh.put(str, bVar);
                        }
                        bVar.jW(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.cVy.cVi.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.cVy.cVi.put(str, bVar2);
                            }
                            bVar2.jW(i);
                        }
                        synchronized (d.this.cVw) {
                            hashMap = new HashMap(d.this.cVx);
                        }
                        c.apv().n(hashMap);
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
