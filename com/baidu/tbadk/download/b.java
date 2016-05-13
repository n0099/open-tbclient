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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.t;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b aoI = null;
    private static DownloadData aoL = null;
    private static List<DownloadData> aoM = new LinkedList();
    private final int aoJ = 5;
    private a aoK = null;

    private b() {
    }

    public static b AR() {
        synchronized (b.class) {
            if (aoI == null) {
                aoI = new b();
            }
        }
        return aoI;
    }

    public void a(String str, String str2, String str3, String[] strArr) {
        a(str, str2, str3, -1, (int) com.baidu.adp.lib.h.b.c(str, 0L), null, true, false, true);
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
            List<DownloadData> hZ = e.AU().hZ();
            if (hZ != null && hZ.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.m11getInst().getApp().getString(t.j.download_fail_over_max));
                h(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.m11getInst(), t.j.download_fail_over_max);
                return;
            }
            aoM.add(downloadData);
            AS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AS() {
        if (aoL == null && !aoM.isEmpty()) {
            aoL = aoM.get(0);
            if (aoL != null) {
                this.aoK = new a(this, null);
                this.aoK.setPriority(3);
                this.aoK.execute(aoL);
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

    public void v(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void n(ArrayList<com.baidu.tbadk.core.data.c> arrayList) {
        try {
            new C0039b(this, null).execute(arrayList);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.download.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0039b extends BdAsyncTask<ArrayList<com.baidu.tbadk.core.data.c>, List<DownloadData>, List<DownloadData>> {
        ArrayList<com.baidu.tbadk.core.data.c> aoO;

        private C0039b() {
            this.aoO = null;
        }

        /* synthetic */ C0039b(b bVar, C0039b c0039b) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public List<DownloadData> doInBackground(ArrayList<com.baidu.tbadk.core.data.c>... arrayListArr) {
            ArrayList<com.baidu.tbadk.core.data.c> arrayList = arrayListArr[0];
            LinkedList linkedList = new LinkedList();
            if (arrayList == null) {
                return linkedList;
            }
            this.aoO = arrayList;
            Iterator<com.baidu.tbadk.core.data.c> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.data.c next = it.next();
                String str = next.MS;
                if (m.cS(b.this.getFileOfUrl(next.MR)) != null) {
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
            for (DownloadData downloadData : e.AU().hZ()) {
                Iterator<com.baidu.tbadk.core.data.c> it = this.aoO.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().MS, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            b.this.v(list);
            this.aoO = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String az(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(m.getCacheDir());
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
                if (!ay.isEmpty(id) && !ay.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = String.valueOf(id.replace(".", "_")) + ".apk";
                    String az = b.this.az(str);
                    File cS = m.cS(str);
                    if (isForceDownload || cS == null) {
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
        /* renamed from: l */
        public void onPostExecute(DownloadData downloadData) {
            super.onPostExecute(downloadData);
            b.this.aoK = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    b.this.h(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.m11getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
                    }
                } else {
                    e.AU().a(downloadData, 5);
                    int al = b.this.al(downloadData.getId(), downloadData.getName());
                    if (downloadData.isNeedNotify() && al <= 0) {
                        String string = TbadkCoreApplication.m11getInst().getApp().getResources().getString(t.j.download_will_begin);
                        NotificationHelper.showProgressNotification(TbadkCoreApplication.m11getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + string, 0, string, downloadData.getName(), b.this.eZ(downloadData.getAction()), false);
                    } else {
                        b.this.i(downloadData);
                    }
                }
                b.aoL = null;
                if (!b.aoM.isEmpty()) {
                    b.aoM.remove(0);
                    b.this.AS();
                }
            }
        }
    }

    public void i(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int al = al(downloadData.getId(), downloadData.getName());
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m11getInst().getApp(), downloadData.getNotifyId(), null, al, String.valueOf(al) + "%", downloadData.getName(), eZ(downloadData.getAction()), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent eZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.m11getInst(), 0, intent, 0);
    }

    public void j(DownloadData downloadData) {
        String string;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.m11getInst().getString(t.j.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m11getInst().getString(t.j.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m11getInst().getString(t.j.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m11getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m11getInst().getApp().getResources().getString(t.j.download_fail_tip), process, String.valueOf(process) + "%", string, eZ(downloadData.getAction()), false);
            }
        }
    }

    public boolean fa(String str) {
        for (DownloadData downloadData : e.AU().hZ()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int al(String str, String str2) {
        long an = an(str, str2);
        long j = TbadkCoreApplication.m11getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (an <= j) {
            return (int) ((an * 100) / j);
        }
        return 0;
    }

    public boolean fb(String str) {
        for (DownloadData downloadData : e.AU().hZ()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void e(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : e.AU().hZ()) {
                if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                    downloadData = downloadData2;
                }
            }
            if (z) {
                e.AU().r(str, true);
            } else {
                e.AU().fe(str);
            }
            if (downloadData != null) {
                int al = al(downloadData.getId(), downloadData.getName());
                String str3 = String.valueOf(al) + "%";
                if (downloadData != null && al >= 0) {
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.m11getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m11getInst().getApp().getResources().getString(t.j.download_cancel), al, str3, String.valueOf(downloadData.getName()) + TbadkCoreApplication.m11getInst().getApp().getResources().getString(t.j.download_cancel), eZ(downloadData.getAction()), false);
                }
            }
        }
    }

    public void fc(String str) {
        if (!StringUtils.isNull(str)) {
            e.AU().fe(str);
        }
    }

    public boolean am(String str, String str2) {
        File cS;
        return TbadkCoreApplication.m11getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (cS = m.cS(new StringBuilder(String.valueOf(str)).append("_").append(str2).append(".tmp").toString())) != null && cS.exists() && cS.isFile();
    }

    public long an(String str, String str2) {
        File cS = m.cS(String.valueOf(str) + "_" + str2 + ".tmp");
        if (cS != null && cS.exists() && cS.isFile()) {
            return cS.length();
        }
        return -1L;
    }

    public boolean fd(String str) {
        return (TextUtils.isEmpty(str) || m.cS(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }
}
