package com.baidu.tbadk.distribute;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class a {
    public static String Xq = null;
    private static a Xr = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a Xx = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener Xy = new d(this, 2001121);
    private ArrayList<AdReq> Xt = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> Xz = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> XA = new ArrayList<>();
    private boolean Xu = true;
    private long Xv = TbConfig.USE_TIME_INTERVAL;
    private int Xw = 10;
    private boolean Xs = i.ff();

    public static a uU() {
        return Xr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(boolean z) {
        if (this.Xs != z) {
            this.Xs = z;
            if (z) {
                aH(true);
            } else {
                uV();
            }
        }
    }

    private void uV() {
        this.handler.removeMessages(1);
    }

    private void uW() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.Xv);
    }

    private synchronized void a(AdReq adReq) {
        if (this.Xt != null && this.Xt.size() < 20) {
            this.Xt.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k(List<AdReq> list) {
        if (this.Xt != null) {
            this.Xt.addAll(list);
        }
    }

    private a() {
    }

    public void uX() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerTask(va());
        messageManager.registerTask(uY());
        messageManager.registerListener(this.Xx);
        messageManager.registerListener(this.Xy);
    }

    private HttpMessageTask uY() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void aG(boolean z) {
        this.Xu = z;
    }

    public void dh(int i) {
        if (i > 3600) {
            this.Xv = 300000L;
        } else if (i <= 0) {
            this.Xv = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.Xv = i * 1000;
        }
    }

    public void di(int i) {
        if (i > 20) {
            this.Xw = 10;
        } else if (i <= 0) {
            this.Xw = 5;
        } else {
            this.Xw = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str, long j, String str2, String str3) {
        AdReq a = cVar.a(str, j, str2, str3);
        if (TextUtils.equals(str3, "show")) {
            a(a);
        }
        if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
            if (this.Xs) {
                MessageManager.getInstance().sendMessage(new DistributeRequest(a));
            } else {
                a(a);
            }
        }
        aH(false);
    }

    private boolean uZ() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(boolean z) {
        if (this.Xs && this.Xu) {
            List<AdReq> aI = aI(z);
            if (z || !uZ()) {
                uW();
            }
            if (aI != null && aI.size() != 0) {
                if (!z) {
                    uW();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(aI));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.Xt.size() < r3.Xw) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> aI(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.Xt.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.Xt);
                this.Xt.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask va() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.i(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void a(Context context, com.baidu.tbadk.core.data.c cVar, String str, String str2, String str3, long j) {
        if (TextUtils.equals(str, "show")) {
            if (TextUtils.equals(str2, "frs")) {
                this.Xz.add(cVar);
            } else if (TextUtils.equals(str2, "pb")) {
                this.XA.add(cVar);
            }
        } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
            StringBuilder sb = new StringBuilder(15);
            sb.append(String.valueOf(l.M(context)));
            sb.append(",");
            sb.append(String.valueOf(l.N(context)));
            TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", Integer.valueOf(cVar.Dt), "da_type", str, "da_obj_id", cVar.Dn, ImageViewerConfig.FORUM_ID, str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(cVar.DB.DE), "da_ext_info", cVar.Dz, "da_price", cVar.price, "da_verify", cVar.Dy, "cuid", TbadkCoreApplication.m255getInst().getCuid(), SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", cVar.Do, "da_first_name", cVar.Du, "da_second_name", cVar.Dv, "da_cpid", Integer.valueOf(cVar.Dw), "da_abtest", cVar.abtest, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
        }
    }

    public void a(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.Xz, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.XA, str, str2, j);
        }
    }

    private void a(Context context, ArrayList<com.baidu.tbadk.core.data.c> arrayList, String str, String str2, long j) {
        if (arrayList != null && arrayList.size() > 0) {
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
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size) {
                    com.baidu.tbadk.core.data.c cVar = arrayList.get(i2);
                    if (cVar != null) {
                        if (i2 != size - 1) {
                            sb.append(cVar.Dy).append("|");
                            sb2.append(cVar.Dt).append("|");
                            sb3.append(cVar.Dn).append("|");
                            sb4.append(cVar.DB.DE).append("|");
                            sb5.append(cVar.Dz).append("|");
                            sb6.append(cVar.price).append("|");
                            sb7.append(cVar.Do).append("|");
                            sb8.append(cVar.Du).append("|");
                            sb9.append(cVar.Dv).append("|");
                            sb10.append(cVar.Dw).append("|");
                            sb11.append(cVar.abtest).append("|");
                        } else {
                            sb.append(cVar.Dy);
                            sb2.append(cVar.Dt);
                            sb3.append(cVar.Dn);
                            sb4.append(cVar.DB.DE);
                            sb5.append(cVar.Dz);
                            sb6.append(cVar.price);
                            sb7.append(cVar.Do);
                            sb8.append(cVar.Du);
                            sb9.append(cVar.Dv);
                            sb10.append(cVar.Dw);
                            sb11.append(cVar.abtest);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(l.M(context)));
                    sb12.append(",");
                    sb12.append(String.valueOf(l.N(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, ImageViewerConfig.FORUM_ID, str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, "cuid", TbadkCoreApplication.m255getInst().getCuid(), SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    arrayList.clear();
                    return;
                }
            }
        }
    }
}
