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
    private static d dpf = null;
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
    private Object dpg = new Object();
    private Map<String, a> dph = null;
    private a dpi = null;
    private boolean dpj = false;

    public static final d avv() {
        if (dpf == null) {
            synchronized (d.class) {
                if (dpf == null) {
                    dpf = new d();
                }
            }
        }
        return dpf;
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
        if (!this.dpj) {
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
                            synchronized (d.this.dpg) {
                                if (d.this.dph == null) {
                                    d.this.dph = new ConcurrentHashMap();
                                }
                                d.this.dph.clear();
                                d.this.dph.putAll(hashMap);
                            }
                            d.this.dpj = true;
                            d.this.avx();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.dph.entrySet()) {
                                if (d.this.dpi != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).doT > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.avh().G("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.dph.remove(aVar.name);
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
        if (this.dpj) {
            String avq = a.avq();
            if (!TextUtils.isEmpty(avq)) {
                if (!this.dph.containsKey(avq)) {
                    e.avi().fZ(false);
                    return;
                }
                this.dpi = this.dph.get(avq);
                if (this.dpi == null) {
                    e.avi().fZ(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dpi.doU > 3600000 && currentTimeMillis - this.dpi.doT < 3600000) {
                    e.avi().fZ(false);
                }
            }
        }
    }

    public float br(String str, String str2) {
        if (!this.dpj || this.dpi == null) {
            return 0.0f;
        }
        b bVar = this.dpi.doR.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.doV;
    }

    public float bs(String str, String str2) {
        if (!this.dpj || this.dpi == null) {
            return 10000.0f;
        }
        b bVar = this.dpi.doS.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.doV;
    }

    public void H(String str, boolean z) {
        e(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final boolean z, final boolean z2) {
        if (this.dpj && !TextUtils.isEmpty(str)) {
            e.avi().h(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.dpi != null) {
                        b bVar = d.this.dpi.doR.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.dpi.doR.put(str, bVar);
                        }
                        bVar.lq(z ? 1 : 0);
                        synchronized (d.this.dpg) {
                            hashMap = new HashMap(d.this.dph);
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
        if (this.dpj && !TextUtils.isEmpty(str)) {
            e.avi().h(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.dpi == null) {
                        String avq = a.avq();
                        if (!TextUtils.isEmpty(avq)) {
                            a aVar = new a();
                            aVar.name = avq;
                            d.this.dpi = aVar;
                            d.this.dph.put(avq, aVar);
                        }
                    }
                    if (d.this.dpi != null) {
                        b bVar = d.this.dpi.doR.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.dpi.doR.put(str, bVar);
                        }
                        bVar.lq(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.dpi.doS.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.dpi.doS.put(str, bVar2);
                            }
                            bVar2.lq(i);
                        }
                        synchronized (d.this.dpg) {
                            hashMap = new HashMap(d.this.dph);
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
