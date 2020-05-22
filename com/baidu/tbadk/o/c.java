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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.adp.lib.util.BdNetWorkError;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.plugin.packageManager.pluginFileDownload.b {
    private static c etK = new c();
    private static BdFileDownloadData etL = null;
    private static List<BdFileDownloadData> mTaskList = new LinkedList();
    private a etM = null;
    @SuppressLint({"HandlerLeak"})
    private Handler ekE = new Handler() { // from class: com.baidu.tbadk.o.c.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 900002 && message.arg2 > 0 && c.etL != null) {
                c.etL.setLength(message.arg1);
                c.etL.setSize(message.arg2);
                if (c.etL.getCallback() != null) {
                    c.etL.getCallback().e(c.etL);
                }
            }
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            if (message != null && message.what == -1 && (message.obj instanceof b)) {
                if (c.etL != null) {
                    b bVar = (b) message.obj;
                    c.etL.setErrorCode(message.arg1);
                    c.etL.setAfterHttpDnsUrl(bVar.getUrl());
                    c.etL.setStatusMsg(bVar.bfV());
                    return;
                }
                return;
            }
            super.dispatchMessage(message);
        }
    };

    private c() {
    }

    public static c bfW() {
        return etK;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void a(BdFileDownloadData bdFileDownloadData, int i) {
        if (bdFileDownloadData != null) {
            if (!m.checkSD() && i == 2) {
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
                if (bdFileDownloadData2 != null && !aq.isEmpty(bdFileDownloadData2.getUrl()) && bdFileDownloadData2.getUrl().equals(bdFileDownloadData.getUrl()) && bdFileDownloadData2.getId().equals(bdFileDownloadData.getId())) {
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
            if (!m.checkSD() && i == 2) {
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
            if (etL == null || !etL.getUrl().equals(bdFileDownloadData.getUrl()) || !etL.getId().equals(bdFileDownloadData.getId())) {
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
        if (etL == null && !mTaskList.isEmpty()) {
            etL = mTaskList.get(0);
            if (etL != null) {
                this.etM = new a();
                this.etM.execute(etL);
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void cA(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (etL != null && etL.getId().equals(str)) {
                this.etM.cancel(true);
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
        private BdFileDownloadData etQ;
        private long etU;
        private long etV;
        private x bth = new x();
        private long etO = -1;
        private String etP = null;
        private String etR = null;
        private String mPackageName = "";
        private String etS = "";
        private String etT = "";

        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.bth.cancelNetConnect();
            c.etL.setStatus(4);
            c.etL.setStatusMsg(null);
            if (c.etL.getCallback() != null) {
                c.etL.getCallback().e(c.etL);
            }
            if (!c.mTaskList.isEmpty()) {
                c.mTaskList.remove(0);
            }
            BdFileDownloadData unused = c.etL = null;
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
            this.etQ = bdFileDownloadDataArr[0];
            if (bdFileDownloadDataArr[0].getCallback() != null && !bdFileDownloadDataArr[0].getCallback().d(bdFileDownloadDataArr[0])) {
                return 0;
            }
            BdLog.i("pluginFileDownloader beging download " + bdFileDownloadDataArr[0].getId());
            if (bdFileDownloadDataArr[0].getPath() == null || bdFileDownloadDataArr[0].getCheck() == null) {
                return 4;
            }
            this.mPackageName = bdFileDownloadDataArr[0].getId();
            this.bth.setUrl(bdFileDownloadDataArr[0].getUrl());
            this.bth.aj(true);
            File file = new File(bdFileDownloadDataArr[0].getPath());
            if (b(file, bdFileDownloadDataArr[0].getCheck(), null)) {
                return 0;
            }
            if (!file.exists()) {
                long currentTimeMillis = System.currentTimeMillis();
                this.etS = UtilHelper.getIpFromDomain("tb1.bdstatic.com");
                int a = a(bdFileDownloadDataArr[0], null);
                if (a == 6 || a == 7) {
                    a = a(bdFileDownloadDataArr[0], null);
                }
                this.etU = System.currentTimeMillis() - currentTimeMillis;
                if (a != 0) {
                    return Integer.valueOf(a);
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
            if (this.bth.downloadFile(c.this.i(bdFileDownloadData), c.this.ekE, 900002, 3, 3000, true)) {
                if (c(file2, file, bArr)) {
                    if (b(file, bdFileDownloadData.getCheck(), bArr)) {
                        return 0;
                    }
                    return 6;
                }
                return 8;
            } else if (this.bth.aUA().aVb().mNetErrorCode == 416) {
                if (b(file2, bdFileDownloadData.getCheck(), null)) {
                    if (c(file2, file, bArr)) {
                        if (b(file, bdFileDownloadData.getCheck(), bArr)) {
                            return 0;
                        }
                        return 6;
                    }
                    return 8;
                }
                return 7;
            } else {
                this.etV = file2.length();
                this.downloadSize = file2.length() - length;
                return bfY();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [482=5, 484=4, 485=4, 486=4] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean b(File file, String str, byte[] bArr) {
            FileInputStream fileInputStream;
            boolean z = false;
            if (file.exists() && file.length() > 0) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        try {
                            String a = Util.a(fileInputStream, bArr);
                            if (a.equalsIgnoreCase(str)) {
                                z = true;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e) {
                                        BdLog.d(e.getMessage());
                                    }
                                }
                            } else {
                                this.etO = file.length();
                                this.etP = a;
                                f.deleteQuietly(file);
                                this.etR = com.baidu.tbadk.o.a.L(file);
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
                    com.baidu.adp.plugin.b.a.nH().i("retry_rename_tmp", this.mPackageName, 0 != 0 ? "true" : "false", e.toString());
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
                        this.etT = "avirom_" + Util.oL() + "-filesize_0-exception_" + e.toString() + "-exception1_" + e2.toString();
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
                this.etT = "temp_exists";
                f.deleteQuietly(file);
            }
            return false;
        }

        private int bfY() {
            if (j.isNetWorkAvailable()) {
                if (c.etL == null) {
                    return 2;
                }
                switch (c.etL.getErrorCode()) {
                    case -100:
                        return CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL;
                    case BdNetWorkError.NETWORK_CONNECT_EXCEPTION /* -22 */:
                        return 3009;
                    case BdNetWorkError.NETWORK_UNKNOWN_HOST_EXCEPTION /* -21 */:
                        return 3008;
                    case BdNetWorkError.NETWORK_SSL_EXCEPTION /* -20 */:
                        return 3007;
                    case -19:
                        return CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL;
                    case -15:
                        return 3005;
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
            return 3006;
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
                if (c.etL.getCallback() != null) {
                    c.etL.getCallback().g(c.etL);
                }
                c.etL.setStatus(0);
                if (c.etL.getCallback() != null) {
                    c.etL.getCallback().e(c.etL);
                }
            } else {
                i(num);
            }
            BdFileDownloadData unused = c.etL = null;
            if (!c.mTaskList.isEmpty()) {
                c.mTaskList.remove(0);
                c.this.startQueue();
            }
        }

        private void i(Integer num) {
            String string;
            String statusMsg = c.etL.getStatusMsg();
            switch (num.intValue()) {
                case 2:
                case 3006:
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
                case CyberPlayerManager.MEDIA_INFO_RTMP_HANDSHAKE_FAIL /* 3003 */:
                case CyberPlayerManager.MEDIA_INFO_RTMP_IO_FAIL /* 3004 */:
                case 3005:
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
                statusMsg = statusMsg + "_err-" + this.etT;
            }
            if (num.intValue() == 6 || num.intValue() == 7) {
                statusMsg = "_downloadfilesize-" + this.etO + " downloadfileMd5-" + this.etP + " wishMd5-" + (this.etQ == null ? "" : this.etQ.getCheck()) + "-url_" + c.etL.getUrl() + "-realurl_" + c.etL.getAfterHttpDnsUrl() + "-uploadResult_" + this.etR + "-Proxy_" + com.baidu.tbadk.o.a.dX(TbadkCoreApplication.getInst()) + "-UsbDebug_" + (com.baidu.tbadk.o.a.bfU() ? "true" : "false") + "-errorMsg_" + statusMsg;
            }
            if (statusMsg != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("-netType_");
                sb.append(j.netTypeNameInLowerCase());
                sb.append("-cost_");
                sb.append(this.etU);
                sb.append("-downloadSize_");
                sb.append(this.downloadSize);
                sb.append("-tempSize_");
                sb.append(this.etV);
                sb.append("-clientIp_");
                sb.append(com.baidu.tbadk.core.util.d.getIp());
                sb.append("-cdnIp_");
                sb.append(this.etS);
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
            c.etL.setStatusMsg(string);
            c.etL.setErrorCode(num.intValue());
            if (c.etL.getCallback() != null) {
                c.etL.getCallback().a(c.etL, num.intValue(), string, statusMsg);
            }
            c.etL.setStatus(2);
            if (c.etL.getCallback() != null) {
                c.etL.getCallback().e(c.etL);
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
