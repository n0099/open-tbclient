package com.baidu.tbadk.download;

import android.os.Handler;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private static g Xg = new g();
    private static DownloadData Xh = null;
    private static List<DownloadData> Xb = new LinkedList();
    private i Xi = null;
    private int max = 20;
    private Handler Xj = new h(this);

    private g() {
    }

    public static g uO() {
        return Xg;
    }

    public void a(DownloadData downloadData, int i) {
        int type = downloadData.getType();
        int i2 = 0;
        for (DownloadData downloadData2 : Xb) {
            if (downloadData2.getType() == type) {
                i2++;
            }
        }
        if (i2 >= i) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.m255getInst().getApp().getString(z.download_fail_over_max));
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
            if (!s.bN()) {
                downloadData.setStatusMsg(TbadkCoreApplication.m255getInst().getApp().getString(z.download_fail_no_sd));
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
                if (i2 < Xb.size()) {
                    DownloadData downloadData2 = Xb.get(i2);
                    if (downloadData2 == null || !downloadData2.getUrl().equals(downloadData.getUrl()) || !downloadData2.getId().equals(downloadData.getId())) {
                        i = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    downloadData.setStatus(5);
                    Xb.add(downloadData);
                    uP();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uP() {
        if (Xh == null && !Xb.isEmpty()) {
            Xh = Xb.get(0);
            if (Xh != null) {
                this.Xi = new i(this);
                this.Xi.execute(Xh);
            }
        }
    }

    public void bn(String str) {
        if (Xh != null && Xh.getUrl().equals(str)) {
            this.Xi.cancel(true);
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = Xb.iterator();
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
            Xb.remove(downloadData);
        }
    }

    public void r(String str, int i) {
        if (Xh != null && Xh.getId().equals(str) && Xh.getType() == i) {
            this.Xi.cancel(true);
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = Xb.iterator();
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
            Xb.remove(downloadData);
        }
    }

    public void dd(int i) {
        if (Xh != null && Xh.getType() == i) {
            this.Xi.cancel(true);
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        for (DownloadData downloadData : Xb) {
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
            Xb.remove(downloadData2);
        }
    }

    public List<DownloadData> uQ() {
        return Xb;
    }
}
