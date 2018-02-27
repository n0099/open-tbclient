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
    private static d dmZ = null;
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
    private Object dna = new Object();
    private Map<String, a> dnb = null;
    private a dnc = null;
    private boolean dnd = false;

    public static final d apL() {
        if (dmZ == null) {
            synchronized (d.class) {
                if (dmZ == null) {
                    dmZ = new d();
                }
            }
        }
        return dmZ;
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
        if (!this.dnd) {
            c.apH().a(new h<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.apy().i(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.dna) {
                                if (d.this.dnb == null) {
                                    d.this.dnb = new ConcurrentHashMap();
                                }
                                d.this.dnb.clear();
                                d.this.dnb.putAll(hashMap);
                            }
                            d.this.dnd = true;
                            d.this.apN();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.dnb.entrySet()) {
                                if (d.this.dnc != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).dmN > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.apx().A("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.dnb.remove(aVar.name);
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

    public void apM() {
        apN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apN() {
        if (this.dnd) {
            String apG = a.apG();
            if (!TextUtils.isEmpty(apG)) {
                if (!this.dnb.containsKey(apG)) {
                    e.apy().fp(false);
                    return;
                }
                this.dnc = this.dnb.get(apG);
                if (this.dnc == null) {
                    e.apy().fp(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dnc.dmO > 3600000 && currentTimeMillis - this.dnc.dmN < 3600000) {
                    e.apy().fp(false);
                }
            }
        }
    }

    public float aM(String str, String str2) {
        if (!this.dnd || this.dnc == null) {
            return 0.0f;
        }
        b bVar = this.dnc.dmL.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.dmP;
    }

    public float aN(String str, String str2) {
        if (!this.dnd || this.dnc == null) {
            return 10000.0f;
        }
        b bVar = this.dnc.dmM.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.dmP;
    }

    public void B(String str, boolean z) {
        e(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final boolean z, final boolean z2) {
        if (this.dnd && !TextUtils.isEmpty(str)) {
            e.apy().i(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.dnc != null) {
                        b bVar = d.this.dnc.dmL.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.dnc.dmL.put(str, bVar);
                        }
                        bVar.mb(z ? 1 : 0);
                        synchronized (d.this.dna) {
                            hashMap = new HashMap(d.this.dnb);
                        }
                        c.apH().h(hashMap);
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
        if (this.dnd && !TextUtils.isEmpty(str)) {
            e.apy().i(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.dnc == null) {
                        String apG = a.apG();
                        if (!TextUtils.isEmpty(apG)) {
                            a aVar = new a();
                            aVar.name = apG;
                            d.this.dnc = aVar;
                            d.this.dnb.put(apG, aVar);
                        }
                    }
                    if (d.this.dnc != null) {
                        b bVar = d.this.dnc.dmL.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.dnc.dmL.put(str, bVar);
                        }
                        bVar.mb(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.dnc.dmM.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.dnc.dmM.put(str, bVar2);
                            }
                            bVar2.mb(i);
                        }
                        synchronized (d.this.dna) {
                            hashMap = new HashMap(d.this.dnb);
                        }
                        c.apH().h(hashMap);
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
