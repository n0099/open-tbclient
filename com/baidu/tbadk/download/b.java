package com.baidu.tbadk.download;

import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b aof = null;
    private static c aoj = null;
    private static List<c> aok = new LinkedList();
    private final int max = 5;
    private int aog = 0;
    private a aoh = null;
    private C0045b aoi = null;

    private b() {
    }

    public static b An() {
        synchronized (b.class) {
            if (aof == null) {
                aof = new b();
            }
        }
        return aof;
    }

    public void a(String str, String str2, String str3, int i, int i2) {
        a(str, str2, str3, i, i2, true, false, true);
    }

    public void a(String str, String str2, String str3, int i, int i2, boolean z, boolean z2, boolean z3) {
        if (this.aog >= 5) {
            Toast.makeText(TbadkCoreApplication.m411getInst(), i.h.download_fail_over_max, 0).show();
            return;
        }
        DownloadData downloadData = new DownloadData(str);
        downloadData.setType(12);
        downloadData.setNeedInvokeApk(z);
        downloadData.setForceDownload(z2);
        this.aog++;
        downloadData.setStatus(1);
        downloadData.setStatusMsg(null);
        downloadData.setNotifyId(i2);
        downloadData.setNeedNotify(z3);
        e(downloadData);
        c cVar = new c();
        cVar.setKey(str);
        cVar.setUrl(str2);
        cVar.setName(str3);
        cVar.setPosition(i);
        cVar.dO(i2);
        cVar.setNeedInvokeApk(z);
        cVar.bc(z2);
        cVar.setNeedNotify(z3);
        aok.add(cVar);
        Ao();
    }

    public void eG(String str) {
        if (!StringUtils.isNull(str)) {
            d.As().eJ(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ao() {
        if (aoj == null && !aok.isEmpty()) {
            aoj = aok.get(0);
            if (aoj != null) {
                this.aoh = new a(this, null);
                this.aoh.setPriority(3);
                this.aoh.execute(aoj);
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

    public void e(DownloadData downloadData) {
        if (downloadData.getStatus() != 1 && downloadData.getStatus() != 5) {
            this.aog--;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void n(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void o(ArrayList<com.baidu.tbadk.core.data.b> arrayList) {
        this.aoi = new C0045b(this, null);
        this.aoi.execute(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.download.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0045b extends BdAsyncTask<ArrayList<com.baidu.tbadk.core.data.b>, List<DownloadData>, List<DownloadData>> {
        ArrayList<com.baidu.tbadk.core.data.b> aom;

        private C0045b() {
            this.aom = null;
        }

        /* synthetic */ C0045b(b bVar, C0045b c0045b) {
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
            this.aom = arrayList;
            Iterator<com.baidu.tbadk.core.data.b> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.data.b next = it.next();
                String str = next.Ua;
                if (n.cJ(b.this.getFileOfUrl(next.TZ)) != null) {
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
            for (DownloadData downloadData : d.As().me()) {
                Iterator<com.baidu.tbadk.core.data.b> it = this.aom.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().Ua, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            b.this.n(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aD(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(n.tD());
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
    public class a extends BdAsyncTask<c, DownloadData, DownloadData> {
        private a() {
        }

        /* synthetic */ a(b bVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public DownloadData doInBackground(c... cVarArr) {
            c cVar = cVarArr[0];
            String key = cVar.getKey();
            String name = cVar.getName();
            String url = cVar.getUrl();
            int position = cVar.getPosition();
            int Aq = cVar.Aq();
            boolean isNeedInvokeApk = cVar.isNeedInvokeApk();
            boolean Ar = cVar.Ar();
            boolean isNeedNotify = cVar.isNeedNotify();
            if (as.isEmpty(key) || as.isEmpty(name)) {
                return null;
            }
            String str = String.valueOf(key.replace(".", "_")) + ".apk";
            String aD = b.this.aD(str);
            if (Ar) {
                DownloadData downloadData = new DownloadData(key, name, url, new com.baidu.tbadk.download.a());
                downloadData.setNotifyId(Aq);
                downloadData.setNeedInvokeApk(isNeedInvokeApk);
                downloadData.setNeedNotify(isNeedNotify);
                downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                downloadData.setType(12);
                downloadData.setPath(aD);
                downloadData.setPosition(position);
                return downloadData;
            } else if (n.cJ(str) != null) {
                DownloadData downloadData2 = new DownloadData(key);
                downloadData2.setName(str);
                downloadData2.setNeedInvokeApk(isNeedInvokeApk);
                downloadData2.setNeedNotify(isNeedNotify);
                downloadData2.setPosition(position);
                downloadData2.setPath(aD);
                downloadData2.setStatus(3);
                return downloadData2;
            } else {
                DownloadData downloadData3 = new DownloadData(key, name, url, new com.baidu.tbadk.download.a());
                downloadData3.setNotifyId(Aq);
                downloadData3.setNeedInvokeApk(isNeedInvokeApk);
                downloadData3.setNeedNotify(isNeedNotify);
                downloadData3.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                downloadData3.setType(12);
                downloadData3.setPath(aD);
                downloadData3.setPosition(position);
                return downloadData3;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public void onPostExecute(DownloadData downloadData) {
            super.onPostExecute(downloadData);
            b.this.aoh = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    b.this.e(downloadData);
                    if (downloadData.isNeedInvokeApk()) {
                        UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
                    }
                } else {
                    downloadData.setStatus(1);
                    b.this.e(downloadData);
                    d.As().a(downloadData, 5);
                    if (downloadData.isNeedNotify()) {
                        NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), null, 0, TbadkCoreApplication.m411getInst().getApp().getString(i.h.download_will_begin), downloadData.getName(), true);
                    }
                }
                b.aoj = null;
                if (!b.aok.isEmpty()) {
                    b.aok.remove(0);
                    b.this.Ao();
                }
            }
        }
    }

    public void f(DownloadData downloadData) {
        if (downloadData != null && downloadData.isNeedNotify()) {
            int process = downloadData.getProcess();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(i.h.download_will_begin), process, String.valueOf(process) + "%", downloadData.getName(), true);
        }
    }

    public void g(DownloadData downloadData) {
        String string;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.m411getInst().getString(i.h.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m411getInst().getString(i.h.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m411getInst().getString(i.h.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(i.h.download_fail_tip), process, String.valueOf(process) + "%", string, false);
            }
        }
    }

    public boolean eH(String str) {
        for (DownloadData downloadData : d.As().me()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean eI(String str) {
        return (TextUtils.isEmpty(str) || n.cJ(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }

    /* loaded from: classes.dex */
    public class c {
        private int aon;
        private String key;
        private String name;
        private int position;
        private String url;
        private boolean isNeedInvokeApk = true;
        private boolean aoo = false;
        private boolean isNeedNotify = true;

        public c() {
        }

        public void setKey(String str) {
            this.key = str;
        }

        public String getKey() {
            return this.key;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public String getUrl() {
            return this.url;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }

        public void setPosition(int i) {
            this.position = i;
        }

        public int getPosition() {
            return this.position;
        }

        public int Aq() {
            return this.aon;
        }

        public void dO(int i) {
            this.aon = i;
        }

        public boolean isNeedInvokeApk() {
            return this.isNeedInvokeApk;
        }

        public void setNeedInvokeApk(boolean z) {
            this.isNeedInvokeApk = z;
        }

        public boolean Ar() {
            return this.aoo;
        }

        public void bc(boolean z) {
            this.aoo = z;
        }

        public boolean isNeedNotify() {
            return this.isNeedNotify;
        }

        public void setNeedNotify(boolean z) {
            this.isNeedNotify = z;
        }
    }
}
