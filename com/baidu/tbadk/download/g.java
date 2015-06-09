package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Looper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.o;
import com.baidu.tieba.t;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private static g aiX = new g();
    private static DownloadData aiY = null;
    private static List<DownloadData> aiS = new LinkedList();
    private i aiZ = null;
    private int max = 20;
    private Handler aja = new h(this, Looper.getMainLooper());

    private g() {
    }

    public static g zj() {
        return aiX;
    }

    public void a(DownloadData downloadData, int i) {
        int type = downloadData.getType();
        int i2 = 0;
        for (DownloadData downloadData2 : aiS) {
            if (downloadData2.getType() == type) {
                i2++;
            }
        }
        if (i2 >= i) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.m411getInst().getApp().getString(t.download_fail_over_max));
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
            if (!o.fo()) {
                downloadData.setStatusMsg(TbadkCoreApplication.m411getInst().getApp().getString(t.download_fail_no_sd));
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
                if (i2 < aiS.size()) {
                    DownloadData downloadData2 = aiS.get(i2);
                    if (downloadData2 == null || !downloadData2.getUrl().equals(downloadData.getUrl()) || !downloadData2.getId().equals(downloadData.getId())) {
                        i = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    downloadData.setStatus(5);
                    aiS.add(downloadData);
                    zk();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zk() {
        if (aiY == null && !aiS.isEmpty()) {
            aiY = aiS.get(0);
            if (aiY != null) {
                this.aiZ = new i(this);
                this.aiZ.execute(aiY);
            }
        }
    }

    public void et(String str) {
        if (aiY != null && aiY.getUrl().equals(str)) {
            this.aiZ.cancel(true);
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = aiS.iterator();
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
            aiS.remove(downloadData);
        }
    }

    public void q(String str, int i) {
        if (aiY != null && aiY.getId().equals(str) && aiY.getType() == i) {
            this.aiZ.cancel(true);
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = aiS.iterator();
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
            aiS.remove(downloadData);
        }
    }

    public void dw(int i) {
        if (aiY != null && aiY.getType() == i) {
            this.aiZ.cancel(true);
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        for (DownloadData downloadData : aiS) {
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
            aiS.remove(downloadData2);
        }
    }

    public List<DownloadData> lZ() {
        return aiS;
    }
}
