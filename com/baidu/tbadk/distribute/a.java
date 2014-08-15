package com.baidu.tbadk.distribute;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
import java.util.List;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class a {
    private static a a = new a();
    private Handler g = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.d h = new c(this, 303101);
    private CustomMessageListener i = new d(this, 2001121);
    private ArrayList<AdReq> c = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.a> j = new ArrayList<>();
    private boolean d = true;
    private long e = TbConfig.USE_TIME_INTERVAL;
    private int f = 10;
    private boolean b = UtilHelper.isNetOk();

    public static a a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (this.b != z) {
            this.b = z;
            if (z) {
                c(true);
            } else {
                c();
            }
        }
    }

    private void c() {
        this.g.removeMessages(1);
    }

    private void d() {
        this.g.removeMessages(1);
        this.g.sendEmptyMessageDelayed(1, this.e);
    }

    private synchronized void a(AdReq adReq) {
        if (this.c != null && this.c.size() < 20) {
            this.c.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(List<AdReq> list) {
        if (this.c != null) {
            this.c.addAll(list);
        }
    }

    private a() {
    }

    public void b() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerTask(f());
        messageManager.registerListener(this.h);
        messageManager.registerListener(this.i);
    }

    public void a(boolean z) {
        this.d = z;
        c(true);
    }

    public void a(int i) {
        if (i > 3600) {
            this.e = 300000L;
        } else if (i <= 0) {
            this.e = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.e = i * 1000;
        }
    }

    public void b(int i) {
        if (i <= 20 && i > 0) {
            this.f = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.a aVar, String str, long j, String str2, String str3) {
        AdReq a2 = aVar.a(str, j, str2, str3);
        if (TextUtils.equals(str3, "show")) {
            a(a2);
        }
        if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
            if (this.b) {
                MessageManager.getInstance().sendMessage(new RequestDistributeMessage(a2));
            } else {
                a(a2);
            }
        }
        c(false);
    }

    private boolean e() {
        return this.g.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.b && this.d) {
            List<AdReq> d = d(z);
            if (z || !e()) {
                d();
            }
            if (d != null && d.size() != 0) {
                if (!z) {
                    d();
                }
                MessageManager.getInstance().sendMessage(new RequestDistributeMessage(d));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.c.size() < r3.f) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> d(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.c.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.c);
                this.c.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask f() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.a(true);
        socketMessageTask.a(ResponseDistributeMessage.class);
        return socketMessageTask;
    }

    public void a(Context context, com.baidu.tbadk.core.data.a aVar, String str, String str2, String str3, long j) {
        if (TextUtils.equals(str, "show")) {
            this.j.add(aVar);
        } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
            StringBuilder sb = new StringBuilder(15);
            sb.append(String.valueOf(j.b(context)));
            sb.append(",");
            sb.append(String.valueOf(j.c(context)));
            TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", Integer.valueOf(aVar.h), "da_type", str, "da_obj_id", aVar.b, "fid", str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(aVar.s.a), "da_ext_info", aVar.q, "da_price", aVar.l, "da_verify", aVar.p, "cuid", TbadkApplication.m252getInst().getCuid(), SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount(), "baiduid", TbadkApplication.getCurrentBduss(), "da_obj_name", aVar.c, "da_first_name", aVar.i, "da_second_name", aVar.j, "da_cpid", Integer.valueOf(aVar.k), "da_abtest", aVar.m, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
        }
    }

    public void a(Context context, String str, String str2, long j) {
        if (this.j != null && this.j.size() > 0) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            StringBuilder sb7 = new StringBuilder();
            StringBuilder sb8 = new StringBuilder();
            StringBuilder sb9 = new StringBuilder();
            StringBuilder sb10 = new StringBuilder();
            StringBuilder sb11 = new StringBuilder();
            int size = this.j.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size) {
                    com.baidu.tbadk.core.data.a aVar = this.j.get(i2);
                    if (aVar != null) {
                        if (i2 != size - 1) {
                            sb.append(aVar.p).append("|");
                            sb2.append(aVar.h).append("|");
                            sb3.append(aVar.b).append("|");
                            sb4.append(aVar.s.a).append("|");
                            sb5.append(aVar.q).append("|");
                            sb6.append(aVar.l).append("|");
                            sb7.append(aVar.c).append("|");
                            sb8.append(aVar.i).append("|");
                            sb9.append(aVar.j).append("|");
                            sb10.append(aVar.k).append("|");
                            sb11.append(aVar.m).append("|");
                        } else {
                            sb.append(aVar.p);
                            sb2.append(aVar.h);
                            sb3.append(aVar.b);
                            sb4.append(aVar.s.a);
                            sb5.append(aVar.q);
                            sb6.append(aVar.l);
                            sb7.append(aVar.c);
                            sb8.append(aVar.i);
                            sb9.append(aVar.j);
                            sb10.append(aVar.k);
                            sb11.append(aVar.m);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(j.b(context)));
                    sb12.append(",");
                    sb12.append(String.valueOf(j.c(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, "fid", str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, "cuid", TbadkApplication.m252getInst().getCuid(), SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount(), "baiduid", TbadkApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    this.j.clear();
                    return;
                }
            }
        }
    }
}
