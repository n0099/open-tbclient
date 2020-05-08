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
import com.baidu.tbadk.util.l;
import com.baidu.tieba.dnsproxy.e;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class d {
    private static d gwY = null;
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
    private Object gwZ = new Object();
    private Map<String, a> gxa = null;
    private a gxb = null;
    private boolean gxc = false;

    public static final d bGQ() {
        if (gwY == null) {
            synchronized (d.class) {
                if (gwY == null) {
                    gwY = new d();
                }
            }
        }
        return gwY;
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
        if (!this.gxc) {
            c.bGM().a(new l<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.bGD().u(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.gwZ) {
                                if (d.this.gxa == null) {
                                    d.this.gxa = new ConcurrentHashMap();
                                }
                                d.this.gxa.clear();
                                d.this.gxa.putAll(hashMap);
                            }
                            d.this.gxc = true;
                            d.this.bGS();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.gxa.entrySet()) {
                                if (d.this.gxb != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).gwM > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.bGC().ai("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.gxa.remove(aVar.name);
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

    public void bGR() {
        bGS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGS() {
        if (this.gxc) {
            String bGL = a.bGL();
            if (!TextUtils.isEmpty(bGL)) {
                if (!this.gxa.containsKey(bGL)) {
                    e.bGD().lG(false);
                    return;
                }
                this.gxb = this.gxa.get(bGL);
                if (this.gxb == null) {
                    e.bGD().lG(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.gxb.gwN > BdKVCache.MILLS_1Hour && currentTimeMillis - this.gxb.gwM < BdKVCache.MILLS_1Hour) {
                    e.bGD().lG(false);
                }
            }
        }
    }

    public float dr(String str, String str2) {
        if (!this.gxc || this.gxb == null) {
            return 0.0f;
        }
        b bVar = this.gxb.gwK.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.gwO;
    }

    public float ds(String str, String str2) {
        if (!this.gxc || this.gxb == null) {
            return 10000.0f;
        }
        b bVar = this.gxb.gwL.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.gwO;
    }

    public void an(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.gxc && !TextUtils.isEmpty(str)) {
            e.bGD().u(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.gxb != null) {
                        b bVar = d.this.gxb.gwK.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.gxb.gwK.put(str, bVar);
                        }
                        bVar.rT(z ? 1 : 0);
                        synchronized (d.this.gwZ) {
                            hashMap = new HashMap(d.this.gxa);
                        }
                        c.bGM().t(hashMap);
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
        if (this.gxc && !TextUtils.isEmpty(str)) {
            e.bGD().u(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.gxb == null) {
                        String bGL = a.bGL();
                        if (!TextUtils.isEmpty(bGL)) {
                            a aVar = new a();
                            aVar.name = bGL;
                            d.this.gxb = aVar;
                            d.this.gxa.put(bGL, aVar);
                        }
                    }
                    if (d.this.gxb != null) {
                        b bVar = d.this.gxb.gwK.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.gxb.gwK.put(str, bVar);
                        }
                        bVar.rT(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.gxb.gwL.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.gxb.gwL.put(str, bVar2);
                            }
                            bVar2.rT(i);
                        }
                        synchronized (d.this.gwZ) {
                            hashMap = new HashMap(d.this.gxa);
                        }
                        c.bGM().t(hashMap);
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
