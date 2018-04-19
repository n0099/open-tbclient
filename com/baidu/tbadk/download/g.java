package com.baidu.tbadk.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.util.Constants;
import com.baidu.fsg.base.utils.PhoneUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.d;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private static g aCt;
    private static DownloadData aCv;
    private static List<DownloadData> aCw = new LinkedList();
    private SparseArray<c> aCu = new SparseArray<>();

    public static g DC() {
        synchronized (g.class) {
            if (aCt == null) {
                aCt = new g();
            }
        }
        return aCt;
    }

    private g() {
        DD();
    }

    public void b(String str, String str2, String str3, int i, int i2) {
        a(str, str2, str3, i, i2, true);
    }

    public void a(String str, String str2, String str3, int i, int i2, boolean z) {
        if (this.aCu.get(i2) == null) {
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
            aCw.add(downloadData);
            Dw();
        }
    }

    private void Dw() {
        if (aCv == null && !aCw.isEmpty()) {
            aCv = aCw.get(0);
            if (aCv != null) {
                j(i(aCv));
            }
        }
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessage(new DownloadMessage(linkedList));
    }

    private String A(String str, int i) {
        c eB = eB(i);
        StringBuilder sb = new StringBuilder();
        sb.append(eB.aCl).append("/").append(eB.aCm).append("/").append(str);
        if (!StringUtils.isNull(eB.aCn)) {
            sb.append(Constants.DOT).append(eB.aCn);
        }
        return sb.toString();
    }

    public void eA(int i) {
        List<DownloadData> jq = e.Dy().jq();
        if (jq != null && jq.size() != 0) {
            for (DownloadData downloadData : jq) {
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
            if (!an.isEmpty(id) && !an.isEmpty(name)) {
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
                e.Dy().a(downloadData, eB(downloadData.getType()).maxSize);
            }
            aCv = null;
            if (!aCw.isEmpty()) {
                aCw.remove(0);
                Dw();
            }
        }
    }

    private PendingIntent fS(String str) {
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
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.k.download_fail_tip), process, process + "%", string, fS(downloadData.getAction()), false);
            }
        }
    }

    public int al(String str, String str2) {
        long am = am(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (am <= j) {
            return (int) ((100 * am) / j);
        }
        return 0;
    }

    public boolean fX(String str) {
        for (DownloadData downloadData : e.Dy().jq()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean fY(String str) {
        for (DownloadData downloadData : e.Dy().jq()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void B(String str, int i) {
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : e.Dy().jq()) {
            if (downloadData2.getId() == null || !downloadData2.getId().equals(str)) {
                downloadData2 = downloadData;
            }
            downloadData = downloadData2;
        }
        e.Dy().z(str, i);
        if (downloadData != null) {
            int al = al(downloadData.getId(), downloadData.getName());
            String str2 = al + "%";
            if (downloadData != null && al >= 0) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.k.download_cancel), al, str2, downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.k.download_cancel), fS(downloadData.getAction()), false);
            }
        }
    }

    public boolean an(String str, String str2) {
        File du = k.du(str + "_" + str2 + ".tmp");
        return du != null && du.exists() && du.isFile();
    }

    public long am(String str, String str2) {
        File du = k.du(str + "_" + str2 + ".tmp");
        if (du != null && du.exists() && du.isFile()) {
            return du.length();
        }
        return -1L;
    }

    public File ao(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return k.du(str + "_" + str2 + ".tmp");
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
        this.aCu.put(i, cVar);
    }

    public c eB(int i) {
        c cVar = this.aCu.get(i);
        if (cVar == null) {
            return this.aCu.get(10);
        }
        return cVar;
    }

    private void DD() {
        c cVar = new c();
        cVar.aCl = new File(k.uG());
        cVar.aCm = PhoneUtils.CPUInfo.FEATURE_COMMON;
        cVar.aCn = "";
        this.aCu.put(10, cVar);
    }
}
