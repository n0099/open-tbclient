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
import com.baidu.adp.lib.util.k;
import com.baidu.cloudsdk.social.core.SocialConstants;
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
    public static String apu = null;
    private static a apv = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a apA = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener apB = new d(this, 2000994);
    private ArrayList<AdReq> apx = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> apC = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> apD = new ArrayList<>();
    private boolean isUpload = true;
    private long apy = TbConfig.USE_TIME_INTERVAL;
    private int apz = 10;
    private boolean apw = i.iL();

    public static a Av() {
        return apv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(boolean z) {
        if (this.apw != z) {
            this.apw = z;
            if (z) {
                bf(true);
            } else {
                Aw();
            }
        }
    }

    private void Aw() {
        this.handler.removeMessages(1);
    }

    private void Ax() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.apy);
    }

    private synchronized void a(AdReq adReq) {
        if (this.apx != null && this.apx.size() < 20) {
            this.apx.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m(List<AdReq> list) {
        if (this.apx != null) {
            this.apx.addAll(list);
        }
    }

    private a() {
    }

    public void Ay() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerTask(AB());
        messageManager.registerTask(Az());
        messageManager.registerListener(this.apA);
        messageManager.registerListener(this.apB);
    }

    private HttpMessageTask Az() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void be(boolean z) {
        this.isUpload = z;
    }

    public void dL(int i) {
        if (i > 3600) {
            this.apy = 300000L;
        } else if (i <= 0) {
            this.apy = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.apy = i * 1000;
        }
    }

    public void dM(int i) {
        if (i > 20) {
            this.apz = 10;
        } else if (i <= 0) {
            this.apz = 5;
        } else {
            this.apz = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str, long j, String str2, String str3) {
        AdReq b = cVar.b(str, j, str2, str3);
        if (TextUtils.equals(str3, "show")) {
            a(b);
        }
        if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
            if (this.apw) {
                MessageManager.getInstance().sendMessage(new DistributeRequest(b));
            } else {
                a(b);
            }
        }
        bf(false);
    }

    private boolean AA() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(boolean z) {
        if (this.apw && this.isUpload) {
            List<AdReq> bg = bg(z);
            if (z || !AA()) {
                Ax();
            }
            if (bg != null && bg.size() != 0) {
                if (!z) {
                    Ax();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(bg));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.apx.size() < r3.apz) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> bg(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.apx.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.apx);
                this.apx.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask AB() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.i(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void a(Context context, com.baidu.tbadk.core.data.c cVar, String str, String str2, String str3, long j) {
        if (TextUtils.equals(str, "show")) {
            if (TextUtils.equals(str2, "frs")) {
                this.apC.add(cVar);
            } else if (TextUtils.equals(str2, "pb")) {
                this.apD.add(cVar);
            }
        } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
            StringBuilder sb = new StringBuilder(15);
            sb.append(String.valueOf(k.K(context)));
            sb.append(",");
            sb.append(String.valueOf(k.L(context)));
            TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", Integer.valueOf(cVar.Uo), "da_type", str, "da_obj_id", cVar.Ui, ImageViewerConfig.FORUM_ID, str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(cVar.Uw.Uy), "da_ext_info", cVar.Uu, "da_price", cVar.price, "da_verify", cVar.Ut, SocialConstants.PARAM_CUID, TbadkCoreApplication.m411getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", cVar.Uj, "da_first_name", cVar.Up, "da_second_name", cVar.Uq, "da_cpid", Integer.valueOf(cVar.Ur), "da_abtest", cVar.abtest, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
        }
    }

    public void a(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.apC, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.apD, str, str2, j);
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
                            sb.append(cVar.Ut).append("|");
                            sb2.append(cVar.Uo).append("|");
                            sb3.append(cVar.Ui).append("|");
                            sb4.append(cVar.Uw.Uy).append("|");
                            sb5.append(cVar.Uu).append("|");
                            sb6.append(cVar.price).append("|");
                            sb7.append(cVar.Uj).append("|");
                            sb8.append(cVar.Up).append("|");
                            sb9.append(cVar.Uq).append("|");
                            sb10.append(cVar.Ur).append("|");
                            sb11.append(cVar.abtest).append("|");
                        } else {
                            sb.append(cVar.Ut);
                            sb2.append(cVar.Uo);
                            sb3.append(cVar.Ui);
                            sb4.append(cVar.Uw.Uy);
                            sb5.append(cVar.Uu);
                            sb6.append(cVar.price);
                            sb7.append(cVar.Uj);
                            sb8.append(cVar.Up);
                            sb9.append(cVar.Uq);
                            sb10.append(cVar.Ur);
                            sb11.append(cVar.abtest);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(k.K(context)));
                    sb12.append(",");
                    sb12.append(String.valueOf(k.L(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, ImageViewerConfig.FORUM_ID, str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, SocialConstants.PARAM_CUID, TbadkCoreApplication.m411getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    arrayList.clear();
                    return;
                }
            }
        }
    }
}
