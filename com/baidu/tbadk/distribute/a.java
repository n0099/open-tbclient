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
    public static String anZ = null;
    private static a aoa = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a aof = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener aog = new d(this, 2000994);
    private ArrayList<AdReq> aoc = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.b> aoh = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.b> aoi = new ArrayList<>();
    private boolean isUpload = true;
    private long aod = TbConfig.USE_TIME_INTERVAL;
    private int aoe = 10;
    private boolean aob = i.iN();

    public static a Ai() {
        return aoa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(boolean z) {
        if (this.aob != z) {
            this.aob = z;
            if (z) {
                ba(true);
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
        this.handler.sendEmptyMessageDelayed(1, this.aod);
    }

    private synchronized void a(AdReq adReq) {
        if (this.aoc != null && this.aoc.size() < 20) {
            this.aoc.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n(List<AdReq> list) {
        if (this.aoc != null) {
            this.aoc.addAll(list);
        }
    }

    private a() {
    }

    public void Al() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerTask(Ao());
        messageManager.registerTask(Am());
        messageManager.registerListener(this.aof);
        messageManager.registerListener(this.aog);
    }

    private HttpMessageTask Am() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void aZ(boolean z) {
        this.isUpload = z;
    }

    public void dM(int i) {
        if (i > 3600) {
            this.aod = 300000L;
        } else if (i <= 0) {
            this.aod = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.aod = i * 1000;
        }
    }

    public void dN(int i) {
        if (i > 20) {
            this.aoe = 10;
        } else if (i <= 0) {
            this.aoe = 5;
        } else {
            this.aoe = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str, long j, String str2, String str3, int i) {
        AdReq a = bVar.a(str, j, str2, str3, i);
        if (TextUtils.equals(str3, "show")) {
            a(a);
        }
        if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
            if (this.aob) {
                MessageManager.getInstance().sendMessage(new DistributeRequest(a));
            } else {
                a(a);
            }
        }
        ba(false);
    }

    private boolean An() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(boolean z) {
        if (this.aob && this.isUpload) {
            List<AdReq> bb = bb(z);
            if (z || !An()) {
                Ak();
            }
            if (bb != null && bb.size() != 0) {
                if (!z) {
                    Ak();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(bb));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.aoc.size() < r3.aoe) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> bb(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.aoc.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.aoc);
                this.aoc.clear();
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

    public void a(Context context, com.baidu.tbadk.core.data.b bVar, String str, String str2, String str3, long j) {
        if (TextUtils.equals(str, "show")) {
            if (TextUtils.equals(str2, "frs")) {
                this.aoh.add(bVar);
            } else if (TextUtils.equals(str2, "pb")) {
                this.aoi.add(bVar);
            }
        } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
            StringBuilder sb = new StringBuilder(15);
            sb.append(String.valueOf(k.K(context)));
            sb.append(",");
            sb.append(String.valueOf(k.L(context)));
            TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", bVar.Uc, "da_type", str, "da_obj_id", bVar.TW, ImageViewerConfig.FORUM_ID, str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(bVar.Uk.Um), "da_ext_info", bVar.Ui, "da_price", bVar.price, "da_verify", bVar.Uh, SocialConstants.PARAM_CUID, TbadkCoreApplication.m411getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", bVar.TX, "da_first_name", bVar.Ud, "da_second_name", bVar.Ue, "da_cpid", Integer.valueOf(bVar.Uf), "da_abtest", bVar.abtest, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
        }
    }

    public void a(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.aoh, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.aoi, str, str2, j);
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
                            sb.append(bVar.Uh).append("|");
                            sb2.append(bVar.Uc).append("|");
                            sb3.append(bVar.TW).append("|");
                            sb4.append(bVar.Uk.Um).append("|");
                            sb5.append(bVar.Ui).append("|");
                            sb6.append(bVar.price).append("|");
                            sb7.append(bVar.TX).append("|");
                            sb8.append(bVar.Ud).append("|");
                            sb9.append(bVar.Ue).append("|");
                            sb10.append(bVar.Uf).append("|");
                            sb11.append(bVar.abtest).append("|");
                        } else {
                            sb.append(bVar.Uh);
                            sb2.append(bVar.Uc);
                            sb3.append(bVar.TW);
                            sb4.append(bVar.Uk.Um);
                            sb5.append(bVar.Ui);
                            sb6.append(bVar.price);
                            sb7.append(bVar.TX);
                            sb8.append(bVar.Ud);
                            sb9.append(bVar.Ue);
                            sb10.append(bVar.Uf);
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
