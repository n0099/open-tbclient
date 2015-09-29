package com.baidu.tbadk.f;

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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.plugin.packageManager.pluginFileDownload.b {
    private static a ayu = new a();
    private static BdFileDownloadData ayv = null;
    private static List<BdFileDownloadData> aoj = new LinkedList();
    private C0048a ayw = null;
    private Handler aos = new b(this);

    private a() {
    }

    public static a En() {
        return ayu;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void a(BdFileDownloadData bdFileDownloadData, int i) {
        if (bdFileDownloadData != null) {
            if (!n.fi() && i == 2) {
                bdFileDownloadData.setStatusMsg(TbadkCoreApplication.m411getInst().getApp().getString(i.h.download_fail_no_sd));
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
                if (i3 < aoj.size()) {
                    BdFileDownloadData bdFileDownloadData2 = aoj.get(i3);
                    if (bdFileDownloadData2 == null || !bdFileDownloadData2.getUrl().equals(bdFileDownloadData.getUrl()) || !bdFileDownloadData2.getId().equals(bdFileDownloadData.getId())) {
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                } else {
                    bdFileDownloadData.setStatus(1);
                    aoj.add(bdFileDownloadData);
                    At();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void At() {
        if (ayv == null && !aoj.isEmpty()) {
            ayv = aoj.get(0);
            if (ayv != null) {
                this.ayw = new C0048a();
                this.ayw.execute(ayv);
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public void bx(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (ayv != null && ayv.getId().equals(str)) {
                this.ayw.cancel(true);
                return;
            }
            LinkedList<BdFileDownloadData> linkedList = new LinkedList();
            Iterator<BdFileDownloadData> it = aoj.iterator();
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
                aoj.remove(bdFileDownloadData);
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.b
    public List<BdFileDownloadData> me() {
        return aoj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tbadk.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0048a extends BdAsyncTask<BdFileDownloadData, BdFileDownloadData, Integer> {
        private w Th = new w();

        C0048a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.Th.gJ();
            a.ayv.setStatus(4);
            a.ayv.setStatusMsg(null);
            if (a.ayv.getCallback() != null) {
                a.ayv.getCallback().e(a.ayv);
            }
            if (!a.aoj.isEmpty()) {
                a.aoj.remove(0);
            }
            a.ayv = null;
            a.this.At();
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
                        if (ar.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
                            e.f(file);
                        } else {
                            try {
                                fileInputStream2 = new FileInputStream(file);
                                try {
                                    if (t.e(fileInputStream2).equalsIgnoreCase(bdFileDownloadDataArr[0].getCheck())) {
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
                                    if (!ar.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
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
                    this.Th.setUrl(bdFileDownloadDataArr[0].getUrl());
                    Boolean valueOf = Boolean.valueOf(this.Th.a(a.this.i(bdFileDownloadDataArr[0]), a.this.aos, TbConfig.NET_MSG_GETLENTH, 3, LocationClientOption.MIN_SCAN_SPAN_NETWORK, true));
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
                if (!ar.isEmpty(bdFileDownloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(bdFileDownloadDataArr[0].getPath());
                        try {
                            if (!t.e(fileInputStream).equalsIgnoreCase(bdFileDownloadDataArr[0].getCheck())) {
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
            super.onPostExecute((C0048a) num);
            if (num == null) {
                num = -1;
            }
            if (num.intValue() == 0) {
                if (a.ayv.getCallback() != null) {
                    a.ayv.getCallback().g(a.ayv);
                }
                a.ayv.setStatus(0);
                if (a.ayv.getCallback() != null) {
                    a.ayv.getCallback().e(a.ayv);
                }
            } else {
                switch (num.intValue()) {
                    case 1:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(i.h.download_fail);
                        break;
                    case 2:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(i.h.download_fail);
                        break;
                    case 3:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(i.h.download_fail_net);
                        break;
                    case 4:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(i.h.download_fail);
                        break;
                    case 5:
                    default:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(i.h.tb_err_unknown);
                        break;
                    case 6:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(i.h.download_fail);
                        break;
                    case 7:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(i.h.download_fail);
                        break;
                }
                a.ayv.setStatusMsg(string);
                a.ayv.setErrorCode(num.intValue());
                if (a.ayv.getCallback() != null) {
                    a.ayv.getCallback().a(a.ayv, num.intValue(), string, string);
                }
                a.ayv.setStatus(2);
                if (a.ayv.getCallback() != null) {
                    a.ayv.getCallback().e(a.ayv);
                }
            }
            a.ayv = null;
            if (!a.aoj.isEmpty()) {
                a.aoj.remove(0);
                a.this.At();
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
