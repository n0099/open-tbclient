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
    public static String apZ = null;
    private static a aqa = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a aqf = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener aqg = new d(this, 2000994);
    private final CustomMessageListener downloadListener = new e(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private HashMap<String, com.baidu.tbadk.core.data.b> aqj = new HashMap<>();
    private HashMap<String, com.baidu.tbadk.core.data.b> aqk = new HashMap<>();
    private ArrayList<AdReq> aqc = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.b> aqh = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.b> aqi = new ArrayList<>();
    private boolean isUpload = true;
    private long aqd = TbConfig.USE_TIME_INTERVAL;
    private int aqe = 10;
    private boolean aqb = i.fq();

    public static a AU() {
        return aqa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(boolean z) {
        if (this.aqb != z) {
            this.aqb = z;
            if (z) {
                bu(true);
            } else {
                AV();
            }
        }
    }

    private void AV() {
        this.handler.removeMessages(1);
    }

    private void AW() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.aqd);
    }

    private synchronized void a(AdReq adReq) {
        if (this.aqc != null && this.aqc.size() < 20) {
            this.aqc.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void v(List<AdReq> list) {
        if (this.aqc != null) {
            this.aqc.addAll(list);
        }
    }

    private a() {
    }

    public void bs(boolean z) {
        MessageManager messageManager = MessageManager.getInstance();
        if (z) {
            messageManager.registerTask(AZ());
        }
        messageManager.registerTask(AX());
        messageManager.registerListener(this.aqf);
        messageManager.registerListener(this.aqg);
        messageManager.registerListener(this.downloadListener);
    }

    private HttpMessageTask AX() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void bt(boolean z) {
        this.isUpload = z;
    }

    public void ec(int i) {
        if (i > 3600) {
            this.aqd = 300000L;
        } else if (i <= 0) {
            this.aqd = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.aqd = i * 1000;
        }
    }

    public void ed(int i) {
        if (i > 20) {
            this.aqe = 10;
        } else if (i <= 0) {
            this.aqe = 5;
        } else {
            this.aqe = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str, long j, String str2, String str3, int i) {
        if (bVar != null) {
            AdReq a = bVar.a(str, j, str2, str3, i);
            if (TextUtils.equals(str3, "show")) {
                a(a);
            }
            if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
                if (this.aqb) {
                    MessageManager.getInstance().sendMessage(new DistributeRequest(a));
                } else {
                    a(a);
                }
            }
            bu(false);
        }
    }

    private boolean AY() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(boolean z) {
        if (this.aqb && this.isUpload) {
            List<AdReq> bv = bv(z);
            if (z || !AY()) {
                AW();
            }
            if (bv != null && bv.size() != 0) {
                if (!z) {
                    AW();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(bv));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.aqc.size() < r3.aqe) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> bv(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.aqc.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.aqc);
                this.aqc.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask AZ() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.j(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void a(Context context, com.baidu.tbadk.core.data.b bVar, String str, String str2, String str3, long j) {
        if (bVar != null) {
            if (TextUtils.equals(str, "show")) {
                if (TextUtils.equals(str2, "frs")) {
                    this.aqh.add(bVar);
                } else if (TextUtils.equals(str2, "pb")) {
                    this.aqi.add(bVar);
                }
            } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
                StringBuilder sb = new StringBuilder(15);
                sb.append(String.valueOf(k.A(context)));
                sb.append(",");
                sb.append(String.valueOf(k.B(context)));
                TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", bVar.MM, "da_type", str, "da_obj_id", bVar.ME, "fid", str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(bVar.MU.Nb), "da_ext_info", bVar.MS, "da_price", bVar.price, "da_verify", bVar.MR, SocialConstants.PARAM_CUID, TbadkCoreApplication.m10getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", bVar.MF, "da_first_name", bVar.MN, "da_second_name", bVar.MO, "da_cpid", Integer.valueOf(bVar.MP), "da_abtest", bVar.abtest, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
            }
        }
    }

    public void b(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.aqh, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.aqi, str, str2, j);
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
                            sb.append(bVar.MR).append("|");
                            sb2.append(bVar.MM).append("|");
                            sb3.append(bVar.ME).append("|");
                            sb4.append(bVar.MU.Nb).append("|");
                            sb5.append(bVar.MS).append("|");
                            sb6.append(bVar.price).append("|");
                            sb7.append(bVar.MF).append("|");
                            sb8.append(bVar.MN).append("|");
                            sb9.append(bVar.MO).append("|");
                            sb10.append(bVar.MP).append("|");
                            sb11.append(bVar.abtest).append("|");
                        } else {
                            sb.append(bVar.MR);
                            sb2.append(bVar.MM);
                            sb3.append(bVar.ME);
                            sb4.append(bVar.MU.Nb);
                            sb5.append(bVar.MS);
                            sb6.append(bVar.price);
                            sb7.append(bVar.MF);
                            sb8.append(bVar.MN);
                            sb9.append(bVar.MO);
                            sb10.append(bVar.MP);
                            sb11.append(bVar.abtest);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(k.A(context)));
                    sb12.append(",");
                    sb12.append(String.valueOf(k.B(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, "fid", str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, SocialConstants.PARAM_CUID, TbadkCoreApplication.m10getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fc(String str) {
        com.baidu.tbadk.core.data.b remove = this.aqj.remove(str);
        if (remove != null) {
            this.aqk.put(str, remove);
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(remove, "download_status", 0);
            a.bL("dl", IntentConfig.START);
            com.baidu.tieba.recapp.report.b.aYc().a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, int i) {
        String str2;
        com.baidu.tbadk.core.data.b remove = this.aqk.remove(str);
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
            a.bL("dl", str2);
            com.baidu.tieba.recapp.report.b.aYc().a(a);
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar) {
        this.aqj.put(bVar.MK, bVar);
    }
}
