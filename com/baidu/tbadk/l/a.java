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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.y;
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
    private static a aUl = new a();
    private static BdFileDownloadData aUm = null;
    private static List<BdFileDownloadData> mTaskList = new LinkedList();
    private C0118a aUn = null;
    @SuppressLint({"HandlerLeak"})
    private Handler aKO = new Handler() { // from class: com.baidu.tbadk.l.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 900002 && message.arg2 > 0 && a.aUm != null) {
                a.aUm.setLength(message.arg1);
                a.aUm.setSize(message.arg2);
                if (a.aUm.getCallback() != null) {
                    a.aUm.getCallback().e(a.aUm);
                }
            }
        }
    };

    private a() {
    }

    public static a KC() {
        return aUl;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void a(BdFileDownloadData bdFileDownloadData, int i) {
        if (bdFileDownloadData != null) {
            if (!l.ge() && i == 2) {
                bdFileDownloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.k.download_fail_no_sd));
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
                    Ha();
                    return;
                }
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void b(BdFileDownloadData bdFileDownloadData, int i) {
        if (bdFileDownloadData != null) {
            if (!l.ge() && i == 2) {
                bdFileDownloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.k.download_fail_no_sd));
                bdFileDownloadData.setStatus(2);
            }
            if (bdFileDownloadData.getStatus() == 2) {
                if (bdFileDownloadData.getCallback() != null) {
                    bdFileDownloadData.getCallback().e(bdFileDownloadData);
                }
            } else if (aUm == null || !aUm.getUrl().equals(bdFileDownloadData.getUrl()) || !aUm.getId().equals(bdFileDownloadData.getId())) {
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
                Ha();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ha() {
        if (aUm == null && !mTaskList.isEmpty()) {
            aUm = mTaskList.get(0);
            if (aUm != null) {
                this.aUn = new C0118a();
                this.aUn.execute(aUm);
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void bK(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (aUm != null && aUm.getId().equals(str)) {
                this.aUn.cancel(true);
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
    public List<BdFileDownloadData> me() {
        return mTaskList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"DefaultLocale"})
    /* renamed from: com.baidu.tbadk.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0118a extends BdAsyncTask<BdFileDownloadData, BdFileDownloadData, Integer> {
        private BdFileDownloadData aUr;
        private y mNetWork = new y();
        private long aUp = -1;
        private String aUq = null;

        C0118a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.mNetWork.hN();
            a.aUm.setStatus(4);
            a.aUm.setStatusMsg(null);
            if (a.aUm.getCallback() != null) {
                a.aUm.getCallback().e(a.aUm);
            }
            if (!a.mTaskList.isEmpty()) {
                a.mTaskList.remove(0);
            }
            BdFileDownloadData unused = a.aUm = null;
            a.this.Ha();
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
            this.aUr = bdFileDownloadDataArr[0];
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
                        if (ao.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
                            f.i(file);
                        } else {
                            try {
                                fileInputStream2 = new FileInputStream(file);
                                try {
                                    if (s.g(fileInputStream2).equalsIgnoreCase(bdFileDownloadDataArr[0].getCheck())) {
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
                                    f.i(file);
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
                                    if (!ao.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
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
                    Boolean valueOf = Boolean.valueOf(this.mNetWork.a(a.this.i(bdFileDownloadDataArr[0]), a.this.aKO, TbConfig.NET_MSG_GETLENTH, 3, 3000, true));
                    BdLog.i("pluginFileDownloader download complete " + bdFileDownloadDataArr[0].getId());
                    if (!valueOf.booleanValue()) {
                        return 3;
                    }
                    File file2 = new File(a.this.i(bdFileDownloadDataArr[0]));
                    if (!file2.exists() || file2.length() <= 0) {
                        if (file2.exists()) {
                            f.i(file2);
                        }
                        return 1;
                    }
                    try {
                        f.b(file2, file);
                        f.i(file2);
                    } catch (IOException e7) {
                        try {
                            f.i(file);
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                        return 7;
                    }
                }
                if (!ao.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(bdFileDownloadDataArr[0].getPath());
                        try {
                            String g = s.g(fileInputStream);
                            if (!g.equalsIgnoreCase(bdFileDownloadDataArr[0].getCheck())) {
                                File file3 = new File(bdFileDownloadDataArr[0].getPath());
                                this.aUp = file3.length();
                                this.aUq = g;
                                f.i(file3);
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
            super.onPostExecute((C0118a) num);
            if (num == null) {
                num = -1;
            }
            if (num.intValue() == 0) {
                if (a.aUm.getCallback() != null) {
                    a.aUm.getCallback().g(a.aUm);
                }
                a.aUm.setStatus(0);
                if (a.aUm.getCallback() != null) {
                    a.aUm.getCallback().e(a.aUm);
                }
            } else {
                switch (num.intValue()) {
                    case 1:
                        string = TbadkCoreApplication.getInst().getApp().getString(d.k.download_fail);
                        break;
                    case 2:
                        string = TbadkCoreApplication.getInst().getApp().getString(d.k.download_fail);
                        break;
                    case 3:
                        string = TbadkCoreApplication.getInst().getApp().getString(d.k.download_fail_net);
                        break;
                    case 4:
                        string = TbadkCoreApplication.getInst().getApp().getString(d.k.download_fail);
                        break;
                    case 5:
                    default:
                        string = TbadkCoreApplication.getInst().getApp().getString(d.k.tb_err_unknown);
                        break;
                    case 6:
                        string = TbadkCoreApplication.getInst().getApp().getString(d.k.download_fail);
                        break;
                    case 7:
                        string = TbadkCoreApplication.getInst().getApp().getString(d.k.download_fail);
                        break;
                }
                if (num.intValue() == 4) {
                    str = "downloadfilesize-" + this.aUp + " downloadfileMd5-" + this.aUq + " wishMd5-" + (this.aUr == null ? "" : this.aUr.getCheck()) + " " + string;
                } else {
                    str = string;
                }
                a.aUm.setStatusMsg(string);
                a.aUm.setErrorCode(num.intValue());
                if (a.aUm.getCallback() != null) {
                    a.aUm.getCallback().a(a.aUm, num.intValue(), string, str);
                }
                a.aUm.setStatus(2);
                if (a.aUm.getCallback() != null) {
                    a.aUm.getCallback().e(a.aUm);
                }
            }
            BdFileDownloadData unused = a.aUm = null;
            if (!a.mTaskList.isEmpty()) {
                a.mTaskList.remove(0);
                a.this.Ha();
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
