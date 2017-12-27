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
    private static List<DownloadData> bpA = new LinkedList();
    private static g bpx;
    private static DownloadData bpz;
    private SparseArray<c> bpy = new SparseArray<>();

    public static g KC() {
        synchronized (g.class) {
            if (bpx == null) {
                bpx = new g();
            }
        }
        return bpx;
    }

    private g() {
        KD();
    }

    public void b(String str, String str2, String str3, int i, int i2) {
        a(str, str2, str3, i, i2, true);
    }

    public void a(String str, String str2, String str3, int i, int i2, boolean z) {
        if (this.bpy.get(i2) == null) {
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
            bpA.add(downloadData);
            Kv();
        }
    }

    private void Kv() {
        if (bpz == null && !bpA.isEmpty()) {
            bpz = bpA.get(0);
            if (bpz != null) {
                j(i(bpz));
            }
        }
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessage(new DownloadMessage(linkedList));
    }

    private String A(String str, int i) {
        c hI = hI(i);
        StringBuilder sb = new StringBuilder();
        sb.append(hI.bpp).append("/").append(hI.bpq).append("/").append(str);
        if (!StringUtils.isNull(hI.bpr)) {
            sb.append(".").append(hI.bpr);
        }
        return sb.toString();
    }

    public void hH(int i) {
        List<DownloadData> rk = e.Kx().rk();
        if (rk != null && rk.size() != 0) {
            for (DownloadData downloadData : rk) {
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
                e.Kx().a(downloadData, hI(downloadData.getType()).maxSize);
            }
            bpz = null;
            if (!bpA.isEmpty()) {
                bpA.remove(0);
                Kv();
            }
        }
    }

    private PendingIntent fJ(String str) {
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
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.download_fail_tip), process, process + "%", string, fJ(downloadData.getAction()), false);
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

    public boolean fO(String str) {
        for (DownloadData downloadData : e.Kx().rk()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean fP(String str) {
        for (DownloadData downloadData : e.Kx().rk()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void B(String str, int i) {
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : e.Kx().rk()) {
            if (downloadData2.getId() == null || !downloadData2.getId().equals(str)) {
                downloadData2 = downloadData;
            }
            downloadData = downloadData2;
        }
        e.Kx().z(str, i);
        if (downloadData != null) {
            int al = al(downloadData.getId(), downloadData.getName());
            String str2 = al + "%";
            if (downloadData != null && al >= 0) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.download_cancel), al, str2, downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.download_cancel), fJ(downloadData.getAction()), false);
            }
        }
    }

    public boolean an(String str, String str2) {
        File dr = k.dr(str + "_" + str2 + ".tmp");
        return dr != null && dr.exists() && dr.isFile();
    }

    public long am(String str, String str2) {
        File dr = k.dr(str + "_" + str2 + ".tmp");
        if (dr != null && dr.exists() && dr.isFile()) {
            return dr.length();
        }
        return -1L;
    }

    public File ao(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return k.dr(str + "_" + str2 + ".tmp");
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
        this.bpy.put(i, cVar);
    }

    public c hI(int i) {
        c cVar = this.bpy.get(i);
        if (cVar == null) {
            return this.bpy.get(10);
        }
        return cVar;
    }

    private void KD() {
        c cVar = new c();
        cVar.bpp = new File(k.BK());
        cVar.bpq = "common";
        cVar.bpr = "";
        this.bpy.put(10, cVar);
    }
}
