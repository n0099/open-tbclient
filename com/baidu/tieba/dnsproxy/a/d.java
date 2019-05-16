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
    private static d eOm = null;
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
    private Object eOn = new Object();
    private Map<String, a> eOo = null;
    private a eOp = null;
    private boolean eOq = false;

    public static final d bcs() {
        if (eOm == null) {
            synchronized (d.class) {
                if (eOm == null) {
                    eOm = new d();
                }
            }
        }
        return eOm;
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
        if (!this.eOq) {
            c.bco().a(new k<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.bcf().o(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.eOn) {
                                if (d.this.eOo == null) {
                                    d.this.eOo = new ConcurrentHashMap();
                                }
                                d.this.eOo.clear();
                                d.this.eOo.putAll(hashMap);
                            }
                            d.this.eOq = true;
                            d.this.bcu();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.eOo.entrySet()) {
                                if (d.this.eOp != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).eOa > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.bce().R("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.eOo.remove(aVar.name);
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

    public void bct() {
        bcu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcu() {
        if (this.eOq) {
            String bcn = a.bcn();
            if (!TextUtils.isEmpty(bcn)) {
                if (!this.eOo.containsKey(bcn)) {
                    e.bcf().iW(false);
                    return;
                }
                this.eOp = this.eOo.get(bcn);
                if (this.eOp == null) {
                    e.bcf().iW(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.eOp.eOb > 3600000 && currentTimeMillis - this.eOp.eOa < 3600000) {
                    e.bcf().iW(false);
                }
            }
        }
    }

    public float cJ(String str, String str2) {
        if (!this.eOq || this.eOp == null) {
            return 0.0f;
        }
        b bVar = this.eOp.eNY.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.eOc;
    }

    public float cK(String str, String str2) {
        if (!this.eOq || this.eOp == null) {
            return 10000.0f;
        }
        b bVar = this.eOp.eNZ.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.eOc;
    }

    public void ad(String str, boolean z) {
        h(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final String str, final boolean z, final boolean z2) {
        if (this.eOq && !TextUtils.isEmpty(str)) {
            e.bcf().o(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.eOp != null) {
                        b bVar = d.this.eOp.eNY.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.eOp.eNY.put(str, bVar);
                        }
                        bVar.pS(z ? 1 : 0);
                        synchronized (d.this.eOn) {
                            hashMap = new HashMap(d.this.eOo);
                        }
                        c.bco().v(hashMap);
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
        if (this.eOq && !TextUtils.isEmpty(str)) {
            e.bcf().o(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.eOp == null) {
                        String bcn = a.bcn();
                        if (!TextUtils.isEmpty(bcn)) {
                            a aVar = new a();
                            aVar.name = bcn;
                            d.this.eOp = aVar;
                            d.this.eOo.put(bcn, aVar);
                        }
                    }
                    if (d.this.eOp != null) {
                        b bVar = d.this.eOp.eNY.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.eOp.eNY.put(str, bVar);
                        }
                        bVar.pS(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.eOp.eNZ.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.eOp.eNZ.put(str, bVar2);
                            }
                            bVar2.pS(i);
                        }
                        synchronized (d.this.eOn) {
                            hashMap = new HashMap(d.this.eOo);
                        }
                        c.bco().v(hashMap);
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
