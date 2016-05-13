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
    public static String aov = null;
    private static a aow = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a aoB = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener aoC = new d(this, 2000994);
    private final CustomMessageListener downloadListener = new e(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private HashMap<String, com.baidu.tbadk.core.data.c> aoF = new HashMap<>();
    private HashMap<String, com.baidu.tbadk.core.data.c> aoG = new HashMap<>();
    private ArrayList<AdReq> aoy = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> aoD = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> aoE = new ArrayList<>();
    private boolean isUpload = true;
    private long aoz = TbConfig.USE_TIME_INTERVAL;
    private int aoA = 10;
    private boolean aox = i.fq();

    public static a AL() {
        return aow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(boolean z) {
        if (this.aox != z) {
            this.aox = z;
            if (z) {
                bu(true);
            } else {
                AM();
            }
        }
    }

    private void AM() {
        this.handler.removeMessages(1);
    }

    private void AN() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.aoz);
    }

    private synchronized void a(AdReq adReq) {
        if (this.aoy != null && this.aoy.size() < 20) {
            this.aoy.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(List<AdReq> list) {
        if (this.aoy != null) {
            this.aoy.addAll(list);
        }
    }

    private a() {
    }

    public void bs(boolean z) {
        MessageManager messageManager = MessageManager.getInstance();
        if (z) {
            messageManager.registerTask(AQ());
        }
        messageManager.registerTask(AO());
        messageManager.registerListener(this.aoB);
        messageManager.registerListener(this.aoC);
        messageManager.registerListener(this.downloadListener);
    }

    private HttpMessageTask AO() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void bt(boolean z) {
        this.isUpload = z;
    }

    public void dY(int i) {
        if (i > 3600) {
            this.aoz = 300000L;
        } else if (i <= 0) {
            this.aoz = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.aoz = i * 1000;
        }
    }

    public void dZ(int i) {
        if (i > 20) {
            this.aoA = 10;
        } else if (i <= 0) {
            this.aoA = 5;
        } else {
            this.aoA = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str, long j, String str2, String str3, int i) {
        if (cVar != null) {
            AdReq a = cVar.a(str, j, str2, str3, i);
            if (TextUtils.equals(str3, "show")) {
                a(a);
            }
            if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
                if (this.aox) {
                    MessageManager.getInstance().sendMessage(new DistributeRequest(a));
                } else {
                    a(a);
                }
            }
            bu(false);
        }
    }

    private boolean AP() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(boolean z) {
        if (this.aox && this.isUpload) {
            List<AdReq> bv = bv(z);
            if (z || !AP()) {
                AN();
            }
            if (bv != null && bv.size() != 0) {
                if (!z) {
                    AN();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(bv));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.aoy.size() < r3.aoA) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> bv(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.aoy.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.aoy);
                this.aoy.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask AQ() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.h(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void a(Context context, com.baidu.tbadk.core.data.c cVar, String str, String str2, String str3, long j) {
        if (cVar != null) {
            if (TextUtils.equals(str, "show")) {
                if (TextUtils.equals(str2, "frs")) {
                    this.aoD.add(cVar);
                } else if (TextUtils.equals(str2, "pb")) {
                    this.aoE.add(cVar);
                }
            } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
                StringBuilder sb = new StringBuilder(15);
                sb.append(String.valueOf(k.B(context)));
                sb.append(",");
                sb.append(String.valueOf(k.C(context)));
                TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", cVar.MT, "da_type", str, "da_obj_id", cVar.MN, "fid", str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(cVar.Nb.Nh), "da_ext_info", cVar.MZ, "da_price", cVar.price, "da_verify", cVar.MY, SocialConstants.PARAM_CUID, TbadkCoreApplication.m11getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", cVar.MO, "da_first_name", cVar.MU, "da_second_name", cVar.MV, "da_cpid", Integer.valueOf(cVar.MW), "da_abtest", cVar.abtest, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
            }
        }
    }

    public void b(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.aoD, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.aoE, str, str2, j);
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
                            sb.append(cVar.MY).append("|");
                            sb2.append(cVar.MT).append("|");
                            sb3.append(cVar.MN).append("|");
                            sb4.append(cVar.Nb.Nh).append("|");
                            sb5.append(cVar.MZ).append("|");
                            sb6.append(cVar.price).append("|");
                            sb7.append(cVar.MO).append("|");
                            sb8.append(cVar.MU).append("|");
                            sb9.append(cVar.MV).append("|");
                            sb10.append(cVar.MW).append("|");
                            sb11.append(cVar.abtest).append("|");
                        } else {
                            sb.append(cVar.MY);
                            sb2.append(cVar.MT);
                            sb3.append(cVar.MN);
                            sb4.append(cVar.Nb.Nh);
                            sb5.append(cVar.MZ);
                            sb6.append(cVar.price);
                            sb7.append(cVar.MO);
                            sb8.append(cVar.MU);
                            sb9.append(cVar.MV);
                            sb10.append(cVar.MW);
                            sb11.append(cVar.abtest);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(k.B(context)));
                    sb12.append(",");
                    sb12.append(String.valueOf(k.C(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, "fid", str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, SocialConstants.PARAM_CUID, TbadkCoreApplication.m11getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(String str) {
        com.baidu.tbadk.core.data.c remove = this.aoF.remove(str);
        if (remove != null) {
            this.aoG.put(str, remove);
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(remove, "download_status", 0);
            a.bE("dl", IntentConfig.START);
            com.baidu.tieba.recapp.report.b.aLJ().a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, int i) {
        String str2;
        com.baidu.tbadk.core.data.c remove = this.aoG.remove(str);
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
            a.bE("dl", str2);
            com.baidu.tieba.recapp.report.b.aLJ().a(a);
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar) {
        this.aoF.put(cVar.MS, cVar);
    }
}
