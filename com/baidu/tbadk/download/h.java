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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.t;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h aoY;
    private static DownloadData apa;
    private static List<DownloadData> apb = new LinkedList();
    private SparseArray<c> aoZ = new SparseArray<>();

    public static h AY() {
        synchronized (h.class) {
            if (aoY == null) {
                aoY = new h();
            }
        }
        return aoY;
    }

    private h() {
        AZ();
    }

    public void b(String str, String str2, String str3, int i, int i2) {
        if (this.aoZ.get(i2) == null) {
            throw new RuntimeException("you need register downloadType first");
        }
        DownloadData downloadData = new DownloadData(str);
        downloadData.setType(i2);
        downloadData.setId(str);
        downloadData.setUrl(str2);
        downloadData.setName(str3);
        downloadData.setNotifyId(i);
        downloadData.setNeedInvokeApk(false);
        o(downloadData);
    }

    private void o(DownloadData downloadData) {
        if (downloadData != null) {
            apb.add(downloadData);
            AR();
        }
    }

    private void AR() {
        if (apa == null && !apb.isEmpty()) {
            apa = apb.get(0);
            if (apa != null) {
                q(p(apa));
            }
        }
    }

    public void h(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessage(new DownloadMessage(linkedList));
    }

    private String z(String str, int i) {
        c ed = ed(i);
        StringBuilder sb = new StringBuilder();
        sb.append(ed.aoQ).append("/").append(ed.aoR).append("/").append(str);
        if (!StringUtils.isNull(ed.aoS)) {
            sb.append(".").append(ed.aoS);
        }
        return sb.toString();
    }

    public void ec(int i) {
        List<DownloadData> hZ = e.AT().hZ();
        if (hZ != null && hZ.size() != 0) {
            for (DownloadData downloadData : hZ) {
                if (downloadData.getType() == i) {
                    A(downloadData.getId(), i);
                }
            }
        }
    }

    private DownloadData p(DownloadData downloadData) {
        if (downloadData != null) {
            String id = downloadData.getId();
            String name = downloadData.getName();
            int type = downloadData.getType();
            if (!ay.isEmpty(id) && !ay.isEmpty(name)) {
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

    private void q(DownloadData downloadData) {
        if (downloadData != null) {
            if (downloadData.getStatus() == 3) {
                h(downloadData);
                if (downloadData.isNeedInvokeApk()) {
                    UtilHelper.install_apk(TbadkCoreApplication.m11getInst().getApp(), downloadData.getPath());
                }
            } else {
                e.AT().a(downloadData, ed(downloadData.getType()).maxSize);
            }
            apa = null;
            if (!apb.isEmpty()) {
                apb.remove(0);
                AR();
            }
        }
    }

    private PendingIntent eZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.m11getInst(), 0, intent, 0);
    }

    public void j(DownloadData downloadData) {
        String string;
        int process;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.m11getInst().getString(t.j.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m11getInst().getString(t.j.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m11getInst().getString(t.j.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                String str = String.valueOf(downloadData.getLength() / 1000) + "K/" + String.valueOf(downloadData.getSize() / 1000) + "K";
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m11getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m11getInst().getApp().getResources().getString(t.j.download_fail_tip), downloadData.getProcess(), String.valueOf(process) + "%", string, eZ(downloadData.getAction()), false);
            }
        }
    }

    public int al(String str, String str2) {
        long an = an(str, str2);
        long j = TbadkCoreApplication.m11getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (an <= j) {
            return (int) ((an * 100) / j);
        }
        return 0;
    }

    public boolean ff(String str) {
        for (DownloadData downloadData : e.AT().hZ()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean fb(String str) {
        for (DownloadData downloadData : e.AT().hZ()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void A(String str, int i) {
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : e.AT().hZ()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str)) {
                downloadData = downloadData2;
            }
        }
        e.AT().y(str, i);
        if (downloadData != null) {
            int al = al(downloadData.getId(), downloadData.getName());
            String str2 = String.valueOf(al) + "%";
            if (downloadData != null && al >= 0) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m11getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m11getInst().getApp().getResources().getString(t.j.download_cancel), al, str2, String.valueOf(downloadData.getName()) + TbadkCoreApplication.m11getInst().getApp().getResources().getString(t.j.download_cancel), eZ(downloadData.getAction()), false);
            }
        }
    }

    public boolean am(String str, String str2) {
        File cS = m.cS(String.valueOf(str) + "_" + str2 + ".tmp");
        return cS != null && cS.exists() && cS.isFile();
    }

    public long an(String str, String str2) {
        File cS = m.cS(String.valueOf(str) + "_" + str2 + ".tmp");
        if (cS != null && cS.exists() && cS.isFile()) {
            return cS.length();
        }
        return -1L;
    }

    public File ao(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return m.cS(String.valueOf(str) + "_" + str2 + ".tmp");
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
        this.aoZ.put(i, cVar);
    }

    public c ed(int i) {
        c cVar = this.aoZ.get(i);
        if (cVar == null) {
            return this.aoZ.get(10);
        }
        return cVar;
    }

    private void AZ() {
        c cVar = new c();
        cVar.aoQ = new File(m.sZ());
        cVar.aoR = "common";
        cVar.aoS = "";
        this.aoZ.put(10, cVar);
    }
}
