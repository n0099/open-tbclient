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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.t;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h atJ;
    private static DownloadData atL;
    private static List<DownloadData> atM = new LinkedList();
    private SparseArray<c> atK = new SparseArray<>();

    public static h CD() {
        synchronized (h.class) {
            if (atJ == null) {
                atJ = new h();
            }
        }
        return atJ;
    }

    private h() {
        CE();
    }

    public void b(String str, String str2, String str3, int i, int i2) {
        a(str, str2, str3, i, i2, true);
    }

    public void a(String str, String str2, String str3, int i, int i2, boolean z) {
        if (this.atK.get(i2) == null) {
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
        m(downloadData);
    }

    private void m(DownloadData downloadData) {
        if (downloadData != null) {
            atM.add(downloadData);
            Cw();
        }
    }

    private void Cw() {
        if (atL == null && !atM.isEmpty()) {
            atL = atM.get(0);
            if (atL != null) {
                o(n(atL));
            }
        }
    }

    public void f(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessage(new DownloadMessage(linkedList));
    }

    private String A(String str, int i) {
        c eu = eu(i);
        StringBuilder sb = new StringBuilder();
        sb.append(eu.atB).append("/").append(eu.atC).append("/").append(str);
        if (!StringUtils.isNull(eu.atD)) {
            sb.append(".").append(eu.atD);
        }
        return sb.toString();
    }

    public void et(int i) {
        List<DownloadData> iV = e.Cy().iV();
        if (iV != null && iV.size() != 0) {
            for (DownloadData downloadData : iV) {
                if (downloadData.getType() == i) {
                    B(downloadData.getId(), i);
                }
            }
        }
    }

    private DownloadData n(DownloadData downloadData) {
        if (downloadData != null) {
            String id = downloadData.getId();
            String name = downloadData.getName();
            int type = downloadData.getType();
            if (!ba.isEmpty(id) && !ba.isEmpty(name)) {
                boolean isForceDownload = downloadData.isForceDownload();
                String A = A(id, type);
                File file = new File(A);
                if (isForceDownload || !file.exists() || file.length() == 0) {
                    downloadData.setCallback(new g());
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

    private void o(DownloadData downloadData) {
        if (downloadData != null) {
            if (downloadData.getStatus() == 3) {
                f(downloadData);
                if (downloadData.isNeedInvokeApk()) {
                    UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), downloadData.getPath());
                }
            } else {
                e.Cy().a(downloadData, eu(downloadData.getType()).maxSize);
            }
            atL = null;
            if (!atM.isEmpty()) {
                atM.remove(0);
                Cw();
            }
        }
    }

    private PendingIntent fg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.m9getInst(), 0, intent, 0);
    }

    public void h(DownloadData downloadData) {
        String string;
        int process;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.m9getInst().getString(t.j.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m9getInst().getString(t.j.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m9getInst().getString(t.j.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                String str = String.valueOf(downloadData.getLength() / 1000) + "K/" + String.valueOf(downloadData.getSize() / 1000) + "K";
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(t.j.download_fail_tip), downloadData.getProcess(), String.valueOf(process) + "%", string, fg(downloadData.getAction()), false);
            }
        }
    }

    public int ak(String str, String str2) {
        long al = al(str, str2);
        long j = TbadkCoreApplication.m9getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (al <= j) {
            return (int) ((al * 100) / j);
        }
        return 0;
    }

    public boolean fl(String str) {
        for (DownloadData downloadData : e.Cy().iV()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean fm(String str) {
        for (DownloadData downloadData : e.Cy().iV()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void B(String str, int i) {
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : e.Cy().iV()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str)) {
                downloadData = downloadData2;
            }
        }
        e.Cy().z(str, i);
        if (downloadData != null) {
            int ak = ak(downloadData.getId(), downloadData.getName());
            String str2 = String.valueOf(ak) + "%";
            if (downloadData != null && ak >= 0) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(t.j.download_cancel), ak, str2, String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(t.j.download_cancel), fg(downloadData.getAction()), false);
            }
        }
    }

    public boolean am(String str, String str2) {
        File cU = m.cU(String.valueOf(str) + "_" + str2 + ".tmp");
        return cU != null && cU.exists() && cU.isFile();
    }

    public long al(String str, String str2) {
        File cU = m.cU(String.valueOf(str) + "_" + str2 + ".tmp");
        if (cU != null && cU.exists() && cU.isFile()) {
            return cU.length();
        }
        return -1L;
    }

    public File an(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return m.cU(String.valueOf(str) + "_" + str2 + ".tmp");
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
        this.atK.put(i, cVar);
    }

    public c eu(int i) {
        c cVar = this.atK.get(i);
        if (cVar == null) {
            return this.atK.get(10);
        }
        return cVar;
    }

    private void CE() {
        c cVar = new c();
        cVar.atB = new File(m.ub());
        cVar.atC = "common";
        cVar.atD = "";
        this.atK.put(10, cVar);
    }
}
