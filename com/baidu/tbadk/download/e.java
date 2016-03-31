package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.t;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private static e atd = new e();
    private static DownloadData ate = null;
    private static List<DownloadData> asW = new LinkedList();
    private a atf = null;
    private int max = 20;
    private Handler atg = new f(this, Looper.getMainLooper());

    private e() {
    }

    public static e Da() {
        return atd;
    }

    public void a(DownloadData downloadData, int i) {
        int type = downloadData.getType();
        int i2 = 0;
        for (DownloadData downloadData2 : asW) {
            if (downloadData2.getType() == type) {
                i2++;
            }
        }
        if (i2 >= i) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.m411getInst().getApp().getString(t.j.download_fail_over_max));
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().d(downloadData);
                return;
            }
            return;
        }
        m(downloadData);
    }

    public void m(DownloadData downloadData) {
        if (downloadData != null) {
            if (!m.fr()) {
                downloadData.setStatusMsg(TbadkCoreApplication.m411getInst().getApp().getString(t.j.download_fail_no_sd));
                downloadData.setStatus(2);
            }
            if (downloadData.getStatus() == 2) {
                if (downloadData.getCallback() != null) {
                    downloadData.getCallback().d(downloadData);
                    return;
                }
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < asW.size()) {
                    DownloadData downloadData2 = asW.get(i2);
                    if (downloadData2 == null || !downloadData2.getUrl().equals(downloadData.getUrl()) || !downloadData2.getId().equals(downloadData.getId())) {
                        i = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    downloadData.setStatus(5);
                    asW.add(downloadData);
                    Db();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Db() {
        if (ate == null && !asW.isEmpty()) {
            ate = asW.get(0);
            if (ate != null) {
                this.atf = new a();
                this.atf.execute(ate);
            }
        }
    }

    public void fh(String str) {
        if (ate != null && ate.getUrl().equals(str)) {
            this.atf.cancel(true);
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = asW.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadData next = it.next();
            if (next.getUrl().equals(str)) {
                next.setStatus(4);
                if (next.getCallback() != null) {
                    next.getCallback().d(next);
                }
                linkedList.add(next);
            }
        }
        for (DownloadData downloadData : linkedList) {
            asW.remove(downloadData);
        }
    }

    public void x(String str, int i) {
        if (ate != null && ate.getId().equals(str) && ate.getType() == i) {
            this.atf.cancel(true);
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = asW.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadData next = it.next();
            if (next.getId().equals(str) && next.getType() == i) {
                next.setStatus(4);
                next.setStatusMsg(null);
                if (next.getCallback() != null) {
                    next.getCallback().d(next);
                }
                linkedList.add(next);
            }
        }
        for (DownloadData downloadData : linkedList) {
            asW.remove(downloadData);
        }
    }

    public void ev(int i) {
        if (ate != null && ate.getType() == i) {
            this.atf.cancel(true);
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        for (DownloadData downloadData : asW) {
            if (downloadData.getType() == i) {
                downloadData.setStatus(4);
                downloadData.setStatusMsg(null);
                if (downloadData.getCallback() != null) {
                    downloadData.getCallback().d(downloadData);
                }
                linkedList.add(downloadData);
            }
        }
        for (DownloadData downloadData2 : linkedList) {
            asW.remove(downloadData2);
        }
    }

    public List<DownloadData> lL() {
        return asW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        private ab QV = new ab();

        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.QV.ha();
            e.ate.setStatus(4);
            e.ate.setStatusMsg(null);
            if (e.ate.getCallback() != null) {
                e.ate.getCallback().d(e.ate);
            }
            if (!e.asW.isEmpty()) {
                e.asW.remove(0);
            }
            e.ate = null;
            e.this.Db();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [368=4, 370=4, 371=4, 372=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:75:0x016d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Integer doInBackground(DownloadData... downloadDataArr) {
            FileInputStream fileInputStream;
            FileInputStream fileInputStream2 = null;
            Boolean.valueOf(false);
            if (downloadDataArr[0] == null) {
                return null;
            }
            if (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().c(downloadDataArr[0])) {
                File file = new File(downloadDataArr[0].getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (!file.exists()) {
                    this.QV.setUrl(downloadDataArr[0].getUrl());
                    if (!Boolean.valueOf(this.QV.a(String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp", e.this.atg, TbConfig.NET_MSG_GETLENTH, 3, LocationClientOption.MIN_SCAN_SPAN_NETWORK)).booleanValue()) {
                        return 3;
                    }
                    File cU = m.cU(String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp");
                    if (cU == null) {
                        return 1;
                    }
                    try {
                        String parent = cU.getParent();
                        String parent2 = file.getParent();
                        if (parent.equals(parent2)) {
                            cU.renameTo(new File(parent2, file.getName()));
                        } else {
                            com.baidu.adp.lib.util.e.b(cU, file);
                            com.baidu.adp.lib.util.e.e(cU);
                        }
                    } catch (IOException e) {
                        try {
                            com.baidu.adp.lib.util.e.e(file);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return 7;
                    }
                }
                if (!ay.isEmpty(downloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                        try {
                            if (!com.baidu.adp.lib.util.t.d(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                                com.baidu.adp.lib.util.e.e(new File(downloadDataArr[0].getPath()));
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                        return 4;
                                    } catch (IOException e3) {
                                        BdLog.d(e3.getMessage());
                                        return 4;
                                    }
                                }
                                return 4;
                            } else if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e4) {
                                    BdLog.d(e4.getMessage());
                                }
                            }
                        } catch (FileNotFoundException e5) {
                            e = e5;
                            fileInputStream2 = fileInputStream;
                            try {
                                BdLog.d(e.getMessage());
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                        return 6;
                                    } catch (IOException e6) {
                                        BdLog.d(e6.getMessage());
                                        return 6;
                                    }
                                }
                                return 6;
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e7) {
                                        BdLog.d(e7.getMessage());
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e8) {
                        e = e8;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = null;
                    }
                }
                return (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().e(downloadDataArr[0])) ? 0 : 2;
            }
            return 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            String string;
            super.onPostExecute((a) num);
            if (num.intValue() == 0) {
                e.ate.setStatus(0);
                if (e.ate.getCallback() != null) {
                    e.ate.getCallback().d(e.ate);
                }
                if (e.ate.getCallback() != null) {
                    e.ate.getCallback().f(e.ate);
                }
            } else {
                switch (num.intValue()) {
                    case 1:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(t.j.download_fail);
                        break;
                    case 2:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(t.j.download_fail);
                        break;
                    case 3:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(t.j.download_fail_net);
                        break;
                    case 4:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(t.j.download_fail);
                        break;
                    case 5:
                    default:
                        string = null;
                        break;
                    case 6:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(t.j.download_fail);
                        break;
                    case 7:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(t.j.download_fail);
                        break;
                }
                e.ate.setStatusMsg(string);
                e.ate.setErrorCode(num.intValue());
                e.ate.setStatus(2);
                if (e.ate.getCallback() != null) {
                    e.ate.getCallback().d(e.ate);
                }
                if (e.ate.getCallback() != null) {
                    e.ate.getCallback().a(e.ate, num.intValue(), string);
                }
            }
            e.ate = null;
            if (!e.asW.isEmpty()) {
                e.asW.remove(0);
                e.this.Db();
            }
        }
    }
}
