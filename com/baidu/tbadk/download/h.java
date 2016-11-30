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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.r;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h auh;
    private static DownloadData auj;
    private static List<DownloadData> auk = new LinkedList();
    private SparseArray<c> aui = new SparseArray<>();

    public static h CL() {
        synchronized (h.class) {
            if (auh == null) {
                auh = new h();
            }
        }
        return auh;
    }

    private h() {
        CM();
    }

    public void b(String str, String str2, String str3, int i, int i2) {
        a(str, str2, str3, i, i2, true);
    }

    public void a(String str, String str2, String str3, int i, int i2, boolean z) {
        if (this.aui.get(i2) == null) {
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
        l(downloadData);
    }

    private void l(DownloadData downloadData) {
        if (downloadData != null) {
            auk.add(downloadData);
            CE();
        }
    }

    private void CE() {
        if (auj == null && !auk.isEmpty()) {
            auj = auk.get(0);
            if (auj != null) {
                n(m(auj));
            }
        }
    }

    public void f(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessage(new DownloadMessage(linkedList));
    }

    private String z(String str, int i) {
        c ew = ew(i);
        StringBuilder sb = new StringBuilder();
        sb.append(ew.atZ).append("/").append(ew.aua).append("/").append(str);
        if (!StringUtils.isNull(ew.aub)) {
            sb.append(".").append(ew.aub);
        }
        return sb.toString();
    }

    public void ev(int i) {
        List<DownloadData> iV = e.CG().iV();
        if (iV != null && iV.size() != 0) {
            for (DownloadData downloadData : iV) {
                if (downloadData.getType() == i) {
                    A(downloadData.getId(), i);
                }
            }
        }
    }

    private DownloadData m(DownloadData downloadData) {
        if (downloadData != null) {
            String id = downloadData.getId();
            String name = downloadData.getName();
            int type = downloadData.getType();
            if (!ax.isEmpty(id) && !ax.isEmpty(name)) {
                boolean isForceDownload = downloadData.isForceDownload();
                String z = z(id, type);
                File file = new File(z);
                if (isForceDownload || !file.exists() || file.length() == 0) {
                    downloadData.setCallback(new g());
                    downloadData.setPath(z);
                    return downloadData;
                }
                DownloadData downloadData2 = new DownloadData(id);
                downloadData2.setPath(z);
                downloadData2.setStatus(3);
                return downloadData2;
            }
            return downloadData;
        }
        return downloadData;
    }

    private void n(DownloadData downloadData) {
        if (downloadData != null) {
            if (downloadData.getStatus() == 3) {
                f(downloadData);
                if (downloadData.isNeedInvokeApk()) {
                    UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), downloadData.getPath());
                }
            } else {
                e.CG().a(downloadData, ew(downloadData.getType()).maxSize);
            }
            auj = null;
            if (!auk.isEmpty()) {
                auk.remove(0);
                CE();
            }
        }
    }

    private PendingIntent fl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.m9getInst(), 0, intent, 0);
    }

    public void o(DownloadData downloadData) {
        String string;
        int process;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.m9getInst().getString(r.j.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m9getInst().getString(r.j.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m9getInst().getString(r.j.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                String str = String.valueOf(downloadData.getLength() / 1000) + "K/" + String.valueOf(downloadData.getSize() / 1000) + "K";
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.j.download_fail_tip), downloadData.getProcess(), String.valueOf(process) + "%", string, fl(downloadData.getAction()), false);
            }
        }
    }

    public int al(String str, String str2) {
        long am = am(str, str2);
        long j = TbadkCoreApplication.m9getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (am <= j) {
            return (int) ((am * 100) / j);
        }
        return 0;
    }

    public boolean fq(String str) {
        for (DownloadData downloadData : e.CG().iV()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean fr(String str) {
        for (DownloadData downloadData : e.CG().iV()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void A(String str, int i) {
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : e.CG().iV()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str)) {
                downloadData = downloadData2;
            }
        }
        e.CG().y(str, i);
        if (downloadData != null) {
            int al = al(downloadData.getId(), downloadData.getName());
            String str2 = String.valueOf(al) + "%";
            if (downloadData != null && al >= 0) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.j.download_cancel), al, str2, String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.j.download_cancel), fl(downloadData.getAction()), false);
            }
        }
    }

    public boolean an(String str, String str2) {
        File cY = m.cY(String.valueOf(str) + "_" + str2 + ".tmp");
        return cY != null && cY.exists() && cY.isFile();
    }

    public long am(String str, String str2) {
        File cY = m.cY(String.valueOf(str) + "_" + str2 + ".tmp");
        if (cY != null && cY.exists() && cY.isFile()) {
            return cY.length();
        }
        return -1L;
    }

    public File ao(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return m.cY(String.valueOf(str) + "_" + str2 + ".tmp");
    }

    public boolean B(String str, int i) {
        File file;
        return !TextUtils.isEmpty(str) && (file = new File(z(str, i))) != null && file.exists() && file.length() > 0;
    }

    public File C(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(z(str, i));
    }

    public void a(int i, c cVar) {
        this.aui.put(i, cVar);
    }

    public c ew(int i) {
        c cVar = this.aui.get(i);
        if (cVar == null) {
            return this.aui.get(10);
        }
        return cVar;
    }

    private void CM() {
        c cVar = new c();
        cVar.atZ = new File(m.uv());
        cVar.aua = "common";
        cVar.aub = "";
        this.aui.put(10, cVar);
    }
}
