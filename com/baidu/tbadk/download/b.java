package com.baidu.tbadk.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b aUk = null;
    private static DownloadData aUn = null;
    private static List<DownloadData> mTaskList = new LinkedList();
    private final int aUl = 5;
    private a aUm = null;

    private b() {
    }

    public static b KL() {
        synchronized (b.class) {
            if (aUk == null) {
                aUk = new b();
            }
        }
        return aUk;
    }

    public void a(String str, String str2, String str3, String[] strArr) {
        a(str, str2, str3, -1, (int) com.baidu.adp.lib.g.b.d(str, 0L), null, true, false, true);
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
            List<DownloadData> nu = d.KN().nu();
            if (nu != null && nu.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(e.j.download_fail_over_max));
                b(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), e.j.download_fail_over_max);
                return;
            }
            mTaskList.add(downloadData);
            KM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KM() {
        if (aUn == null) {
            aUn = (DownloadData) v.d(mTaskList, 0);
            if (aUn != null) {
                this.aUm = new a();
                this.aUm.setPriority(3);
                this.aUm.execute(aUn);
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

    public void O(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void s(ArrayList<AdvertAppInfo> arrayList) {
        try {
            new C0157b().execute(arrayList);
        } catch (Exception e) {
        }
    }

    /* renamed from: com.baidu.tbadk.download.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0157b extends BdAsyncTask<ArrayList<AdvertAppInfo>, List<DownloadData>, List<DownloadData>> {
        ArrayList<AdvertAppInfo> aUp;

        private C0157b() {
            this.aUp = null;
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
            this.aUp = arrayList;
            Iterator<AdvertAppInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AdvertAppInfo next = it.next();
                String str = next.alU;
                if (l.eC(b.this.getFileOfUrl(next.alT)) != null) {
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
            for (DownloadData downloadData : d.KN().nu()) {
                Iterator<AdvertAppInfo> it = this.aUp.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().alU, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            b.this.O(list);
            this.aUp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bj(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(l.getCacheDir());
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
                if (!ao.isEmpty(id) && !ao.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = id.replace(".", BaseRequestAction.SPLITE) + ".apk";
                    String bj = b.this.bj(str);
                    File eC = l.eC(str);
                    if (isForceDownload || eC == null) {
                        downloadData.setCallback(new com.baidu.tbadk.download.a());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(bj);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(bj);
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
            b.this.aUm = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    b.this.b(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", BaseRequestAction.SPLITE) + ".apk");
                    }
                } else {
                    d.KN().a(downloadData, 5);
                    int aG = b.this.aG(downloadData.getId(), downloadData.getName());
                    if (downloadData.isNeedNotify() && aG <= 0) {
                        String string = TbadkCoreApplication.getInst().getApp().getResources().getString(e.j.download_will_begin);
                        NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + string, 0, string, downloadData.getName(), b.this.he(downloadData.getAction()), false);
                    } else {
                        b.this.c(downloadData);
                    }
                }
                DownloadData unused = b.aUn = null;
                if (!b.mTaskList.isEmpty()) {
                    b.mTaskList.remove(0);
                    b.this.KM();
                }
            }
        }
    }

    public void c(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int aG = aG(downloadData.getId(), downloadData.getName());
            NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, aG, aG + "%", downloadData.getName(), he(downloadData.getAction()), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent he(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.getInst(), 0, intent, 0);
    }

    public boolean hf(String str) {
        for (DownloadData downloadData : d.KN().nu()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int aG(String str, String str2) {
        long aH = aH(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (aH <= j) {
            return (int) ((100 * aH) / j);
        }
        return 0;
    }

    public void hg(String str) {
        if (!StringUtils.isNull(str)) {
            d.KN().hi(str);
        }
    }

    public long aH(String str, String str2) {
        File eC = l.eC(str + BaseRequestAction.SPLITE + str2 + ".tmp");
        if (eC != null && eC.exists() && eC.isFile()) {
            return eC.length();
        }
        return -1L;
    }

    public boolean hh(String str) {
        return (TextUtils.isEmpty(str) || l.eC(new StringBuilder().append(str.replace(".", BaseRequestAction.SPLITE)).append(".apk").toString()) == null) ? false : true;
    }
}
