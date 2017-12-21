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
    private static g aBB;
    private static DownloadData aBD;
    private static List<DownloadData> aBE = new LinkedList();
    private SparseArray<c> aBC = new SparseArray<>();

    public static g Db() {
        synchronized (g.class) {
            if (aBB == null) {
                aBB = new g();
            }
        }
        return aBB;
    }

    private g() {
        Dc();
    }

    public void b(String str, String str2, String str3, int i, int i2) {
        a(str, str2, str3, i, i2, true);
    }

    public void a(String str, String str2, String str3, int i, int i2, boolean z) {
        if (this.aBC.get(i2) == null) {
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
            aBE.add(downloadData);
            CU();
        }
    }

    private void CU() {
        if (aBD == null && !aBE.isEmpty()) {
            aBD = aBE.get(0);
            if (aBD != null) {
                j(i(aBD));
            }
        }
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessage(new DownloadMessage(linkedList));
    }

    private String A(String str, int i) {
        c eK = eK(i);
        StringBuilder sb = new StringBuilder();
        sb.append(eK.aBt).append("/").append(eK.aBu).append("/").append(str);
        if (!StringUtils.isNull(eK.aBv)) {
            sb.append(".").append(eK.aBv);
        }
        return sb.toString();
    }

    public void eJ(int i) {
        List<DownloadData> jL = e.CW().jL();
        if (jL != null && jL.size() != 0) {
            for (DownloadData downloadData : jL) {
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
            if (!am.isEmpty(id) && !am.isEmpty(name)) {
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
                e.CW().a(downloadData, eK(downloadData.getType()).maxSize);
            }
            aBD = null;
            if (!aBE.isEmpty()) {
                aBE.remove(0);
                CU();
            }
        }
    }

    private PendingIntent fC(String str) {
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
                    string = TbadkCoreApplication.getInst().getString(d.j.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.getInst().getString(d.j.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.getInst().getString(d.j.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                String str = String.valueOf(downloadData.getLength() / 1000) + "K/" + String.valueOf(downloadData.getSize() / 1000) + "K";
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.download_fail_tip), process, process + "%", string, fC(downloadData.getAction()), false);
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

    public boolean fH(String str) {
        for (DownloadData downloadData : e.CW().jL()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean fI(String str) {
        for (DownloadData downloadData : e.CW().jL()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void B(String str, int i) {
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : e.CW().jL()) {
            if (downloadData2.getId() == null || !downloadData2.getId().equals(str)) {
                downloadData2 = downloadData;
            }
            downloadData = downloadData2;
        }
        e.CW().z(str, i);
        if (downloadData != null) {
            int am = am(downloadData.getId(), downloadData.getName());
            String str2 = am + "%";
            if (downloadData != null && am >= 0) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.download_cancel), am, str2, downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.download_cancel), fC(downloadData.getAction()), false);
            }
        }
    }

    public boolean ao(String str, String str2) {
        File dk = k.dk(str + "_" + str2 + ".tmp");
        return dk != null && dk.exists() && dk.isFile();
    }

    public long an(String str, String str2) {
        File dk = k.dk(str + "_" + str2 + ".tmp");
        if (dk != null && dk.exists() && dk.isFile()) {
            return dk.length();
        }
        return -1L;
    }

    public File ap(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return k.dk(str + "_" + str2 + ".tmp");
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
        this.aBC.put(i, cVar);
    }

    public c eK(int i) {
        c cVar = this.aBC.get(i);
        if (cVar == null) {
            return this.aBC.get(10);
        }
        return cVar;
    }

    private void Dc() {
        c cVar = new c();
        cVar.aBt = new File(k.uk());
        cVar.aBu = "common";
        cVar.aBv = "";
        this.aBC.put(10, cVar);
    }
}
