package com.baidu.tbadk.download;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.s;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.o;
import com.baidu.tieba.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static d fAU = new d();
    private static DownloadData fAV = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private a fAW = null;
    private int max = 20;
    @SuppressLint({"HandlerLeak"})
    private Handler fAX = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.download.d.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 900002 && message.arg2 > 0 && d.fAV != null) {
                d.fAV.setLength(message.arg1);
                d.fAV.setSize(message.arg2);
                d.fAV.setStatus(1);
                if (d.fAV.getCallback() != null) {
                    d.fAV.getCallback().onFileUpdateProgress(d.fAV);
                }
            }
        }
    };

    private d() {
    }

    public static d bBd() {
        return fAU;
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
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().onFileUpdateProgress(downloadData);
                return;
            }
            return;
        }
        f(downloadData);
    }

    public void f(DownloadData downloadData) {
        DownloadData downloadData2;
        if (downloadData != null) {
            if (!o.checkSD()) {
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_no_sd));
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
                    try {
                        downloadData2 = mTaskList.get(i2);
                    } catch (Exception e) {
                        downloadData2 = null;
                    }
                    if (downloadData2 == null || downloadData2.getUrl() == null || downloadData.getUrl() == null || !downloadData2.getUrl().equals(downloadData.getUrl()) || downloadData2.getId() == null || downloadData.getId() == null || !downloadData2.getId().equals(downloadData.getId())) {
                        i = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    downloadData.setStatus(5);
                    mTaskList.add(downloadData);
                    startQueue();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startQueue() {
        if (fAV == null && !mTaskList.isEmpty()) {
            try {
                fAV = mTaskList.get(0);
            } catch (Exception e) {
                BdLog.e(e);
            }
            if (fAV != null) {
                this.fAW = new a();
                this.fAW.execute(fAV);
            }
        }
    }

    public void cancelDownLoadByUrl(String str, boolean z) {
        if (fAV != null && fAV.getUrl().equals(str)) {
            if (z) {
                this.fAW.cancelImmediately();
                return;
            } else {
                this.fAW.cancel(true);
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

    public void cancelDownLoadById(String str, int i) {
        if (fAV != null && fAV.getId().equals(str) && fAV.getType() == i) {
            this.fAW.cancel(true);
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

    public void cancelDownloadByType(int i) {
        if (fAV != null && fAV.getType() == i) {
            this.fAW.cancel(true);
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

    public List<DownloadData> getDownloadList() {
        return mTaskList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"DefaultLocale"})
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        private aa cml = new aa();

        a() {
        }

        public void cancelImmediately() {
            if (this.cml != null) {
                this.cml.setCancel();
            }
            cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.cml.setCancel();
            if (d.fAV != null) {
                d.fAV.setStatus(4);
                d.fAV.setStatusMsg(null);
                if (d.fAV.getCallback() != null) {
                    d.fAV.getCallback().onFileUpdateProgress(d.fAV);
                }
                if (!d.mTaskList.isEmpty()) {
                    d.mTaskList.remove(0);
                }
                DownloadData unused = d.fAV = null;
                d.this.startQueue();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [395=5, 397=4, 398=4, 399=4] */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:69:0x01b3 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:71:0x01b5 */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:75:? */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x00e0 */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:83:0x01a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r0v0 */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v34 */
        /* JADX WARN: Type inference failed for: r1v37 */
        /* JADX WARN: Type inference failed for: r1v38 */
        /* JADX WARN: Type inference failed for: r1v39 */
        /* JADX WARN: Type inference failed for: r1v40 */
        /* JADX WARN: Type inference failed for: r1v42 */
        /* JADX WARN: Type inference failed for: r1v45 */
        /* JADX WARN: Type inference failed for: r1v5, types: [java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r1v9 */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Integer doInBackground(DownloadData... downloadDataArr) {
            FileInputStream fileInputStream;
            int i;
            Throwable th;
            FileInputStream fileInputStream2;
            boolean equalsIgnoreCase;
            Boolean.valueOf(false);
            if (downloadDataArr[0] == 0) {
                return 1;
            }
            if (downloadDataArr[0].getCallback() != null) {
                c callback = downloadDataArr[0].getCallback();
                fileInputStream = downloadDataArr[0];
                if (!callback.onPreDownload(fileInputStream)) {
                    return 0;
                }
            }
            File file = new File(downloadDataArr[0].getPath());
            if (file.exists()) {
                file.delete();
            }
            if (!file.exists()) {
                this.cml.setUrl(downloadDataArr[0].getUrl());
                if (!Boolean.valueOf(this.cml.a(downloadDataArr[0].getId() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + downloadDataArr[0].getName() + ".tmp", d.this.fAX, 900002, 3, 3000)).booleanValue()) {
                    return 3;
                }
                File GetFileInCache = o.GetFileInCache(downloadDataArr[0].getId() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + downloadDataArr[0].getName() + ".tmp");
                if (GetFileInCache == null) {
                    return 1;
                }
                try {
                    String parent = GetFileInCache.getParent();
                    String parent2 = file.getParent();
                    boolean equals = parent.equals(parent2);
                    if (equals) {
                        String name = file.getName();
                        GetFileInCache.renameTo(new File(parent2, name));
                        fileInputStream = name;
                    } else {
                        f.copyFile(GetFileInCache, file);
                        f.deleteQuietly(GetFileInCache);
                        fileInputStream = equals;
                    }
                } catch (IOException e) {
                    try {
                        f.deleteQuietly(file);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return 7;
                }
            }
            FileInputStream fileInputStream3 = fileInputStream;
            if (!au.isEmpty(downloadDataArr[0].getCheck())) {
                try {
                    try {
                        fileInputStream2 = new FileInputStream(downloadDataArr[0].getPath());
                        try {
                            equalsIgnoreCase = s.toMd5(fileInputStream2).equalsIgnoreCase(downloadDataArr[0].getCheck());
                            fileInputStream3 = fileInputStream2;
                        } catch (FileNotFoundException e3) {
                            e = e3;
                            BdLog.d(e.getMessage());
                            i = 6;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                    fileInputStream = fileInputStream2;
                                } catch (IOException e4) {
                                    String message = e4.getMessage();
                                    BdLog.d(message);
                                    fileInputStream = message;
                                }
                            }
                            return i;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != 0) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                BdLog.d(e5.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e6) {
                    e = e6;
                    fileInputStream2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = 0;
                    if (fileInputStream != 0) {
                    }
                    throw th;
                }
                if (!equalsIgnoreCase) {
                    f.deleteQuietly(new File(downloadDataArr[0].getPath()));
                    i = 4;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                            fileInputStream = fileInputStream2;
                        } catch (IOException e7) {
                            String message2 = e7.getMessage();
                            BdLog.d(message2);
                            fileInputStream = message2;
                        }
                    }
                    return i;
                } else if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                        fileInputStream3 = fileInputStream2;
                    } catch (IOException e8) {
                        BdLog.d(e8.getMessage());
                        fileInputStream3 = fileInputStream2;
                    }
                }
            }
            FileInputStream fileInputStream4 = fileInputStream3;
            if (downloadDataArr[0].getCallback() != null) {
                c callback2 = downloadDataArr[0].getCallback();
                DownloadData downloadData = downloadDataArr[0];
                boolean onFileDownloaded = callback2.onFileDownloaded(downloadData);
                fileInputStream4 = downloadData;
                if (!onFileDownloaded) {
                    i = 2;
                    fileInputStream = downloadData;
                    return i;
                }
            }
            i = 0;
            fileInputStream = fileInputStream4;
            return i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            String string;
            super.onPostExecute((a) num);
            if (d.fAV != null && num != null) {
                if (num.intValue() == 0) {
                    d.fAV.setStatus(0);
                    if (d.fAV.getCallback() != null) {
                        d.fAV.getCallback().onFileUpdateProgress(d.fAV);
                    }
                    if (d.fAV.getCallback() != null) {
                        d.fAV.getCallback().onFileDownloadSucceed(d.fAV);
                    }
                } else {
                    switch (num.intValue()) {
                        case 1:
                            string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                            break;
                        case 2:
                            string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                            break;
                        case 3:
                            string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_error);
                            break;
                        case 4:
                            string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                            break;
                        case 5:
                        default:
                            string = null;
                            break;
                        case 6:
                            string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                            break;
                        case 7:
                            string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                            break;
                    }
                    d.fAV.setStatusMsg(string);
                    d.fAV.setErrorCode(num.intValue());
                    d.fAV.setStatus(2);
                    if (d.fAV.getCallback() != null) {
                        d.fAV.getCallback().onFileUpdateProgress(d.fAV);
                    }
                    if (d.fAV.getCallback() != null) {
                        d.fAV.getCallback().onFileDownloadFailed(d.fAV, num.intValue(), string);
                    }
                }
                DownloadData unused = d.fAV = null;
                if (!d.mTaskList.isEmpty()) {
                    d.mTaskList.remove(0);
                    d.this.startQueue();
                }
            }
        }
    }
}
