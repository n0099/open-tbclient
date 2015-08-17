package com.baidu.tbadk.download;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static d aoe = new d();
    private static DownloadData aof = null;
    private static List<DownloadData> anZ = new LinkedList();
    private a aog = null;
    private int max = 20;
    private Handler aoh = new e(this, Looper.getMainLooper());

    private d() {
    }

    public static d At() {
        return aoe;
    }

    public void a(DownloadData downloadData, int i) {
        int type = downloadData.getType();
        int i2 = 0;
        for (DownloadData downloadData2 : anZ) {
            if (downloadData2.getType() == type) {
                i2++;
            }
        }
        if (i2 >= i) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(TbadkCoreApplication.m411getInst().getApp().getString(i.C0057i.download_fail_over_max));
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().a(downloadData);
                return;
            }
            return;
        }
        i(downloadData);
    }

    public void i(DownloadData downloadData) {
        if (downloadData != null) {
            if (!n.fl()) {
                downloadData.setStatusMsg(TbadkCoreApplication.m411getInst().getApp().getString(i.C0057i.download_fail_no_sd));
                downloadData.setStatus(2);
            }
            if (downloadData.getStatus() == 2) {
                if (downloadData.getCallback() != null) {
                    downloadData.getCallback().a(downloadData);
                    return;
                }
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < anZ.size()) {
                    DownloadData downloadData2 = anZ.get(i2);
                    if (downloadData2 == null || !downloadData2.getUrl().equals(downloadData.getUrl()) || !downloadData2.getId().equals(downloadData.getId())) {
                        i = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    downloadData.setStatus(5);
                    anZ.add(downloadData);
                    Au();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Au() {
        if (aof == null && !anZ.isEmpty()) {
            aof = anZ.get(0);
            if (aof != null) {
                this.aog = new a();
                this.aog.execute(aof);
            }
        }
    }

    public void ew(String str) {
        if (aof != null && aof.getUrl().equals(str)) {
            this.aog.cancel(true);
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = anZ.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadData next = it.next();
            if (next.getUrl().equals(str)) {
                next.setStatus(4);
                if (next.getCallback() != null) {
                    next.getCallback().a(next);
                }
                linkedList.add(next);
            }
        }
        for (DownloadData downloadData : linkedList) {
            anZ.remove(downloadData);
        }
    }

    public void t(String str, int i) {
        if (aof != null && aof.getId().equals(str) && aof.getType() == i) {
            this.aog.cancel(true);
            return;
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        Iterator<DownloadData> it = anZ.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadData next = it.next();
            if (next.getId().equals(str) && next.getType() == i) {
                next.setStatus(4);
                next.setStatusMsg(null);
                if (next.getCallback() != null) {
                    next.getCallback().a(next);
                }
                linkedList.add(next);
            }
        }
        for (DownloadData downloadData : linkedList) {
            anZ.remove(downloadData);
        }
    }

    public void dG(int i) {
        if (aof != null && aof.getType() == i) {
            this.aog.cancel(true);
        }
        LinkedList<DownloadData> linkedList = new LinkedList();
        for (DownloadData downloadData : anZ) {
            if (downloadData.getType() == i) {
                downloadData.setStatus(4);
                downloadData.setStatusMsg(null);
                if (downloadData.getCallback() != null) {
                    downloadData.getCallback().a(downloadData);
                }
                linkedList.add(downloadData);
            }
        }
        for (DownloadData downloadData2 : linkedList) {
            anZ.remove(downloadData2);
        }
    }

    public List<DownloadData> mg() {
        return anZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        private v Tu = new v();

        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
            this.Tu.gM();
            d.aof.setStatus(4);
            d.aof.setStatusMsg(null);
            if (d.aof.getCallback() != null) {
                d.aof.getCallback().a(d.aof);
            }
            if (!d.anZ.isEmpty()) {
                d.anZ.remove(0);
            }
            d.aof = null;
            d.this.Au();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [367=4, 369=4, 370=4, 371=4] */
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:75:0x016d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
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
            if (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().b(downloadDataArr[0])) {
                File file = new File(downloadDataArr[0].getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (!file.exists()) {
                    this.Tu.setUrl(downloadDataArr[0].getUrl());
                    if (!Boolean.valueOf(this.Tu.a(String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp", d.this.aoh, TbConfig.NET_MSG_GETLENTH, 3, LocationClientOption.MIN_SCAN_SPAN_NETWORK)).booleanValue()) {
                        return 3;
                    }
                    File cC = n.cC(String.valueOf(downloadDataArr[0].getId()) + "_" + downloadDataArr[0].getName() + ".tmp");
                    if (cC == null) {
                        return 1;
                    }
                    try {
                        String parent = cC.getParent();
                        String parent2 = file.getParent();
                        if (parent.equals(parent2)) {
                            cC.renameTo(new File(parent2, file.getName()));
                        } else {
                            com.baidu.adp.lib.util.e.copyFile(cC, file);
                            com.baidu.adp.lib.util.e.f(cC);
                        }
                    } catch (IOException e) {
                        try {
                            com.baidu.adp.lib.util.e.f(file);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return 7;
                    }
                }
                if (!aq.isEmpty(downloadDataArr[0].getCheck())) {
                    try {
                        fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                        try {
                            if (!t.e(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                                com.baidu.adp.lib.util.e.f(new File(downloadDataArr[0].getPath()));
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
                return (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().c(downloadDataArr[0])) ? 0 : 2;
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
                if (d.aof.getCallback() != null) {
                    d.aof.getCallback().d(d.aof);
                }
                d.aof.setStatus(0);
                if (d.aof.getCallback() != null) {
                    d.aof.getCallback().a(d.aof);
                }
            } else {
                switch (num.intValue()) {
                    case 1:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(i.C0057i.download_fail);
                        break;
                    case 2:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(i.C0057i.download_fail);
                        break;
                    case 3:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(i.C0057i.download_fail_net);
                        break;
                    case 4:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(i.C0057i.download_fail);
                        break;
                    case 5:
                    default:
                        string = null;
                        break;
                    case 6:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(i.C0057i.download_fail);
                        break;
                    case 7:
                        string = TbadkCoreApplication.m411getInst().getApp().getString(i.C0057i.download_fail);
                        break;
                }
                d.aof.setStatusMsg(string);
                d.aof.setErrorCode(num.intValue());
                if (d.aof.getCallback() != null) {
                    d.aof.getCallback().a(d.aof, num.intValue(), string);
                }
                d.aof.setStatus(2);
                if (d.aof.getCallback() != null) {
                    d.aof.getCallback().a(d.aof);
                }
            }
            d.aof = null;
            if (!d.anZ.isEmpty()) {
                d.anZ.remove(0);
                d.this.Au();
            }
        }
    }
}
