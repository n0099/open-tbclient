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
/* loaded from: classes8.dex */
public class d {
    private static d iET = null;
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
    private Object iEU = new Object();
    private Map<String, a> iEV = null;
    private a iEW = null;
    private boolean iEX = false;

    public static final d cun() {
        if (iET == null) {
            synchronized (d.class) {
                if (iET == null) {
                    iET = new d();
                }
            }
        }
        return iET;
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
        if (!this.iEX) {
            c.cuj().a(new m<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.cua().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.iEU) {
                                if (d.this.iEV == null) {
                                    d.this.iEV = new ConcurrentHashMap();
                                }
                                d.this.iEV.clear();
                                d.this.iEV.putAll(hashMap);
                            }
                            d.this.iEX = true;
                            d.this.cup();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.iEV.entrySet()) {
                                if (d.this.iEW != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).iEH > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.ctZ().aD("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.iEV.remove(aVar.name);
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

    public void cuo() {
        cup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cup() {
        if (this.iEX) {
            String cui = a.cui();
            if (!TextUtils.isEmpty(cui)) {
                if (!this.iEV.containsKey(cui)) {
                    e.cua().pM(false);
                    return;
                }
                this.iEW = this.iEV.get(cui);
                if (this.iEW == null) {
                    e.cua().pM(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.iEW.iEI > BdKVCache.MILLS_1Hour && currentTimeMillis - this.iEW.iEH < BdKVCache.MILLS_1Hour) {
                    e.cua().pM(false);
                }
            }
        }
    }

    public float eM(String str, String str2) {
        if (!this.iEX || this.iEW == null) {
            return 0.0f;
        }
        b bVar = this.iEW.iEF.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.iEJ;
    }

    public float eN(String str, String str2) {
        if (!this.iEX || this.iEW == null) {
            return 10000.0f;
        }
        b bVar = this.iEW.iEG.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.iEJ;
    }

    public void aK(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.iEX && !TextUtils.isEmpty(str)) {
            e.cua().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.iEW != null) {
                        b bVar = d.this.iEW.iEF.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.iEW.iEF.put(str, bVar);
                        }
                        bVar.xn(z ? 1 : 0);
                        synchronized (d.this.iEU) {
                            hashMap = new HashMap(d.this.iEV);
                        }
                        c.cuj().G(hashMap);
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
        if (this.iEX && !TextUtils.isEmpty(str)) {
            e.cua().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.iEW == null) {
                        String cui = a.cui();
                        if (!TextUtils.isEmpty(cui)) {
                            a aVar = new a();
                            aVar.name = cui;
                            d.this.iEW = aVar;
                            d.this.iEV.put(cui, aVar);
                        }
                    }
                    if (d.this.iEW != null) {
                        b bVar = d.this.iEW.iEF.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.iEW.iEF.put(str, bVar);
                        }
                        bVar.xn(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.iEW.iEG.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.iEW.iEG.put(str, bVar2);
                            }
                            bVar2.xn(i);
                        }
                        synchronized (d.this.iEU) {
                            hashMap = new HashMap(d.this.iEV);
                        }
                        c.cuj().G(hashMap);
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
