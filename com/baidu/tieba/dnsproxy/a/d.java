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
    private static d irB = null;
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
    private Object irC = new Object();
    private Map<String, a> irD = null;
    private a irE = null;
    private boolean irF = false;

    public static final d cua() {
        if (irB == null) {
            synchronized (d.class) {
                if (irB == null) {
                    irB = new d();
                }
            }
        }
        return irB;
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
        if (!this.irF) {
            c.ctW().a(new m<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.ctN().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.irC) {
                                if (d.this.irD == null) {
                                    d.this.irD = new ConcurrentHashMap();
                                }
                                d.this.irD.clear();
                                d.this.irD.putAll(hashMap);
                            }
                            d.this.irF = true;
                            d.this.cuc();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.irD.entrySet()) {
                                if (d.this.irE != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).irp > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.ctM().aA("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.irD.remove(aVar.name);
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

    public void cub() {
        cuc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuc() {
        if (this.irF) {
            String ctV = a.ctV();
            if (!TextUtils.isEmpty(ctV)) {
                if (!this.irD.containsKey(ctV)) {
                    e.ctN().pj(false);
                    return;
                }
                this.irE = this.irD.get(ctV);
                if (this.irE == null) {
                    e.ctN().pj(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.irE.irq > BdKVCache.MILLS_1Hour && currentTimeMillis - this.irE.irp < BdKVCache.MILLS_1Hour) {
                    e.ctN().pj(false);
                }
            }
        }
    }

    public float eM(String str, String str2) {
        if (!this.irF || this.irE == null) {
            return 0.0f;
        }
        b bVar = this.irE.irn.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.irr;
    }

    public float eN(String str, String str2) {
        if (!this.irF || this.irE == null) {
            return 10000.0f;
        }
        b bVar = this.irE.iro.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.irr;
    }

    public void aL(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.irF && !TextUtils.isEmpty(str)) {
            e.ctN().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.irE != null) {
                        b bVar = d.this.irE.irn.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.irE.irn.put(str, bVar);
                        }
                        bVar.yw(z ? 1 : 0);
                        synchronized (d.this.irC) {
                            hashMap = new HashMap(d.this.irD);
                        }
                        c.ctW().D(hashMap);
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
        if (this.irF && !TextUtils.isEmpty(str)) {
            e.ctN().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.irE == null) {
                        String ctV = a.ctV();
                        if (!TextUtils.isEmpty(ctV)) {
                            a aVar = new a();
                            aVar.name = ctV;
                            d.this.irE = aVar;
                            d.this.irD.put(ctV, aVar);
                        }
                    }
                    if (d.this.irE != null) {
                        b bVar = d.this.irE.irn.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.irE.irn.put(str, bVar);
                        }
                        bVar.yw(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.irE.iro.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.irE.iro.put(str, bVar2);
                            }
                            bVar2.yw(i);
                        }
                        synchronized (d.this.irC) {
                            hashMap = new HashMap(d.this.irD);
                        }
                        c.ctW().D(hashMap);
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
