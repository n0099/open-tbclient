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
    private static d dpe = null;
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
    private Object dpf = new Object();
    private Map<String, a> dpg = null;
    private a dph = null;
    private boolean dpi = false;

    public static final d avv() {
        if (dpe == null) {
            synchronized (d.class) {
                if (dpe == null) {
                    dpe = new d();
                }
            }
        }
        return dpe;
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
        if (!this.dpi) {
            c.avr().a(new h<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.avi().h(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.dpf) {
                                if (d.this.dpg == null) {
                                    d.this.dpg = new ConcurrentHashMap();
                                }
                                d.this.dpg.clear();
                                d.this.dpg.putAll(hashMap);
                            }
                            d.this.dpi = true;
                            d.this.avx();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.dpg.entrySet()) {
                                if (d.this.dph != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).doS > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.avh().G("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.dpg.remove(aVar.name);
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

    public void avw() {
        avx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avx() {
        if (this.dpi) {
            String avq = a.avq();
            if (!TextUtils.isEmpty(avq)) {
                if (!this.dpg.containsKey(avq)) {
                    e.avi().fZ(false);
                    return;
                }
                this.dph = this.dpg.get(avq);
                if (this.dph == null) {
                    e.avi().fZ(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dph.doT > 3600000 && currentTimeMillis - this.dph.doS < 3600000) {
                    e.avi().fZ(false);
                }
            }
        }
    }

    public float br(String str, String str2) {
        if (!this.dpi || this.dph == null) {
            return 0.0f;
        }
        b bVar = this.dph.doQ.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.doU;
    }

    public float bs(String str, String str2) {
        if (!this.dpi || this.dph == null) {
            return 10000.0f;
        }
        b bVar = this.dph.doR.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.doU;
    }

    public void H(String str, boolean z) {
        e(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final boolean z, final boolean z2) {
        if (this.dpi && !TextUtils.isEmpty(str)) {
            e.avi().h(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.dph != null) {
                        b bVar = d.this.dph.doQ.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.dph.doQ.put(str, bVar);
                        }
                        bVar.lq(z ? 1 : 0);
                        synchronized (d.this.dpf) {
                            hashMap = new HashMap(d.this.dpg);
                        }
                        c.avr().t(hashMap);
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
        if (this.dpi && !TextUtils.isEmpty(str)) {
            e.avi().h(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.dph == null) {
                        String avq = a.avq();
                        if (!TextUtils.isEmpty(avq)) {
                            a aVar = new a();
                            aVar.name = avq;
                            d.this.dph = aVar;
                            d.this.dpg.put(avq, aVar);
                        }
                    }
                    if (d.this.dph != null) {
                        b bVar = d.this.dph.doQ.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.dph.doQ.put(str, bVar);
                        }
                        bVar.lq(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.dph.doR.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.dph.doR.put(str, bVar2);
                            }
                            bVar2.lq(i);
                        }
                        synchronized (d.this.dpf) {
                            hashMap = new HashMap(d.this.dpg);
                        }
                        c.avr().t(hashMap);
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
