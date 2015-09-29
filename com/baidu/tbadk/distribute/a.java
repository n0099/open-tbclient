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
    public static String anT = null;
    private static a anU = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a anZ = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener aoa = new d(this, 2000994);
    private ArrayList<AdReq> anW = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.b> aob = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.b> aoc = new ArrayList<>();
    private boolean isUpload = true;
    private long anX = TbConfig.USE_TIME_INTERVAL;
    private int anY = 10;
    private boolean anV = i.iM();

    public static a Ag() {
        return anU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(boolean z) {
        if (this.anV != z) {
            this.anV = z;
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
        this.handler.sendEmptyMessageDelayed(1, this.anX);
    }

    private synchronized void a(AdReq adReq) {
        if (this.anW != null && this.anW.size() < 20) {
            this.anW.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m(List<AdReq> list) {
        if (this.anW != null) {
            this.anW.addAll(list);
        }
    }

    private a() {
    }

    public void Aj() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerTask(Am());
        messageManager.registerTask(Ak());
        messageManager.registerListener(this.anZ);
        messageManager.registerListener(this.aoa);
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
            this.anX = 300000L;
        } else if (i <= 0) {
            this.anX = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.anX = i * 1000;
        }
    }

    public void dN(int i) {
        if (i > 20) {
            this.anY = 10;
        } else if (i <= 0) {
            this.anY = 5;
        } else {
            this.anY = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str, long j, String str2, String str3) {
        AdReq b = bVar.b(str, j, str2, str3);
        if (TextUtils.equals(str3, "show")) {
            a(b);
        }
        if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
            if (this.anV) {
                MessageManager.getInstance().sendMessage(new DistributeRequest(b));
            } else {
                a(b);
            }
        }
        ba(false);
    }

    private boolean Al() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(boolean z) {
        if (this.anV && this.isUpload) {
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
        if (r3.anW.size() < r3.anY) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> bb(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.anW.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.anW);
                this.anW.clear();
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
                this.aob.add(bVar);
            } else if (TextUtils.equals(str2, "pb")) {
                this.aoc.add(bVar);
            }
        } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
            StringBuilder sb = new StringBuilder(15);
            sb.append(String.valueOf(k.K(context)));
            sb.append(",");
            sb.append(String.valueOf(k.L(context)));
            TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", bVar.Ua, "da_type", str, "da_obj_id", bVar.TU, ImageViewerConfig.FORUM_ID, str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(bVar.Ui.Uk), "da_ext_info", bVar.Ug, "da_price", bVar.price, "da_verify", bVar.Uf, SocialConstants.PARAM_CUID, TbadkCoreApplication.m411getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", bVar.TV, "da_first_name", bVar.Ub, "da_second_name", bVar.Uc, "da_cpid", Integer.valueOf(bVar.Ud), "da_abtest", bVar.abtest, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
        }
    }

    public void a(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.aob, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.aoc, str, str2, j);
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
                            sb.append(bVar.Uf).append("|");
                            sb2.append(bVar.Ua).append("|");
                            sb3.append(bVar.TU).append("|");
                            sb4.append(bVar.Ui.Uk).append("|");
                            sb5.append(bVar.Ug).append("|");
                            sb6.append(bVar.price).append("|");
                            sb7.append(bVar.TV).append("|");
                            sb8.append(bVar.Ub).append("|");
                            sb9.append(bVar.Uc).append("|");
                            sb10.append(bVar.Ud).append("|");
                            sb11.append(bVar.abtest).append("|");
                        } else {
                            sb.append(bVar.Uf);
                            sb2.append(bVar.Ua);
                            sb3.append(bVar.TU);
                            sb4.append(bVar.Ui.Uk);
                            sb5.append(bVar.Ug);
                            sb6.append(bVar.price);
                            sb7.append(bVar.TV);
                            sb8.append(bVar.Ub);
                            sb9.append(bVar.Uc);
                            sb10.append(bVar.Ud);
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
