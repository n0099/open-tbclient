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
    private static d dos = null;
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
    private Object dot = new Object();
    private Map<String, a> dou = null;
    private a dov = null;
    private boolean dow = false;

    public static final d auX() {
        if (dos == null) {
            synchronized (d.class) {
                if (dos == null) {
                    dos = new d();
                }
            }
        }
        return dos;
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
        if (!this.dow) {
            c.auT().a(new h<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.auK().h(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.dot) {
                                if (d.this.dou == null) {
                                    d.this.dou = new ConcurrentHashMap();
                                }
                                d.this.dou.clear();
                                d.this.dou.putAll(hashMap);
                            }
                            d.this.dow = true;
                            d.this.auZ();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.dou.entrySet()) {
                                if (d.this.dov != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).dog > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.auJ().G("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.dou.remove(aVar.name);
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

    public void auY() {
        auZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auZ() {
        if (this.dow) {
            String auS = a.auS();
            if (!TextUtils.isEmpty(auS)) {
                if (!this.dou.containsKey(auS)) {
                    e.auK().fW(false);
                    return;
                }
                this.dov = this.dou.get(auS);
                if (this.dov == null) {
                    e.auK().fW(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dov.doh > 3600000 && currentTimeMillis - this.dov.dog < 3600000) {
                    e.auK().fW(false);
                }
            }
        }
    }

    public float bq(String str, String str2) {
        if (!this.dow || this.dov == null) {
            return 0.0f;
        }
        b bVar = this.dov.doe.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.doi;
    }

    public float br(String str, String str2) {
        if (!this.dow || this.dov == null) {
            return 10000.0f;
        }
        b bVar = this.dov.dof.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.doi;
    }

    public void H(String str, boolean z) {
        e(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final boolean z, final boolean z2) {
        if (this.dow && !TextUtils.isEmpty(str)) {
            e.auK().h(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.dov != null) {
                        b bVar = d.this.dov.doe.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.dov.doe.put(str, bVar);
                        }
                        bVar.lp(z ? 1 : 0);
                        synchronized (d.this.dot) {
                            hashMap = new HashMap(d.this.dou);
                        }
                        c.auT().t(hashMap);
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
        if (this.dow && !TextUtils.isEmpty(str)) {
            e.auK().h(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.dov == null) {
                        String auS = a.auS();
                        if (!TextUtils.isEmpty(auS)) {
                            a aVar = new a();
                            aVar.name = auS;
                            d.this.dov = aVar;
                            d.this.dou.put(auS, aVar);
                        }
                    }
                    if (d.this.dov != null) {
                        b bVar = d.this.dov.doe.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.dov.doe.put(str, bVar);
                        }
                        bVar.lp(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.dov.dof.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.dov.dof.put(str, bVar2);
                            }
                            bVar2.lp(i);
                        }
                        synchronized (d.this.dot) {
                            hashMap = new HashMap(d.this.dou);
                        }
                        c.auT().t(hashMap);
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
