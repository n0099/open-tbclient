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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.t;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private final int asA = 5;
    private a asB = null;
    private C0048b asC = null;
    private static b asz = null;
    private static DownloadData asD = null;
    private static List<DownloadData> asE = new LinkedList();

    private b() {
    }

    public static b Cr() {
        synchronized (b.class) {
            if (asz == null) {
                asz = new b();
            }
        }
        return asz;
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
            List<DownloadData> lT = d.Cu().lT();
            if (lT != null && lT.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.m411getInst().getApp().getString(t.j.download_fail_over_max));
                h(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.m411getInst(), t.j.download_fail_over_max);
                return;
            }
            asE.add(downloadData);
            Cs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cs() {
        if (asD == null && !asE.isEmpty()) {
            asD = asE.get(0);
            if (asD != null) {
                this.asB = new a(this, null);
                this.asB.setPriority(3);
                this.asB.execute(asD);
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

    public void s(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void q(ArrayList<com.baidu.tbadk.core.data.c> arrayList) {
        this.asC = new C0048b(this, null);
        this.asC.execute(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.download.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0048b extends BdAsyncTask<ArrayList<com.baidu.tbadk.core.data.c>, List<DownloadData>, List<DownloadData>> {
        ArrayList<com.baidu.tbadk.core.data.c> asG;

        private C0048b() {
            this.asG = null;
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
            this.asG = arrayList;
            Iterator<com.baidu.tbadk.core.data.c> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.data.c next = it.next();
                String str = next.Uy;
                if (m.cR(b.this.getFileOfUrl(next.Ux)) != null) {
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
        /* renamed from: t */
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute(list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : d.Cu().lT()) {
                Iterator<com.baidu.tbadk.core.data.c> it = this.asG.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().Uy, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            b.this.s(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aE(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(m.uW());
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
                    String aE = b.this.aE(str);
                    File cR = m.cR(str);
                    if (isForceDownload || cR == null) {
                        downloadData.setCallback(new com.baidu.tbadk.download.a());
                        downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                        downloadData.setType(12);
                        downloadData.setPath(aE);
                        return downloadData;
                    }
                    DownloadData downloadData2 = new DownloadData(id);
                    downloadData2.setName(str);
                    downloadData2.setPath(aE);
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
            b.this.asB = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    b.this.h(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
                    }
                } else {
                    d.Cu().a(downloadData, 5);
                    int ah = b.this.ah(downloadData.getId(), downloadData.getName());
                    if (downloadData.isNeedNotify() && ah <= 0) {
                        String string = TbadkCoreApplication.m411getInst().getApp().getResources().getString(t.j.download_will_begin);
                        NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + string, 0, string, downloadData.getName(), b.this.eV(downloadData.getAction()), false);
                    } else {
                        b.this.i(downloadData);
                    }
                }
                b.asD = null;
                if (!b.asE.isEmpty()) {
                    b.asE.remove(0);
                    b.this.Cs();
                }
            }
        }
    }

    public void i(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int ah = ah(downloadData.getId(), downloadData.getName());
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), null, ah, String.valueOf(ah) + "%", downloadData.getName(), eV(downloadData.getAction()), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PendingIntent eV(String str) {
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
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(t.j.download_fail_tip), downloadData.getProcess(), String.valueOf(process) + "%", string, eV(downloadData.getAction()), false);
            }
        }
    }

    public boolean eW(String str) {
        for (DownloadData downloadData : d.Cu().lT()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public int ah(String str, String str2) {
        long ak = ak(str, str2);
        long j = TbadkCoreApplication.m411getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (ak <= j) {
            return (int) ((ak * 100) / j);
        }
        return 0;
    }

    public boolean eX(String str) {
        for (DownloadData downloadData : d.Cu().lT()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void ai(String str, String str2) {
        if (!StringUtils.isNull(str)) {
            DownloadData downloadData = null;
            for (DownloadData downloadData2 : d.Cu().lT()) {
                if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                    downloadData = downloadData2;
                }
            }
            d.Cu().fa(str);
            if (downloadData != null) {
                int ah = ah(downloadData.getId(), downloadData.getName());
                String str3 = String.valueOf(ah) + "%";
                if (downloadData != null && ah >= 0) {
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(t.j.download_cancel), ah, str3, String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(t.j.download_cancel), eV(downloadData.getAction()), false);
                }
            }
        }
    }

    public void eY(String str) {
        if (!StringUtils.isNull(str)) {
            d.Cu().fa(str);
        }
    }

    public boolean aj(String str, String str2) {
        File cR;
        return TbadkCoreApplication.m411getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) != 0 && (cR = m.cR(new StringBuilder(String.valueOf(str)).append("_").append(str2).append(".tmp").toString())) != null && cR.exists() && cR.isFile();
    }

    public long ak(String str, String str2) {
        File cR = m.cR(String.valueOf(str) + "_" + str2 + ".tmp");
        if (cR != null && cR.exists() && cR.isFile()) {
            return cR.length();
        }
        return -1L;
    }

    public boolean eZ(String str) {
        return (TextUtils.isEmpty(str) || m.cR(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }
}
