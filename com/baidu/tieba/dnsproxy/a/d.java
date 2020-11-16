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
    private static d igH = null;
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
    private Object igI = new Object();
    private Map<String, a> igJ = null;
    private a igK = null;
    private boolean igL = false;

    public static final d cpM() {
        if (igH == null) {
            synchronized (d.class) {
                if (igH == null) {
                    igH = new d();
                }
            }
        }
        return igH;
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
        if (!this.igL) {
            c.cpI().a(new m<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.cpz().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.igI) {
                                if (d.this.igJ == null) {
                                    d.this.igJ = new ConcurrentHashMap();
                                }
                                d.this.igJ.clear();
                                d.this.igJ.putAll(hashMap);
                            }
                            d.this.igL = true;
                            d.this.cpO();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.igJ.entrySet()) {
                                if (d.this.igK != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).igv > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.cpy().ay("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.igJ.remove(aVar.name);
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

    public void cpN() {
        cpO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpO() {
        if (this.igL) {
            String cpH = a.cpH();
            if (!TextUtils.isEmpty(cpH)) {
                if (!this.igJ.containsKey(cpH)) {
                    e.cpz().oN(false);
                    return;
                }
                this.igK = this.igJ.get(cpH);
                if (this.igK == null) {
                    e.cpz().oN(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.igK.igw > BdKVCache.MILLS_1Hour && currentTimeMillis - this.igK.igv < BdKVCache.MILLS_1Hour) {
                    e.cpz().oN(false);
                }
            }
        }
    }

    public float eH(String str, String str2) {
        if (!this.igL || this.igK == null) {
            return 0.0f;
        }
        b bVar = this.igK.igt.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.igx;
    }

    public float eI(String str, String str2) {
        if (!this.igL || this.igK == null) {
            return 10000.0f;
        }
        b bVar = this.igK.igu.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.igx;
    }

    public void aK(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.igL && !TextUtils.isEmpty(str)) {
            e.cpz().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.igK != null) {
                        b bVar = d.this.igK.igt.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.igK.igt.put(str, bVar);
                        }
                        bVar.xR(z ? 1 : 0);
                        synchronized (d.this.igI) {
                            hashMap = new HashMap(d.this.igJ);
                        }
                        c.cpI().D(hashMap);
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
        if (this.igL && !TextUtils.isEmpty(str)) {
            e.cpz().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.igK == null) {
                        String cpH = a.cpH();
                        if (!TextUtils.isEmpty(cpH)) {
                            a aVar = new a();
                            aVar.name = cpH;
                            d.this.igK = aVar;
                            d.this.igJ.put(cpH, aVar);
                        }
                    }
                    if (d.this.igK != null) {
                        b bVar = d.this.igK.igt.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.igK.igt.put(str, bVar);
                        }
                        bVar.xR(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.igK.igu.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.igK.igu.put(str, bVar2);
                            }
                            bVar2.xR(i);
                        }
                        synchronized (d.this.igI) {
                            hashMap = new HashMap(d.this.igJ);
                        }
                        c.cpI().D(hashMap);
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
