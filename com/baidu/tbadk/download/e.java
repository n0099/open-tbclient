package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e azk = new e();
    private static DownloadData azl = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private a azm = null;
    private int max = 20;
    private Handler azn = new f(this, Looper.getMainLooper());

    private e() {
    }

    public static e Cy() {
        return azk;
    }

    public void a(DownloadData downloadData, int i) {
        int type = downloadData.getType();
        int i2 = 0;
        for (DownloadData downloadData2 : mTaskList) {
            if (downloadData2.getType() == type) {
                i2++;
            }
        }
        if (i2 >= i) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail_over_max));
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
            if (!n.dH()) {
                downloadData.setStatusMsg(TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail_no_sd));
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
                if (i2 < mTaskList.size()) {
                    DownloadData downloadData2 = mTaskList.get(i2);
                    if (downloadData2 == null || !downloadData2.getUrl().equals(downloadData.getUrl()) || !downloadData2.getId().equals(downloadData.getId())) {
                        i = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    downloadData.setStatus(5);
                    mTaskList.add(downloadData);
                    Cz();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cz() {
        if (azl == null && !mTaskList.isEmpty()) {
            azl = mTaskList.get(0);
            if (azl != null) {
                this.azm = new a();
                this.azm.execute(azl);
            }
        }
    }

    public void fs(String str) {
        r(str, false);
    }

    public void r(String str, boolean z) {
        if (azl != null && azl.getUrl().equals(str)) {
            if (z) {
                this.azm.CC();
                return;
            } else {
                this.azm.cancel(true);
                return;
            }
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = mTaskList.iterator();
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
            mTaskList.remove(downloadData);
        }
    }

    public void w(String str, int i) {
        if (azl != null && azl.getId().equals(str) && azl.getType() == i) {
            this.azm.cancel(true);
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = mTaskList.iterator();
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
            mTaskList.remove(downloadData);
        }
    }

    public void et(int i) {
        if (azl != null && azl.getType() == i) {
            this.azm.cancel(true);
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        for (DownloadData downloadData : mTaskList) {
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
            mTaskList.remove(downloadData2);
        }
    }

    public List<DownloadData> jP() {
        return mTaskList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        private ab mNetWork = new ab();

        a() {
        }

        public void CC() {
            if (this.mNetWork != null) {
                this.mNetWork.fu();
            }
            cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.mNetWork.fu();
            if (e.azl != null) {
                e.azl.setStatus(4);
                e.azl.setStatusMsg(null);
                if (e.azl.getCallback() != null) {
                    e.azl.getCallback().onFileUpdateProgress(e.azl);
                }
                if (!e.mTaskList.isEmpty()) {
                    e.mTaskList.remove(0);
                }
                e.azl = null;
                e.this.Cz();
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
            if (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().onPreDownload(downloadDataArr[0])) {
                File file = new File(downloadDataArr[0].getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (!file.exists()) {
                    this.mNetWork.setUrl(downloadDataArr[0].getUrl());
                    if (!Boolean.valueOf(this.mNetWork.a(String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp", e.this.azn, TbConfig.NET_MSG_GETLENTH, 3, 3000)).booleanValue()) {
                        return 3;
                    }
                    File dm = n.dm(String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp");
                    if (dm == null) {
                        return 1;
                    }
                    try {
                        String parent = dm.getParent();
                        String parent2 = file.getParent();
                        if (parent.equals(parent2)) {
                            dm.renameTo(new File(parent2, file.getName()));
                        } else {
                            com.baidu.adp.lib.util.e.b(dm, file);
                            com.baidu.adp.lib.util.e.g(dm);
                        }
                    } catch (IOException e) {
                        try {
                            com.baidu.adp.lib.util.e.g(file);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return 7;
                    }
                }
                if (!aw.isEmpty(downloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                        try {
                            if (!t.k(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                                com.baidu.adp.lib.util.e.g(new File(downloadDataArr[0].getPath()));
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
                return (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().onFileDownloaded(downloadDataArr[0])) ? 0 : 2;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            String string;
            super.onPostExecute((a) num);
            if (e.azl != null) {
                if (num.intValue() == 0) {
                    e.azl.setStatus(0);
                    if (e.azl.getCallback() != null) {
                        e.azl.getCallback().onFileUpdateProgress(e.azl);
                    }
                    if (e.azl.getCallback() != null) {
                        e.azl.getCallback().onFileDownloadSucceed(e.azl);
                    }
                } else {
                    switch (num.intValue()) {
                        case 1:
                            string = TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail);
                            break;
                        case 2:
                            string = TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail);
                            break;
                        case 3:
                            string = TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail_net);
                            break;
                        case 4:
                            string = TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail);
                            break;
                        case 5:
                        default:
                            string = null;
                            break;
                        case 6:
                            string = TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail);
                            break;
                        case 7:
                            string = TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail);
                            break;
                    }
                    e.azl.setStatusMsg(string);
                    e.azl.setErrorCode(num.intValue());
                    e.azl.setStatus(2);
                    if (e.azl.getCallback() != null) {
                        e.azl.getCallback().onFileUpdateProgress(e.azl);
                    }
                    if (e.azl.getCallback() != null) {
                        e.azl.getCallback().onFileDownloadFailed(e.azl, num.intValue(), string);
                    }
                }
                e.azl = null;
                if (!e.mTaskList.isEmpty()) {
                    e.mTaskList.remove(0);
                    e.this.Cz();
                }
            }
        }
    }
}
