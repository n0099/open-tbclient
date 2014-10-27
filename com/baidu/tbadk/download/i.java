package com.baidu.tbadk.download;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.y;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<DownloadData, DownloadData, Integer> {
    final /* synthetic */ g Rj;
    private ac mNetWork = new ac();

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.Rj = gVar;
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
        this.mNetWork.dM();
        downloadData = g.Rg;
        downloadData.setStatus(4);
        downloadData2 = g.Rg;
        downloadData2.setStatusMsg(null);
        downloadData3 = g.Rg;
        if (downloadData3.getCallback() != null) {
            downloadData4 = g.Rg;
            f callback = downloadData4.getCallback();
            downloadData5 = g.Rg;
            callback.onFileUpdateProgress(downloadData5);
        }
        list = g.Ra;
        if (!list.isEmpty()) {
            list2 = g.Ra;
            list2.remove(0);
        }
        g.Rg = null;
        this.Rj.rl();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [366=4, 368=4, 369=4, 370=4] */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:75:0x016d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Integer doInBackground(DownloadData... downloadDataArr) {
        FileInputStream fileInputStream;
        Handler handler;
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
                ac acVar = this.mNetWork;
                String str = String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp";
                handler = this.Rj.Ri;
                if (!Boolean.valueOf(acVar.a(str, handler, TbConfig.NET_MSG_GETLENTH, 3, 3000)).booleanValue()) {
                    return 3;
                }
                File br = s.br(String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp");
                if (br == null) {
                    return 1;
                }
                try {
                    String parent = br.getParent();
                    String parent2 = file.getParent();
                    if (parent.equals(parent2)) {
                        br.renameTo(new File(parent2, file.getName()));
                    } else {
                        com.baidu.adp.lib.util.commonsio.a.a(br, file);
                        com.baidu.adp.lib.util.commonsio.a.f(br);
                    }
                } catch (IOException e) {
                    try {
                        com.baidu.adp.lib.util.commonsio.a.f(file);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return 7;
                }
            }
            if (!ay.aA(downloadDataArr[0].getCheck())) {
                try {
                    fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                    try {
                        if (!u.b(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                            com.baidu.adp.lib.util.commonsio.a.f(new File(downloadDataArr[0].getPath()));
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
            downloadData10 = g.Rg;
            if (downloadData10.getCallback() != null) {
                downloadData15 = g.Rg;
                f callback = downloadData15.getCallback();
                downloadData16 = g.Rg;
                callback.onFileDownloadSucceed(downloadData16);
            }
            downloadData11 = g.Rg;
            downloadData11.setStatus(0);
            downloadData12 = g.Rg;
            if (downloadData12.getCallback() != null) {
                downloadData13 = g.Rg;
                f callback2 = downloadData13.getCallback();
                downloadData14 = g.Rg;
                callback2.onFileUpdateProgress(downloadData14);
            }
        } else {
            switch (num.intValue()) {
                case 1:
                    string = TbadkApplication.m251getInst().getApp().getString(y.download_fail);
                    break;
                case 2:
                    string = TbadkApplication.m251getInst().getApp().getString(y.download_fail);
                    break;
                case 3:
                    string = TbadkApplication.m251getInst().getApp().getString(y.download_fail_net);
                    break;
                case 4:
                    string = TbadkApplication.m251getInst().getApp().getString(y.download_fail);
                    break;
                case 5:
                default:
                    string = null;
                    break;
                case 6:
                    string = TbadkApplication.m251getInst().getApp().getString(y.download_fail);
                    break;
                case 7:
                    string = TbadkApplication.m251getInst().getApp().getString(y.download_fail);
                    break;
            }
            downloadData = g.Rg;
            downloadData.setStatusMsg(string);
            downloadData2 = g.Rg;
            downloadData2.setErrorCode(num.intValue());
            downloadData3 = g.Rg;
            if (downloadData3.getCallback() != null) {
                downloadData8 = g.Rg;
                f callback3 = downloadData8.getCallback();
                downloadData9 = g.Rg;
                callback3.onFileDownloadFailed(downloadData9, num.intValue(), string);
            }
            downloadData4 = g.Rg;
            downloadData4.setStatus(2);
            downloadData5 = g.Rg;
            if (downloadData5.getCallback() != null) {
                downloadData6 = g.Rg;
                f callback4 = downloadData6.getCallback();
                downloadData7 = g.Rg;
                callback4.onFileUpdateProgress(downloadData7);
            }
        }
        g.Rg = null;
        list = g.Ra;
        if (!list.isEmpty()) {
            list2 = g.Ra;
            list2.remove(0);
            this.Rj.rl();
        }
    }
}
