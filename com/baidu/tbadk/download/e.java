package com.baidu.tbadk.download;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e bps = new e();
    private static DownloadData bpt = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private a bpu = null;
    private int max = 20;
    @SuppressLint({"HandlerLeak"})
    private Handler bpv = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.download.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 900002 && message.arg2 > 0 && e.bpt != null) {
                e.bpt.setLength(message.arg1);
                e.bpt.setSize(message.arg2);
                e.bpt.setStatus(1);
                if (e.bpt.getCallback() != null) {
                    e.bpt.getCallback().onFileUpdateProgress(e.bpt);
                }
            }
        }
    };

    private e() {
    }

    public static e Kx() {
        return bps;
    }

    public void a(DownloadData downloadData, int i) {
        int i2;
        int type = downloadData.getType();
        int i3 = 0;
        Iterator<DownloadData> it = mTaskList.iterator();
        while (true) {
            i2 = i3;
            if (!it.hasNext()) {
                break;
            }
            i3 = it.next().getType() == type ? i2 + 1 : i2;
        }
        if (i2 >= i) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail_over_max));
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
            if (!k.lk()) {
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail_no_sd));
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
                    if (downloadData2 == null || downloadData2.getUrl() == null || downloadData.getUrl() == null || !downloadData2.getUrl().equals(downloadData.getUrl()) || downloadData2.getId() == null || downloadData.getId() == null || !downloadData2.getId().equals(downloadData.getId())) {
                        i = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    downloadData.setStatus(5);
                    mTaskList.add(downloadData);
                    Ky();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ky() {
        if (bpt == null && !mTaskList.isEmpty()) {
            bpt = mTaskList.get(0);
            if (bpt != null) {
                this.bpu = new a();
                this.bpu.execute(bpt);
            }
        }
    }

    public void fN(String str) {
        o(str, false);
    }

    public void o(String str, boolean z) {
        if (bpt != null && bpt.getUrl().equals(str)) {
            if (z) {
                this.bpu.KB();
                return;
            } else {
                this.bpu.cancel(true);
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

    public void z(String str, int i) {
        if (bpt != null && bpt.getId().equals(str) && bpt.getType() == i) {
            this.bpu.cancel(true);
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

    public void hG(int i) {
        if (bpt != null && bpt.getType() == i) {
            this.bpu.cancel(true);
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

    public List<DownloadData> rk() {
        return mTaskList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"DefaultLocale"})
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        private x mNetWork = new x();

        a() {
        }

        public void KB() {
            if (this.mNetWork != null) {
                this.mNetWork.mU();
            }
            cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.mNetWork.mU();
            if (e.bpt != null) {
                e.bpt.setStatus(4);
                e.bpt.setStatusMsg(null);
                if (e.bpt.getCallback() != null) {
                    e.bpt.getCallback().onFileUpdateProgress(e.bpt);
                }
                if (!e.mTaskList.isEmpty()) {
                    e.mTaskList.remove(0);
                }
                DownloadData unused = e.bpt = null;
                e.this.Ky();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [388=5, 390=4, 391=4, 392=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:84:0x019c A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                    if (!Boolean.valueOf(this.mNetWork.a(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp", e.this.bpv, TbConfig.NET_MSG_GETLENTH, 3, PushConstants.WORK_RECEIVER_EVENTCORE_ERROR)).booleanValue()) {
                        return 3;
                    }
                    File dr = k.dr(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp");
                    if (dr == null) {
                        return 1;
                    }
                    try {
                        String parent = dr.getParent();
                        String parent2 = file.getParent();
                        if (parent.equals(parent2)) {
                            dr.renameTo(new File(parent2, file.getName()));
                        } else {
                            com.baidu.adp.lib.util.f.b(dr, file);
                            com.baidu.adp.lib.util.f.i(dr);
                        }
                    } catch (IOException e) {
                        try {
                            com.baidu.adp.lib.util.f.i(file);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return 7;
                    }
                }
                if (!am.isEmpty(downloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                        try {
                            if (!s.e(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                                com.baidu.adp.lib.util.f.i(new File(downloadDataArr[0].getPath()));
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
            if (e.bpt != null) {
                if (num.intValue() == 0) {
                    e.bpt.setStatus(0);
                    if (e.bpt.getCallback() != null) {
                        e.bpt.getCallback().onFileUpdateProgress(e.bpt);
                    }
                    if (e.bpt.getCallback() != null) {
                        e.bpt.getCallback().onFileDownloadSucceed(e.bpt);
                    }
                } else {
                    switch (num.intValue()) {
                        case 1:
                            string = TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail);
                            break;
                        case 2:
                            string = TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail);
                            break;
                        case 3:
                            string = TbadkCoreApplication.getInst().getApp().getString(d.j.download_error);
                            break;
                        case 4:
                            string = TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail);
                            break;
                        case 5:
                        default:
                            string = null;
                            break;
                        case 6:
                            string = TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail);
                            break;
                        case 7:
                            string = TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail);
                            break;
                    }
                    e.bpt.setStatusMsg(string);
                    e.bpt.setErrorCode(num.intValue());
                    e.bpt.setStatus(2);
                    if (e.bpt.getCallback() != null) {
                        e.bpt.getCallback().onFileUpdateProgress(e.bpt);
                    }
                    if (e.bpt.getCallback() != null) {
                        e.bpt.getCallback().onFileDownloadFailed(e.bpt, num.intValue(), string);
                    }
                }
                DownloadData unused = e.bpt = null;
                if (!e.mTaskList.isEmpty()) {
                    e.mTaskList.remove(0);
                    e.this.Ky();
                }
            }
        }
    }
}
