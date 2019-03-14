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
    private static d eyY = null;
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
    private Object eyZ = new Object();
    private Map<String, a> eza = null;
    private a ezb = null;
    private boolean ezc = false;

    public static final d aVm() {
        if (eyY == null) {
            synchronized (d.class) {
                if (eyY == null) {
                    eyY = new d();
                }
            }
        }
        return eyY;
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
        if (!this.ezc) {
            c.aVi().a(new k<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.aUZ().m(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.eyZ) {
                                if (d.this.eza == null) {
                                    d.this.eza = new ConcurrentHashMap();
                                }
                                d.this.eza.clear();
                                d.this.eza.putAll(hashMap);
                            }
                            d.this.ezc = true;
                            d.this.aVo();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.eza.entrySet()) {
                                if (d.this.ezb != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).eyM > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.aUY().R("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.eza.remove(aVar.name);
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

    public void aVn() {
        aVo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVo() {
        if (this.ezc) {
            String aVh = a.aVh();
            if (!TextUtils.isEmpty(aVh)) {
                if (!this.eza.containsKey(aVh)) {
                    e.aUZ().ir(false);
                    return;
                }
                this.ezb = this.eza.get(aVh);
                if (this.ezb == null) {
                    e.aUZ().ir(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.ezb.eyN > 3600000 && currentTimeMillis - this.ezb.eyM < 3600000) {
                    e.aUZ().ir(false);
                }
            }
        }
    }

    public float cw(String str, String str2) {
        if (!this.ezc || this.ezb == null) {
            return 0.0f;
        }
        b bVar = this.ezb.eyK.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.eyO;
    }

    public float cx(String str, String str2) {
        if (!this.ezc || this.ezb == null) {
            return 10000.0f;
        }
        b bVar = this.ezb.eyL.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.eyO;
    }

    public void ab(String str, boolean z) {
        h(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final String str, final boolean z, final boolean z2) {
        if (this.ezc && !TextUtils.isEmpty(str)) {
            e.aUZ().m(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.ezb != null) {
                        b bVar = d.this.ezb.eyK.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.ezb.eyK.put(str, bVar);
                        }
                        bVar.oS(z ? 1 : 0);
                        synchronized (d.this.eyZ) {
                            hashMap = new HashMap(d.this.eza);
                        }
                        c.aVi().u(hashMap);
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
        if (this.ezc && !TextUtils.isEmpty(str)) {
            e.aUZ().m(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.ezb == null) {
                        String aVh = a.aVh();
                        if (!TextUtils.isEmpty(aVh)) {
                            a aVar = new a();
                            aVar.name = aVh;
                            d.this.ezb = aVar;
                            d.this.eza.put(aVh, aVar);
                        }
                    }
                    if (d.this.ezb != null) {
                        b bVar = d.this.ezb.eyK.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.ezb.eyK.put(str, bVar);
                        }
                        bVar.oS(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.ezb.eyL.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.ezb.eyL.put(str, bVar2);
                            }
                            bVar2.oS(i);
                        }
                        synchronized (d.this.eyZ) {
                            hashMap = new HashMap(d.this.eza);
                        }
                        c.aVi().u(hashMap);
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
