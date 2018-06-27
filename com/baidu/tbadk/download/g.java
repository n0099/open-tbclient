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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.d;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private static g aLM;
    private static DownloadData aLO;
    private static List<DownloadData> aLP = new LinkedList();
    private SparseArray<c> aLN = new SparseArray<>();

    public static g Hv() {
        synchronized (g.class) {
            if (aLM == null) {
                aLM = new g();
            }
        }
        return aLM;
    }

    private g() {
        Hw();
    }

    public void b(String str, String str2, String str3, int i, int i2) {
        a(str, str2, str3, i, i2, true);
    }

    public void a(String str, String str2, String str3, int i, int i2, boolean z) {
        if (this.aLN.get(i2) == null) {
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
            aLP.add(downloadData);
            Hp();
        }
    }

    private void Hp() {
        if (aLO == null && !aLP.isEmpty()) {
            aLO = aLP.get(0);
            if (aLO != null) {
                j(i(aLO));
            }
        }
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessage(new DownloadMessage(linkedList));
    }

    private String A(String str, int i) {
        c eH = eH(i);
        StringBuilder sb = new StringBuilder();
        sb.append(eH.aLE).append("/").append(eH.aLF).append("/").append(str);
        if (!StringUtils.isNull(eH.aLG)) {
            sb.append(".").append(eH.aLG);
        }
        return sb.toString();
    }

    public void eG(int i) {
        List<DownloadData> me = e.Hr().me();
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
            if (!ap.isEmpty(id) && !ap.isEmpty(name)) {
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
                e.Hr().a(downloadData, eH(downloadData.getType()).maxSize);
            }
            aLO = null;
            if (!aLP.isEmpty()) {
                aLP.remove(0);
                Hp();
            }
        }
    }

    private PendingIntent gv(String str) {
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
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.k.download_fail_tip), process, process + "%", string, gv(downloadData.getAction()), false);
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

    public boolean gA(String str) {
        for (DownloadData downloadData : e.Hr().me()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean gB(String str) {
        for (DownloadData downloadData : e.Hr().me()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void B(String str, int i) {
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : e.Hr().me()) {
            if (downloadData2.getId() == null || !downloadData2.getId().equals(str)) {
                downloadData2 = downloadData;
            }
            downloadData = downloadData2;
        }
        e.Hr().z(str, i);
        if (downloadData != null) {
            int aq = aq(downloadData.getId(), downloadData.getName());
            String str2 = aq + "%";
            if (downloadData != null && aq >= 0) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.k.download_cancel), aq, str2, downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.k.download_cancel), gv(downloadData.getAction()), false);
            }
        }
    }

    public boolean as(String str, String str2) {
        File dX = l.dX(str + "_" + str2 + ".tmp");
        return dX != null && dX.exists() && dX.isFile();
    }

    public long ar(String str, String str2) {
        File dX = l.dX(str + "_" + str2 + ".tmp");
        if (dX != null && dX.exists() && dX.isFile()) {
            return dX.length();
        }
        return -1L;
    }

    public File at(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return l.dX(str + "_" + str2 + ".tmp");
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
        this.aLN.put(i, cVar);
    }

    public c eH(int i) {
        c cVar = this.aLN.get(i);
        if (cVar == null) {
            return this.aLN.get(10);
        }
        return cVar;
    }

    private void Hw() {
        c cVar = new c();
        cVar.aLE = new File(l.yt());
        cVar.aLF = PhoneUtils.CPUInfo.FEATURE_COMMON;
        cVar.aLG = "";
        this.aLN.put(10, cVar);
    }
}
