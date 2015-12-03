package com.baidu.tbadk.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b aqc = null;
    private static DownloadData aqg = null;
    private static List<DownloadData> aqh = new LinkedList();
    private final int aqd = 5;
    private a aqe = null;
    private C0047b aqf = null;

    private b() {
    }

    public static b Bm() {
        synchronized (b.class) {
            if (aqc == null) {
                aqc = new b();
            }
        }
        return aqc;
    }

    public void a(String str, String str2, String str3, int i, int i2) {
        a(str, str2, str3, i, i2, null, true, false, true);
    }

    public void a(String str, String str2, String str3, int i, int i2, String[] strArr, boolean z, boolean z2, boolean z3) {
        DownloadData downloadData = new DownloadData(str);
        downloadData.setType(12);
        downloadData.setId(str);
        downloadData.setUrl(str2);
        downloadData.setName(str3);
        downloadData.setTag(strArr);
        downloadData.setPosition(i);
        downloadData.setNotifyId(i2);
        downloadData.setNeedInvokeApk(z);
        downloadData.setForceDownload(z2);
        downloadData.setNeedNotify(z3);
        g(downloadData);
    }

    public void g(DownloadData downloadData) {
        if (downloadData != null) {
            List<DownloadData> mi = d.Bp().mi();
            if (mi != null && mi.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.m411getInst().getApp().getString(n.i.download_fail_over_max));
                h(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.m411getInst(), n.i.download_fail_over_max);
                return;
            }
            aqh.add(downloadData);
            Bn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bn() {
        if (aqg == null && !aqh.isEmpty()) {
            aqg = aqh.get(0);
            if (aqg != null) {
                this.aqe = new a(this, null);
                this.aqe.setPriority(3);
                this.aqe.execute(aqg);
            }
        }
    }

    public String getFileOfUrl(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf("?"));
        }
        String[] split = str.split("/");
        return split[split.length - 1];
    }

    public void h(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void n(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void p(ArrayList<com.baidu.tbadk.core.data.b> arrayList) {
        this.aqf = new C0047b(this, null);
        this.aqf.execute(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.download.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0047b extends BdAsyncTask<ArrayList<com.baidu.tbadk.core.data.b>, List<DownloadData>, List<DownloadData>> {
        ArrayList<com.baidu.tbadk.core.data.b> aqj;

        private C0047b() {
            this.aqj = null;
        }

        /* synthetic */ C0047b(b bVar, C0047b c0047b) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public List<DownloadData> doInBackground(ArrayList<com.baidu.tbadk.core.data.b>... arrayListArr) {
            ArrayList<com.baidu.tbadk.core.data.b> arrayList = arrayListArr[0];
            LinkedList linkedList = new LinkedList();
            if (arrayList == null) {
                return linkedList;
            }
            this.aqj = arrayList;
            Iterator<com.baidu.tbadk.core.data.b> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.data.b next = it.next();
                String str = next.Ur;
                if (com.baidu.tbadk.core.util.n.cR(b.this.getFileOfUrl(next.Uq)) != null) {
                    DownloadData downloadData = new DownloadData(str);
                    downloadData.setStatus(3);
                    linkedList.add(downloadData);
                }
            }
            return linkedList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute(list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : d.Bp().mi()) {
                Iterator<com.baidu.tbadk.core.data.b> it = this.aqj.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().Ur, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            b.this.n(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aF(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.tbadk.core.util.n.ui());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public DownloadData doInBackground(DownloadData... downloadDataArr) {
            DownloadData downloadData = downloadDataArr[0];
            if (downloadData != null) {
                String id = downloadData.getId();
                String name = downloadData.getName();
                if (!ax.isEmpty(id) && !ax.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = String.valueOf(id.replace(".", "_")) + ".apk";
                    String aF = b.this.aF(str);
                    File cR = com.baidu.tbadk.core.util.n.cR(str);
                    if (isForceDownload || cR == null) {
                        downloadData.setCallback(new com.baidu.tbadk.download.a());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(aF);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(aF);
                    downloadData2.setStatus(3);
                    return downloadData2;
                }
                return downloadData;
            }
            return downloadData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public void onPostExecute(DownloadData downloadData) {
            super.onPostExecute(downloadData);
            b.this.aqe = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    b.this.h(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
                    }
                } else {
                    d.Bp().a(downloadData, 5);
                    if (downloadData.isNeedNotify()) {
                        NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), null, 0, TbadkCoreApplication.m411getInst().getApp().getString(n.i.download_will_begin), downloadData.getName(), b.this.eS(downloadData.getAction()), false);
                    }
                }
                b.aqg = null;
                if (!b.aqh.isEmpty()) {
                    b.aqh.remove(0);
                    b.this.Bn();
                }
            }
        }
    }

    public void i(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int ai = ai(downloadData.getId(), downloadData.getName());
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(n.i.download_will_begin), ai, String.valueOf(ai) + "%", downloadData.getName(), eS(downloadData.getAction()), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent eS(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.m411getInst(), 0, intent, 0);
    }

    public void j(DownloadData downloadData) {
        String string;
        int process;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.m411getInst().getString(n.i.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m411getInst().getString(n.i.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m411getInst().getString(n.i.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                String str = String.valueOf(downloadData.getLength() / 1000) + "K/" + String.valueOf(downloadData.getSize() / 1000) + "K";
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(n.i.download_fail_tip), downloadData.getProcess(), String.valueOf(process) + "%", string, eS(downloadData.getAction()), false);
            }
        }
    }

    public boolean eT(String str) {
        for (DownloadData downloadData : d.Bp().mi()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int ai(String str, String str2) {
        long al = al(str, str2);
        long j = TbadkCoreApplication.m411getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (al <= j) {
            return (int) ((al * 100) / j);
        }
        return 0;
    }

    public boolean eU(String str) {
        for (DownloadData downloadData : d.Bp().mi()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void aj(String str, String str2) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : d.Bp().mi()) {
                if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                    downloadData = downloadData2;
                }
            }
            d.Bp().eX(str);
            if (downloadData != null && downloadData.getSize() != 0) {
                int length = (int) ((downloadData.getLength() * 100) / downloadData.getSize());
                String str3 = String.valueOf(length) + "%";
                if (downloadData != null) {
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(n.i.download_cancel), length, str3, String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(n.i.download_cancel), eS(downloadData.getAction()), false);
                }
            }
        }
    }

    public void eV(String str) {
        if (!StringUtils.isNull(str)) {
            d.Bp().eX(str);
        }
    }

    public boolean ak(String str, String str2) {
        File cR;
        return TbadkCoreApplication.m411getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (cR = com.baidu.tbadk.core.util.n.cR(new StringBuilder(String.valueOf(str)).append("_").append(str2).append(".tmp").toString())) != null && cR.exists() && cR.isFile();
    }

    public long al(String str, String str2) {
        File cR = com.baidu.tbadk.core.util.n.cR(String.valueOf(str) + "_" + str2 + ".tmp");
        if (cR != null && cR.exists() && cR.isFile()) {
            return cR.length();
        }
        return -1L;
    }

    public boolean eW(String str) {
        return (TextUtils.isEmpty(str) || com.baidu.tbadk.core.util.n.cR(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }
}
