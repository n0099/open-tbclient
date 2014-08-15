package com.baidu.tbadk.download;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b a = new b();
    private static DownloadData b = null;
    private static List<DownloadData> c = new LinkedList();
    private d d = null;
    private int e = 20;
    @SuppressLint({"HandlerLeak"})
    private Handler f = new c(this);

    private b() {
    }

    public static b a() {
        return a;
    }

    public void a(DownloadData downloadData, int i) {
        int type = downloadData.getType();
        int i2 = 0;
        for (DownloadData downloadData2 : c) {
            if (downloadData2.getType() == type) {
                i2++;
            }
        }
        if (i2 >= i) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkApplication.m252getInst().getApp().getString(x.download_fail_over_max));
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().a(downloadData);
                return;
            }
            return;
        }
        b(downloadData);
    }

    public void a(DownloadData downloadData) {
        if (c.size() >= this.e) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkApplication.m252getInst().getApp().getString(x.download_fail_over_max));
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().a(downloadData);
                return;
            }
            return;
        }
        b(downloadData);
    }

    public void b(DownloadData downloadData) {
        if (downloadData != null) {
            if (!s.a()) {
                downloadData.setStatusMsg(TbadkApplication.m252getInst().getApp().getString(x.download_fail_no_sd));
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
                if (i2 < c.size()) {
                    DownloadData downloadData2 = c.get(i2);
                    if (downloadData2 == null || !downloadData2.getUrl().equals(downloadData.getUrl()) || !downloadData2.getId().equals(downloadData.getId())) {
                        i = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    downloadData.setStatus(1);
                    c.add(downloadData);
                    e();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (b == null && !c.isEmpty()) {
            b = c.get(0);
            if (b != null) {
                this.d = new d(this);
                this.d.execute(b);
            }
        }
    }

    public void a(String str) {
        if (b != null && b.getUrl().equals(str)) {
            this.d.cancel(true);
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = c.iterator();
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
            c.remove(downloadData);
        }
    }

    public void a(String str, int i) {
        if (b != null && b.getId().equals(str) && b.getType() == i) {
            this.d.cancel(true);
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = c.iterator();
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
            c.remove(downloadData);
        }
    }

    public void a(int i) {
        if (b != null && b.getType() == i) {
            this.d.cancel(true);
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        for (DownloadData downloadData : c) {
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
            c.remove(downloadData2);
        }
    }

    public List<DownloadData> b() {
        return c;
    }
}
