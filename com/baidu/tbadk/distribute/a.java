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
    public static String asE = null;
    private static a asF = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a asK = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener asL = new d(this, 2000994);
    private final CustomMessageListener downloadListener = new e(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private HashMap<String, com.baidu.tbadk.core.data.c> asO = new HashMap<>();
    private HashMap<String, com.baidu.tbadk.core.data.c> asP = new HashMap<>();
    private ArrayList<AdReq> asH = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> asM = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> asN = new ArrayList<>();
    private boolean isUpload = true;
    private long asI = TbConfig.USE_TIME_INTERVAL;
    private int asJ = 10;
    private boolean asG = i.jf();

    public static a CR() {
        return asF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(boolean z) {
        if (this.asG != z) {
            this.asG = z;
            if (z) {
                bo(true);
            } else {
                CS();
            }
        }
    }

    private void CS() {
        this.handler.removeMessages(1);
    }

    private void CT() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.asI);
    }

    private synchronized void a(AdReq adReq) {
        if (this.asH != null && this.asH.size() < 20) {
            this.asH.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void s(List<AdReq> list) {
        if (this.asH != null) {
            this.asH.addAll(list);
        }
    }

    private a() {
    }

    public void bm(boolean z) {
        MessageManager messageManager = MessageManager.getInstance();
        if (z) {
            messageManager.registerTask(CW());
        }
        messageManager.registerTask(CU());
        messageManager.registerListener(this.asK);
        messageManager.registerListener(this.asL);
        messageManager.registerListener(this.downloadListener);
    }

    private HttpMessageTask CU() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void bn(boolean z) {
        this.isUpload = z;
    }

    public void et(int i) {
        if (i > 3600) {
            this.asI = 300000L;
        } else if (i <= 0) {
            this.asI = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.asI = i * 1000;
        }
    }

    public void eu(int i) {
        if (i > 20) {
            this.asJ = 10;
        } else if (i <= 0) {
            this.asJ = 5;
        } else {
            this.asJ = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str, long j, String str2, String str3, int i) {
        if (cVar != null) {
            AdReq a = cVar.a(str, j, str2, str3, i);
            if (TextUtils.equals(str3, "show")) {
                a(a);
            }
            if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
                if (this.asG) {
                    MessageManager.getInstance().sendMessage(new DistributeRequest(a));
                } else {
                    a(a);
                }
            }
            bo(false);
        }
    }

    private boolean CV() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(boolean z) {
        if (this.asG && this.isUpload) {
            List<AdReq> bp = bp(z);
            if (z || !CV()) {
                CT();
            }
            if (bp != null && bp.size() != 0) {
                if (!z) {
                    CT();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(bp));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.asH.size() < r3.asJ) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> bp(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.asH.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.asH);
                this.asH.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask CW() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.h(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void a(Context context, com.baidu.tbadk.core.data.c cVar, String str, String str2, String str3, long j) {
        if (cVar != null) {
            if (TextUtils.equals(str, "show")) {
                if (TextUtils.equals(str2, "frs")) {
                    this.asM.add(cVar);
                } else if (TextUtils.equals(str2, "pb")) {
                    this.asN.add(cVar);
                }
            } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
                StringBuilder sb = new StringBuilder(15);
                sb.append(String.valueOf(k.B(context)));
                sb.append(",");
                sb.append(String.valueOf(k.C(context)));
                TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", cVar.Sf, "da_type", str, "da_obj_id", cVar.RZ, "fid", str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(cVar.Sn.St), "da_ext_info", cVar.Sl, "da_price", cVar.price, "da_verify", cVar.Sk, SocialConstants.PARAM_CUID, TbadkCoreApplication.m411getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", cVar.Sa, "da_first_name", cVar.Sg, "da_second_name", cVar.Sh, "da_cpid", Integer.valueOf(cVar.Si), "da_abtest", cVar.abtest, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
            }
        }
    }

    public void b(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.asM, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.asN, str, str2, j);
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
                            sb.append(cVar.Sk).append("|");
                            sb2.append(cVar.Sf).append("|");
                            sb3.append(cVar.RZ).append("|");
                            sb4.append(cVar.Sn.St).append("|");
                            sb5.append(cVar.Sl).append("|");
                            sb6.append(cVar.price).append("|");
                            sb7.append(cVar.Sa).append("|");
                            sb8.append(cVar.Sg).append("|");
                            sb9.append(cVar.Sh).append("|");
                            sb10.append(cVar.Si).append("|");
                            sb11.append(cVar.abtest).append("|");
                        } else {
                            sb.append(cVar.Sk);
                            sb2.append(cVar.Sf);
                            sb3.append(cVar.RZ);
                            sb4.append(cVar.Sn.St);
                            sb5.append(cVar.Sl);
                            sb6.append(cVar.price);
                            sb7.append(cVar.Sa);
                            sb8.append(cVar.Sg);
                            sb9.append(cVar.Sh);
                            sb10.append(cVar.Si);
                            sb11.append(cVar.abtest);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(k.B(context)));
                    sb12.append(",");
                    sb12.append(String.valueOf(k.C(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, "fid", str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, SocialConstants.PARAM_CUID, TbadkCoreApplication.m411getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb(String str) {
        com.baidu.tbadk.core.data.c remove = this.asO.remove(str);
        if (remove != null) {
            this.asP.put(str, remove);
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(remove, "download_status", 0);
            a.bz("dl", IntentConfig.START);
            com.baidu.tieba.recapp.report.b.aLC().a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, int i) {
        String str2;
        com.baidu.tbadk.core.data.c remove = this.asP.remove(str);
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
            a.bz("dl", str2);
            com.baidu.tieba.recapp.report.b.aLC().a(a);
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar) {
        this.asO.put(cVar.Se, cVar);
    }
}
