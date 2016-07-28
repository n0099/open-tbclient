package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.u;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e aqx = new e();
    private static DownloadData aqy = null;
    private static List<DownloadData> aqq = new LinkedList();
    private a aqz = null;
    private int max = 20;
    private Handler aqA = new f(this, Looper.getMainLooper());

    private e() {
    }

    public static e Bd() {
        return aqx;
    }

    public void a(DownloadData downloadData, int i) {
        int type = downloadData.getType();
        int i2 = 0;
        for (DownloadData downloadData2 : aqq) {
            if (downloadData2.getType() == type) {
                i2++;
            }
        }
        if (i2 >= i) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.m10getInst().getApp().getString(u.j.download_fail_over_max));
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().d(downloadData);
                return;
            }
            return;
        }
        m(downloadData);
    }

    public void m(DownloadData downloadData) {
        if (downloadData != null) {
            if (!m.bF()) {
                downloadData.setStatusMsg(TbadkCoreApplication.m10getInst().getApp().getString(u.j.download_fail_no_sd));
                downloadData.setStatus(2);
            }
            if (downloadData.getStatus() == 2) {
                if (downloadData.getCallback() != null) {
                    downloadData.getCallback().d(downloadData);
                    return;
                }
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < aqq.size()) {
                    DownloadData downloadData2 = aqq.get(i2);
                    if (downloadData2 == null || !downloadData2.getUrl().equals(downloadData.getUrl()) || !downloadData2.getId().equals(downloadData.getId())) {
                        i = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    downloadData.setStatus(5);
                    aqq.add(downloadData);
                    Be();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Be() {
        if (aqy == null && !aqq.isEmpty()) {
            aqy = aqq.get(0);
            if (aqy != null) {
                this.aqz = new a();
                this.aqz.execute(aqy);
            }
        }
    }

    public void fi(String str) {
        r(str, false);
    }

    public void r(String str, boolean z) {
        if (aqy != null && aqy.getUrl().equals(str)) {
            if (z) {
                this.aqz.Bh();
                return;
            } else {
                this.aqz.cancel(true);
                return;
            }
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = aqq.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadData next = it.next();
            if (next.getUrl().equals(str)) {
                next.setStatus(4);
                if (next.getCallback() != null) {
                    next.getCallback().d(next);
                }
                linkedList.add(next);
            }
        }
        for (DownloadData downloadData : linkedList) {
            aqq.remove(downloadData);
        }
    }

    public void A(String str, int i) {
        if (aqy != null && aqy.getId().equals(str) && aqy.getType() == i) {
            this.aqz.cancel(true);
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = aqq.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadData next = it.next();
            if (next.getId().equals(str) && next.getType() == i) {
                next.setStatus(4);
                next.setStatusMsg(null);
                if (next.getCallback() != null) {
                    next.getCallback().d(next);
                }
                linkedList.add(next);
            }
        }
        for (DownloadData downloadData : linkedList) {
            aqq.remove(downloadData);
        }
    }

    public void ee(int i) {
        if (aqy != null && aqy.getType() == i) {
            this.aqz.cancel(true);
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        for (DownloadData downloadData : aqq) {
            if (downloadData.getType() == i) {
                downloadData.setStatus(4);
                downloadData.setStatusMsg(null);
                if (downloadData.getCallback() != null) {
                    downloadData.getCallback().d(downloadData);
                }
                linkedList.add(downloadData);
            }
        }
        for (DownloadData downloadData2 : linkedList) {
            aqq.remove(downloadData2);
        }
    }

    public List<DownloadData> ia() {
        return aqq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        private ab LI = new ab();

        a() {
        }

        public void Bh() {
            if (this.LI != null) {
                this.LI.m12do();
            }
            cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.LI.m12do();
            if (e.aqy != null) {
                e.aqy.setStatus(4);
                e.aqy.setStatusMsg(null);
                if (e.aqy.getCallback() != null) {
                    e.aqy.getCallback().d(e.aqy);
                }
                if (!e.aqq.isEmpty()) {
                    e.aqq.remove(0);
                }
                e.aqy = null;
                e.this.Be();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [384=4, 380=4, 382=4, 383=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:75:0x016d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Integer doInBackground(DownloadData... downloadDataArr) {
            FileInputStream fileInputStream;
            FileInputStream fileInputStream2 = null;
            Boolean.valueOf(false);
            if (downloadDataArr[0] == null) {
                return null;
            }
            if (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().c(downloadDataArr[0])) {
                File file = new File(downloadDataArr[0].getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (!file.exists()) {
                    this.LI.setUrl(downloadDataArr[0].getUrl());
                    if (!Boolean.valueOf(this.LI.a(String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp", e.this.aqA, TbConfig.NET_MSG_GETLENTH, 3, 3000)).booleanValue()) {
                        return 3;
                    }
                    File cR = m.cR(String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp");
                    if (cR == null) {
                        return 1;
                    }
                    try {
                        String parent = cR.getParent();
                        String parent2 = file.getParent();
                        if (parent.equals(parent2)) {
                            cR.renameTo(new File(parent2, file.getName()));
                        } else {
                            com.baidu.adp.lib.util.e.b(cR, file);
                            com.baidu.adp.lib.util.e.f(cR);
                        }
                    } catch (IOException e) {
                        try {
                            com.baidu.adp.lib.util.e.f(file);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return 7;
                    }
                }
                if (!ba.isEmpty(downloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                        try {
                            if (!t.k(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                                com.baidu.adp.lib.util.e.f(new File(downloadDataArr[0].getPath()));
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                        return 4;
                                    } catch (IOException e3) {
                                        BdLog.d(e3.getMessage());
                                        return 4;
                                    }
                                }
                                return 4;
                            } else if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e4) {
                                    BdLog.d(e4.getMessage());
                                }
                            }
                        } catch (FileNotFoundException e5) {
                            e = e5;
                            fileInputStream2 = fileInputStream;
                            try {
                                BdLog.d(e.getMessage());
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                        return 6;
                                    } catch (IOException e6) {
                                        BdLog.d(e6.getMessage());
                                        return 6;
                                    }
                                }
                                return 6;
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e7) {
                                        BdLog.d(e7.getMessage());
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e8) {
                        e = e8;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = null;
                    }
                }
                return (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().e(downloadDataArr[0])) ? 0 : 2;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            String string;
            super.onPostExecute((a) num);
            if (e.aqy != null) {
                if (num.intValue() == 0) {
                    e.aqy.setStatus(0);
                    if (e.aqy.getCallback() != null) {
                        e.aqy.getCallback().d(e.aqy);
                    }
                    if (e.aqy.getCallback() != null) {
                        e.aqy.getCallback().f(e.aqy);
                    }
                } else {
                    switch (num.intValue()) {
                        case 1:
                            string = TbadkCoreApplication.m10getInst().getApp().getString(u.j.download_fail);
                            break;
                        case 2:
                            string = TbadkCoreApplication.m10getInst().getApp().getString(u.j.download_fail);
                            break;
                        case 3:
                            string = TbadkCoreApplication.m10getInst().getApp().getString(u.j.download_fail_net);
                            break;
                        case 4:
                            string = TbadkCoreApplication.m10getInst().getApp().getString(u.j.download_fail);
                            break;
                        case 5:
                        default:
                            string = null;
                            break;
                        case 6:
                            string = TbadkCoreApplication.m10getInst().getApp().getString(u.j.download_fail);
                            break;
                        case 7:
                            string = TbadkCoreApplication.m10getInst().getApp().getString(u.j.download_fail);
                            break;
                    }
                    e.aqy.setStatusMsg(string);
                    e.aqy.setErrorCode(num.intValue());
                    e.aqy.setStatus(2);
                    if (e.aqy.getCallback() != null) {
                        e.aqy.getCallback().d(e.aqy);
                    }
                    if (e.aqy.getCallback() != null) {
                        e.aqy.getCallback().a(e.aqy, num.intValue(), string);
                    }
                }
                e.aqy = null;
                if (!e.aqq.isEmpty()) {
                    e.aqq.remove(0);
                    e.this.Be();
                }
            }
        }
    }
}
