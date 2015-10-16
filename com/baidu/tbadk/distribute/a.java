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
    public static String anU = null;
    private static a anV = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a aoa = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener aob = new d(this, 2000994);
    private ArrayList<AdReq> anX = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.b> aoc = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.b> aod = new ArrayList<>();
    private boolean isUpload = true;
    private long anY = TbConfig.USE_TIME_INTERVAL;
    private int anZ = 10;
    private boolean anW = i.iM();

    public static a Ag() {
        return anV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(boolean z) {
        if (this.anW != z) {
            this.anW = z;
            if (z) {
                ba(true);
            } else {
                Ah();
            }
        }
    }

    private void Ah() {
        this.handler.removeMessages(1);
    }

    private void Ai() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.anY);
    }

    private synchronized void a(AdReq adReq) {
        if (this.anX != null && this.anX.size() < 20) {
            this.anX.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m(List<AdReq> list) {
        if (this.anX != null) {
            this.anX.addAll(list);
        }
    }

    private a() {
    }

    public void Aj() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerTask(Am());
        messageManager.registerTask(Ak());
        messageManager.registerListener(this.aoa);
        messageManager.registerListener(this.aob);
    }

    private HttpMessageTask Ak() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void aZ(boolean z) {
        this.isUpload = z;
    }

    public void dM(int i) {
        if (i > 3600) {
            this.anY = 300000L;
        } else if (i <= 0) {
            this.anY = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.anY = i * 1000;
        }
    }

    public void dN(int i) {
        if (i > 20) {
            this.anZ = 10;
        } else if (i <= 0) {
            this.anZ = 5;
        } else {
            this.anZ = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str, long j, String str2, String str3, int i) {
        AdReq a = bVar.a(str, j, str2, str3, i);
        if (TextUtils.equals(str3, "show")) {
            a(a);
        }
        if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
            if (this.anW) {
                MessageManager.getInstance().sendMessage(new DistributeRequest(a));
            } else {
                a(a);
            }
        }
        ba(false);
    }

    private boolean Al() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(boolean z) {
        if (this.anW && this.isUpload) {
            List<AdReq> bb = bb(z);
            if (z || !Al()) {
                Ai();
            }
            if (bb != null && bb.size() != 0) {
                if (!z) {
                    Ai();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(bb));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.anX.size() < r3.anZ) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> bb(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.anX.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.anX);
                this.anX.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask Am() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.i(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void a(Context context, com.baidu.tbadk.core.data.b bVar, String str, String str2, String str3, long j) {
        if (TextUtils.equals(str, "show")) {
            if (TextUtils.equals(str2, "frs")) {
                this.aoc.add(bVar);
            } else if (TextUtils.equals(str2, "pb")) {
                this.aod.add(bVar);
            }
        } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
            StringBuilder sb = new StringBuilder(15);
            sb.append(String.valueOf(k.K(context)));
            sb.append(",");
            sb.append(String.valueOf(k.L(context)));
            TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", bVar.Ub, "da_type", str, "da_obj_id", bVar.TV, ImageViewerConfig.FORUM_ID, str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(bVar.Uj.Ul), "da_ext_info", bVar.Uh, "da_price", bVar.price, "da_verify", bVar.Ug, SocialConstants.PARAM_CUID, TbadkCoreApplication.m411getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", bVar.TW, "da_first_name", bVar.Uc, "da_second_name", bVar.Ud, "da_cpid", Integer.valueOf(bVar.Ue), "da_abtest", bVar.abtest, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
        }
    }

    public void a(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.aoc, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.aod, str, str2, j);
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
                            sb.append(bVar.Ug).append("|");
                            sb2.append(bVar.Ub).append("|");
                            sb3.append(bVar.TV).append("|");
                            sb4.append(bVar.Uj.Ul).append("|");
                            sb5.append(bVar.Uh).append("|");
                            sb6.append(bVar.price).append("|");
                            sb7.append(bVar.TW).append("|");
                            sb8.append(bVar.Uc).append("|");
                            sb9.append(bVar.Ud).append("|");
                            sb10.append(bVar.Ue).append("|");
                            sb11.append(bVar.abtest).append("|");
                        } else {
                            sb.append(bVar.Ug);
                            sb2.append(bVar.Ub);
                            sb3.append(bVar.TV);
                            sb4.append(bVar.Uj.Ul);
                            sb5.append(bVar.Uh);
                            sb6.append(bVar.price);
                            sb7.append(bVar.TW);
                            sb8.append(bVar.Uc);
                            sb9.append(bVar.Ud);
                            sb10.append(bVar.Ue);
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
