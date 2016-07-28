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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.u;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b aqm = null;
    private static DownloadData aqp = null;
    private static List<DownloadData> aqq = new LinkedList();
    private final int aqn = 5;
    private a aqo = null;

    private b() {
    }

    public static b Ba() {
        synchronized (b.class) {
            if (aqm == null) {
                aqm = new b();
            }
        }
        return aqm;
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
            List<DownloadData> ia = e.Bd().ia();
            if (ia != null && ia.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.m10getInst().getApp().getString(u.j.download_fail_over_max));
                h(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.m10getInst(), u.j.download_fail_over_max);
                return;
            }
            aqq.add(downloadData);
            Bb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bb() {
        if (aqp == null && !aqq.isEmpty()) {
            aqp = aqq.get(0);
            if (aqp != null) {
                this.aqo = new a(this, null);
                this.aqo.setPriority(3);
                this.aqo.execute(aqp);
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

    public void w(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void o(ArrayList<com.baidu.tbadk.core.data.b> arrayList) {
        try {
            new C0040b(this, null).execute(arrayList);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.download.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0040b extends BdAsyncTask<ArrayList<com.baidu.tbadk.core.data.b>, List<DownloadData>, List<DownloadData>> {
        ArrayList<com.baidu.tbadk.core.data.b> aqs;

        private C0040b() {
            this.aqs = null;
        }

        /* synthetic */ C0040b(b bVar, C0040b c0040b) {
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
            this.aqs = arrayList;
            Iterator<com.baidu.tbadk.core.data.b> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.data.b next = it.next();
                String str = next.MK;
                if (m.cR(b.this.getFileOfUrl(next.MI)) != null) {
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
        /* renamed from: x */
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute(list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : e.Bd().ia()) {
                Iterator<com.baidu.tbadk.core.data.b> it = this.aqs.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().MK, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            b.this.w(list);
            this.aqs = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aB(String str) {
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
                if (!ba.isEmpty(id) && !ba.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = String.valueOf(id.replace(".", "_")) + ".apk";
                    String aB = b.this.aB(str);
                    File cR = m.cR(str);
                    if (isForceDownload || cR == null) {
                        downloadData.setCallback(new com.baidu.tbadk.download.a());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(aB);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(aB);
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
            b.this.aqo = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    b.this.h(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.m10getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
                    }
                } else {
                    e.Bd().a(downloadData, 5);
                    int ak = b.this.ak(downloadData.getId(), downloadData.getName());
                    if (downloadData.isNeedNotify() && ak <= 0) {
                        String string = TbadkCoreApplication.m10getInst().getApp().getResources().getString(u.j.download_will_begin);
                        NotificationHelper.showProgressNotification(TbadkCoreApplication.m10getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + string, 0, string, downloadData.getName(), b.this.fd(downloadData.getAction()), false);
                    } else {
                        b.this.i(downloadData);
                    }
                }
                b.aqp = null;
                if (!b.aqq.isEmpty()) {
                    b.aqq.remove(0);
                    b.this.Bb();
                }
            }
        }
    }

    public void i(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int ak = ak(downloadData.getId(), downloadData.getName());
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m10getInst().getApp(), downloadData.getNotifyId(), null, ak, String.valueOf(ak) + "%", downloadData.getName(), fd(downloadData.getAction()), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent fd(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.m10getInst(), 0, intent, 0);
    }

    public void j(DownloadData downloadData) {
        String string;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.m10getInst().getString(u.j.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m10getInst().getString(u.j.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m10getInst().getString(u.j.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m10getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m10getInst().getApp().getResources().getString(u.j.download_fail_tip), process, String.valueOf(process) + "%", string, fd(downloadData.getAction()), false);
            }
        }
    }

    public boolean fe(String str) {
        for (DownloadData downloadData : e.Bd().ia()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int ak(String str, String str2) {
        long am = am(str, str2);
        long j = TbadkCoreApplication.m10getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (am <= j) {
            return (int) ((am * 100) / j);
        }
        return 0;
    }

    public boolean ff(String str) {
        for (DownloadData downloadData : e.Bd().ia()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void e(String str, String str2, boolean z) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : e.Bd().ia()) {
                if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                    downloadData = downloadData2;
                }
            }
            if (z) {
                e.Bd().r(str, true);
            } else {
                e.Bd().fi(str);
            }
            if (downloadData != null) {
                int ak = ak(downloadData.getId(), downloadData.getName());
                String str3 = String.valueOf(ak) + "%";
                if (downloadData != null && ak >= 0) {
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.m10getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m10getInst().getApp().getResources().getString(u.j.download_cancel), ak, str3, String.valueOf(downloadData.getName()) + TbadkCoreApplication.m10getInst().getApp().getResources().getString(u.j.download_cancel), fd(downloadData.getAction()), false);
                }
            }
        }
    }

    public void fg(String str) {
        if (!StringUtils.isNull(str)) {
            e.Bd().fi(str);
        }
    }

    public boolean al(String str, String str2) {
        File cR;
        return TbadkCoreApplication.m10getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (cR = m.cR(new StringBuilder(String.valueOf(str)).append("_").append(str2).append(".tmp").toString())) != null && cR.exists() && cR.isFile();
    }

    public long am(String str, String str2) {
        File cR = m.cR(String.valueOf(str) + "_" + str2 + ".tmp");
        if (cR != null && cR.exists() && cR.isFile()) {
            return cR.length();
        }
        return -1L;
    }

    public boolean fh(String str) {
        return (TextUtils.isEmpty(str) || m.cR(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }
}
