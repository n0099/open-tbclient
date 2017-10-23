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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b azK = null;
    private static DownloadData azN = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private final int azL = 5;
    private a azM = null;

    private b() {
    }

    public static b Ci() {
        synchronized (b.class) {
            if (azK == null) {
                azK = new b();
            }
        }
        return azK;
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
            List<DownloadData> jO = e.Cl().jO();
            if (jO != null && jO.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.l.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), d.l.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            Cj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cj() {
        if (azN == null) {
            azN = (DownloadData) v.c(mTaskList, 0);
            if (azN != null) {
                this.azM = new a();
                this.azM.setPriority(3);
                this.azM.execute(azN);
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

    public void y(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void n(ArrayList<AdvertAppInfo> arrayList) {
        try {
            new C0054b().execute(arrayList);
        } catch (Exception e) {
        }
    }

    /* renamed from: com.baidu.tbadk.download.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0054b extends BdAsyncTask<ArrayList<AdvertAppInfo>, List<DownloadData>, List<DownloadData>> {
        ArrayList<AdvertAppInfo> azP;

        private C0054b() {
            this.azP = null;
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
            this.azP = arrayList;
            Iterator<AdvertAppInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                String str = next.TT;
                if (k.dd(b.this.getFileOfUrl(next.TS)) != null) {
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
            super.onPostExecute((C0054b) list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : e.Cl().jO()) {
                Iterator<AdvertAppInfo> it = this.azP.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().TT, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            b.this.y(list);
            this.azP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String az(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(k.uc());
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

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public DownloadData doInBackground(DownloadData... downloadDataArr) {
            DownloadData downloadData = downloadDataArr[0];
            if (downloadData != null) {
                String id = downloadData.getId();
                String name = downloadData.getName();
                if (!am.isEmpty(id) && !am.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = id.replace(".", "_") + ".apk";
                    String az = b.this.az(str);
                    File dd = k.dd(str);
                    if (isForceDownload || dd == null) {
                        downloadData.setCallback(new com.baidu.tbadk.download.a());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(az);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(az);
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
            b.this.azM = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    b.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", "_") + ".apk");
                    }
                } else {
                    e.Cl().a(downloadData, 5);
                    int am = b.this.am(downloadData.getId(), downloadData.getName());
                    if (downloadData.isNeedNotify() && am <= 0) {
                        String string = TbadkCoreApplication.getInst().getApp().getResources().getString(d.l.download_will_begin);
                        NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + string, 0, string, downloadData.getName(), b.this.fp(downloadData.getAction()), false);
                    } else {
                        b.this.c(downloadData);
                    }
                }
                DownloadData unused = b.azN = null;
                if (!b.mTaskList.isEmpty()) {
                    b.mTaskList.remove(0);
                    b.this.Cj();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int am = am(downloadData.getId(), downloadData.getName());
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, am, am + "%", downloadData.getName(), fp(downloadData.getAction()), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent fp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.getInst(), 0, intent, 0);
    }

    public boolean fq(String str) {
        for (DownloadData downloadData : e.Cl().jO()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int am(String str, String str2) {
        long an = an(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (an <= j) {
            return (int) ((100 * an) / j);
        }
        return 0;
    }

    public void fr(String str) {
        if (!StringUtils.isNull(str)) {
            e.Cl().ft(str);
        }
    }

    public long an(String str, String str2) {
        File dd = k.dd(str + "_" + str2 + ".tmp");
        if (dd != null && dd.exists() && dd.isFile()) {
            return dd.length();
        }
        return -1L;
    }

    public boolean fs(String str) {
        return (TextUtils.isEmpty(str) || k.dd(new StringBuilder().append(str.replace(".", "_")).append(".apk").toString()) == null) ? false : true;
    }
}
