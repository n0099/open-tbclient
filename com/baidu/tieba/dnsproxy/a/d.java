package com.baidu.tieba.dnsproxy.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.adp.lib.f.f;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.dnsproxy.e;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes13.dex */
public class d {
    private static d irD = null;
    private BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.baidu.tieba.dnsproxy.a.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra(TableDefine.UserInfoColumns.COLUMN_IP);
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
    private Object irE = new Object();
    private Map<String, a> irF = null;
    private a irG = null;
    private boolean irH = false;

    public static final d cub() {
        if (irD == null) {
            synchronized (d.class) {
                if (irD == null) {
                    irD = new d();
                }
            }
        }
        return irD;
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
        if (!this.irH) {
            c.ctX().a(new m<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.ctO().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HashMap hashMap = new HashMap();
                            if (writeHistroyDataReqIdl != null) {
                                for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                                    a a2 = a.a(connectPointData);
                                    if (a2 != null) {
                                        hashMap.put(a2.name, a2);
                                    }
                                }
                            }
                            synchronized (d.this.irE) {
                                if (d.this.irF == null) {
                                    d.this.irF = new ConcurrentHashMap();
                                }
                                d.this.irF.clear();
                                d.this.irF.putAll(hashMap);
                            }
                            d.this.irH = true;
                            d.this.cud();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.irF.entrySet()) {
                                if (d.this.irG != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).irr > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.ctN().aA("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.irF.remove(aVar.name);
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

    public void cuc() {
        cud();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cud() {
        if (this.irH) {
            String ctW = a.ctW();
            if (!TextUtils.isEmpty(ctW)) {
                if (!this.irF.containsKey(ctW)) {
                    e.ctO().pj(false);
                    return;
                }
                this.irG = this.irF.get(ctW);
                if (this.irG == null) {
                    e.ctO().pj(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.irG.irs > BdKVCache.MILLS_1Hour && currentTimeMillis - this.irG.irr < BdKVCache.MILLS_1Hour) {
                    e.ctO().pj(false);
                }
            }
        }
    }

    public float eM(String str, String str2) {
        if (!this.irH || this.irG == null) {
            return 0.0f;
        }
        b bVar = this.irG.irp.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.irt;
    }

    public float eN(String str, String str2) {
        if (!this.irH || this.irG == null) {
            return 10000.0f;
        }
        b bVar = this.irG.irq.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.irt;
    }

    public void aL(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.irH && !TextUtils.isEmpty(str)) {
            e.ctO().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.irG != null) {
                        b bVar = d.this.irG.irp.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.irG.irp.put(str, bVar);
                        }
                        bVar.yw(z ? 1 : 0);
                        synchronized (d.this.irE) {
                            hashMap = new HashMap(d.this.irF);
                        }
                        c.ctX().D(hashMap);
                    }
                    if (z2) {
                        Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                        intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                        intent.putExtra(TableDefine.UserInfoColumns.COLUMN_IP, str);
                        intent.putExtra("result", z);
                        f.sendBroadcast(TbadkCoreApplication.getInst().getContext(), intent);
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
        if (this.irH && !TextUtils.isEmpty(str)) {
            e.ctO().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.irG == null) {
                        String ctW = a.ctW();
                        if (!TextUtils.isEmpty(ctW)) {
                            a aVar = new a();
                            aVar.name = ctW;
                            d.this.irG = aVar;
                            d.this.irF.put(ctW, aVar);
                        }
                    }
                    if (d.this.irG != null) {
                        b bVar = d.this.irG.irp.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.irG.irp.put(str, bVar);
                        }
                        bVar.yw(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.irG.irq.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.irG.irq.put(str, bVar2);
                            }
                            bVar2.yw(i);
                        }
                        synchronized (d.this.irE) {
                            hashMap = new HashMap(d.this.irF);
                        }
                        c.ctX().D(hashMap);
                    }
                    if (z2) {
                        Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                        intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                        intent.putExtra(TableDefine.UserInfoColumns.COLUMN_IP, str);
                        intent.putExtra("result", z);
                        intent.putExtra("speed", i);
                        f.sendBroadcast(TbadkCoreApplication.getInst().getContext(), intent);
                    }
                }
            });
        }
    }
}
