package com.baidu.tbadk.g;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.e;
import com.baidu.adp.lib.util.t;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.plugin.packageManager.pluginFileDownload.b {
    private static a azz = new a();
    private static BdFileDownloadData azA = null;
    private static List<BdFileDownloadData> aqh = new LinkedList();
    private C0050a azB = null;
    private Handler aqo = new b(this);

    private a() {
    }

    public static a Fe() {
        return azz;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void a(BdFileDownloadData bdFileDownloadData, int i) {
        if (bdFileDownloadData != null) {
            if (!n.fi() && i == 2) {
                bdFileDownloadData.setStatusMsg(TbadkCoreApplication.m411getInst().getApp().getString(n.i.download_fail_no_sd));
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
                if (i3 < aqh.size()) {
                    BdFileDownloadData bdFileDownloadData2 = aqh.get(i3);
                    if (bdFileDownloadData2 == null || !bdFileDownloadData2.getUrl().equals(bdFileDownloadData.getUrl()) || !bdFileDownloadData2.getId().equals(bdFileDownloadData.getId())) {
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                } else {
                    bdFileDownloadData.setStatus(1);
                    aqh.add(bdFileDownloadData);
                    Bq();
                    return;
                }
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void b(BdFileDownloadData bdFileDownloadData, int i) {
        if (bdFileDownloadData != null) {
            if (!com.baidu.tbadk.core.util.n.fi() && i == 2) {
                bdFileDownloadData.setStatusMsg(TbadkCoreApplication.m411getInst().getApp().getString(n.i.download_fail_no_sd));
                bdFileDownloadData.setStatus(2);
            }
            if (bdFileDownloadData.getStatus() == 2) {
                if (bdFileDownloadData.getCallback() != null) {
                    bdFileDownloadData.getCallback().e(bdFileDownloadData);
                }
            } else if (azA == null || !azA.getUrl().equals(bdFileDownloadData.getUrl()) || !azA.getId().equals(bdFileDownloadData.getId())) {
                for (int i2 = 0; i2 < aqh.size(); i2++) {
                    BdFileDownloadData bdFileDownloadData2 = aqh.get(i2);
                    if (bdFileDownloadData2 != null && bdFileDownloadData2.getUrl().equals(bdFileDownloadData.getUrl()) && bdFileDownloadData2.getId().equals(bdFileDownloadData.getId())) {
                        aqh.remove(i2);
                        aqh.add(0, bdFileDownloadData2);
                        return;
                    }
                }
                bdFileDownloadData.setStatus(1);
                aqh.add(0, bdFileDownloadData);
                Bq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bq() {
        if (azA == null && !aqh.isEmpty()) {
            azA = aqh.get(0);
            if (azA != null) {
                this.azB = new C0050a();
                this.azB.execute(azA);
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void bz(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (azA != null && azA.getId().equals(str)) {
                this.azB.cancel(true);
                return;
            }
            LinkedList<BdFileDownloadData> linkedList = new LinkedList();
            Iterator<BdFileDownloadData> it = aqh.iterator();
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
                aqh.remove(bdFileDownloadData);
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public List<BdFileDownloadData> mi() {
        return aqh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0050a extends BdAsyncTask<BdFileDownloadData, BdFileDownloadData, Integer> {
        private ab Ty = new ab();

        C0050a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.Ty.gL();
            a.azA.setStatus(4);
            a.azA.setStatusMsg(null);
            if (a.azA.getCallback() != null) {
                a.azA.getCallback().e(a.azA);
            }
            if (!a.aqh.isEmpty()) {
                a.aqh.remove(0);
            }
            a.azA = null;
            a.this.Bq();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [400=4, 402=4, 403=4, 404=4, 342=4, 344=4, 345=4, 346=4] */
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
                        if (ax.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
                            e.f(file);
                        } else {
                            try {
                                fileInputStream2 = new FileInputStream(file);
                                try {
                                    if (t.f(fileInputStream2).equalsIgnoreCase(bdFileDownloadDataArr[0].getCheck())) {
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
                    this.Ty.setUrl(bdFileDownloadDataArr[0].getUrl());
                    Boolean valueOf = Boolean.valueOf(this.Ty.a(a.this.i(bdFileDownloadDataArr[0]), a.this.aqo, TbConfig.NET_MSG_GETLENTH, 3, LocationClientOption.MIN_SCAN_SPAN_NETWORK, true));
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
                        e.copyFile(file2, file);
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
                        try {
                            if (!t.f(fileInputStream).equalsIgnoreCase(bdFileDownloadDataArr[0].getCheck())) {
                                e.f(new File(bdFileDownloadDataArr[0].getPath()));
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
            super.onPostExecute((C0050a) num);
            if (num == null) {
                num = -1;
            }
            if (num.intValue() == 0) {
                if (a.azA.getCallback() != null) {
                    a.azA.getCallback().g(a.azA);
                }
                a.azA.setStatus(0);
                if (a.azA.getCallback() != null) {
                    a.azA.getCallback().e(a.azA);
                }
            } else {
                switch (num.intValue()) {
                    case 1:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(n.i.download_fail);
                        break;
                    case 2:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(n.i.download_fail);
                        break;
                    case 3:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(n.i.download_fail_net);
                        break;
                    case 4:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(n.i.download_fail);
                        break;
                    case 5:
                    default:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(n.i.tb_err_unknown);
                        break;
                    case 6:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(n.i.download_fail);
                        break;
                    case 7:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(n.i.download_fail);
                        break;
                }
                a.azA.setStatusMsg(string);
                a.azA.setErrorCode(num.intValue());
                if (a.azA.getCallback() != null) {
                    a.azA.getCallback().a(a.azA, num.intValue(), string, string);
                }
                a.azA.setStatus(2);
                if (a.azA.getCallback() != null) {
                    a.azA.getCallback().e(a.azA);
                }
            }
            a.azA = null;
            if (!a.aqh.isEmpty()) {
                a.aqh.remove(0);
                a.this.Bq();
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
