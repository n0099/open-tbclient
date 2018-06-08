package com.baidu.tbadk.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.fsg.base.utils.PhoneUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.d;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private static g aKQ;
    private static DownloadData aKS;
    private static List<DownloadData> aKT = new LinkedList();
    private SparseArray<c> aKR = new SparseArray<>();

    public static g Hd() {
        synchronized (g.class) {
            if (aKQ == null) {
                aKQ = new g();
            }
        }
        return aKQ;
    }

    private g() {
        He();
    }

    public void b(String str, String str2, String str3, int i, int i2) {
        a(str, str2, str3, i, i2, true);
    }

    public void a(String str, String str2, String str3, int i, int i2, boolean z) {
        if (this.aKR.get(i2) == null) {
            throw new RuntimeException("you need register downloadType first");
        }
        DownloadData downloadData = new DownloadData(str);
        downloadData.setType(i2);
        downloadData.setId(str);
        downloadData.setUrl(str2);
        downloadData.setName(str3);
        downloadData.setNotifyId(i);
        downloadData.setNeedInvokeApk(false);
        downloadData.setNeedNotify(z);
        h(downloadData);
    }

    private void h(DownloadData downloadData) {
        if (downloadData != null) {
            aKT.add(downloadData);
            GX();
        }
    }

    private void GX() {
        if (aKS == null && !aKT.isEmpty()) {
            aKS = aKT.get(0);
            if (aKS != null) {
                j(i(aKS));
            }
        }
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessage(new DownloadMessage(linkedList));
    }

    private String A(String str, int i) {
        c eG = eG(i);
        StringBuilder sb = new StringBuilder();
        sb.append(eG.aKI).append("/").append(eG.aKJ).append("/").append(str);
        if (!StringUtils.isNull(eG.aKK)) {
            sb.append(".").append(eG.aKK);
        }
        return sb.toString();
    }

    public void eF(int i) {
        List<DownloadData> me = e.GZ().me();
        if (me != null && me.size() != 0) {
            for (DownloadData downloadData : me) {
                if (downloadData.getType() == i) {
                    B(downloadData.getId(), i);
                }
            }
        }
    }

    private DownloadData i(DownloadData downloadData) {
        if (downloadData != null) {
            String id = downloadData.getId();
            String name = downloadData.getName();
            int type = downloadData.getType();
            if (!ao.isEmpty(id) && !ao.isEmpty(name)) {
                boolean isForceDownload = downloadData.isForceDownload();
                String A = A(id, type);
                File file = new File(A);
                if (isForceDownload || !file.exists() || file.length() == 0) {
                    downloadData.setCallback(new f());
                    downloadData.setPath(A);
                    return downloadData;
                }
                DownloadData downloadData2 = new DownloadData(id);
                downloadData2.setPath(A);
                downloadData2.setStatus(3);
                return downloadData2;
            }
            return downloadData;
        }
        return downloadData;
    }

    private void j(DownloadData downloadData) {
        if (downloadData != null) {
            if (downloadData.getStatus() == 3) {
                b(downloadData);
                if (downloadData.isNeedInvokeApk()) {
                    UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getPath());
                }
            } else {
                e.GZ().a(downloadData, eG(downloadData.getType()).maxSize);
            }
            aKS = null;
            if (!aKT.isEmpty()) {
                aKT.remove(0);
                GX();
            }
        }
    }

    private PendingIntent gq(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.getInst(), 0, intent, 0);
    }

    public void k(DownloadData downloadData) {
        String string;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.getInst().getString(d.k.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.getInst().getString(d.k.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.getInst().getString(d.k.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                String str = String.valueOf(downloadData.getLength() / 1000) + "K/" + String.valueOf(downloadData.getSize() / 1000) + "K";
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.k.download_fail_tip), process, process + "%", string, gq(downloadData.getAction()), false);
            }
        }
    }

    public int aq(String str, String str2) {
        long ar = ar(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (ar <= j) {
            return (int) ((100 * ar) / j);
        }
        return 0;
    }

    public boolean gw(String str) {
        for (DownloadData downloadData : e.GZ().me()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean gx(String str) {
        for (DownloadData downloadData : e.GZ().me()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void B(String str, int i) {
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : e.GZ().me()) {
            if (downloadData2.getId() == null || !downloadData2.getId().equals(str)) {
                downloadData2 = downloadData;
            }
            downloadData = downloadData2;
        }
        e.GZ().z(str, i);
        if (downloadData != null) {
            int aq = aq(downloadData.getId(), downloadData.getName());
            String str2 = aq + "%";
            if (downloadData != null && aq >= 0) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.k.download_cancel), aq, str2, downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.k.download_cancel), gq(downloadData.getAction()), false);
            }
        }
    }

    public boolean as(String str, String str2) {
        File dU = l.dU(str + "_" + str2 + ".tmp");
        return dU != null && dU.exists() && dU.isFile();
    }

    public long ar(String str, String str2) {
        File dU = l.dU(str + "_" + str2 + ".tmp");
        if (dU != null && dU.exists() && dU.isFile()) {
            return dU.length();
        }
        return -1L;
    }

    public File at(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return l.dU(str + "_" + str2 + ".tmp");
    }

    public boolean C(String str, int i) {
        File file;
        return !TextUtils.isEmpty(str) && (file = new File(A(str, i))) != null && file.exists() && file.length() > 0;
    }

    public File D(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(A(str, i));
    }

    public void a(int i, c cVar) {
        this.aKR.put(i, cVar);
    }

    public c eG(int i) {
        c cVar = this.aKR.get(i);
        if (cVar == null) {
            return this.aKR.get(10);
        }
        return cVar;
    }

    private void He() {
        c cVar = new c();
        cVar.aKI = new File(l.yf());
        cVar.aKJ = PhoneUtils.CPUInfo.FEATURE_COMMON;
        cVar.aKK = "";
        this.aKR.put(10, cVar);
    }
}
