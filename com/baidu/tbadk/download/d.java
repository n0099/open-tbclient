package com.baidu.tbadk.download;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.kirin.KirinConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.y;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class d extends BdAsyncTask<DownloadData, DownloadData, Integer> {
    final /* synthetic */ b a;
    private aq b = new aq();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        DownloadData downloadData;
        DownloadData downloadData2;
        DownloadData downloadData3;
        List list;
        List list2;
        DownloadData downloadData4;
        DownloadData downloadData5;
        super.onCancelled();
        this.b.g();
        downloadData = b.b;
        downloadData.setStatus(4);
        downloadData2 = b.b;
        downloadData2.setStatusMsg(null);
        downloadData3 = b.b;
        if (downloadData3.getCallback() != null) {
            downloadData4 = b.b;
            a callback = downloadData4.getCallback();
            downloadData5 = b.b;
            callback.b(downloadData5);
        }
        list = b.c;
        if (!list.isEmpty()) {
            list2 = b.c;
            list2.remove(0);
        }
        b.b = null;
        this.a.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [350=4, 352=4, 353=4, 354=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Integer doInBackground(DownloadData... downloadDataArr) {
        int i;
        FileInputStream fileInputStream;
        Handler handler;
        FileInputStream fileInputStream2 = null;
        Boolean.valueOf(false);
        if (downloadDataArr[0] == null) {
            return null;
        }
        if (downloadDataArr[0].getCallback() != null && !downloadDataArr[0].getCallback().c(downloadDataArr[0])) {
            return 0;
        }
        File file = new File(downloadDataArr[0].getPath());
        if (file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
            this.b.a(downloadDataArr[0].getUrl());
            aq aqVar = this.b;
            String str = String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp";
            handler = this.a.f;
            if (!Boolean.valueOf(aqVar.a(str, handler, TbConfig.NET_MSG_GETLENTH, 3, KirinConfig.CONNECT_TIME_OUT)).booleanValue()) {
                return 3;
            }
            File d = z.d(String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp");
            if (d == null) {
                return 1;
            }
            try {
                FileUtils.copyFile(d, file);
                FileUtils.deleteQuietly(d);
            } catch (IOException e) {
                return 1;
            }
        }
        try {
            if (!bm.c(downloadDataArr[0].getCheck())) {
                try {
                    fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                } catch (FileNotFoundException e2) {
                    e = e2;
                }
                try {
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    BdLog.d(e.getMessage());
                    i = 4;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e4) {
                            BdLog.d(e4.getMessage());
                        }
                    }
                    return i;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e5) {
                            BdLog.d(e5.getMessage());
                        }
                    }
                    throw th;
                }
                if (!bm.a(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                    i = 4;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                            BdLog.d(e6.getMessage());
                        }
                    }
                    return i;
                } else if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e7) {
                        BdLog.d(e7.getMessage());
                    }
                }
            }
            i = (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().d(downloadDataArr[0])) ? 0 : 2;
            return i;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Integer num) {
        String string;
        DownloadData downloadData;
        DownloadData downloadData2;
        DownloadData downloadData3;
        DownloadData downloadData4;
        DownloadData downloadData5;
        DownloadData downloadData6;
        DownloadData downloadData7;
        DownloadData downloadData8;
        List list;
        List list2;
        DownloadData downloadData9;
        DownloadData downloadData10;
        DownloadData downloadData11;
        DownloadData downloadData12;
        DownloadData downloadData13;
        DownloadData downloadData14;
        DownloadData downloadData15;
        super.onPostExecute(num);
        if (num.intValue() == 0) {
            downloadData9 = b.b;
            if (downloadData9.getCallback() != null) {
                downloadData14 = b.b;
                a callback = downloadData14.getCallback();
                downloadData15 = b.b;
                callback.a(downloadData15);
            }
            downloadData10 = b.b;
            downloadData10.setStatus(0);
            downloadData11 = b.b;
            if (downloadData11.getCallback() != null) {
                downloadData12 = b.b;
                a callback2 = downloadData12.getCallback();
                downloadData13 = b.b;
                callback2.b(downloadData13);
            }
        } else {
            switch (num.intValue()) {
                case 1:
                    string = TbadkApplication.m252getInst().getApp().getString(y.download_fail);
                    break;
                case 2:
                    string = TbadkApplication.m252getInst().getApp().getString(y.download_fail);
                    break;
                case 3:
                    string = TbadkApplication.m252getInst().getApp().getString(y.download_fail_net);
                    break;
                case 4:
                    string = TbadkApplication.m252getInst().getApp().getString(y.download_fail);
                    break;
                default:
                    string = null;
                    break;
            }
            downloadData = b.b;
            downloadData.setStatusMsg(string);
            downloadData2 = b.b;
            if (downloadData2.getCallback() != null) {
                downloadData7 = b.b;
                a callback3 = downloadData7.getCallback();
                downloadData8 = b.b;
                callback3.a(downloadData8, num.intValue(), string);
            }
            downloadData3 = b.b;
            downloadData3.setStatus(2);
            downloadData4 = b.b;
            if (downloadData4.getCallback() != null) {
                downloadData5 = b.b;
                a callback4 = downloadData5.getCallback();
                downloadData6 = b.b;
                callback4.b(downloadData6);
            }
        }
        b.b = null;
        list = b.c;
        if (!list.isEmpty()) {
            list2 = b.c;
            list2.remove(0);
            this.a.e();
        }
    }
}
