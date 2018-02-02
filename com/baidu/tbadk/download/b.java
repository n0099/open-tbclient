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
    private static b bpA = null;
    private static DownloadData bpD = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private final int bpB = 5;
    private a bpC = null;

    private b() {
    }

    public static b Kl() {
        synchronized (b.class) {
            if (bpA == null) {
                bpA = new b();
            }
        }
        return bpA;
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
            List<DownloadData> rl = e.Ko().rl();
            if (rl != null && rl.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(d.j.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), d.j.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            Km();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Km() {
        if (bpD == null) {
            bpD = (DownloadData) v.f(mTaskList, 0);
            if (bpD != null) {
                this.bpC = new a();
                this.bpC.setPriority(3);
                this.bpC.execute(bpD);
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

    public void H(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void p(ArrayList<AdvertAppInfo> arrayList) {
        try {
            new C0081b().execute(arrayList);
        } catch (Exception e) {
        }
    }

    /* renamed from: com.baidu.tbadk.download.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0081b extends BdAsyncTask<ArrayList<AdvertAppInfo>, List<DownloadData>, List<DownloadData>> {
        ArrayList<AdvertAppInfo> bpF;

        private C0081b() {
            this.bpF = null;
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
            this.bpF = arrayList;
            Iterator<AdvertAppInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                String str = next.aJr;
                if (k.dr(b.this.getFileOfUrl(next.aJq)) != null) {
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
        /* renamed from: w */
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute(list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : e.Ko().rl()) {
                Iterator<AdvertAppInfo> it = this.bpF.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().aJr, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            b.this.H(list);
            this.bpF = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aH(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(k.BC());
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
                    String aH = b.this.aH(str);
                    File dr = k.dr(str);
                    if (isForceDownload || dr == null) {
                        downloadData.setCallback(new com.baidu.tbadk.download.a());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(aH);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(aH);
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
            b.this.bpC = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    b.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", "_") + ".apk");
                    }
                } else {
                    e.Ko().a(downloadData, 5);
                    int ak = b.this.ak(downloadData.getId(), downloadData.getName());
                    if (downloadData.isNeedNotify() && ak <= 0) {
                        String string = TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.download_will_begin);
                        NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + string, 0, string, downloadData.getName(), b.this.fS(downloadData.getAction()), false);
                    } else {
                        b.this.c(downloadData);
                    }
                }
                DownloadData unused = b.bpD = null;
                if (!b.mTaskList.isEmpty()) {
                    b.mTaskList.remove(0);
                    b.this.Km();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int ak = ak(downloadData.getId(), downloadData.getName());
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, ak, ak + "%", downloadData.getName(), fS(downloadData.getAction()), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent fS(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.getInst(), 0, intent, 0);
    }

    public boolean fT(String str) {
        for (DownloadData downloadData : e.Ko().rl()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int ak(String str, String str2) {
        long al = al(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (al <= j) {
            return (int) ((100 * al) / j);
        }
        return 0;
    }

    public void fU(String str) {
        if (!StringUtils.isNull(str)) {
            e.Ko().fW(str);
        }
    }

    public long al(String str, String str2) {
        File dr = k.dr(str + "_" + str2 + ".tmp");
        if (dr != null && dr.exists() && dr.isFile()) {
            return dr.length();
        }
        return -1L;
    }

    public boolean fV(String str) {
        return (TextUtils.isEmpty(str) || k.dr(new StringBuilder().append(str.replace(".", "_")).append(".apk").toString()) == null) ? false : true;
    }
}
