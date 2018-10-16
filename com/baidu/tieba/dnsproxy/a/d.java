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
    private static d ddN = null;
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
    private Object ddO = new Object();
    private Map<String, a> ddP = null;
    private a ddQ = null;
    private boolean ddR = false;

    public static final d asW() {
        if (ddN == null) {
            synchronized (d.class) {
                if (ddN == null) {
                    ddN = new d();
                }
            }
        }
        return ddN;
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
        if (!this.ddR) {
            c.asS().a(new h<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.asJ().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.ddO) {
                                if (d.this.ddP == null) {
                                    d.this.ddP = new ConcurrentHashMap();
                                }
                                d.this.ddP.clear();
                                d.this.ddP.putAll(hashMap);
                            }
                            d.this.ddR = true;
                            d.this.asY();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.ddP.entrySet()) {
                                if (d.this.ddQ != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).ddB > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.asI().F("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.ddP.remove(aVar.name);
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

    public void asX() {
        asY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asY() {
        if (this.ddR) {
            String asR = a.asR();
            if (!TextUtils.isEmpty(asR)) {
                if (!this.ddP.containsKey(asR)) {
                    e.asJ().fJ(false);
                    return;
                }
                this.ddQ = this.ddP.get(asR);
                if (this.ddQ == null) {
                    e.asJ().fJ(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.ddQ.ddC > 3600000 && currentTimeMillis - this.ddQ.ddB < 3600000) {
                    e.asJ().fJ(false);
                }
            }
        }
    }

    public float bl(String str, String str2) {
        if (!this.ddR || this.ddQ == null) {
            return 0.0f;
        }
        b bVar = this.ddQ.ddz.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.ddD;
    }

    public float bm(String str, String str2) {
        if (!this.ddR || this.ddQ == null) {
            return 10000.0f;
        }
        b bVar = this.ddQ.ddA.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.ddD;
    }

    public void F(String str, boolean z) {
        e(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final boolean z, final boolean z2) {
        if (this.ddR && !TextUtils.isEmpty(str)) {
            e.asJ().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.ddQ != null) {
                        b bVar = d.this.ddQ.ddz.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.ddQ.ddz.put(str, bVar);
                        }
                        bVar.ku(z ? 1 : 0);
                        synchronized (d.this.ddO) {
                            hashMap = new HashMap(d.this.ddP);
                        }
                        c.asS().q(hashMap);
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
        if (this.ddR && !TextUtils.isEmpty(str)) {
            e.asJ().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.ddQ == null) {
                        String asR = a.asR();
                        if (!TextUtils.isEmpty(asR)) {
                            a aVar = new a();
                            aVar.name = asR;
                            d.this.ddQ = aVar;
                            d.this.ddP.put(asR, aVar);
                        }
                    }
                    if (d.this.ddQ != null) {
                        b bVar = d.this.ddQ.ddz.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.ddQ.ddz.put(str, bVar);
                        }
                        bVar.ku(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.ddQ.ddA.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.ddQ.ddA.put(str, bVar2);
                            }
                            bVar2.ku(i);
                        }
                        synchronized (d.this.ddO) {
                            hashMap = new HashMap(d.this.ddP);
                        }
                        c.asS().q(hashMap);
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
