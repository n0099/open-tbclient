package com.baidu.tieba.dnsproxy.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.adp.lib.g.f;
import com.baidu.tbadk.TbConfig;
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
    private static d ezc = null;
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
    private Object ezd = new Object();
    private Map<String, a> eze = null;
    private a ezf = null;
    private boolean ezg = false;

    public static final d aVn() {
        if (ezc == null) {
            synchronized (d.class) {
                if (ezc == null) {
                    ezc = new d();
                }
            }
        }
        return ezc;
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
        if (!this.ezg) {
            c.aVj().a(new k<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.aVa().m(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.ezd) {
                                if (d.this.eze == null) {
                                    d.this.eze = new ConcurrentHashMap();
                                }
                                d.this.eze.clear();
                                d.this.eze.putAll(hashMap);
                            }
                            d.this.ezg = true;
                            d.this.aVp();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.eze.entrySet()) {
                                if (d.this.ezf != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).eyQ > TbConfig.APP_OVERDUR_DRAFT_BOX) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.aUZ().R("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.eze.remove(aVar.name);
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

    public void aVo() {
        aVp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVp() {
        if (this.ezg) {
            String aVi = a.aVi();
            if (!TextUtils.isEmpty(aVi)) {
                if (!this.eze.containsKey(aVi)) {
                    e.aVa().ir(false);
                    return;
                }
                this.ezf = this.eze.get(aVi);
                if (this.ezf == null) {
                    e.aVa().ir(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.ezf.eyR > 3600000 && currentTimeMillis - this.ezf.eyQ < 3600000) {
                    e.aVa().ir(false);
                }
            }
        }
    }

    public float cw(String str, String str2) {
        if (!this.ezg || this.ezf == null) {
            return 0.0f;
        }
        b bVar = this.ezf.eyO.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.eyS;
    }

    public float cx(String str, String str2) {
        if (!this.ezg || this.ezf == null) {
            return 10000.0f;
        }
        b bVar = this.ezf.eyP.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.eyS;
    }

    public void ab(String str, boolean z) {
        h(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final String str, final boolean z, final boolean z2) {
        if (this.ezg && !TextUtils.isEmpty(str)) {
            e.aVa().m(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.ezf != null) {
                        b bVar = d.this.ezf.eyO.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.ezf.eyO.put(str, bVar);
                        }
                        bVar.oS(z ? 1 : 0);
                        synchronized (d.this.ezd) {
                            hashMap = new HashMap(d.this.eze);
                        }
                        c.aVj().u(hashMap);
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
        if (this.ezg && !TextUtils.isEmpty(str)) {
            e.aVa().m(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.ezf == null) {
                        String aVi = a.aVi();
                        if (!TextUtils.isEmpty(aVi)) {
                            a aVar = new a();
                            aVar.name = aVi;
                            d.this.ezf = aVar;
                            d.this.eze.put(aVi, aVar);
                        }
                    }
                    if (d.this.ezf != null) {
                        b bVar = d.this.ezf.eyO.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.ezf.eyO.put(str, bVar);
                        }
                        bVar.oS(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.ezf.eyP.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.ezf.eyP.put(str, bVar2);
                            }
                            bVar2.oS(i);
                        }
                        synchronized (d.this.ezd) {
                            hashMap = new HashMap(d.this.eze);
                        }
                        c.aVj().u(hashMap);
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
