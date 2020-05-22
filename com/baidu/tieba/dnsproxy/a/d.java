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
    private static d gLI = null;
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
    private Object gLJ = new Object();
    private Map<String, a> gLK = null;
    private a gLL = null;
    private boolean gLM = false;

    public static final d bNk() {
        if (gLI == null) {
            synchronized (d.class) {
                if (gLI == null) {
                    gLI = new d();
                }
            }
        }
        return gLI;
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
        if (!this.gLM) {
            c.bNg().a(new l<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.bMX().w(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.gLJ) {
                                if (d.this.gLK == null) {
                                    d.this.gLK = new ConcurrentHashMap();
                                }
                                d.this.gLK.clear();
                                d.this.gLK.putAll(hashMap);
                            }
                            d.this.gLM = true;
                            d.this.bNm();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.gLK.entrySet()) {
                                if (d.this.gLL != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).gLw > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.bMW().am("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.gLK.remove(aVar.name);
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

    public void bNl() {
        bNm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNm() {
        if (this.gLM) {
            String bNf = a.bNf();
            if (!TextUtils.isEmpty(bNf)) {
                if (!this.gLK.containsKey(bNf)) {
                    e.bMX().mc(false);
                    return;
                }
                this.gLL = this.gLK.get(bNf);
                if (this.gLL == null) {
                    e.bMX().mc(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.gLL.gLx > BdKVCache.MILLS_1Hour && currentTimeMillis - this.gLL.gLw < BdKVCache.MILLS_1Hour) {
                    e.bMX().mc(false);
                }
            }
        }
    }

    public float dS(String str, String str2) {
        if (!this.gLM || this.gLL == null) {
            return 0.0f;
        }
        b bVar = this.gLL.gLu.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.gLy;
    }

    public float dT(String str, String str2) {
        if (!this.gLM || this.gLL == null) {
            return 10000.0f;
        }
        b bVar = this.gLL.gLv.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.gLy;
    }

    public void aA(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.gLM && !TextUtils.isEmpty(str)) {
            e.bMX().w(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.gLL != null) {
                        b bVar = d.this.gLL.gLu.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.gLL.gLu.put(str, bVar);
                        }
                        bVar.sy(z ? 1 : 0);
                        synchronized (d.this.gLJ) {
                            hashMap = new HashMap(d.this.gLK);
                        }
                        c.bNg().s(hashMap);
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
        if (this.gLM && !TextUtils.isEmpty(str)) {
            e.bMX().w(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.gLL == null) {
                        String bNf = a.bNf();
                        if (!TextUtils.isEmpty(bNf)) {
                            a aVar = new a();
                            aVar.name = bNf;
                            d.this.gLL = aVar;
                            d.this.gLK.put(bNf, aVar);
                        }
                    }
                    if (d.this.gLL != null) {
                        b bVar = d.this.gLL.gLu.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.gLL.gLu.put(str, bVar);
                        }
                        bVar.sy(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.gLL.gLv.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.gLL.gLv.put(str, bVar2);
                            }
                            bVar2.sy(i);
                        }
                        synchronized (d.this.gLJ) {
                            hashMap = new HashMap(d.this.gLK);
                        }
                        c.bNg().s(hashMap);
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
