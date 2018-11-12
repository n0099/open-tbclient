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
    private static d deT = null;
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
    private Object deU = new Object();
    private Map<String, a> deV = null;
    private a deW = null;
    private boolean deX = false;

    public static final d asw() {
        if (deT == null) {
            synchronized (d.class) {
                if (deT == null) {
                    deT = new d();
                }
            }
        }
        return deT;
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
        if (!this.deX) {
            c.ass().a(new h<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.asj().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.deU) {
                                if (d.this.deV == null) {
                                    d.this.deV = new ConcurrentHashMap();
                                }
                                d.this.deV.clear();
                                d.this.deV.putAll(hashMap);
                            }
                            d.this.deX = true;
                            d.this.asy();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.deV.entrySet()) {
                                if (d.this.deW != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).deH > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.asi().F("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.deV.remove(aVar.name);
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

    public void asx() {
        asy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asy() {
        if (this.deX) {
            String asr = a.asr();
            if (!TextUtils.isEmpty(asr)) {
                if (!this.deV.containsKey(asr)) {
                    e.asj().fT(false);
                    return;
                }
                this.deW = this.deV.get(asr);
                if (this.deW == null) {
                    e.asj().fT(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.deW.deI > 3600000 && currentTimeMillis - this.deW.deH < 3600000) {
                    e.asj().fT(false);
                }
            }
        }
    }

    public float bl(String str, String str2) {
        if (!this.deX || this.deW == null) {
            return 0.0f;
        }
        b bVar = this.deW.deF.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.deJ;
    }

    public float bm(String str, String str2) {
        if (!this.deX || this.deW == null) {
            return 10000.0f;
        }
        b bVar = this.deW.deG.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.deJ;
    }

    public void F(String str, boolean z) {
        e(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final boolean z, final boolean z2) {
        if (this.deX && !TextUtils.isEmpty(str)) {
            e.asj().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.deW != null) {
                        b bVar = d.this.deW.deF.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.deW.deF.put(str, bVar);
                        }
                        bVar.kM(z ? 1 : 0);
                        synchronized (d.this.deU) {
                            hashMap = new HashMap(d.this.deV);
                        }
                        c.ass().q(hashMap);
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
        if (this.deX && !TextUtils.isEmpty(str)) {
            e.asj().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.deW == null) {
                        String asr = a.asr();
                        if (!TextUtils.isEmpty(asr)) {
                            a aVar = new a();
                            aVar.name = asr;
                            d.this.deW = aVar;
                            d.this.deV.put(asr, aVar);
                        }
                    }
                    if (d.this.deW != null) {
                        b bVar = d.this.deW.deF.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.deW.deF.put(str, bVar);
                        }
                        bVar.kM(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.deW.deG.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.deW.deG.put(str, bVar2);
                            }
                            bVar2.kM(i);
                        }
                        synchronized (d.this.deU) {
                            hashMap = new HashMap(d.this.deV);
                        }
                        c.ass().q(hashMap);
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
