package com.baidu.tbadk.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.d;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private static g aAR;
    private static DownloadData aAT;
    private static List<DownloadData> aAU = new LinkedList();
    private SparseArray<c> aAS = new SparseArray<>();

    public static g CS() {
        synchronized (g.class) {
            if (aAR == null) {
                aAR = new g();
            }
        }
        return aAR;
    }

    private g() {
        CT();
    }

    public void b(String str, String str2, String str3, int i, int i2) {
        a(str, str2, str3, i, i2, true);
    }

    public void a(String str, String str2, String str3, int i, int i2, boolean z) {
        if (this.aAS.get(i2) == null) {
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
            aAU.add(downloadData);
            CL();
        }
    }

    private void CL() {
        if (aAT == null && !aAU.isEmpty()) {
            aAT = aAU.get(0);
            if (aAT != null) {
                j(i(aAT));
            }
        }
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessage(new DownloadMessage(linkedList));
    }

    private String y(String str, int i) {
        c ez = ez(i);
        StringBuilder sb = new StringBuilder();
        sb.append(ez.aAJ).append("/").append(ez.aAK).append("/").append(str);
        if (!StringUtils.isNull(ez.aAL)) {
            sb.append(".").append(ez.aAL);
        }
        return sb.toString();
    }

    public void ey(int i) {
        List<DownloadData> jP = e.CN().jP();
        if (jP != null && jP.size() != 0) {
            for (DownloadData downloadData : jP) {
                if (downloadData.getType() == i) {
                    z(downloadData.getId(), i);
                }
            }
        }
    }

    private DownloadData i(DownloadData downloadData) {
        if (downloadData != null) {
            String id = downloadData.getId();
            String name = downloadData.getName();
            int type = downloadData.getType();
            if (!am.isEmpty(id) && !am.isEmpty(name)) {
                boolean isForceDownload = downloadData.isForceDownload();
                String y = y(id, type);
                File file = new File(y);
                if (isForceDownload || !file.exists() || file.length() == 0) {
                    downloadData.setCallback(new f());
                    downloadData.setPath(y);
                    return downloadData;
                }
                DownloadData downloadData2 = new DownloadData(id);
                downloadData2.setPath(y);
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
                e.CN().a(downloadData, ez(downloadData.getType()).maxSize);
            }
            aAT = null;
            if (!aAU.isEmpty()) {
                aAU.remove(0);
                CL();
            }
        }
    }

    private PendingIntent fx(String str) {
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
                    string = TbadkCoreApplication.getInst().getString(d.l.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.getInst().getString(d.l.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.getInst().getString(d.l.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                String str = String.valueOf(downloadData.getLength() / 1000) + "K/" + String.valueOf(downloadData.getSize() / 1000) + "K";
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.l.download_fail_tip), process, process + "%", string, fx(downloadData.getAction()), false);
            }
        }
    }

    public int am(String str, String str2) {
        long an = an(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (an <= j) {
            return (int) ((100 * an) / j);
        }
        return 0;
    }

    public boolean fC(String str) {
        for (DownloadData downloadData : e.CN().jP()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean fD(String str) {
        for (DownloadData downloadData : e.CN().jP()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void z(String str, int i) {
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : e.CN().jP()) {
            if (downloadData2.getId() == null || !downloadData2.getId().equals(str)) {
                downloadData2 = downloadData;
            }
            downloadData = downloadData2;
        }
        e.CN().x(str, i);
        if (downloadData != null) {
            int am = am(downloadData.getId(), downloadData.getName());
            String str2 = am + "%";
            if (downloadData != null && am >= 0) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.l.download_cancel), am, str2, downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.l.download_cancel), fx(downloadData.getAction()), false);
            }
        }
    }

    public boolean ao(String str, String str2) {
        File m9do = k.m9do(str + "_" + str2 + ".tmp");
        return m9do != null && m9do.exists() && m9do.isFile();
    }

    public long an(String str, String str2) {
        File m9do = k.m9do(str + "_" + str2 + ".tmp");
        if (m9do != null && m9do.exists() && m9do.isFile()) {
            return m9do.length();
        }
        return -1L;
    }

    public File ap(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return k.m9do(str + "_" + str2 + ".tmp");
    }

    public boolean A(String str, int i) {
        File file;
        return !TextUtils.isEmpty(str) && (file = new File(y(str, i))) != null && file.exists() && file.length() > 0;
    }

    public File B(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(y(str, i));
    }

    public void a(int i, c cVar) {
        this.aAS.put(i, cVar);
    }

    public c ez(int i) {
        c cVar = this.aAS.get(i);
        if (cVar == null) {
            return this.aAS.get(10);
        }
        return cVar;
    }

    private void CT() {
        c cVar = new c();
        cVar.aAJ = new File(k.uH());
        cVar.aAK = "common";
        cVar.aAL = "";
        this.aAS.put(10, cVar);
    }
}
