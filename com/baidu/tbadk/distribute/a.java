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
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class a {
    public static String asm = null;
    private static a asn = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a ass = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener ast = new d(this, 2000994);
    private final CustomMessageListener downloadListener = new e(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private HashMap<String, com.baidu.tbadk.core.data.c> asw = new HashMap<>();
    private HashMap<String, com.baidu.tbadk.core.data.c> asx = new HashMap<>();
    private ArrayList<AdReq> asp = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> asu = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> asv = new ArrayList<>();
    private boolean isUpload = true;
    private long asq = TbConfig.USE_TIME_INTERVAL;
    private int asr = 10;
    private boolean aso = i.iZ();

    public static a Cl() {
        return asn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(boolean z) {
        if (this.aso != z) {
            this.aso = z;
            if (z) {
                bj(true);
            } else {
                Cm();
            }
        }
    }

    private void Cm() {
        this.handler.removeMessages(1);
    }

    private void Cn() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.asq);
    }

    private synchronized void a(AdReq adReq) {
        if (this.asp != null && this.asp.size() < 20) {
            this.asp.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(List<AdReq> list) {
        if (this.asp != null) {
            this.asp.addAll(list);
        }
    }

    private a() {
    }

    public void bh(boolean z) {
        MessageManager messageManager = MessageManager.getInstance();
        if (z) {
            messageManager.registerTask(Cq());
        }
        messageManager.registerTask(Co());
        messageManager.registerListener(this.ass);
        messageManager.registerListener(this.ast);
        messageManager.registerListener(this.downloadListener);
    }

    private HttpMessageTask Co() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void bi(boolean z) {
        this.isUpload = z;
    }

    public void eq(int i) {
        if (i > 3600) {
            this.asq = 300000L;
        } else if (i <= 0) {
            this.asq = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.asq = i * 1000;
        }
    }

    public void er(int i) {
        if (i > 20) {
            this.asr = 10;
        } else if (i <= 0) {
            this.asr = 5;
        } else {
            this.asr = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str, long j, String str2, String str3, int i) {
        if (cVar != null) {
            AdReq a = cVar.a(str, j, str2, str3, i);
            if (TextUtils.equals(str3, "show")) {
                a(a);
            }
            if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
                if (this.aso) {
                    MessageManager.getInstance().sendMessage(new DistributeRequest(a));
                } else {
                    a(a);
                }
            }
            bj(false);
        }
    }

    private boolean Cp() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(boolean z) {
        if (this.aso && this.isUpload) {
            List<AdReq> bk = bk(z);
            if (z || !Cp()) {
                Cn();
            }
            if (bk != null && bk.size() != 0) {
                if (!z) {
                    Cn();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(bk));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.asp.size() < r3.asr) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> bk(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.asp.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.asp);
                this.asp.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask Cq() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.i(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void a(Context context, com.baidu.tbadk.core.data.c cVar, String str, String str2, String str3, long j) {
        if (cVar != null) {
            if (TextUtils.equals(str, "show")) {
                if (TextUtils.equals(str2, "frs")) {
                    this.asu.add(cVar);
                } else if (TextUtils.equals(str2, "pb")) {
                    this.asv.add(cVar);
                }
            } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
                StringBuilder sb = new StringBuilder(15);
                sb.append(String.valueOf(k.K(context)));
                sb.append(",");
                sb.append(String.valueOf(k.L(context)));
                TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", cVar.Uz, "da_type", str, "da_obj_id", cVar.Ut, ImageViewerConfig.FORUM_ID, str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(cVar.UI.UO), "da_ext_info", cVar.UG, "da_price", cVar.price, "da_verify", cVar.UF, SocialConstants.PARAM_CUID, TbadkCoreApplication.m411getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", cVar.Uu, "da_first_name", cVar.UB, "da_second_name", cVar.UC, "da_cpid", Integer.valueOf(cVar.UD), "da_abtest", cVar.abtest, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
            }
        }
    }

    public void b(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.asu, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.asv, str, str2, j);
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
                            sb.append(cVar.UF).append("|");
                            sb2.append(cVar.Uz).append("|");
                            sb3.append(cVar.Ut).append("|");
                            sb4.append(cVar.UI.UO).append("|");
                            sb5.append(cVar.UG).append("|");
                            sb6.append(cVar.price).append("|");
                            sb7.append(cVar.Uu).append("|");
                            sb8.append(cVar.UB).append("|");
                            sb9.append(cVar.UC).append("|");
                            sb10.append(cVar.UD).append("|");
                            sb11.append(cVar.abtest).append("|");
                        } else {
                            sb.append(cVar.UF);
                            sb2.append(cVar.Uz);
                            sb3.append(cVar.Ut);
                            sb4.append(cVar.UI.UO);
                            sb5.append(cVar.UG);
                            sb6.append(cVar.price);
                            sb7.append(cVar.Uu);
                            sb8.append(cVar.UB);
                            sb9.append(cVar.UC);
                            sb10.append(cVar.UD);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void eU(String str) {
        com.baidu.tbadk.core.data.c remove = this.asw.remove(str);
        if (remove != null) {
            this.asx.put(str, remove);
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(remove, "download_status", 0);
            a.bj("dl", IntentConfig.START);
            com.baidu.tieba.recapp.report.b.aEK().a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, int i) {
        String str2;
        com.baidu.tbadk.core.data.c remove = this.asx.remove(str);
        if (remove != null) {
            if (i == 0) {
                str2 = ImagesInvalidReceiver.SUCCESS;
            } else if (i == 2) {
                str2 = "fail";
            } else if (i == 4) {
                str2 = "cancel";
            } else {
                return;
            }
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(remove, "download_status", 0);
            a.bj("dl", str2);
            com.baidu.tieba.recapp.report.b.aEK().a(a);
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar) {
        this.asw.put(cVar.Uy, cVar);
    }
}
