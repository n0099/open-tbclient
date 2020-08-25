package com.baidu.tbadk.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private static b eJY = null;
    private static DownloadData eKa = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private final int MAX = 5;
    private a eJZ = null;

    private b() {
    }

    public static b bro() {
        synchronized (b.class) {
            if (eJY == null) {
                eJY = new b();
            }
        }
        return eJY;
    }

    public void a(String str, String str2, String str3, String[] strArr) {
        a(str, str2, str3, -1, (int) com.baidu.adp.lib.f.b.toLong(str, 0L), null, true, false, true);
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
            List<DownloadData> downloadList = d.brr().getDownloadList();
            if (downloadList != null && downloadList.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), R.string.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            brp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brp() {
        if (eKa == null) {
            eKa = (DownloadData) y.getItem(mTaskList, 0);
            if (eKa != null) {
                this.eJZ = new a();
                this.eJZ.setPriority(3);
                this.eJZ.execute(eKa);
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

    public void bb(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void L(ArrayList<AdvertAppInfo> arrayList) {
        try {
            new C0551b().execute(arrayList);
        } catch (Exception e) {
        }
    }

    /* renamed from: com.baidu.tbadk.download.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0551b extends BdAsyncTask<ArrayList<AdvertAppInfo>, List<DownloadData>, List<DownloadData>> {
        ArrayList<AdvertAppInfo> eKc;

        private C0551b() {
            this.eKc = null;
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
            this.eKc = arrayList;
            Iterator<AdvertAppInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                String str = next.dWi;
                if (n.GetFile(b.this.getFileOfUrl(next.apkUrl)) != null) {
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
        /* renamed from: y */
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute(list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : d.brr().getDownloadList()) {
                Iterator<AdvertAppInfo> it = this.eKc.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().dWi, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            b.this.bb(list);
            this.eKc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getFilePath(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(n.getCacheDir());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
                if (!at.isEmpty(id) && !at.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = id.replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk";
                    String filePath = b.this.getFilePath(str);
                    File GetFile = n.GetFile(str);
                    if (isForceDownload || GetFile == null) {
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
            b.this.eJZ = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    b.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + ".apk");
                    }
                } else {
                    d.brr().a(downloadData, 5);
                    int dJ = b.this.dJ(downloadData.getId(), downloadData.getName());
                    if (downloadData.isNeedNotify() && dJ <= 0) {
                        String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                        NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + string, 0, string, downloadData.getName(), b.this.BH(downloadData.getAction()), false);
                    } else {
                        b.this.c(downloadData);
                    }
                }
                DownloadData unused = b.eKa = null;
                if (!b.mTaskList.isEmpty()) {
                    b.mTaskList.remove(0);
                    b.this.brp();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int dJ = dJ(downloadData.getId(), downloadData.getName());
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, dJ, dJ + "%", downloadData.getName(), BH(downloadData.getAction()), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent BH(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.getInst(), 0, intent, 0);
    }

    public boolean BI(String str) {
        for (DownloadData downloadData : d.brr().getDownloadList()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int dJ(String str, String str2) {
        long dK = dK(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences(SharedPrefConfig.APP_DOWNLOAD_PROGRESS, 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (dK <= j) {
            return (int) ((100 * dK) / j);
        }
        return 0;
    }

    public void BJ(String str) {
        if (!StringUtils.isNull(str)) {
            d.brr().cancelDownLoadByUrl(str);
        }
    }

    public long dK(String str, String str2) {
        File GetFile = n.GetFile(str + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + str2 + ".tmp");
        if (GetFile != null && GetFile.exists() && GetFile.isFile()) {
            return GetFile.length();
        }
        return -1L;
    }

    public boolean BK(String str) {
        return (TextUtils.isEmpty(str) || n.GetFile(new StringBuilder().append(str.replace(".", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)).append(".apk").toString()) == null) ? false : true;
    }
}
