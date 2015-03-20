package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Looper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.o;
import com.baidu.tieba.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private static g ahP = new g();
    private static DownloadData ahQ = null;
    private static List<DownloadData> ahK = new LinkedList();
    private i ahR = null;
    private int max = 20;
    private Handler ahS = new h(this, Looper.getMainLooper());

    private g() {
    }

    public static g yp() {
        return ahP;
    }

    public void a(DownloadData downloadData, int i) {
        int type = downloadData.getType();
        int i2 = 0;
        for (DownloadData downloadData2 : ahK) {
            if (downloadData2.getType() == type) {
                i2++;
            }
        }
        if (i2 >= i) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.m411getInst().getApp().getString(y.download_fail_over_max));
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().a(downloadData);
                return;
            }
            return;
        }
        i(downloadData);
    }

    public void i(DownloadData downloadData) {
        if (downloadData != null) {
            if (!o.fj()) {
                downloadData.setStatusMsg(TbadkCoreApplication.m411getInst().getApp().getString(y.download_fail_no_sd));
                downloadData.setStatus(2);
            }
            if (downloadData.getStatus() == 2) {
                if (downloadData.getCallback() != null) {
                    downloadData.getCallback().a(downloadData);
                    return;
                }
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < ahK.size()) {
                    DownloadData downloadData2 = ahK.get(i2);
                    if (downloadData2 == null || !downloadData2.getUrl().equals(downloadData.getUrl()) || !downloadData2.getId().equals(downloadData.getId())) {
                        i = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    downloadData.setStatus(5);
                    ahK.add(downloadData);
                    yq();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yq() {
        if (ahQ == null && !ahK.isEmpty()) {
            ahQ = ahK.get(0);
            if (ahQ != null) {
                this.ahR = new i(this);
                this.ahR.execute(ahQ);
            }
        }
    }

    public void dZ(String str) {
        if (ahQ != null && ahQ.getUrl().equals(str)) {
            this.ahR.cancel(true);
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = ahK.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadData next = it.next();
            if (next.getUrl().equals(str)) {
                next.setStatus(4);
                if (next.getCallback() != null) {
                    next.getCallback().a(next);
                }
                linkedList.add(next);
            }
        }
        for (DownloadData downloadData : linkedList) {
            ahK.remove(downloadData);
        }
    }

    public void q(String str, int i) {
        if (ahQ != null && ahQ.getId().equals(str) && ahQ.getType() == i) {
            this.ahR.cancel(true);
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = ahK.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadData next = it.next();
            if (next.getId().equals(str) && next.getType() == i) {
                next.setStatus(4);
                next.setStatusMsg(null);
                if (next.getCallback() != null) {
                    next.getCallback().a(next);
                }
                linkedList.add(next);
            }
        }
        for (DownloadData downloadData : linkedList) {
            ahK.remove(downloadData);
        }
    }

    public void dm(int i) {
        if (ahQ != null && ahQ.getType() == i) {
            this.ahR.cancel(true);
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        for (DownloadData downloadData : ahK) {
            if (downloadData.getType() == i) {
                downloadData.setStatus(4);
                downloadData.setStatusMsg(null);
                if (downloadData.getCallback() != null) {
                    downloadData.getCallback().a(downloadData);
                }
                linkedList.add(downloadData);
            }
        }
        for (DownloadData downloadData2 : linkedList) {
            ahK.remove(downloadData2);
        }
    }

    public List<DownloadData> lG() {
        return ahK;
    }
}
