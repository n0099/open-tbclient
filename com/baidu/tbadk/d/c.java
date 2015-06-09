package com.baidu.tbadk.d;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.ac;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.t;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<BdFileDownloadData, BdFileDownloadData, Integer> {
    private aa OE = new aa();
    final /* synthetic */ a art;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.art = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        BdFileDownloadData bdFileDownloadData;
        BdFileDownloadData bdFileDownloadData2;
        BdFileDownloadData bdFileDownloadData3;
        List list;
        List list2;
        BdFileDownloadData bdFileDownloadData4;
        BdFileDownloadData bdFileDownloadData5;
        super.onCancelled();
        this.OE.gS();
        bdFileDownloadData = a.arr;
        bdFileDownloadData.setStatus(4);
        bdFileDownloadData2 = a.arr;
        bdFileDownloadData2.setStatusMsg(null);
        bdFileDownloadData3 = a.arr;
        if (bdFileDownloadData3.getCallback() != null) {
            bdFileDownloadData4 = a.arr;
            com.baidu.adp.plugin.packageManager.pluginFileDownload.a callback = bdFileDownloadData4.getCallback();
            bdFileDownloadData5 = a.arr;
            callback.e(bdFileDownloadData5);
        }
        list = a.aiS;
        if (!list.isEmpty()) {
            list2 = a.aiS;
            list2.remove(0);
        }
        a.arr = null;
        this.art.zk();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [306=4, 308=4, 309=4, 310=4, 364=4, 366=4, 367=4, 368=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:112:0x024b */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x011c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a7  */
    /* JADX WARN: Type inference failed for: r0v58, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v30, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v31, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v34 */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Integer doInBackground(BdFileDownloadData... bdFileDownloadDataArr) {
        FileInputStream fileInputStream;
        boolean j;
        String i;
        Handler handler;
        String i2;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3 = null;
        Boolean.valueOf(false);
        if (bdFileDownloadDataArr[0] == null) {
            return null;
        }
        if (bdFileDownloadDataArr[0].getCallback() == null || bdFileDownloadDataArr[0].getCallback().d(bdFileDownloadDataArr[0])) {
            BdLog.i("pluginFileDownloader beging download " + bdFileDownloadDataArr[0].getId());
            if (bdFileDownloadDataArr[0].getPath() == null) {
                return 1;
            }
            File file = new File(bdFileDownloadDataArr[0].getPath());
            if (file.exists()) {
                ?? sb = new StringBuilder("pluginFileDownloader has exsit ");
                ?? id = bdFileDownloadDataArr[0].getId();
                BdLog.i(sb.append(id).toString());
                try {
                    if (bb.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
                        com.baidu.adp.lib.util.commonsio.a.g(file);
                    } else {
                        try {
                            fileInputStream2 = new FileInputStream(file);
                            try {
                                if (ac.e(fileInputStream2).equalsIgnoreCase(bdFileDownloadDataArr[0].getCheck())) {
                                    if (fileInputStream2 != null) {
                                        try {
                                            fileInputStream2.close();
                                            return 0;
                                        } catch (IOException e) {
                                            BdLog.d(e.getMessage());
                                            return 0;
                                        }
                                    }
                                    return 0;
                                }
                                com.baidu.adp.lib.util.commonsio.a.g(file);
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e2) {
                                        BdLog.d(e2.getMessage());
                                    }
                                }
                            } catch (FileNotFoundException e3) {
                                e = e3;
                                BdLog.d(e.getMessage());
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e4) {
                                        BdLog.d(e4.getMessage());
                                    }
                                }
                                if (!file.exists()) {
                                }
                                if (!bb.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
                                }
                                if (bdFileDownloadDataArr[0].getCallback() != null) {
                                }
                                j = this.art.j(bdFileDownloadDataArr[0]);
                                if (j) {
                                }
                            }
                        } catch (FileNotFoundException e5) {
                            e = e5;
                            fileInputStream2 = null;
                        } catch (Throwable th) {
                            th = th;
                            id = 0;
                            if (id != 0) {
                                try {
                                    id.close();
                                } catch (IOException e6) {
                                    BdLog.d(e6.getMessage());
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (!file.exists()) {
                this.OE.setUrl(bdFileDownloadDataArr[0].getUrl());
                aa aaVar = this.OE;
                i = this.art.i(bdFileDownloadDataArr[0]);
                handler = this.art.aja;
                Boolean valueOf = Boolean.valueOf(aaVar.a(i, handler, TbConfig.NET_MSG_GETLENTH, 3, LocationClientOption.MIN_SCAN_SPAN_NETWORK, true));
                BdLog.i("pluginFileDownloader download complete " + bdFileDownloadDataArr[0].getId());
                if (!valueOf.booleanValue()) {
                    return 3;
                }
                i2 = this.art.i(bdFileDownloadDataArr[0]);
                File file2 = new File(i2);
                if (!file2.exists() || file2.length() <= 0) {
                    if (file2.exists()) {
                        com.baidu.adp.lib.util.commonsio.a.g(file2);
                    }
                    return 1;
                }
                try {
                    com.baidu.adp.lib.util.commonsio.a.copyFile(file2, file);
                    com.baidu.adp.lib.util.commonsio.a.g(file2);
                } catch (IOException e7) {
                    try {
                        com.baidu.adp.lib.util.commonsio.a.g(file);
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                    return 7;
                }
            }
            if (!bb.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
                try {
                    fileInputStream = new FileInputStream(bdFileDownloadDataArr[0].getPath());
                    try {
                        if (!ac.e(fileInputStream).equalsIgnoreCase(bdFileDownloadDataArr[0].getCheck())) {
                            com.baidu.adp.lib.util.commonsio.a.g(new File(bdFileDownloadDataArr[0].getPath()));
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    return 4;
                                } catch (IOException e9) {
                                    BdLog.d(e9.getMessage());
                                    return 4;
                                }
                            }
                            return 4;
                        } else if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e10) {
                                BdLog.d(e10.getMessage());
                            }
                        }
                    } catch (FileNotFoundException e11) {
                        e = e11;
                        fileInputStream3 = fileInputStream;
                        try {
                            BdLog.d(e.getMessage());
                            if (fileInputStream3 != null) {
                                try {
                                    fileInputStream3.close();
                                    return 6;
                                } catch (IOException e12) {
                                    BdLog.d(e12.getMessage());
                                    return 6;
                                }
                            }
                            return 6;
                        } catch (Throwable th3) {
                            th = th3;
                            fileInputStream = fileInputStream3;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e13) {
                                    BdLog.d(e13.getMessage());
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (fileInputStream != null) {
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e14) {
                    e = e14;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = null;
                }
            }
            if (bdFileDownloadDataArr[0].getCallback() != null || bdFileDownloadDataArr[0].getCallback().f(bdFileDownloadDataArr[0])) {
                j = this.art.j(bdFileDownloadDataArr[0]);
                return j ? 6 : 0;
            }
            return 2;
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Integer num) {
        String string;
        BdFileDownloadData bdFileDownloadData;
        BdFileDownloadData bdFileDownloadData2;
        BdFileDownloadData bdFileDownloadData3;
        BdFileDownloadData bdFileDownloadData4;
        BdFileDownloadData bdFileDownloadData5;
        BdFileDownloadData bdFileDownloadData6;
        BdFileDownloadData bdFileDownloadData7;
        BdFileDownloadData bdFileDownloadData8;
        BdFileDownloadData bdFileDownloadData9;
        List list;
        List list2;
        BdFileDownloadData bdFileDownloadData10;
        BdFileDownloadData bdFileDownloadData11;
        BdFileDownloadData bdFileDownloadData12;
        BdFileDownloadData bdFileDownloadData13;
        BdFileDownloadData bdFileDownloadData14;
        BdFileDownloadData bdFileDownloadData15;
        BdFileDownloadData bdFileDownloadData16;
        super.onPostExecute((c) num);
        if (num == null) {
            num = -1;
        }
        if (num.intValue() == 0) {
            bdFileDownloadData10 = a.arr;
            if (bdFileDownloadData10.getCallback() != null) {
                bdFileDownloadData15 = a.arr;
                com.baidu.adp.plugin.packageManager.pluginFileDownload.a callback = bdFileDownloadData15.getCallback();
                bdFileDownloadData16 = a.arr;
                callback.g(bdFileDownloadData16);
            }
            bdFileDownloadData11 = a.arr;
            bdFileDownloadData11.setStatus(0);
            bdFileDownloadData12 = a.arr;
            if (bdFileDownloadData12.getCallback() != null) {
                bdFileDownloadData13 = a.arr;
                com.baidu.adp.plugin.packageManager.pluginFileDownload.a callback2 = bdFileDownloadData13.getCallback();
                bdFileDownloadData14 = a.arr;
                callback2.e(bdFileDownloadData14);
            }
        } else {
            switch (num.intValue()) {
                case 1:
                    string = TbadkCoreApplication.m411getInst().getApp().getString(t.download_fail);
                    break;
                case 2:
                    string = TbadkCoreApplication.m411getInst().getApp().getString(t.download_fail);
                    break;
                case 3:
                    string = TbadkCoreApplication.m411getInst().getApp().getString(t.download_fail_net);
                    break;
                case 4:
                    string = TbadkCoreApplication.m411getInst().getApp().getString(t.download_fail);
                    break;
                case 5:
                default:
                    string = TbadkCoreApplication.m411getInst().getApp().getString(t.tb_err_unknown);
                    break;
                case 6:
                    string = TbadkCoreApplication.m411getInst().getApp().getString(t.download_fail);
                    break;
                case 7:
                    string = TbadkCoreApplication.m411getInst().getApp().getString(t.download_fail);
                    break;
            }
            bdFileDownloadData = a.arr;
            bdFileDownloadData.setStatusMsg(string);
            bdFileDownloadData2 = a.arr;
            bdFileDownloadData2.setErrorCode(num.intValue());
            bdFileDownloadData3 = a.arr;
            if (bdFileDownloadData3.getCallback() != null) {
                bdFileDownloadData8 = a.arr;
                com.baidu.adp.plugin.packageManager.pluginFileDownload.a callback3 = bdFileDownloadData8.getCallback();
                bdFileDownloadData9 = a.arr;
                callback3.a(bdFileDownloadData9, num.intValue(), string, string);
            }
            bdFileDownloadData4 = a.arr;
            bdFileDownloadData4.setStatus(2);
            bdFileDownloadData5 = a.arr;
            if (bdFileDownloadData5.getCallback() != null) {
                bdFileDownloadData6 = a.arr;
                com.baidu.adp.plugin.packageManager.pluginFileDownload.a callback4 = bdFileDownloadData6.getCallback();
                bdFileDownloadData7 = a.arr;
                callback4.e(bdFileDownloadData7);
            }
        }
        a.arr = null;
        list = a.aiS;
        if (!list.isEmpty()) {
            list2 = a.aiS;
            list2.remove(0);
            this.art.zk();
        }
    }
}
