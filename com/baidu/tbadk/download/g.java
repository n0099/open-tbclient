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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.d;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private static g aBI;
    private static DownloadData aBK;
    private static List<DownloadData> aBL = new LinkedList();
    private SparseArray<c> aBJ = new SparseArray<>();

    public static g CX() {
        synchronized (g.class) {
            if (aBI == null) {
                aBI = new g();
            }
        }
        return aBI;
    }

    private g() {
        CY();
    }

    public void b(String str, String str2, String str3, int i, int i2) {
        a(str, str2, str3, i, i2, true);
    }

    public void a(String str, String str2, String str3, int i, int i2, boolean z) {
        if (this.aBJ.get(i2) == null) {
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
            aBL.add(downloadData);
            CQ();
        }
    }

    private void CQ() {
        if (aBK == null && !aBL.isEmpty()) {
            aBK = aBL.get(0);
            if (aBK != null) {
                j(i(aBK));
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
        sb.append(ez.aBA).append("/").append(ez.aBB).append("/").append(str);
        if (!StringUtils.isNull(ez.aBC)) {
            sb.append(".").append(ez.aBC);
        }
        return sb.toString();
    }

    public void ey(int i) {
        List<DownloadData> jX = e.CS().jX();
        if (jX != null && jX.size() != 0) {
            for (DownloadData downloadData : jX) {
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
            if (!al.isEmpty(id) && !al.isEmpty(name)) {
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
                e.CS().a(downloadData, ez(downloadData.getType()).maxSize);
            }
            aBK = null;
            if (!aBL.isEmpty()) {
                aBL.remove(0);
                CQ();
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
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.l.download_fail_tip), process, process + "%", string, fC(downloadData.getAction()), false);
            }
        }
    }

    public int aj(String str, String str2) {
        long ak = ak(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (ak <= j) {
            return (int) ((100 * ak) / j);
        }
        return 0;
    }

    public boolean fH(String str) {
        for (DownloadData downloadData : e.CS().jX()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean fI(String str) {
        for (DownloadData downloadData : e.CS().jX()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void z(String str, int i) {
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : e.CS().jX()) {
            if (downloadData2.getId() == null || !downloadData2.getId().equals(str)) {
                downloadData2 = downloadData;
            }
            downloadData = downloadData2;
        }
        e.CS().x(str, i);
        if (downloadData != null) {
            int aj = aj(downloadData.getId(), downloadData.getName());
            String str2 = aj + "%";
            if (downloadData != null && aj >= 0) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.l.download_cancel), aj, str2, downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.l.download_cancel), fC(downloadData.getAction()), false);
            }
        }
    }

    public boolean al(String str, String str2) {
        File dy = k.dy(str + "_" + str2 + ".tmp");
        return dy != null && dy.exists() && dy.isFile();
    }

    public long ak(String str, String str2) {
        File dy = k.dy(str + "_" + str2 + ".tmp");
        if (dy != null && dy.exists() && dy.isFile()) {
            return dy.length();
        }
        return -1L;
    }

    public File am(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return k.dy(str + "_" + str2 + ".tmp");
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
        this.aBJ.put(i, cVar);
    }

    public c ez(int i) {
        c cVar = this.aBJ.get(i);
        if (cVar == null) {
            return this.aBJ.get(10);
        }
        return cVar;
    }

    private void CY() {
        c cVar = new c();
        cVar.aBA = new File(k.uM());
        cVar.aBB = "common";
        cVar.aBC = "";
        this.aBJ.put(10, cVar);
    }
}
