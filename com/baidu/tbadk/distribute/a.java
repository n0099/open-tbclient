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
    public static String apj = null;
    private static a apk = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a apq = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener apr = new d(this, 2000994);
    private final CustomMessageListener downloadListener = new e(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private HashMap<String, com.baidu.tbadk.core.data.b> apu = new HashMap<>();
    private HashMap<String, com.baidu.tbadk.core.data.b> apv = new HashMap<>();
    private ArrayList<AdReq> apm = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.b> aps = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.b> apt = new ArrayList<>();
    private boolean isUpload = true;
    private long apn = TbConfig.USE_TIME_INTERVAL;
    private int apo = 10;
    private boolean apl = i.fr();

    public static a AU() {
        return apk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(boolean z) {
        if (this.apl != z) {
            this.apl = z;
            if (z) {
                br(true);
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
        this.handler.sendEmptyMessageDelayed(1, this.apn);
    }

    private synchronized void a(AdReq adReq) {
        if (this.apm != null && this.apm.size() < 20) {
            this.apm.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void v(List<AdReq> list) {
        if (this.apm != null) {
            this.apm.addAll(list);
        }
    }

    private a() {
    }

    public void bp(boolean z) {
        MessageManager messageManager = MessageManager.getInstance();
        if (z) {
            messageManager.registerTask(AZ());
        }
        messageManager.registerTask(AX());
        messageManager.registerListener(this.apq);
        messageManager.registerListener(this.apr);
        messageManager.registerListener(this.downloadListener);
    }

    private HttpMessageTask AX() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void bq(boolean z) {
        this.isUpload = z;
    }

    public void ec(int i) {
        if (i > 3600) {
            this.apn = 300000L;
        } else if (i <= 0) {
            this.apn = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.apn = i * 1000;
        }
    }

    public void ed(int i) {
        if (i > 20) {
            this.apo = 10;
        } else if (i <= 0) {
            this.apo = 5;
        } else {
            this.apo = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str, long j, String str2, String str3, int i) {
        if (bVar != null) {
            AdReq a = bVar.a(str, j, str2, str3, i);
            if (TextUtils.equals(str3, "show")) {
                a(a);
            }
            if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
                if (this.apl) {
                    MessageManager.getInstance().sendMessage(new DistributeRequest(a));
                } else {
                    a(a);
                }
            }
            br(false);
        }
    }

    private boolean AY() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(boolean z) {
        if (this.apl && this.isUpload) {
            List<AdReq> bs = bs(z);
            if (z || !AY()) {
                AW();
            }
            if (bs != null && bs.size() != 0) {
                if (!z) {
                    AW();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(bs));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.apm.size() < r3.apo) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> bs(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.apm.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.apm);
                this.apm.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask AZ() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.h(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void a(Context context, com.baidu.tbadk.core.data.b bVar, String str, String str2, String str3, long j) {
        if (bVar != null) {
            if (TextUtils.equals(str, "show")) {
                if (TextUtils.equals(str2, "frs")) {
                    this.aps.add(bVar);
                } else if (TextUtils.equals(str2, "pb")) {
                    this.apt.add(bVar);
                }
            } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
                StringBuilder sb = new StringBuilder(15);
                sb.append(String.valueOf(k.A(context)));
                sb.append(",");
                sb.append(String.valueOf(k.B(context)));
                TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", bVar.MO, "da_type", str, "da_obj_id", bVar.MG, "fid", str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(bVar.MW.Nd), "da_ext_info", bVar.MU, "da_price", bVar.price, "da_verify", bVar.MT, SocialConstants.PARAM_CUID, TbadkCoreApplication.m9getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", bVar.MH, "da_first_name", bVar.MP, "da_second_name", bVar.MQ, "da_cpid", Integer.valueOf(bVar.MR), "da_abtest", bVar.abtest, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
            }
        }
    }

    public void b(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.aps, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.apt, str, str2, j);
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
                            sb.append(bVar.MT).append("|");
                            sb2.append(bVar.MO).append("|");
                            sb3.append(bVar.MG).append("|");
                            sb4.append(bVar.MW.Nd).append("|");
                            sb5.append(bVar.MU).append("|");
                            sb6.append(bVar.price).append("|");
                            sb7.append(bVar.MH).append("|");
                            sb8.append(bVar.MP).append("|");
                            sb9.append(bVar.MQ).append("|");
                            sb10.append(bVar.MR).append("|");
                            sb11.append(bVar.abtest).append("|");
                        } else {
                            sb.append(bVar.MT);
                            sb2.append(bVar.MO);
                            sb3.append(bVar.MG);
                            sb4.append(bVar.MW.Nd);
                            sb5.append(bVar.MU);
                            sb6.append(bVar.price);
                            sb7.append(bVar.MH);
                            sb8.append(bVar.MP);
                            sb9.append(bVar.MQ);
                            sb10.append(bVar.MR);
                            sb11.append(bVar.abtest);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(k.A(context)));
                    sb12.append(",");
                    sb12.append(String.valueOf(k.B(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, "fid", str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, SocialConstants.PARAM_CUID, TbadkCoreApplication.m9getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fe(String str) {
        com.baidu.tbadk.core.data.b remove = this.apu.remove(str);
        if (remove != null) {
            this.apv.put(str, remove);
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(remove, "download_status", 0);
            a.bG("dl", IntentConfig.START);
            com.baidu.tieba.recapp.report.b.aUO().a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, int i) {
        String str2;
        com.baidu.tbadk.core.data.b remove = this.apv.remove(str);
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
            a.bG("dl", str2);
            com.baidu.tieba.recapp.report.b.aUO().a(a);
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar) {
        this.apu.put(bVar.MN, bVar);
    }
}
