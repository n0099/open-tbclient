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
    public static String apR = null;
    private static a apS = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a apX = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener apY = new d(this, 2000994);
    private ArrayList<AdReq> apU = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.b> apZ = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.b> aqa = new ArrayList<>();
    private boolean isUpload = true;
    private long apV = TbConfig.USE_TIME_INTERVAL;
    private int apW = 10;
    private boolean apT = i.iP();

    public static a Bf() {
        return apS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(boolean z) {
        if (this.apT != z) {
            this.apT = z;
            if (z) {
                bh(true);
            } else {
                Bg();
            }
        }
    }

    private void Bg() {
        this.handler.removeMessages(1);
    }

    private void Bh() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.apV);
    }

    private synchronized void a(AdReq adReq) {
        if (this.apU != null && this.apU.size() < 20) {
            this.apU.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m(List<AdReq> list) {
        if (this.apU != null) {
            this.apU.addAll(list);
        }
    }

    private a() {
    }

    public void Bi() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerTask(Bl());
        messageManager.registerTask(Bj());
        messageManager.registerListener(this.apX);
        messageManager.registerListener(this.apY);
    }

    private HttpMessageTask Bj() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void bg(boolean z) {
        this.isUpload = z;
    }

    public void eb(int i) {
        if (i > 3600) {
            this.apV = 300000L;
        } else if (i <= 0) {
            this.apV = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.apV = i * 1000;
        }
    }

    public void ec(int i) {
        if (i > 20) {
            this.apW = 10;
        } else if (i <= 0) {
            this.apW = 5;
        } else {
            this.apW = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str, long j, String str2, String str3, int i) {
        AdReq a = bVar.a(str, j, str2, str3, i);
        if (TextUtils.equals(str3, "show")) {
            a(a);
        }
        if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
            if (this.apT) {
                MessageManager.getInstance().sendMessage(new DistributeRequest(a));
            } else {
                a(a);
            }
        }
        bh(false);
    }

    private boolean Bk() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bh(boolean z) {
        if (this.apT && this.isUpload) {
            List<AdReq> bi = bi(z);
            if (z || !Bk()) {
                Bh();
            }
            if (bi != null && bi.size() != 0) {
                if (!z) {
                    Bh();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(bi));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.apU.size() < r3.apW) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> bi(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.apU.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.apU);
                this.apU.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask Bl() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.i(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void a(Context context, com.baidu.tbadk.core.data.b bVar, String str, String str2, String str3, long j) {
        if (TextUtils.equals(str, "show")) {
            if (TextUtils.equals(str2, "frs")) {
                this.apZ.add(bVar);
            } else if (TextUtils.equals(str2, "pb")) {
                this.aqa.add(bVar);
            }
        } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
            StringBuilder sb = new StringBuilder(15);
            sb.append(String.valueOf(k.K(context)));
            sb.append(",");
            sb.append(String.valueOf(k.L(context)));
            TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", bVar.Us, "da_type", str, "da_obj_id", bVar.Um, ImageViewerConfig.FORUM_ID, str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(bVar.UA.UC), "da_ext_info", bVar.Uy, "da_price", bVar.price, "da_verify", bVar.Ux, SocialConstants.PARAM_CUID, TbadkCoreApplication.m411getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", bVar.Un, "da_first_name", bVar.Ut, "da_second_name", bVar.Uu, "da_cpid", Integer.valueOf(bVar.Uv), "da_abtest", bVar.abtest, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
        }
    }

    public void a(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.apZ, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.aqa, str, str2, j);
        }
    }

    private void a(Context context, ArrayList<com.baidu.tbadk.core.data.b> arrayList, String str, String str2, long j) {
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
                    com.baidu.tbadk.core.data.b bVar = arrayList.get(i2);
                    if (bVar != null) {
                        if (i2 != size - 1) {
                            sb.append(bVar.Ux).append("|");
                            sb2.append(bVar.Us).append("|");
                            sb3.append(bVar.Um).append("|");
                            sb4.append(bVar.UA.UC).append("|");
                            sb5.append(bVar.Uy).append("|");
                            sb6.append(bVar.price).append("|");
                            sb7.append(bVar.Un).append("|");
                            sb8.append(bVar.Ut).append("|");
                            sb9.append(bVar.Uu).append("|");
                            sb10.append(bVar.Uv).append("|");
                            sb11.append(bVar.abtest).append("|");
                        } else {
                            sb.append(bVar.Ux);
                            sb2.append(bVar.Us);
                            sb3.append(bVar.Um);
                            sb4.append(bVar.UA.UC);
                            sb5.append(bVar.Uy);
                            sb6.append(bVar.price);
                            sb7.append(bVar.Un);
                            sb8.append(bVar.Ut);
                            sb9.append(bVar.Uu);
                            sb10.append(bVar.Uv);
                            sb11.append(bVar.abtest);
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
