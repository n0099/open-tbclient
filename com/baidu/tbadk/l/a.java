package com.baidu.tbadk.l;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.s;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.plugin.packageManager.pluginFileDownload.b {
    private static a aLK = new a();
    private static BdFileDownloadData aLL = null;
    private static List<BdFileDownloadData> mTaskList = new LinkedList();
    private C0076a aLM = null;
    @SuppressLint({"HandlerLeak"})
    private Handler aBw = new Handler() { // from class: com.baidu.tbadk.l.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 900002 && message.arg2 > 0 && a.aLL != null) {
                a.aLL.setLength(message.arg1);
                a.aLL.setSize(message.arg2);
                if (a.aLL.getCallback() != null) {
                    a.aLL.getCallback().e(a.aLL);
                }
            }
        }
    };

    private a() {
    }

    public static a GM() {
        return aLK;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void a(BdFileDownloadData bdFileDownloadData, int i) {
        if (bdFileDownloadData != null) {
            if (!k.dG() && i == 2) {
                bdFileDownloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail_no_sd));
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
                    if (bdFileDownloadData2 == null || !bdFileDownloadData2.getUrl().equals(bdFileDownloadData.getUrl()) || !bdFileDownloadData2.getId().equals(bdFileDownloadData.getId())) {
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                } else {
                    bdFileDownloadData.setStatus(1);
                    mTaskList.add(bdFileDownloadData);
                    CX();
                    return;
                }
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void b(BdFileDownloadData bdFileDownloadData, int i) {
        if (bdFileDownloadData != null) {
            if (!k.dG() && i == 2) {
                bdFileDownloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail_no_sd));
                bdFileDownloadData.setStatus(2);
            }
            if (bdFileDownloadData.getStatus() == 2) {
                if (bdFileDownloadData.getCallback() != null) {
                    bdFileDownloadData.getCallback().e(bdFileDownloadData);
                }
            } else if (aLL == null || !aLL.getUrl().equals(bdFileDownloadData.getUrl()) || !aLL.getId().equals(bdFileDownloadData.getId())) {
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
                CX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CX() {
        if (aLL == null && !mTaskList.isEmpty()) {
            aLL = mTaskList.get(0);
            if (aLL != null) {
                this.aLM = new C0076a();
                this.aLM.execute(aLL);
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void bt(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (aLL != null && aLL.getId().equals(str)) {
                this.aLM.cancel(true);
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
    public List<BdFileDownloadData> jL() {
        return mTaskList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"DefaultLocale"})
    /* renamed from: com.baidu.tbadk.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0076a extends BdAsyncTask<BdFileDownloadData, BdFileDownloadData, Integer> {
        private BdFileDownloadData aLQ;
        private x mNetWork = new x();
        private long aLO = -1;
        private String aLP = null;

        C0076a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.mNetWork.fo();
            a.aLL.setStatus(4);
            a.aLL.setStatusMsg(null);
            if (a.aLL.getCallback() != null) {
                a.aLL.getCallback().e(a.aLL);
            }
            if (!a.mTaskList.isEmpty()) {
                a.mTaskList.remove(0);
            }
            BdFileDownloadData unused = a.aLL = null;
            a.this.CX();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [407=5, 409=4, 410=4, 411=4, 346=5, 348=4, 349=4, 350=4] */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:112:0x0266 */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:104:0x0252  */
        /* JADX WARN: Removed duplicated region for block: B:105:0x0258  */
        /* JADX WARN: Removed duplicated region for block: B:136:0x023b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:142:0x012f A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
            FileInputStream fileInputStream3 = null;
            Boolean.valueOf(false);
            if (bdFileDownloadDataArr[0] == null) {
                return null;
            }
            this.aLQ = bdFileDownloadDataArr[0];
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
                        if (am.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
                            f.h(file);
                        } else {
                            try {
                                fileInputStream2 = new FileInputStream(file);
                                try {
                                    if (s.e(fileInputStream2).equalsIgnoreCase(bdFileDownloadDataArr[0].getCheck())) {
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
                                    f.h(file);
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
                                    if (!am.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
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
                    Boolean valueOf = Boolean.valueOf(this.mNetWork.a(a.this.i(bdFileDownloadDataArr[0]), a.this.aBw, TbConfig.NET_MSG_GETLENTH, 3, 3000, true));
                    BdLog.i("pluginFileDownloader download complete " + bdFileDownloadDataArr[0].getId());
                    if (!valueOf.booleanValue()) {
                        return 3;
                    }
                    File file2 = new File(a.this.i(bdFileDownloadDataArr[0]));
                    if (!file2.exists() || file2.length() <= 0) {
                        if (file2.exists()) {
                            f.h(file2);
                        }
                        return 1;
                    }
                    try {
                        f.b(file2, file);
                        f.h(file2);
                    } catch (IOException e7) {
                        try {
                            f.h(file);
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                        return 7;
                    }
                }
                if (!am.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(bdFileDownloadDataArr[0].getPath());
                        try {
                            String e9 = s.e(fileInputStream);
                            if (!e9.equalsIgnoreCase(bdFileDownloadDataArr[0].getCheck())) {
                                File file3 = new File(bdFileDownloadDataArr[0].getPath());
                                this.aLO = file3.length();
                                this.aLP = e9;
                                f.h(file3);
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
                            } catch (Throwable th3) {
                                th = th3;
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
                        } catch (Throwable th4) {
                            th = th4;
                            if (fileInputStream != null) {
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e15) {
                        e = e15;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = null;
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
            String str;
            super.onPostExecute((C0076a) num);
            if (num == null) {
                num = -1;
            }
            if (num.intValue() == 0) {
                if (a.aLL.getCallback() != null) {
                    a.aLL.getCallback().g(a.aLL);
                }
                a.aLL.setStatus(0);
                if (a.aLL.getCallback() != null) {
                    a.aLL.getCallback().e(a.aLL);
                }
            } else {
                switch (num.intValue()) {
                    case 1:
                        string = TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail);
                        break;
                    case 2:
                        string = TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail);
                        break;
                    case 3:
                        string = TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail_net);
                        break;
                    case 4:
                        string = TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail);
                        break;
                    case 5:
                    default:
                        string = TbadkCoreApplication.getInst().getApp().getString(d.j.tb_err_unknown);
                        break;
                    case 6:
                        string = TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail);
                        break;
                    case 7:
                        string = TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail);
                        break;
                }
                if (num.intValue() == 4) {
                    str = "downloadfilesize-" + this.aLO + " downloadfileMd5-" + this.aLP + " wishMd5-" + (this.aLQ == null ? "" : this.aLQ.getCheck()) + " " + string;
                } else {
                    str = string;
                }
                a.aLL.setStatusMsg(string);
                a.aLL.setErrorCode(num.intValue());
                if (a.aLL.getCallback() != null) {
                    a.aLL.getCallback().a(a.aLL, num.intValue(), string, str);
                }
                a.aLL.setStatus(2);
                if (a.aLL.getCallback() != null) {
                    a.aLL.getCallback().e(a.aLL);
                }
            }
            BdFileDownloadData unused = a.aLL = null;
            if (!a.mTaskList.isEmpty()) {
                a.mTaskList.remove(0);
                a.this.CX();
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
