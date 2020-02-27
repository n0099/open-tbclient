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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.x;
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
    private static d dwf = new d();
    private static DownloadData dwg = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private a dwh = null;
    private int max = 20;
    @SuppressLint({"HandlerLeak"})
    private Handler dwi = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.download.d.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 900002 && message.arg2 > 0 && d.dwg != null) {
                d.dwg.setLength(message.arg1);
                d.dwg.setSize(message.arg2);
                d.dwg.setStatus(1);
                if (d.dwg.getCallback() != null) {
                    d.dwg.getCallback().onFileUpdateProgress(d.dwg);
                }
            }
        }
    };

    private d() {
    }

    public static d aOn() {
        return dwf;
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
            if (!m.checkSD()) {
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
        if (dwg == null && !mTaskList.isEmpty()) {
            try {
                dwg = mTaskList.get(0);
            } catch (Exception e) {
                BdLog.e(e);
            }
            if (dwg != null) {
                this.dwh = new a();
                this.dwh.execute(dwg);
            }
        }
    }

    public void cancelDownLoadByUrl(String str) {
        cancelDownLoadByUrl(str, false);
    }

    public void cancelDownLoadByUrl(String str, boolean z) {
        if (dwg != null && dwg.getUrl().equals(str)) {
            if (z) {
                this.dwh.cancelImmediately();
                return;
            } else {
                this.dwh.cancel(true);
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
        if (dwg != null && dwg.getId().equals(str) && dwg.getType() == i) {
            this.dwh.cancel(true);
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
        if (dwg != null && dwg.getType() == i) {
            this.dwh.cancel(true);
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
        private x cLD = new x();

        a() {
        }

        public void cancelImmediately() {
            if (this.cLD != null) {
                this.cLD.setCancel();
            }
            cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.cLD.setCancel();
            if (d.dwg != null) {
                d.dwg.setStatus(4);
                d.dwg.setStatusMsg(null);
                if (d.dwg.getCallback() != null) {
                    d.dwg.getCallback().onFileUpdateProgress(d.dwg);
                }
                if (!d.mTaskList.isEmpty()) {
                    d.mTaskList.remove(0);
                }
                DownloadData unused = d.dwg = null;
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
                this.cLD.setUrl(downloadDataArr[0].getUrl());
                if (!Boolean.valueOf(this.cLD.a(downloadDataArr[0].getId() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + downloadDataArr[0].getName() + ".tmp", d.this.dwi, 900002, 3, 3000)).booleanValue()) {
                    return 3;
                }
                File GetFileInCache = m.GetFileInCache(downloadDataArr[0].getId() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + downloadDataArr[0].getName() + ".tmp");
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
            if (!aq.isEmpty(downloadDataArr[0].getCheck())) {
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
            if (d.dwg != null && num != null) {
                if (num.intValue() == 0) {
                    d.dwg.setStatus(0);
                    if (d.dwg.getCallback() != null) {
                        d.dwg.getCallback().onFileUpdateProgress(d.dwg);
                    }
                    if (d.dwg.getCallback() != null) {
                        d.dwg.getCallback().onFileDownloadSucceed(d.dwg);
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
                    d.dwg.setStatusMsg(string);
                    d.dwg.setErrorCode(num.intValue());
                    d.dwg.setStatus(2);
                    if (d.dwg.getCallback() != null) {
                        d.dwg.getCallback().onFileUpdateProgress(d.dwg);
                    }
                    if (d.dwg.getCallback() != null) {
                        d.dwg.getCallback().onFileDownloadFailed(d.dwg, num.intValue(), string);
                    }
                }
                DownloadData unused = d.dwg = null;
                if (!d.mTaskList.isEmpty()) {
                    d.mTaskList.remove(0);
                    d.this.startQueue();
                }
            }
        }
    }
}
