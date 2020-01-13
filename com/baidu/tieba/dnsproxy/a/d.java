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
/* loaded from: classes5.dex */
public class d {
    private static d fOR = null;
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
    private Object fOS = new Object();
    private Map<String, a> fOT = null;
    private a fOU = null;
    private boolean fOV = false;

    public static final d bvu() {
        if (fOR == null) {
            synchronized (d.class) {
                if (fOR == null) {
                    fOR = new d();
                }
            }
        }
        return fOR;
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
        if (!this.fOV) {
            c.bvq().a(new l<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.bvh().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.fOS) {
                                if (d.this.fOT == null) {
                                    d.this.fOT = new ConcurrentHashMap();
                                }
                                d.this.fOT.clear();
                                d.this.fOT.putAll(hashMap);
                            }
                            d.this.fOV = true;
                            d.this.bvw();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.fOT.entrySet()) {
                                if (d.this.fOU != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).fOF > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.bvg().aj("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.fOT.remove(aVar.name);
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

    public void bvv() {
        bvw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvw() {
        if (this.fOV) {
            String bvp = a.bvp();
            if (!TextUtils.isEmpty(bvp)) {
                if (!this.fOT.containsKey(bvp)) {
                    e.bvh().kw(false);
                    return;
                }
                this.fOU = this.fOT.get(bvp);
                if (this.fOU == null) {
                    e.bvh().kw(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.fOU.fOG > BdKVCache.MILLS_1Hour && currentTimeMillis - this.fOU.fOF < BdKVCache.MILLS_1Hour) {
                    e.bvh().kw(false);
                }
            }
        }
    }

    public float cV(String str, String str2) {
        if (!this.fOV || this.fOU == null) {
            return 0.0f;
        }
        b bVar = this.fOU.fOD.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.fOH;
    }

    public float cW(String str, String str2) {
        if (!this.fOV || this.fOU == null) {
            return 10000.0f;
        }
        b bVar = this.fOU.fOE.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.fOH;
    }

    public void ah(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.fOV && !TextUtils.isEmpty(str)) {
            e.bvh().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.fOU != null) {
                        b bVar = d.this.fOU.fOD.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.fOU.fOD.put(str, bVar);
                        }
                        bVar.rt(z ? 1 : 0);
                        synchronized (d.this.fOS) {
                            hashMap = new HashMap(d.this.fOT);
                        }
                        c.bvq().v(hashMap);
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
        if (this.fOV && !TextUtils.isEmpty(str)) {
            e.bvh().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.fOU == null) {
                        String bvp = a.bvp();
                        if (!TextUtils.isEmpty(bvp)) {
                            a aVar = new a();
                            aVar.name = bvp;
                            d.this.fOU = aVar;
                            d.this.fOT.put(bvp, aVar);
                        }
                    }
                    if (d.this.fOU != null) {
                        b bVar = d.this.fOU.fOD.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.fOU.fOD.put(str, bVar);
                        }
                        bVar.rt(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.fOU.fOE.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.fOU.fOE.put(str, bVar2);
                            }
                            bVar2.rt(i);
                        }
                        synchronized (d.this.fOS) {
                            hashMap = new HashMap(d.this.fOT);
                        }
                        c.bvq().v(hashMap);
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
