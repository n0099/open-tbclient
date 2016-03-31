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
    private static b asR = null;
    private static DownloadData asV = null;
    private static List<DownloadData> asW = new LinkedList();
    private final int asS = 5;
    private a asT = null;
    private C0048b asU = null;

    private b() {
    }

    public static b CX() {
        synchronized (b.class) {
            if (asR == null) {
                asR = new b();
            }
        }
        return asR;
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
            List<DownloadData> lL = e.Da().lL();
            if (lL != null && lL.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.m411getInst().getApp().getString(t.j.download_fail_over_max));
                h(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.m411getInst(), t.j.download_fail_over_max);
                return;
            }
            asW.add(downloadData);
            CY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CY() {
        if (asV == null && !asW.isEmpty()) {
            asV = asW.get(0);
            if (asV != null) {
                this.asT = new a(this, null);
                this.asT.setPriority(3);
                this.asT.execute(asV);
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

    public void t(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void n(ArrayList<com.baidu.tbadk.core.data.c> arrayList) {
        this.asU = new C0048b(this, null);
        this.asU.execute(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.download.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0048b extends BdAsyncTask<ArrayList<com.baidu.tbadk.core.data.c>, List<DownloadData>, List<DownloadData>> {
        ArrayList<com.baidu.tbadk.core.data.c> asY;

        private C0048b() {
            this.asY = null;
        }

        /* synthetic */ C0048b(b bVar, C0048b c0048b) {
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
            this.asY = arrayList;
            Iterator<com.baidu.tbadk.core.data.c> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.data.c next = it.next();
                String str = next.Se;
                if (m.cU(b.this.getFileOfUrl(next.Sd)) != null) {
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
        /* renamed from: u */
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute(list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : e.Da().lL()) {
                Iterator<com.baidu.tbadk.core.data.c> it = this.asY.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().Se, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            b.this.t(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aG(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(m.vs());
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
                    String aG = b.this.aG(str);
                    File cU = m.cU(str);
                    if (isForceDownload || cU == null) {
                        downloadData.setCallback(new com.baidu.tbadk.download.a());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(aG);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(aG);
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
            b.this.asT = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    b.this.h(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
                    }
                } else {
                    e.Da().a(downloadData, 5);
                    int al = b.this.al(downloadData.getId(), downloadData.getName());
                    if (downloadData.isNeedNotify() && al <= 0) {
                        String string = TbadkCoreApplication.m411getInst().getApp().getResources().getString(t.j.download_will_begin);
                        NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + string, 0, string, downloadData.getName(), b.this.fc(downloadData.getAction()), false);
                    } else {
                        b.this.i(downloadData);
                    }
                }
                b.asV = null;
                if (!b.asW.isEmpty()) {
                    b.asW.remove(0);
                    b.this.CY();
                }
            }
        }
    }

    public void i(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int al = al(downloadData.getId(), downloadData.getName());
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), null, al, String.valueOf(al) + "%", downloadData.getName(), fc(downloadData.getAction()), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent fc(String str) {
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
                    string = TbadkCoreApplication.m411getInst().getString(t.j.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m411getInst().getString(t.j.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m411getInst().getString(t.j.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                String str = String.valueOf(downloadData.getLength() / 1000) + "K/" + String.valueOf(downloadData.getSize() / 1000) + "K";
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(t.j.download_fail_tip), downloadData.getProcess(), String.valueOf(process) + "%", string, fc(downloadData.getAction()), false);
            }
        }
    }

    public boolean fd(String str) {
        for (DownloadData downloadData : e.Da().lL()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int al(String str, String str2) {
        long ao = ao(str, str2);
        long j = TbadkCoreApplication.m411getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (ao <= j) {
            return (int) ((ao * 100) / j);
        }
        return 0;
    }

    public boolean fe(String str) {
        for (DownloadData downloadData : e.Da().lL()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void am(String str, String str2) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : e.Da().lL()) {
                if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                    downloadData = downloadData2;
                }
            }
            e.Da().fh(str);
            if (downloadData != null) {
                int al = al(downloadData.getId(), downloadData.getName());
                String str3 = String.valueOf(al) + "%";
                if (downloadData != null && al >= 0) {
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(t.j.download_cancel), al, str3, String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(t.j.download_cancel), fc(downloadData.getAction()), false);
                }
            }
        }
    }

    public void ff(String str) {
        if (!StringUtils.isNull(str)) {
            e.Da().fh(str);
        }
    }

    public boolean an(String str, String str2) {
        File cU;
        return TbadkCoreApplication.m411getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (cU = m.cU(new StringBuilder(String.valueOf(str)).append("_").append(str2).append(".tmp").toString())) != null && cU.exists() && cU.isFile();
    }

    public long ao(String str, String str2) {
        File cU = m.cU(String.valueOf(str) + "_" + str2 + ".tmp");
        if (cU != null && cU.exists() && cU.isFile()) {
            return cU.length();
        }
        return -1L;
    }

    public boolean fg(String str) {
        return (TextUtils.isEmpty(str) || m.cU(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }
}
