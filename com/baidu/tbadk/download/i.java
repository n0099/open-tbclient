package com.baidu.tbadk.download;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.z;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.s;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<DownloadData, DownloadData, Integer> {
    private ad AO = new ad();
    final /* synthetic */ g XN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.XN = gVar;
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
        this.AO.dJ();
        downloadData = g.XK;
        downloadData.setStatus(4);
        downloadData2 = g.XK;
        downloadData2.setStatusMsg(null);
        downloadData3 = g.XK;
        if (downloadData3.getCallback() != null) {
            downloadData4 = g.XK;
            f callback = downloadData4.getCallback();
            downloadData5 = g.XK;
            callback.a(downloadData5);
        }
        list = g.XE;
        if (!list.isEmpty()) {
            list2 = g.XE;
            list2.remove(0);
        }
        g.XK = null;
        this.XN.va();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [367=4, 369=4, 370=4, 371=4] */
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
        if (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().b(downloadDataArr[0])) {
            File file = new File(downloadDataArr[0].getPath());
            if (file.exists()) {
                file.delete();
            }
            if (!file.exists()) {
                this.AO.setUrl(downloadDataArr[0].getUrl());
                ad adVar = this.AO;
                String str = String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp";
                handler = this.XN.XM;
                if (!Boolean.valueOf(adVar.a(str, handler, TbConfig.NET_MSG_GETLENTH, 3, 3000)).booleanValue()) {
                    return 3;
                }
                File ce = s.ce(String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp");
                if (ce == null) {
                    return 1;
                }
                try {
                    String parent = ce.getParent();
                    String parent2 = file.getParent();
                    if (parent.equals(parent2)) {
                        ce.renameTo(new File(parent2, file.getName()));
                    } else {
                        com.baidu.adp.lib.util.commonsio.a.copyFile(ce, file);
                        com.baidu.adp.lib.util.commonsio.a.g(ce);
                    }
                } catch (IOException e) {
                    try {
                        com.baidu.adp.lib.util.commonsio.a.g(file);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return 7;
                }
            }
            if (!bf.isEmpty(downloadDataArr[0].getCheck())) {
                try {
                    fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                    try {
                        if (!z.e(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                            com.baidu.adp.lib.util.commonsio.a.g(new File(downloadDataArr[0].getPath()));
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
            return (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().c(downloadDataArr[0])) ? 0 : 2;
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
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
        super.onPostExecute((i) num);
        if (num.intValue() == 0) {
            downloadData10 = g.XK;
            if (downloadData10.getCallback() != null) {
                downloadData15 = g.XK;
                f callback = downloadData15.getCallback();
                downloadData16 = g.XK;
                callback.d(downloadData16);
            }
            downloadData11 = g.XK;
            downloadData11.setStatus(0);
            downloadData12 = g.XK;
            if (downloadData12.getCallback() != null) {
                downloadData13 = g.XK;
                f callback2 = downloadData13.getCallback();
                downloadData14 = g.XK;
                callback2.a(downloadData14);
            }
        } else {
            switch (num.intValue()) {
                case 1:
                    string = TbadkCoreApplication.m255getInst().getApp().getString(com.baidu.tieba.z.download_fail);
                    break;
                case 2:
                    string = TbadkCoreApplication.m255getInst().getApp().getString(com.baidu.tieba.z.download_fail);
                    break;
                case 3:
                    string = TbadkCoreApplication.m255getInst().getApp().getString(com.baidu.tieba.z.download_fail_net);
                    break;
                case 4:
                    string = TbadkCoreApplication.m255getInst().getApp().getString(com.baidu.tieba.z.download_fail);
                    break;
                case 5:
                default:
                    string = null;
                    break;
                case 6:
                    string = TbadkCoreApplication.m255getInst().getApp().getString(com.baidu.tieba.z.download_fail);
                    break;
                case 7:
                    string = TbadkCoreApplication.m255getInst().getApp().getString(com.baidu.tieba.z.download_fail);
                    break;
            }
            downloadData = g.XK;
            downloadData.setStatusMsg(string);
            downloadData2 = g.XK;
            downloadData2.setErrorCode(num.intValue());
            downloadData3 = g.XK;
            if (downloadData3.getCallback() != null) {
                downloadData8 = g.XK;
                f callback3 = downloadData8.getCallback();
                downloadData9 = g.XK;
                callback3.a(downloadData9, num.intValue(), string);
            }
            downloadData4 = g.XK;
            downloadData4.setStatus(2);
            downloadData5 = g.XK;
            if (downloadData5.getCallback() != null) {
                downloadData6 = g.XK;
                f callback4 = downloadData6.getCallback();
                downloadData7 = g.XK;
                callback4.a(downloadData7);
            }
        }
        g.XK = null;
        list = g.XE;
        if (!list.isEmpty()) {
            list2 = g.XE;
            list2.remove(0);
            this.XN.va();
        }
    }
}
