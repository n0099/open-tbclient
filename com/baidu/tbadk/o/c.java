package com.baidu.tbadk.o;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.util.Util;
import com.baidu.live.adp.lib.util.BdNetWorkError;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.R;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.plugin.packageManager.pluginFileDownload.b {
    private static c fIV = new c();
    private static BdFileDownloadData fIW = null;
    private static List<BdFileDownloadData> mTaskList = new LinkedList();
    private a fIX = null;
    @SuppressLint({"HandlerLeak"})
    private Handler fyI = new Handler() { // from class: com.baidu.tbadk.o.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 900002 && message.arg2 > 0 && c.fIW != null) {
                c.fIW.setLength(message.arg1);
                c.fIW.setSize(message.arg2);
                if (c.fIW.getCallback() != null) {
                    c.fIW.getCallback().e(c.fIW);
                }
            }
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            if (message != null && message.what == -1 && (message.obj instanceof b)) {
                if (c.fIW != null) {
                    b bVar = (b) message.obj;
                    c.fIW.setErrorCode(message.arg1);
                    c.fIW.setAfterHttpDnsUrl(bVar.getUrl());
                    c.fIW.setStatusMsg(bVar.bEf());
                    return;
                }
                return;
            }
            super.dispatchMessage(message);
        }
    };

    private c() {
    }

    public static c bEg() {
        return fIV;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void a(BdFileDownloadData bdFileDownloadData, int i) {
        if (bdFileDownloadData != null) {
            if (!n.checkSD() && i == 2) {
                bdFileDownloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_no_sd));
                bdFileDownloadData.setStatus(2);
            }
            if (bdFileDownloadData.getStatus() == 2) {
                if (bdFileDownloadData.getCallback() != null) {
                    bdFileDownloadData.getCallback().e(bdFileDownloadData);
                    return;
                }
                return;
            }
            BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), "plugin_start_download", null, 1, "pname", bdFileDownloadData.getId(), "appver", BdStatisticsManager.getInstance().getAppVersion(), "comment", "downloadByAuto-isBackgrount_" + TbadkCoreApplication.getInst().isInBackground(), "pid", Integer.valueOf(Process.myPid()));
            for (int i2 = 0; i2 < mTaskList.size(); i2++) {
                BdFileDownloadData bdFileDownloadData2 = mTaskList.get(i2);
                if (bdFileDownloadData2 != null && !at.isEmpty(bdFileDownloadData2.getUrl()) && bdFileDownloadData2.getUrl().equals(bdFileDownloadData.getUrl()) && bdFileDownloadData2.getId().equals(bdFileDownloadData.getId())) {
                    return;
                }
            }
            bdFileDownloadData.setStatus(1);
            mTaskList.add(bdFileDownloadData);
            startQueue();
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void b(BdFileDownloadData bdFileDownloadData, int i) {
        if (bdFileDownloadData != null) {
            if (!n.checkSD() && i == 2) {
                bdFileDownloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_no_sd));
                bdFileDownloadData.setStatus(2);
            }
            if (bdFileDownloadData.getStatus() == 2) {
                if (bdFileDownloadData.getCallback() != null) {
                    bdFileDownloadData.getCallback().e(bdFileDownloadData);
                    return;
                }
                return;
            }
            BdStatisticsManager.getInstance().eventStat(BdBaseApplication.getInst(), "plugin_start_download", null, 1, "pname", bdFileDownloadData.getId(), "appver", BdStatisticsManager.getInstance().getAppVersion(), "comment", "downloadByUser-isBackgrount_" + TbadkCoreApplication.getInst().isInBackground(), "pid", Integer.valueOf(Process.myPid()));
            if (fIW == null || !fIW.getUrl().equals(bdFileDownloadData.getUrl()) || !fIW.getId().equals(bdFileDownloadData.getId())) {
                for (int i2 = 0; i2 < mTaskList.size(); i2++) {
                    BdFileDownloadData bdFileDownloadData2 = mTaskList.get(i2);
                    if (bdFileDownloadData2 != null && bdFileDownloadData2.getUrl().equals(bdFileDownloadData.getUrl()) && bdFileDownloadData2.getId().equals(bdFileDownloadData.getId())) {
                        mTaskList.remove(i2);
                        mTaskList.add(0, bdFileDownloadData2);
                        return;
                    }
                }
                bdFileDownloadData.setStatus(1);
                mTaskList.add(0, bdFileDownloadData);
                startQueue();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startQueue() {
        if (fIW == null && !mTaskList.isEmpty()) {
            fIW = mTaskList.get(0);
            if (fIW != null) {
                this.fIX = new a();
                this.fIX.execute(fIW);
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void cF(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (fIW != null && fIW.getId().equals(str)) {
                this.fIX.cancel(true);
                return;
            }
            LinkedList<BdFileDownloadData> linkedList = new LinkedList();
            Iterator<BdFileDownloadData> it = mTaskList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BdFileDownloadData next = it.next();
                if (next.getId().equals(str)) {
                    next.setStatus(4);
                    next.setStatusMsg(null);
                    if (next.getCallback() != null) {
                        next.getCallback().e(next);
                    }
                    linkedList.add(next);
                }
            }
            for (BdFileDownloadData bdFileDownloadData : linkedList) {
                mTaskList.remove(bdFileDownloadData);
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public List<BdFileDownloadData> getDownloadList() {
        return mTaskList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"DefaultLocale"})
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<BdFileDownloadData, BdFileDownloadData, Integer> {
        private long downloadSize;
        private BdFileDownloadData fJb;
        private long fJf;
        private long fJg;
        private z chV = new z();
        private long fIZ = -1;
        private String fJa = null;
        private String fJc = null;
        private String mPackageName = "";
        private String fJd = "";
        private String fJe = "";

        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.chV.cancelNetConnect();
            c.fIW.setStatus(4);
            c.fIW.setStatusMsg(null);
            if (c.fIW.getCallback() != null) {
                c.fIW.getCallback().e(c.fIW);
            }
            if (!c.mTaskList.isEmpty()) {
                c.mTaskList.remove(0);
            }
            BdFileDownloadData unused = c.fIW = null;
            c.this.startQueue();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Integer doInBackground(BdFileDownloadData... bdFileDownloadDataArr) {
            if (bdFileDownloadDataArr[0] == null) {
                return 3;
            }
            this.fJb = bdFileDownloadDataArr[0];
            if (bdFileDownloadDataArr[0].getCallback() != null && !bdFileDownloadDataArr[0].getCallback().d(bdFileDownloadDataArr[0])) {
                return 0;
            }
            BdLog.i("pluginFileDownloader beging download " + bdFileDownloadDataArr[0].getId());
            if (bdFileDownloadDataArr[0].getPath() == null || bdFileDownloadDataArr[0].getCheck() == null) {
                return 4;
            }
            this.mPackageName = bdFileDownloadDataArr[0].getId();
            this.chV.setUrl(bdFileDownloadDataArr[0].getUrl());
            this.chV.ah(true);
            File file = new File(bdFileDownloadDataArr[0].getPath());
            if (c(file, bdFileDownloadDataArr[0].getCheck(), (byte[]) null)) {
                return 0;
            }
            if (!file.exists()) {
                long currentTimeMillis = System.currentTimeMillis();
                this.fJd = UtilHelper.getIpFromDomain("tb1.bdstatic.com");
                int a2 = a(bdFileDownloadDataArr[0], null);
                if (a2 == 6 || a2 == 7) {
                    a2 = a(bdFileDownloadDataArr[0], null);
                }
                this.fJf = System.currentTimeMillis() - currentTimeMillis;
                if (a2 != 0) {
                    return Integer.valueOf(a2);
                }
            }
            if (bdFileDownloadDataArr[0].getCallback() == null || bdFileDownloadDataArr[0].getCallback().f(bdFileDownloadDataArr[0])) {
                if (!c.this.j(bdFileDownloadDataArr[0])) {
                    return 9;
                }
                return 0;
            }
            return 5;
        }

        private int a(BdFileDownloadData bdFileDownloadData, byte[] bArr) {
            BdLog.i("pluginFileDownloader downloadPlugin " + bdFileDownloadData.getPath());
            File file = new File(bdFileDownloadData.getPath());
            File file2 = new File(c.this.i(bdFileDownloadData));
            long length = file2.length();
            if (this.chV.downloadFile(c.this.i(bdFileDownloadData), c.this.fyI, 900002, 3, 3000, true)) {
                if (c(file2, file, bArr)) {
                    if (c(file, bdFileDownloadData.getCheck(), bArr)) {
                        return 0;
                    }
                    return 6;
                }
                return 8;
            } else if (this.chV.brX().bsH().mNetErrorCode == 416) {
                if (c(file2, bdFileDownloadData.getCheck(), (byte[]) null)) {
                    if (c(file2, file, bArr)) {
                        if (c(file, bdFileDownloadData.getCheck(), bArr)) {
                            return 0;
                        }
                        return 6;
                    }
                    return 8;
                }
                return 7;
            } else {
                this.fJg = file2.length();
                this.downloadSize = file2.length() - length;
                return bEi();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [482=5, 484=4, 485=4, 486=4] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean c(File file, String str, byte[] bArr) {
            FileInputStream fileInputStream;
            boolean z = false;
            if (file.exists() && file.length() > 0) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        try {
                            String b2 = Util.b(fileInputStream, bArr);
                            if (b2.equalsIgnoreCase(str)) {
                                z = true;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e) {
                                        BdLog.d(e.getMessage());
                                    }
                                }
                            } else {
                                this.fIZ = file.length();
                                this.fJa = b2;
                                f.deleteQuietly(file);
                                this.fJc = com.baidu.tbadk.o.a.U(file);
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e2) {
                                        BdLog.d(e2.getMessage());
                                    }
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            BdLog.d(e.getMessage());
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e4) {
                                    BdLog.d(e4.getMessage());
                                }
                            }
                            return z;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                BdLog.d(e5.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    e = e6;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            }
            return z;
        }

        private boolean c(File file, File file2, byte[] bArr) {
            if (file.exists() && file.length() > 0) {
                try {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    file.length();
                } catch (Exception e) {
                    com.baidu.adp.plugin.b.a.pg().i("retry_rename_tmp", this.mPackageName, 0 != 0 ? "true" : "false", e.toString());
                    try {
                        if (0 != 0) {
                            file.delete();
                        } else {
                            if (file2.exists()) {
                                file2.delete();
                            }
                            if (!com.baidu.tbadk.o.a.b(file, file2, bArr)) {
                                throw new Exception("rename return fail");
                            }
                            if (!file2.exists() || file2.length() == 0) {
                                throw new Exception("rename fail");
                            }
                            file.delete();
                        }
                    } catch (Exception e2) {
                        f.deleteQuietly(file2);
                        this.fJe = "avirom_" + Util.qk() + "-filesize_0-exception_" + e.toString() + "-exception1_" + e2.toString();
                        return false;
                    }
                }
                if (!com.baidu.tbadk.o.a.b(file, file2, bArr)) {
                    throw new Exception("rename return fail");
                }
                if (!file2.exists() || file2.length() == 0) {
                    throw new Exception("rename fail");
                }
                file.delete();
                return true;
            }
            if (file.exists()) {
                this.fJe = "temp_exists";
                f.deleteQuietly(file);
            }
            return false;
        }

        private int bEi() {
            if (j.isNetWorkAvailable()) {
                if (c.fIW == null) {
                    return 2;
                }
                switch (c.fIW.getErrorCode()) {
                    case -100:
                        return 3003;
                    case BdNetWorkError.NETWORK_CONNECT_EXCEPTION /* -22 */:
                        return 3009;
                    case BdNetWorkError.NETWORK_UNKNOWN_HOST_EXCEPTION /* -21 */:
                        return 3008;
                    case BdNetWorkError.NETWORK_SSL_EXCEPTION /* -20 */:
                        return 3007;
                    case -19:
                        return 3004;
                    case -15:
                        return PluginError.ERROR_INS_CAPACITY;
                    case -14:
                        return 3000;
                    case -13:
                        return 3002;
                    case -12:
                        return 3001;
                    default:
                        return 2;
                }
            }
            return PluginError.ERROR_INS_INSTALL_PATH;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            super.onPostExecute((a) num);
            if (num == null) {
                num = -1;
            }
            if (num.intValue() == 0) {
                if (c.fIW.getCallback() != null) {
                    c.fIW.getCallback().g(c.fIW);
                }
                c.fIW.setStatus(0);
                if (c.fIW.getCallback() != null) {
                    c.fIW.getCallback().e(c.fIW);
                }
            } else {
                n(num);
            }
            BdFileDownloadData unused = c.fIW = null;
            if (!c.mTaskList.isEmpty()) {
                c.mTaskList.remove(0);
                c.this.startQueue();
            }
        }

        private void n(Integer num) {
            String string;
            String statusMsg = c.fIW.getStatusMsg();
            switch (num.intValue()) {
                case 2:
                case PluginError.ERROR_INS_INSTALL_PATH /* 3006 */:
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_net);
                    break;
                case 3:
                case 4:
                case 5:
                case 8:
                case 9:
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    break;
                case 3000:
                case 3001:
                case 3002:
                case 3003:
                case 3004:
                case PluginError.ERROR_INS_CAPACITY /* 3005 */:
                case 3007:
                case 3008:
                case 3009:
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_net);
                    break;
                default:
                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.tb_err_unknown);
                    break;
            }
            if (statusMsg == null) {
                statusMsg = string;
            }
            if (num.intValue() == 8) {
                statusMsg = statusMsg + "_err-" + this.fJe;
            }
            if (num.intValue() == 6 || num.intValue() == 7) {
                statusMsg = "_downloadfilesize-" + this.fIZ + " downloadfileMd5-" + this.fJa + " wishMd5-" + (this.fJb == null ? "" : this.fJb.getCheck()) + "-url_" + c.fIW.getUrl() + "-realurl_" + c.fIW.getAfterHttpDnsUrl() + "-uploadResult_" + this.fJc + "-Proxy_" + com.baidu.tbadk.o.a.fv(TbadkCoreApplication.getInst()) + "-UsbDebug_" + (com.baidu.tbadk.o.a.bEe() ? "true" : "false") + "-errorMsg_" + statusMsg;
            }
            if (statusMsg != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("-netType_");
                sb.append(j.netTypeNameInLowerCase());
                sb.append("-cost_");
                sb.append(this.fJf);
                sb.append("-downloadSize_");
                sb.append(this.downloadSize);
                sb.append("-tempSize_");
                sb.append(this.fJg);
                sb.append("-clientIp_");
                sb.append(com.baidu.tbadk.core.util.d.getIp());
                sb.append("-cdnIp_");
                sb.append(this.fJd);
                sb.append("-NetChangeTime_");
                sb.append(j.getNetChangedTime());
                sb.append("-syncTime_");
                sb.append(TbadkCoreApplication.getInst().getLastSyncFinishTime());
                if (TbadkCoreApplication.getInst().isInBackground()) {
                    sb.append("|Background:true");
                } else {
                    sb.append("|Background:false|TopActivity:");
                    sb.append(UtilHelper.getTopActivityClassName());
                }
                statusMsg = statusMsg + sb.toString();
            }
            c.fIW.setStatusMsg(string);
            c.fIW.setErrorCode(num.intValue());
            if (c.fIW.getCallback() != null) {
                c.fIW.getCallback().a(c.fIW, num.intValue(), string, statusMsg);
            }
            c.fIW.setStatus(2);
            if (c.fIW.getCallback() != null) {
                c.fIW.getCallback().e(c.fIW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i(BdFileDownloadData bdFileDownloadData) {
        if (bdFileDownloadData == null) {
            return null;
        }
        return bdFileDownloadData.getPath() + ".tmp";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(BdFileDownloadData bdFileDownloadData) {
        File file;
        if (bdFileDownloadData == null) {
            return false;
        }
        String path = bdFileDownloadData.getPath();
        return (TextUtils.isEmpty(path) || (file = new File(path)) == null || !file.exists()) ? false : true;
    }
}
