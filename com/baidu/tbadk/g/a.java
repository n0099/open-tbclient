package com.baidu.tbadk.g;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.e;
import com.baidu.adp.lib.util.t;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.r;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.plugin.packageManager.pluginFileDownload.b {
    private static a aDZ = new a();
    private static BdFileDownloadData aEa = null;
    private static List<BdFileDownloadData> mTaskList = new LinkedList();
    private C0043a aEb = null;
    private Handler auf = new b(this);

    private a() {
    }

    public static a GF() {
        return aDZ;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void a(BdFileDownloadData bdFileDownloadData, int i) {
        if (bdFileDownloadData != null) {
            if (!m.cA() && i == 2) {
                bdFileDownloadData.setStatusMsg(TbadkCoreApplication.m9getInst().getApp().getString(r.j.download_fail_no_sd));
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
                    CH();
                    return;
                }
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void b(BdFileDownloadData bdFileDownloadData, int i) {
        if (bdFileDownloadData != null) {
            if (!m.cA() && i == 2) {
                bdFileDownloadData.setStatusMsg(TbadkCoreApplication.m9getInst().getApp().getString(r.j.download_fail_no_sd));
                bdFileDownloadData.setStatus(2);
            }
            if (bdFileDownloadData.getStatus() == 2) {
                if (bdFileDownloadData.getCallback() != null) {
                    bdFileDownloadData.getCallback().e(bdFileDownloadData);
                }
            } else if (aEa == null || !aEa.getUrl().equals(bdFileDownloadData.getUrl()) || !aEa.getId().equals(bdFileDownloadData.getId())) {
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
                CH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CH() {
        if (aEa == null && !mTaskList.isEmpty()) {
            aEa = mTaskList.get(0);
            if (aEa != null) {
                this.aEb = new C0043a();
                this.aEb.execute(aEa);
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void bv(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (aEa != null && aEa.getId().equals(str)) {
                this.aEb.cancel(true);
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
    public List<BdFileDownloadData> iV() {
        return mTaskList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0043a extends BdAsyncTask<BdFileDownloadData, BdFileDownloadData, Integer> {
        private BdFileDownloadData aEf;
        private z Ob = new z();
        private long aEd = -1;
        private String aEe = null;

        C0043a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.Ob.eg();
            a.aEa.setStatus(4);
            a.aEa.setStatusMsg(null);
            if (a.aEa.getCallback() != null) {
                a.aEa.getCallback().e(a.aEa);
            }
            if (!a.mTaskList.isEmpty()) {
                a.mTaskList.remove(0);
            }
            a.aEa = null;
            a.this.CH();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [407=4, 409=4, 410=4, 411=4, 346=4, 348=4, 349=4, 350=4] */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:112:0x0257 */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:104:0x0243  */
        /* JADX WARN: Removed duplicated region for block: B:105:0x0249  */
        /* JADX WARN: Removed duplicated region for block: B:131:0x0201 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:142:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00ab  */
        /* JADX WARN: Type inference failed for: r0v57, types: [java.lang.StringBuilder] */
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
            this.aEf = bdFileDownloadDataArr[0];
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
                        if (ax.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
                            e.f(file);
                        } else {
                            try {
                                fileInputStream2 = new FileInputStream(file);
                                try {
                                    if (t.k(fileInputStream2).equalsIgnoreCase(bdFileDownloadDataArr[0].getCheck())) {
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
                                    e.f(file);
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
                                    if (!ax.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
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
                    this.Ob.setUrl(bdFileDownloadDataArr[0].getUrl());
                    Boolean valueOf = Boolean.valueOf(this.Ob.a(a.this.i(bdFileDownloadDataArr[0]), a.this.auf, TbConfig.NET_MSG_GETLENTH, 3, 3000, true));
                    BdLog.i("pluginFileDownloader download complete " + bdFileDownloadDataArr[0].getId());
                    if (!valueOf.booleanValue()) {
                        return 3;
                    }
                    File file2 = new File(a.this.i(bdFileDownloadDataArr[0]));
                    if (!file2.exists() || file2.length() <= 0) {
                        if (file2.exists()) {
                            e.f(file2);
                        }
                        return 1;
                    }
                    try {
                        e.b(file2, file);
                        e.f(file2);
                    } catch (IOException e7) {
                        try {
                            e.f(file);
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                        return 7;
                    }
                }
                if (!ax.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(bdFileDownloadDataArr[0].getPath());
                    } catch (FileNotFoundException e9) {
                        e = e9;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = null;
                    }
                    try {
                        String k = t.k(fileInputStream);
                        if (!k.equalsIgnoreCase(bdFileDownloadDataArr[0].getCheck())) {
                            File file3 = new File(bdFileDownloadDataArr[0].getPath());
                            this.aEd = file3.length();
                            this.aEe = k;
                            e.f(file3);
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
            String str;
            super.onPostExecute((C0043a) num);
            if (num == null) {
                num = -1;
            }
            if (num.intValue() == 0) {
                if (a.aEa.getCallback() != null) {
                    a.aEa.getCallback().g(a.aEa);
                }
                a.aEa.setStatus(0);
                if (a.aEa.getCallback() != null) {
                    a.aEa.getCallback().e(a.aEa);
                }
            } else {
                switch (num.intValue()) {
                    case 1:
                        string = TbadkCoreApplication.m9getInst().getApp().getString(r.j.download_fail);
                        break;
                    case 2:
                        string = TbadkCoreApplication.m9getInst().getApp().getString(r.j.download_fail);
                        break;
                    case 3:
                        string = TbadkCoreApplication.m9getInst().getApp().getString(r.j.download_fail_net);
                        break;
                    case 4:
                        string = TbadkCoreApplication.m9getInst().getApp().getString(r.j.download_fail);
                        break;
                    case 5:
                    default:
                        string = TbadkCoreApplication.m9getInst().getApp().getString(r.j.tb_err_unknown);
                        break;
                    case 6:
                        string = TbadkCoreApplication.m9getInst().getApp().getString(r.j.download_fail);
                        break;
                    case 7:
                        string = TbadkCoreApplication.m9getInst().getApp().getString(r.j.download_fail);
                        break;
                }
                if (num.intValue() == 4) {
                    str = "downloadfilesize-" + this.aEd + " downloadfileMd5-" + this.aEe + " wishMd5-" + (this.aEf == null ? "" : this.aEf.getCheck()) + " " + string;
                } else {
                    str = string;
                }
                a.aEa.setStatusMsg(string);
                a.aEa.setErrorCode(num.intValue());
                if (a.aEa.getCallback() != null) {
                    a.aEa.getCallback().a(a.aEa, num.intValue(), string, str);
                }
                a.aEa.setStatus(2);
                if (a.aEa.getCallback() != null) {
                    a.aEa.getCallback().e(a.aEa);
                }
            }
            a.aEa = null;
            if (!a.mTaskList.isEmpty()) {
                a.mTaskList.remove(0);
                a.this.CH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i(BdFileDownloadData bdFileDownloadData) {
        if (bdFileDownloadData == null) {
            return null;
        }
        return String.valueOf(bdFileDownloadData.getPath()) + ".tmp";
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
