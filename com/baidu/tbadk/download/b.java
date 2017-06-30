package com.baidu.tbadk.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b aza = null;
    private static DownloadData azd = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private final int azb = 5;
    private a azc = null;

    private b() {
    }

    public static b Cv() {
        synchronized (b.class) {
            if (aza == null) {
                aza = new b();
            }
        }
        return aza;
    }

    public void a(String str, String str2, String str3, String[] strArr) {
        a(str, str2, str3, -1, (int) com.baidu.adp.lib.g.b.c(str, 0L), null, true, false, true);
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
        a(downloadData);
    }

    public void a(DownloadData downloadData) {
        if (downloadData != null) {
            List<DownloadData> jP = e.Cy().jP();
            if (jP != null && jP.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.m9getInst().getApp().getString(w.l.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.m9getInst(), w.l.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            Cw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cw() {
        if (azd == null) {
            azd = (DownloadData) z.c(mTaskList, 0);
            if (azd != null) {
                this.azc = new a(this, null);
                this.azc.setPriority(3);
                this.azc.execute(azd);
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

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void w(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void o(ArrayList<AdvertAppInfo> arrayList) {
        try {
            new C0044b(this, null).execute(arrayList);
        } catch (Exception e) {
        }
    }

    /* renamed from: com.baidu.tbadk.download.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0044b extends BdAsyncTask<ArrayList<AdvertAppInfo>, List<DownloadData>, List<DownloadData>> {
        ArrayList<AdvertAppInfo> azf;

        private C0044b() {
            this.azf = null;
        }

        /* synthetic */ C0044b(b bVar, C0044b c0044b) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public List<DownloadData> doInBackground(ArrayList<AdvertAppInfo>... arrayListArr) {
            ArrayList<AdvertAppInfo> arrayList = arrayListArr[0];
            LinkedList linkedList = new LinkedList();
            if (arrayList == null) {
                return linkedList;
            }
            this.azf = arrayList;
            Iterator<AdvertAppInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                String str = next.SY;
                if (n.dm(b.this.getFileOfUrl(next.SX)) != null) {
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
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute((C0044b) list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : e.Cy().jP()) {
                Iterator<AdvertAppInfo> it = this.azf.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().SY, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            b.this.w(list);
            this.azf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getFilePath(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(n.uu());
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
                if (!aw.isEmpty(id) && !aw.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = String.valueOf(id.replace(".", "_")) + ".apk";
                    String filePath = b.this.getFilePath(str);
                    File dm = n.dm(str);
                    if (isForceDownload || dm == null) {
                        downloadData.setCallback(new com.baidu.tbadk.download.a());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(filePath);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(filePath);
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
        /* renamed from: e */
        public void onPostExecute(DownloadData downloadData) {
            super.onPostExecute(downloadData);
            b.this.azc = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    b.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
                    }
                } else {
                    e.Cy().a(downloadData, 5);
                    int aj = b.this.aj(downloadData.getId(), downloadData.getName());
                    if (downloadData.isNeedNotify() && aj <= 0) {
                        String string = TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.download_will_begin);
                        NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + string, 0, string, downloadData.getName(), b.this.fo(downloadData.getAction()), false);
                    } else {
                        b.this.c(downloadData);
                    }
                }
                b.azd = null;
                if (!b.mTaskList.isEmpty()) {
                    b.mTaskList.remove(0);
                    b.this.Cw();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int aj = aj(downloadData.getId(), downloadData.getName());
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), null, aj, String.valueOf(aj) + "%", downloadData.getName(), fo(downloadData.getAction()), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent fo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.m9getInst(), 0, intent, 0);
    }

    public boolean fp(String str) {
        for (DownloadData downloadData : e.Cy().jP()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int aj(String str, String str2) {
        long ak = ak(str, str2);
        long j = TbadkCoreApplication.m9getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (ak <= j) {
            return (int) ((ak * 100) / j);
        }
        return 0;
    }

    public void fq(String str) {
        if (!StringUtils.isNull(str)) {
            e.Cy().fs(str);
        }
    }

    public long ak(String str, String str2) {
        File dm = n.dm(String.valueOf(str) + "_" + str2 + ".tmp");
        if (dm != null && dm.exists() && dm.isFile()) {
            return dm.length();
        }
        return -1L;
    }

    public boolean fr(String str) {
        return (TextUtils.isEmpty(str) || n.dm(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }
}
