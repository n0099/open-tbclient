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
    public static String art = null;
    private static a aru = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a arz = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener arA = new d(this, 2000994);
    private final CustomMessageListener downloadListener = new e(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private HashMap<String, com.baidu.tbadk.core.data.b> arD = new HashMap<>();
    private HashMap<String, com.baidu.tbadk.core.data.b> arE = new HashMap<>();
    private ArrayList<AdReq> arw = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.b> arB = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.b> arC = new ArrayList<>();
    private boolean isUpload = true;
    private long arx = TbConfig.USE_TIME_INTERVAL;
    private int ary = 10;
    private boolean arv = i.iQ();

    public static a AV() {
        return aru;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(boolean z) {
        if (this.arv != z) {
            this.arv = z;
            if (z) {
                bh(true);
            } else {
                AW();
            }
        }
    }

    private void AW() {
        this.handler.removeMessages(1);
    }

    private void AX() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.arx);
    }

    private synchronized void a(AdReq adReq) {
        if (this.arw != null && this.arw.size() < 20) {
            this.arw.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n(List<AdReq> list) {
        if (this.arw != null) {
            this.arw.addAll(list);
        }
    }

    private a() {
    }

    public void bf(boolean z) {
        MessageManager messageManager = MessageManager.getInstance();
        if (z) {
            messageManager.registerTask(Ba());
            messageManager.registerTask(AY());
            messageManager.registerListener(this.arz);
            messageManager.registerListener(this.arA);
            messageManager.registerListener(this.downloadListener);
            return;
        }
        messageManager.registerListener(this.arz);
        messageManager.registerListener(this.arA);
        messageManager.registerTask(AY());
    }

    private HttpMessageTask AY() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void bg(boolean z) {
        this.isUpload = z;
    }

    public void dV(int i) {
        if (i > 3600) {
            this.arx = 300000L;
        } else if (i <= 0) {
            this.arx = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.arx = i * 1000;
        }
    }

    public void dW(int i) {
        if (i > 20) {
            this.ary = 10;
        } else if (i <= 0) {
            this.ary = 5;
        } else {
            this.ary = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar, String str, long j, String str2, String str3, int i) {
        if (bVar != null) {
            AdReq a = bVar.a(str, j, str2, str3, i);
            if (TextUtils.equals(str3, "show")) {
                a(a);
            }
            if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
                if (this.arv) {
                    MessageManager.getInstance().sendMessage(new DistributeRequest(a));
                } else {
                    a(a);
                }
            }
            bh(false);
        }
    }

    private boolean AZ() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bh(boolean z) {
        if (this.arv && this.isUpload) {
            List<AdReq> bi = bi(z);
            if (z || !AZ()) {
                AX();
            }
            if (bi != null && bi.size() != 0) {
                if (!z) {
                    AX();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(bi));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.arw.size() < r3.ary) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> bi(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.arw.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.arw);
                this.arw.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask Ba() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.i(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void a(Context context, com.baidu.tbadk.core.data.b bVar, String str, String str2, String str3, long j) {
        if (bVar != null) {
            if (TextUtils.equals(str, "show")) {
                if (TextUtils.equals(str2, "frs")) {
                    this.arB.add(bVar);
                } else if (TextUtils.equals(str2, "pb")) {
                    this.arC.add(bVar);
                }
            } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
                StringBuilder sb = new StringBuilder(15);
                sb.append(String.valueOf(k.K(context)));
                sb.append(",");
                sb.append(String.valueOf(k.L(context)));
                TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", bVar.UT, "da_type", str, "da_obj_id", bVar.UM, ImageViewerConfig.FORUM_ID, str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(bVar.Vb.Vd), "da_ext_info", bVar.UZ, "da_price", bVar.price, "da_verify", bVar.UY, SocialConstants.PARAM_CUID, TbadkCoreApplication.m411getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", bVar.UN, "da_first_name", bVar.UU, "da_second_name", bVar.UV, "da_cpid", Integer.valueOf(bVar.UW), "da_abtest", bVar.abtest, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
            }
        }
    }

    public void a(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.arB, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.arC, str, str2, j);
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
                            sb.append(bVar.UY).append("|");
                            sb2.append(bVar.UT).append("|");
                            sb3.append(bVar.UM).append("|");
                            sb4.append(bVar.Vb.Vd).append("|");
                            sb5.append(bVar.UZ).append("|");
                            sb6.append(bVar.price).append("|");
                            sb7.append(bVar.UN).append("|");
                            sb8.append(bVar.UU).append("|");
                            sb9.append(bVar.UV).append("|");
                            sb10.append(bVar.UW).append("|");
                            sb11.append(bVar.abtest).append("|");
                        } else {
                            sb.append(bVar.UY);
                            sb2.append(bVar.UT);
                            sb3.append(bVar.UM);
                            sb4.append(bVar.Vb.Vd);
                            sb5.append(bVar.UZ);
                            sb6.append(bVar.price);
                            sb7.append(bVar.UN);
                            sb8.append(bVar.UU);
                            sb9.append(bVar.UV);
                            sb10.append(bVar.UW);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void eV(String str) {
        com.baidu.tbadk.core.data.b remove = this.arD.remove(str);
        if (remove != null) {
            this.arE.put(str, remove);
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(remove, "download_status", 0);
            a.aZ("dl", IntentConfig.START);
            com.baidu.tieba.recapp.report.b.axN().a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, int i) {
        String str2;
        com.baidu.tbadk.core.data.b remove = this.arE.remove(str);
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
            a.aZ("dl", str2);
            com.baidu.tieba.recapp.report.b.axN().a(a);
        }
    }

    public void a(com.baidu.tbadk.core.data.b bVar) {
        this.arD.put(bVar.US, bVar);
    }
}
