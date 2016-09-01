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
    public static String atg = null;
    private static a ath = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a atm = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener atn = new d(this, 2000994);
    private final CustomMessageListener downloadListener = new e(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private HashMap<String, com.baidu.tbadk.core.data.b> atq = new HashMap<>();
    private HashMap<String, com.baidu.tbadk.core.data.b> atr = new HashMap<>();
    private ArrayList<AdReq> atj = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.b> ato = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.b> atp = new ArrayList<>();
    private boolean isUpload = true;
    private long atk = TbConfig.USE_TIME_INTERVAL;
    private int atl = 10;
    private boolean ati = i.gm();

    public static a Cp() {
        return ath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(boolean z) {
        if (this.ati != z) {
            this.ati = z;
            if (z) {
                bw(true);
            } else {
                Cq();
            }
        }
    }

    private void Cq() {
        this.handler.removeMessages(1);
    }

    private void Cr() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.atk);
    }

    private synchronized void a(AdReq adReq) {
        if (this.atj != null && this.atj.size() < 20) {
            this.atj.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void v(List<AdReq> list) {
        if (this.atj != null) {
            this.atj.addAll(list);
        }
    }

    private a() {
    }

    public void bu(boolean z) {
        MessageManager messageManager = MessageManager.getInstance();
        if (z) {
            messageManager.registerTask(Cu());
        }
        messageManager.registerTask(Cs());
        messageManager.registerListener(this.atm);
        messageManager.registerListener(this.atn);
        messageManager.registerListener(this.downloadListener);
    }

    private HttpMessageTask Cs() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void bv(boolean z) {
        this.isUpload = z;
    }

    public void eq(int i) {
        if (i > 3600) {
            this.atk = 300000L;
        } else if (i <= 0) {
            this.atk = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.atk = i * 1000;
        }
    }

    public void er(int i) {
        if (i > 20) {
            this.atl = 10;
        } else if (i <= 0) {
            this.atl = 5;
        } else {
            this.atl = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str, long j, String str2, String str3, int i) {
        if (bVar != null) {
            AdReq a = bVar.a(str, j, str2, str3, i);
            if (TextUtils.equals(str3, "show")) {
                a(a);
            }
            if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
                if (this.ati) {
                    MessageManager.getInstance().sendMessage(new DistributeRequest(a));
                } else {
                    a(a);
                }
            }
            bw(false);
        }
    }

    private boolean Ct() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw(boolean z) {
        if (this.ati && this.isUpload) {
            List<AdReq> bx = bx(z);
            if (z || !Ct()) {
                Cr();
            }
            if (bx != null && bx.size() != 0) {
                if (!z) {
                    Cr();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(bx));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.atj.size() < r3.atl) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> bx(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.atj.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.atj);
                this.atj.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask Cu() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.l(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void a(Context context, com.baidu.tbadk.core.data.b bVar, String str, String str2, String str3, long j) {
        com.baidu.tbadk.coreExtra.data.a adAdSense;
        if (bVar != null && (adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense()) != null && adAdSense.xy()) {
            if (TextUtils.equals(str, "show")) {
                if (TextUtils.equals(str2, "frs")) {
                    this.ato.add(bVar);
                } else if (TextUtils.equals(str2, "pb")) {
                    this.atp.add(bVar);
                }
            } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
                StringBuilder sb = new StringBuilder(15);
                sb.append(String.valueOf(k.K(context)));
                sb.append(",");
                sb.append(String.valueOf(k.L(context)));
                TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", bVar.Pf, "da_type", str, "da_obj_id", bVar.OY, "fid", str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(bVar.Pn.Pq), "da_ext_info", bVar.Pl, "da_price", bVar.price, "da_verify", bVar.Pk, SocialConstants.PARAM_CUID, TbadkCoreApplication.m9getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", bVar.OZ, "da_first_name", bVar.Pg, "da_second_name", bVar.Ph, "da_cpid", Integer.valueOf(bVar.Pi), "da_abtest", bVar.abtest, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
            }
        }
    }

    public void b(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.ato, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.atp, str, str2, j);
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
                            sb.append(bVar.Pk).append("|");
                            sb2.append(bVar.Pf).append("|");
                            sb3.append(bVar.OY).append("|");
                            sb4.append(bVar.Pn.Pq).append("|");
                            sb5.append(bVar.Pl).append("|");
                            sb6.append(bVar.price).append("|");
                            sb7.append(bVar.OZ).append("|");
                            sb8.append(bVar.Pg).append("|");
                            sb9.append(bVar.Ph).append("|");
                            sb10.append(bVar.Pi).append("|");
                            sb11.append(bVar.abtest).append("|");
                        } else {
                            sb.append(bVar.Pk);
                            sb2.append(bVar.Pf);
                            sb3.append(bVar.OY);
                            sb4.append(bVar.Pn.Pq);
                            sb5.append(bVar.Pl);
                            sb6.append(bVar.price);
                            sb7.append(bVar.OZ);
                            sb8.append(bVar.Pg);
                            sb9.append(bVar.Ph);
                            sb10.append(bVar.Pi);
                            sb11.append(bVar.abtest);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(k.K(context)));
                    sb12.append(",");
                    sb12.append(String.valueOf(k.L(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, "fid", str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, SocialConstants.PARAM_CUID, TbadkCoreApplication.m9getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ff(String str) {
        com.baidu.tbadk.core.data.b remove = this.atq.remove(str);
        if (remove != null) {
            this.atr.put(str, remove);
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(remove, "download_status", 0);
            a.bM("dl", IntentConfig.START);
            com.baidu.tieba.recapp.report.b.bbu().a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, int i) {
        String str2;
        com.baidu.tbadk.core.data.b remove = this.atr.remove(str);
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
            a.bM("dl", str2);
            com.baidu.tieba.recapp.report.b.bbu().a(a);
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar) {
        this.atq.put(bVar.Pe, bVar);
    }
}
