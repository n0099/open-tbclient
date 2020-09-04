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
/* loaded from: classes13.dex */
public class d {
    private static d hru = null;
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
    private Object hrv = new Object();
    private Map<String, a> hrw = null;
    private a hrx = null;
    private boolean hry = false;

    public static final d cdQ() {
        if (hru == null) {
            synchronized (d.class) {
                if (hru == null) {
                    hru = new d();
                }
            }
        }
        return hru;
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
        if (!this.hry) {
            c.cdM().a(new l<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.cdD().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.hrv) {
                                if (d.this.hrw == null) {
                                    d.this.hrw = new ConcurrentHashMap();
                                }
                                d.this.hrw.clear();
                                d.this.hrw.putAll(hashMap);
                            }
                            d.this.hry = true;
                            d.this.cdS();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.hrw.entrySet()) {
                                if (d.this.hrx != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).hri > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.cdC().ao("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.hrw.remove(aVar.name);
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

    public void cdR() {
        cdS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdS() {
        if (this.hry) {
            String cdL = a.cdL();
            if (!TextUtils.isEmpty(cdL)) {
                if (!this.hrw.containsKey(cdL)) {
                    e.cdD().ny(false);
                    return;
                }
                this.hrx = this.hrw.get(cdL);
                if (this.hrx == null) {
                    e.cdD().ny(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hrx.hrj > BdKVCache.MILLS_1Hour && currentTimeMillis - this.hrx.hri < BdKVCache.MILLS_1Hour) {
                    e.cdD().ny(false);
                }
            }
        }
    }

    public float er(String str, String str2) {
        if (!this.hry || this.hrx == null) {
            return 0.0f;
        }
        b bVar = this.hrx.hrg.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.hrk;
    }

    public float es(String str, String str2) {
        if (!this.hry || this.hrx == null) {
            return 10000.0f;
        }
        b bVar = this.hrx.hrh.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.hrk;
    }

    public void aE(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.hry && !TextUtils.isEmpty(str)) {
            e.cdD().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.hrx != null) {
                        b bVar = d.this.hrx.hrg.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.hrx.hrg.put(str, bVar);
                        }
                        bVar.vI(z ? 1 : 0);
                        synchronized (d.this.hrv) {
                            hashMap = new HashMap(d.this.hrw);
                        }
                        c.cdM().t(hashMap);
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
        if (this.hry && !TextUtils.isEmpty(str)) {
            e.cdD().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.hrx == null) {
                        String cdL = a.cdL();
                        if (!TextUtils.isEmpty(cdL)) {
                            a aVar = new a();
                            aVar.name = cdL;
                            d.this.hrx = aVar;
                            d.this.hrw.put(cdL, aVar);
                        }
                    }
                    if (d.this.hrx != null) {
                        b bVar = d.this.hrx.hrg.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.hrx.hrg.put(str, bVar);
                        }
                        bVar.vI(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.hrx.hrh.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.hrx.hrh.put(str, bVar2);
                            }
                            bVar2.vI(i);
                        }
                        synchronized (d.this.hrv) {
                            hashMap = new HashMap(d.this.hrw);
                        }
                        c.cdM().t(hashMap);
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
