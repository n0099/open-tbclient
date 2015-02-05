package com.baidu.tbadk.e;

import android.os.Handler;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.z;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.bf;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<BdFileDownloadData, BdFileDownloadData, Integer> {
    private ad AO = new ad();
    final /* synthetic */ a ahE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.ahE = aVar;
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
        this.AO.dJ();
        bdFileDownloadData = a.ahC;
        bdFileDownloadData.setStatus(4);
        bdFileDownloadData2 = a.ahC;
        bdFileDownloadData2.setStatusMsg(null);
        bdFileDownloadData3 = a.ahC;
        if (bdFileDownloadData3.getCallback() != null) {
            bdFileDownloadData4 = a.ahC;
            com.baidu.adp.plugin.packageManager.pluginFileDownload.a callback = bdFileDownloadData4.getCallback();
            bdFileDownloadData5 = a.ahC;
            callback.e(bdFileDownloadData5);
        }
        list = a.XE;
        if (!list.isEmpty()) {
            list2 = a.XE;
            list2.remove(0);
        }
        a.ahC = null;
        this.ahE.va();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [305=4, 307=4, 308=4, 309=4, 360=4, 362=4, 363=4, 364=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:107:0x0238 */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0224  */
    /* JADX WARN: Type inference failed for: r0v58, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v27, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v28, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v31 */
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
                    if (bf.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
                        com.baidu.adp.lib.util.commonsio.a.g(file);
                    } else {
                        try {
                            fileInputStream2 = new FileInputStream(file);
                            try {
                                if (z.e(fileInputStream2).equalsIgnoreCase(bdFileDownloadDataArr[0].getCheck())) {
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
                                if (!bf.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
                                }
                                if (bdFileDownloadDataArr[0].getCallback() != null) {
                                }
                                j = this.ahE.j(bdFileDownloadDataArr[0]);
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
                this.AO.setUrl(bdFileDownloadDataArr[0].getUrl());
                ad adVar = this.AO;
                i = this.ahE.i(bdFileDownloadDataArr[0]);
                handler = this.ahE.XM;
                Boolean valueOf = Boolean.valueOf(adVar.a(i, handler, TbConfig.NET_MSG_GETLENTH, 3, 3000, true));
                BdLog.i("pluginFileDownloader download complete " + bdFileDownloadDataArr[0].getId());
                if (!valueOf.booleanValue()) {
                    return 3;
                }
                i2 = this.ahE.i(bdFileDownloadDataArr[0]);
                File file2 = new File(i2);
                if (!file2.exists()) {
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
            if (!bf.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
                try {
                    fileInputStream = new FileInputStream(bdFileDownloadDataArr[0].getPath());
                } catch (FileNotFoundException e9) {
                    e = e9;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                }
                try {
                    if (!z.e(fileInputStream).equalsIgnoreCase(bdFileDownloadDataArr[0].getCheck())) {
                        com.baidu.adp.lib.util.commonsio.a.g(new File(bdFileDownloadDataArr[0].getPath()));
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return 4;
                            } catch (IOException e10) {
                                BdLog.d(e10.getMessage());
                                return 4;
                            }
                        }
                        return 4;
                    } else if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e11) {
                            BdLog.d(e11.getMessage());
                        }
                    }
                } catch (FileNotFoundException e12) {
                    e = e12;
                    fileInputStream3 = fileInputStream;
                    try {
                        BdLog.d(e.getMessage());
                        if (fileInputStream3 != null) {
                            try {
                                fileInputStream3.close();
                                return 6;
                            } catch (IOException e13) {
                                BdLog.d(e13.getMessage());
                                return 6;
                            }
                        }
                        return 6;
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream = fileInputStream3;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e14) {
                                BdLog.d(e14.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            }
            if (bdFileDownloadDataArr[0].getCallback() != null || bdFileDownloadDataArr[0].getCallback().f(bdFileDownloadDataArr[0])) {
                j = this.ahE.j(bdFileDownloadDataArr[0]);
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
        if (num.intValue() == 0) {
            bdFileDownloadData10 = a.ahC;
            if (bdFileDownloadData10.getCallback() != null) {
                bdFileDownloadData15 = a.ahC;
                com.baidu.adp.plugin.packageManager.pluginFileDownload.a callback = bdFileDownloadData15.getCallback();
                bdFileDownloadData16 = a.ahC;
                callback.g(bdFileDownloadData16);
            }
            bdFileDownloadData11 = a.ahC;
            bdFileDownloadData11.setStatus(0);
            bdFileDownloadData12 = a.ahC;
            if (bdFileDownloadData12.getCallback() != null) {
                bdFileDownloadData13 = a.ahC;
                com.baidu.adp.plugin.packageManager.pluginFileDownload.a callback2 = bdFileDownloadData13.getCallback();
                bdFileDownloadData14 = a.ahC;
                callback2.e(bdFileDownloadData14);
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
            bdFileDownloadData = a.ahC;
            bdFileDownloadData.setStatusMsg(string);
            bdFileDownloadData2 = a.ahC;
            bdFileDownloadData2.setErrorCode(num.intValue());
            bdFileDownloadData3 = a.ahC;
            if (bdFileDownloadData3.getCallback() != null) {
                bdFileDownloadData8 = a.ahC;
                com.baidu.adp.plugin.packageManager.pluginFileDownload.a callback3 = bdFileDownloadData8.getCallback();
                bdFileDownloadData9 = a.ahC;
                callback3.a(bdFileDownloadData9, num.intValue(), string, string);
            }
            bdFileDownloadData4 = a.ahC;
            bdFileDownloadData4.setStatus(2);
            bdFileDownloadData5 = a.ahC;
            if (bdFileDownloadData5.getCallback() != null) {
                bdFileDownloadData6 = a.ahC;
                com.baidu.adp.plugin.packageManager.pluginFileDownload.a callback4 = bdFileDownloadData6.getCallback();
                bdFileDownloadData7 = a.ahC;
                callback4.e(bdFileDownloadData7);
            }
        }
        a.ahC = null;
        list = a.XE;
        if (!list.isEmpty()) {
            list2 = a.XE;
            list2.remove(0);
            this.ahE.va();
        }
    }
}
