package com.baidu.tbadk.download;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class d extends BdAsyncTask<DownloadData, DownloadData, Integer> {
    final /* synthetic */ b a;
    private ae b = new ae();

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
        this.b.f();
        downloadData = b.b;
        downloadData.setStatus(4);
        downloadData2 = b.b;
        downloadData2.setStatusMsg(null);
        downloadData3 = b.b;
        if (downloadData3.getCallback() != null) {
            downloadData4 = b.b;
            a callback = downloadData4.getCallback();
            downloadData5 = b.b;
            callback.a(downloadData5);
        }
        list = b.c;
        if (!list.isEmpty()) {
            list2 = b.c;
            list2.remove(0);
        }
        b.b = null;
        this.a.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [355=4, 357=4, 358=4, 359=4] */
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
        if (downloadDataArr[0].getCallback() != null && !downloadDataArr[0].getCallback().b(downloadDataArr[0])) {
            return 0;
        }
        File file = new File(downloadDataArr[0].getPath());
        if (file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
            this.b.a(downloadDataArr[0].getUrl());
            ae aeVar = this.b;
            String str = String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp";
            handler = this.a.f;
            if (!Boolean.valueOf(aeVar.a(str, handler, TbConfig.NET_MSG_GETLENTH, 3, 3000)).booleanValue()) {
                return 3;
            }
            File d = s.d(String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp");
            if (d == null) {
                return 1;
            }
            try {
                com.baidu.adp.lib.util.commonsio.a.a(d, file);
                com.baidu.adp.lib.util.commonsio.a.b(d);
            } catch (IOException e) {
                try {
                    com.baidu.adp.lib.util.commonsio.a.b(file);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 1;
            }
        }
        try {
            if (!ba.c(downloadDataArr[0].getCheck())) {
                try {
                    fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                } catch (FileNotFoundException e3) {
                    e = e3;
                }
                try {
                } catch (FileNotFoundException e4) {
                    e = e4;
                    fileInputStream2 = fileInputStream;
                    BdLog.d(e.getMessage());
                    i = 4;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e5) {
                            BdLog.d(e5.getMessage());
                        }
                    }
                    return i;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e6) {
                            BdLog.d(e6.getMessage());
                        }
                    }
                    throw th;
                }
                if (!ba.a(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                    i = 4;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e7) {
                            BdLog.d(e7.getMessage());
                        }
                    }
                    return i;
                } else if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e8) {
                        BdLog.d(e8.getMessage());
                    }
                }
            }
            i = (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().c(downloadDataArr[0])) ? 0 : 2;
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
        DownloadData downloadData9;
        List list;
        List list2;
        DownloadData downloadData10;
        DownloadData downloadData11;
        DownloadData downloadData12;
        DownloadData downloadData13;
        DownloadData downloadData14;
        DownloadData downloadData15;
        DownloadData downloadData16;
        super.onPostExecute(num);
        if (num.intValue() == 0) {
            downloadData10 = b.b;
            if (downloadData10.getCallback() != null) {
                downloadData15 = b.b;
                a callback = downloadData15.getCallback();
                downloadData16 = b.b;
                callback.d(downloadData16);
            }
            downloadData11 = b.b;
            downloadData11.setStatus(0);
            downloadData12 = b.b;
            if (downloadData12.getCallback() != null) {
                downloadData13 = b.b;
                a callback2 = downloadData13.getCallback();
                downloadData14 = b.b;
                callback2.a(downloadData14);
            }
        } else {
            switch (num.intValue()) {
                case 1:
                    string = TbadkApplication.m252getInst().getApp().getString(x.download_fail);
                    break;
                case 2:
                    string = TbadkApplication.m252getInst().getApp().getString(x.download_fail);
                    break;
                case 3:
                    string = TbadkApplication.m252getInst().getApp().getString(x.download_fail_net);
                    break;
                case 4:
                    string = TbadkApplication.m252getInst().getApp().getString(x.download_fail);
                    break;
                default:
                    string = null;
                    break;
            }
            downloadData = b.b;
            downloadData.setStatusMsg(string);
            downloadData2 = b.b;
            downloadData2.setErrorCode(num.intValue());
            downloadData3 = b.b;
            if (downloadData3.getCallback() != null) {
                downloadData8 = b.b;
                a callback3 = downloadData8.getCallback();
                downloadData9 = b.b;
                callback3.a(downloadData9, num.intValue(), string);
            }
            downloadData4 = b.b;
            downloadData4.setStatus(2);
            downloadData5 = b.b;
            if (downloadData5.getCallback() != null) {
                downloadData6 = b.b;
                a callback4 = downloadData6.getCallback();
                downloadData7 = b.b;
                callback4.a(downloadData7);
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
