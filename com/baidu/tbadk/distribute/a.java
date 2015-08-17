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
    public static String anJ = null;
    private static a anK = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a anP = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener anQ = new d(this, 2000994);
    private ArrayList<AdReq> anM = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> anR = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> anS = new ArrayList<>();
    private boolean isUpload = true;
    private long anN = TbConfig.USE_TIME_INTERVAL;
    private int anO = 10;
    private boolean anL = i.iO();

    public static a Ai() {
        return anK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(boolean z) {
        if (this.anL != z) {
            this.anL = z;
            if (z) {
                aY(true);
            } else {
                Aj();
            }
        }
    }

    private void Aj() {
        this.handler.removeMessages(1);
    }

    private void Ak() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.anN);
    }

    private synchronized void a(AdReq adReq) {
        if (this.anM != null && this.anM.size() < 20) {
            this.anM.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l(List<AdReq> list) {
        if (this.anM != null) {
            this.anM.addAll(list);
        }
    }

    private a() {
    }

    public void Al() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerTask(Ao());
        messageManager.registerTask(Am());
        messageManager.registerListener(this.anP);
        messageManager.registerListener(this.anQ);
    }

    private HttpMessageTask Am() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void aX(boolean z) {
        this.isUpload = z;
    }

    public void dD(int i) {
        if (i > 3600) {
            this.anN = 300000L;
        } else if (i <= 0) {
            this.anN = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.anN = i * 1000;
        }
    }

    public void dE(int i) {
        if (i > 20) {
            this.anO = 10;
        } else if (i <= 0) {
            this.anO = 5;
        } else {
            this.anO = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str, long j, String str2, String str3) {
        AdReq b = cVar.b(str, j, str2, str3);
        if (TextUtils.equals(str3, "show")) {
            a(b);
        }
        if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
            if (this.anL) {
                MessageManager.getInstance().sendMessage(new DistributeRequest(b));
            } else {
                a(b);
            }
        }
        aY(false);
    }

    private boolean An() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(boolean z) {
        if (this.anL && this.isUpload) {
            List<AdReq> aZ = aZ(z);
            if (z || !An()) {
                Ak();
            }
            if (aZ != null && aZ.size() != 0) {
                if (!z) {
                    Ak();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(aZ));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.anM.size() < r3.anO) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> aZ(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.anM.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.anM);
                this.anM.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask Ao() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.i(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void a(Context context, com.baidu.tbadk.core.data.c cVar, String str, String str2, String str3, long j) {
        if (TextUtils.equals(str, "show")) {
            if (TextUtils.equals(str2, "frs")) {
                this.anR.add(cVar);
            } else if (TextUtils.equals(str2, "pb")) {
                this.anS.add(cVar);
            }
        } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
            StringBuilder sb = new StringBuilder(15);
            sb.append(String.valueOf(k.K(context)));
            sb.append(",");
            sb.append(String.valueOf(k.L(context)));
            TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", Integer.valueOf(cVar.Un), "da_type", str, "da_obj_id", cVar.Uh, ImageViewerConfig.FORUM_ID, str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(cVar.Uv.Ux), "da_ext_info", cVar.Ut, "da_price", cVar.price, "da_verify", cVar.Us, SocialConstants.PARAM_CUID, TbadkCoreApplication.m411getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", cVar.Ui, "da_first_name", cVar.Uo, "da_second_name", cVar.Up, "da_cpid", Integer.valueOf(cVar.Uq), "da_abtest", cVar.abtest, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
        }
    }

    public void a(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.anR, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.anS, str, str2, j);
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
                            sb.append(cVar.Us).append("|");
                            sb2.append(cVar.Un).append("|");
                            sb3.append(cVar.Uh).append("|");
                            sb4.append(cVar.Uv.Ux).append("|");
                            sb5.append(cVar.Ut).append("|");
                            sb6.append(cVar.price).append("|");
                            sb7.append(cVar.Ui).append("|");
                            sb8.append(cVar.Uo).append("|");
                            sb9.append(cVar.Up).append("|");
                            sb10.append(cVar.Uq).append("|");
                            sb11.append(cVar.abtest).append("|");
                        } else {
                            sb.append(cVar.Us);
                            sb2.append(cVar.Un);
                            sb3.append(cVar.Uh);
                            sb4.append(cVar.Uv.Ux);
                            sb5.append(cVar.Ut);
                            sb6.append(cVar.price);
                            sb7.append(cVar.Ui);
                            sb8.append(cVar.Uo);
                            sb9.append(cVar.Up);
                            sb10.append(cVar.Uq);
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
