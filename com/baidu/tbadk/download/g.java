package com.baidu.tbadk.download;

import android.os.Handler;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private static g Rf = new g();
    private static DownloadData Rg = null;
    private static List<DownloadData> Ra = new LinkedList();
    private i Rh = null;
    private int max = 20;
    private Handler Ri = new h(this);

    private g() {
    }

    public static g rk() {
        return Rf;
    }

    public void a(DownloadData downloadData, int i) {
        int type = downloadData.getType();
        int i2 = 0;
        for (DownloadData downloadData2 : Ra) {
            if (downloadData2.getType() == type) {
                i2++;
            }
        }
        if (i2 >= i) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkApplication.m251getInst().getApp().getString(y.download_fail_over_max));
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().onFileUpdateProgress(downloadData);
                return;
            }
            return;
        }
        f(downloadData);
    }

    public void e(DownloadData downloadData) {
        if (Ra.size() >= this.max) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkApplication.m251getInst().getApp().getString(y.download_fail_over_max));
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().onFileUpdateProgress(downloadData);
                return;
            }
            return;
        }
        f(downloadData);
    }

    public void f(DownloadData downloadData) {
        if (downloadData != null) {
            if (!s.bm()) {
                downloadData.setStatusMsg(TbadkApplication.m251getInst().getApp().getString(y.download_fail_no_sd));
                downloadData.setStatus(2);
            }
            if (downloadData.getStatus() == 2) {
                if (downloadData.getCallback() != null) {
                    downloadData.getCallback().onFileUpdateProgress(downloadData);
                    return;
                }
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < Ra.size()) {
                    DownloadData downloadData2 = Ra.get(i2);
                    if (downloadData2 == null || !downloadData2.getUrl().equals(downloadData.getUrl()) || !downloadData2.getId().equals(downloadData.getId())) {
                        i = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    downloadData.setStatus(5);
                    Ra.add(downloadData);
                    rl();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rl() {
        if (Rg == null && !Ra.isEmpty()) {
            Rg = Ra.get(0);
            if (Rg != null) {
                this.Rh = new i(this);
                this.Rh.execute(Rg);
            }
        }
    }

    public void cX(String str) {
        if (Rg != null && Rg.getUrl().equals(str)) {
            this.Rh.cancel(true);
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = Ra.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadData next = it.next();
            if (next.getUrl().equals(str)) {
                next.setStatus(4);
                if (next.getCallback() != null) {
                    next.getCallback().onFileUpdateProgress(next);
                }
                linkedList.add(next);
            }
        }
        for (DownloadData downloadData : linkedList) {
            Ra.remove(downloadData);
        }
    }

    public void p(String str, int i) {
        if (Rg != null && Rg.getId().equals(str) && Rg.getType() == i) {
            this.Rh.cancel(true);
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = Ra.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadData next = it.next();
            if (next.getId().equals(str) && next.getType() == i) {
                next.setStatus(4);
                next.setStatusMsg(null);
                if (next.getCallback() != null) {
                    next.getCallback().onFileUpdateProgress(next);
                }
                linkedList.add(next);
            }
        }
        for (DownloadData downloadData : linkedList) {
            Ra.remove(downloadData);
        }
    }

    public void cF(int i) {
        if (Rg != null && Rg.getType() == i) {
            this.Rh.cancel(true);
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        for (DownloadData downloadData : Ra) {
            if (downloadData.getType() == i) {
                downloadData.setStatus(4);
                downloadData.setStatusMsg(null);
                if (downloadData.getCallback() != null) {
                    downloadData.getCallback().onFileUpdateProgress(downloadData);
                }
                linkedList.add(downloadData);
            }
        }
        for (DownloadData downloadData2 : linkedList) {
            Ra.remove(downloadData2);
        }
    }

    public List<DownloadData> rm() {
        return Ra;
    }
}
