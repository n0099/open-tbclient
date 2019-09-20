package com.baidu.tieba.dnsproxy.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.adp.lib.g.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.j;
import com.baidu.tieba.dnsproxy.e;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class d {
    private static d eVa = null;
    private BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.baidu.tieba.dnsproxy.a.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("ip");
                boolean booleanExtra = intent.getBooleanExtra("result", false);
                int intExtra = intent.getIntExtra("speed", -1);
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (intExtra == -1) {
                        d.this.i(stringExtra, booleanExtra, false);
                    } else {
                        d.this.a(stringExtra, intExtra, booleanExtra, false);
                    }
                }
            }
        }
    };
    private Object eVb = new Object();
    private Map<String, a> eVc = null;
    private a eVd = null;
    private boolean eVe = false;

    public static final d bfc() {
        if (eVa == null) {
            synchronized (d.class) {
                if (eVa == null) {
                    eVa = new d();
                }
            }
        }
        return eVa;
    }

    private d() {
    }

    public void ZT() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.receiver);
            TbadkCoreApplication.getInst().registerReceiver(this.receiver, new IntentFilter("action_sub_process_ip_data_change"));
        } else {
            TbadkCoreApplication.getInst().unregisterReceiver(this.receiver);
            TbadkCoreApplication.getInst().registerReceiver(this.receiver, new IntentFilter("action_main_process_ip_data_change"));
        }
        if (!this.eVe) {
            c.beY().a(new j<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.j
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.beP().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.eVb) {
                                if (d.this.eVc == null) {
                                    d.this.eVc = new ConcurrentHashMap();
                                }
                                d.this.eVc.clear();
                                d.this.eVc.putAll(hashMap);
                            }
                            d.this.eVe = true;
                            d.this.bfe();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.eVc.entrySet()) {
                                if (d.this.eVd != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).eUO > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.beO().T("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.eVc.remove(aVar.name);
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

    public void bfd() {
        bfe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfe() {
        if (this.eVe) {
            String beX = a.beX();
            if (!TextUtils.isEmpty(beX)) {
                if (!this.eVc.containsKey(beX)) {
                    e.beP().jj(false);
                    return;
                }
                this.eVd = this.eVc.get(beX);
                if (this.eVd == null) {
                    e.beP().jj(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.eVd.eUP > 3600000 && currentTimeMillis - this.eVd.eUO < 3600000) {
                    e.beP().jj(false);
                }
            }
        }
    }

    public float cL(String str, String str2) {
        if (!this.eVe || this.eVd == null) {
            return 0.0f;
        }
        b bVar = this.eVd.eUM.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.eUQ;
    }

    public float cM(String str, String str2) {
        if (!this.eVe || this.eVd == null) {
            return 10000.0f;
        }
        b bVar = this.eVd.eUN.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.eUQ;
    }

    public void ah(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.eVe && !TextUtils.isEmpty(str)) {
            e.beP().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.eVd != null) {
                        b bVar = d.this.eVd.eUM.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.eVd.eUM.put(str, bVar);
                        }
                        bVar.qn(z ? 1 : 0);
                        synchronized (d.this.eVb) {
                            hashMap = new HashMap(d.this.eVc);
                        }
                        c.beY().v(hashMap);
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
        if (this.eVe && !TextUtils.isEmpty(str)) {
            e.beP().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.eVd == null) {
                        String beX = a.beX();
                        if (!TextUtils.isEmpty(beX)) {
                            a aVar = new a();
                            aVar.name = beX;
                            d.this.eVd = aVar;
                            d.this.eVc.put(beX, aVar);
                        }
                    }
                    if (d.this.eVd != null) {
                        b bVar = d.this.eVd.eUM.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.eVd.eUM.put(str, bVar);
                        }
                        bVar.qn(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.eVd.eUN.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.eVd.eUN.put(str, bVar2);
                            }
                            bVar2.qn(i);
                        }
                        synchronized (d.this.eVb) {
                            hashMap = new HashMap(d.this.eVc);
                        }
                        c.beY().v(hashMap);
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
