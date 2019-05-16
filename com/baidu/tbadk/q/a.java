package com.baidu.tbadk.q;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.s;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.ap;
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
public class a extends com.baidu.adp.plugin.packageManager.pluginFileDownload.b {
    private static a cAd = new a();
    private static BdFileDownloadData cAe = null;
    private static List<BdFileDownloadData> mTaskList = new LinkedList();
    private C0257a cAf = null;
    @SuppressLint({"HandlerLeak"})
    private Handler cqm = new Handler() { // from class: com.baidu.tbadk.q.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 900002 && message.arg2 > 0 && a.cAe != null) {
                a.cAe.setLength(message.arg1);
                a.cAe.setSize(message.arg2);
                if (a.cAe.getCallback() != null) {
                    a.cAe.getCallback().e(a.cAe);
                }
            }
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            if (message != null && message.what == -1 && (message.obj instanceof String)) {
                if (a.cAe != null) {
                    a.cAe.setErrorCode(message.arg1);
                    a.cAe.setStatusMsg((String) message.obj);
                    return;
                }
                return;
            }
            super.dispatchMessage(message);
        }
    };

    private a() {
    }

    public static a auy() {
        return cAd;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void a(BdFileDownloadData bdFileDownloadData, int i) {
        if (bdFileDownloadData != null) {
            if (!m.gs() && i == 2) {
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
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < mTaskList.size()) {
                    BdFileDownloadData bdFileDownloadData2 = mTaskList.get(i3);
                    if (bdFileDownloadData2 == null || ap.isEmpty(bdFileDownloadData2.getUrl()) || !bdFileDownloadData2.getUrl().equals(bdFileDownloadData.getUrl()) || !bdFileDownloadData2.getId().equals(bdFileDownloadData.getId())) {
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                } else {
                    bdFileDownloadData.setStatus(1);
                    mTaskList.add(bdFileDownloadData);
                    aqN();
                    return;
                }
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void b(BdFileDownloadData bdFileDownloadData, int i) {
        if (bdFileDownloadData != null) {
            if (!m.gs() && i == 2) {
                bdFileDownloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_no_sd));
                bdFileDownloadData.setStatus(2);
            }
            if (bdFileDownloadData.getStatus() == 2) {
                if (bdFileDownloadData.getCallback() != null) {
                    bdFileDownloadData.getCallback().e(bdFileDownloadData);
                }
            } else if (cAe == null || !cAe.getUrl().equals(bdFileDownloadData.getUrl()) || !cAe.getId().equals(bdFileDownloadData.getId())) {
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
                aqN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqN() {
        if (cAe == null && !mTaskList.isEmpty()) {
            cAe = mTaskList.get(0);
            if (cAe != null) {
                this.cAf = new C0257a();
                this.cAf.execute(cAe);
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void bN(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (cAe != null && cAe.getId().equals(str)) {
                this.cAf.cancel(true);
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
    public List<BdFileDownloadData> mx() {
        return mTaskList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"DefaultLocale"})
    /* renamed from: com.baidu.tbadk.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0257a extends BdAsyncTask<BdFileDownloadData, BdFileDownloadData, Integer> {
        private BdFileDownloadData cAj;
        private x mNetWork = new x();
        private long cAh = -1;
        private String cAi = null;

        C0257a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.mNetWork.ia();
            a.cAe.setStatus(4);
            a.cAe.setStatusMsg(null);
            if (a.cAe.getCallback() != null) {
                a.cAe.getCallback().e(a.cAe);
            }
            if (!a.mTaskList.isEmpty()) {
                a.mTaskList.remove(0);
            }
            BdFileDownloadData unused = a.cAe = null;
            a.this.aqN();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [450=5, 452=4, 453=4, 454=4, 361=5, 363=4, 364=4, 365=4] */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:126:0x0292 */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:118:0x027e  */
        /* JADX WARN: Removed duplicated region for block: B:119:0x0284  */
        /* JADX WARN: Removed duplicated region for block: B:140:0x0267 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:154:0x012f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00b5  */
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
            FileInputStream fileInputStream2;
            int i = 3;
            FileInputStream fileInputStream3 = null;
            Boolean.valueOf(false);
            if (bdFileDownloadDataArr[0] == null) {
                return null;
            }
            this.cAj = bdFileDownloadDataArr[0];
            if (bdFileDownloadDataArr[0].getCallback() == null || bdFileDownloadDataArr[0].getCallback().d(bdFileDownloadDataArr[0])) {
                BdLog.i("pluginFileDownloader beging download " + bdFileDownloadDataArr[0].getId());
                if (bdFileDownloadDataArr[0].getPath() == null) {
                    return 1;
                }
                File file = new File(bdFileDownloadDataArr[0].getPath());
                if (file.exists()) {
                    StringBuilder append = new StringBuilder().append("pluginFileDownloader has exsit ");
                    ?? id = bdFileDownloadDataArr[0].getId();
                    BdLog.i(append.append((String) id).toString());
                    try {
                        if (ap.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
                            f.j(file);
                        } else {
                            try {
                                fileInputStream2 = new FileInputStream(file);
                                try {
                                    if (s.h(fileInputStream2).equalsIgnoreCase(bdFileDownloadDataArr[0].getCheck())) {
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
                                    f.j(file);
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
                                    if (!ap.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
                                    }
                                    if (bdFileDownloadDataArr[0].getCallback() != null) {
                                    }
                                    if (a.this.j(bdFileDownloadDataArr[0])) {
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
                    this.mNetWork.setUrl(bdFileDownloadDataArr[0].getUrl());
                    Boolean valueOf = Boolean.valueOf(this.mNetWork.a(a.this.i(bdFileDownloadDataArr[0]), a.this.cqm, TbConfig.NET_MSG_GETLENTH, 3, 3000, true));
                    BdLog.i("pluginFileDownloader download complete " + bdFileDownloadDataArr[0].getId());
                    if (!valueOf.booleanValue()) {
                        if (!j.jS()) {
                            i = 3006;
                        } else if (a.cAe != null) {
                            switch (a.cAe.getErrorCode()) {
                                case SapiErrorCode.ERROR_UNKNOWN /* -100 */:
                                    i = 3003;
                                    break;
                                case TbErrInfo.ERR_SQLITE_DONE /* -19 */:
                                    i = 3004;
                                    break;
                                case -15:
                                    i = 3005;
                                    break;
                                case -14:
                                    i = 3000;
                                    break;
                                case -13:
                                    i = 3002;
                                    break;
                                case -12:
                                    i = 3001;
                                    break;
                            }
                        }
                        return Integer.valueOf(i);
                    }
                    File file2 = new File(a.this.i(bdFileDownloadDataArr[0]));
                    if (!file2.exists() || file2.length() <= 0) {
                        if (file2.exists()) {
                            f.j(file2);
                        }
                        return 1;
                    }
                    try {
                        f.c(file2, file);
                        f.j(file2);
                    } catch (IOException e7) {
                        try {
                            f.j(file);
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                        return 7;
                    }
                }
                if (!ap.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(bdFileDownloadDataArr[0].getPath());
                    } catch (FileNotFoundException e9) {
                        e = e9;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = null;
                    }
                    try {
                        String h = s.h(fileInputStream);
                        if (!h.equalsIgnoreCase(bdFileDownloadDataArr[0].getCheck())) {
                            File file3 = new File(bdFileDownloadDataArr[0].getPath());
                            this.cAh = file3.length();
                            this.cAi = h;
                            f.j(file3);
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
                    return a.this.j(bdFileDownloadDataArr[0]) ? 6 : 0;
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
            super.onPostExecute((C0257a) num);
            if (num == null) {
                num = -1;
            }
            if (num.intValue() == 0) {
                if (a.cAe.getCallback() != null) {
                    a.cAe.getCallback().g(a.cAe);
                }
                a.cAe.setStatus(0);
                if (a.cAe.getCallback() != null) {
                    a.cAe.getCallback().e(a.cAe);
                }
            } else {
                String statusMsg = a.cAe.getStatusMsg();
                switch (num.intValue()) {
                    case 1:
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                        break;
                    case 2:
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                        break;
                    case 3:
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_net);
                        break;
                    case 4:
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                        break;
                    case 6:
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                        break;
                    case 7:
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                        break;
                    case 3000:
                    case 3001:
                    case 3002:
                    case 3003:
                    case 3004:
                    case 3005:
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_net);
                        break;
                    case 3006:
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_net);
                        break;
                    default:
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.tb_err_unknown);
                        break;
                }
                if (statusMsg == null) {
                    statusMsg = string;
                }
                if (num.intValue() == 4) {
                    statusMsg = "downloadfilesize-" + this.cAh + " downloadfileMd5-" + this.cAi + " wishMd5-" + (this.cAj == null ? "" : this.cAj.getCheck()) + " " + statusMsg;
                }
                a.cAe.setStatusMsg(string);
                a.cAe.setErrorCode(num.intValue());
                if (a.cAe.getCallback() != null) {
                    a.cAe.getCallback().a(a.cAe, num.intValue(), string, statusMsg);
                }
                a.cAe.setStatus(2);
                if (a.cAe.getCallback() != null) {
                    a.cAe.getCallback().e(a.cAe);
                }
            }
            BdFileDownloadData unused = a.cAe = null;
            if (!a.mTaskList.isEmpty()) {
                a.mTaskList.remove(0);
                a.this.aqN();
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
