package com.baidu.tbadk.download;

import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b apF = null;
    private static c apJ = null;
    private static List<c> apK = new LinkedList();
    private final int max = 5;
    private int apG = 0;
    private a apH = null;
    private C0045b apI = null;

    private b() {
    }

    public static b AC() {
        synchronized (b.class) {
            if (apF == null) {
                apF = new b();
            }
        }
        return apF;
    }

    public void a(String str, String str2, String str3, int i, int i2) {
        if (this.apG >= 5) {
            Toast.makeText(TbadkCoreApplication.m411getInst(), i.h.download_fail_over_max, 0).show();
            return;
        }
        DownloadData downloadData = new DownloadData(str);
        downloadData.setType(12);
        this.apG++;
        downloadData.setStatus(1);
        downloadData.setStatusMsg(null);
        downloadData.setNotifyId(i2);
        e(downloadData);
        c cVar = new c();
        cVar.setKey(str);
        cVar.setUrl(str2);
        cVar.setName(str3);
        cVar.setPosition(i);
        cVar.dN(i2);
        apK.add(cVar);
        AD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AD() {
        if (apJ == null && !apK.isEmpty()) {
            apJ = apK.get(0);
            if (apJ != null) {
                this.apH = new a(this, null);
                this.apH.setPriority(3);
                this.apH.execute(apJ);
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
            this.apG--;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void n(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void o(ArrayList<com.baidu.tbadk.core.data.c> arrayList) {
        this.apI = new C0045b(this, null);
        this.apI.execute(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.download.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0045b extends BdAsyncTask<ArrayList<com.baidu.tbadk.core.data.c>, List<DownloadData>, List<DownloadData>> {
        ArrayList<com.baidu.tbadk.core.data.c> apM;

        private C0045b() {
            this.apM = null;
        }

        /* synthetic */ C0045b(b bVar, C0045b c0045b) {
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
            this.apM = arrayList;
            Iterator<com.baidu.tbadk.core.data.c> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.data.c next = it.next();
                String str = next.Un;
                if (n.cI(b.this.getFileOfUrl(next.Um)) != null) {
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
            for (DownloadData downloadData : d.AG().md()) {
                Iterator<com.baidu.tbadk.core.data.c> it = this.apM.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().Un, downloadData.getId())) {
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
        sb.append(n.tF());
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
            int AF = cVar.AF();
            if (aq.isEmpty(key) || aq.isEmpty(name)) {
                return null;
            }
            String str = String.valueOf(key.replace(".", "_")) + ".apk";
            String aD = b.this.aD(str);
            if (n.cI(str) != null) {
                DownloadData downloadData = new DownloadData(key);
                downloadData.setName(str);
                downloadData.setPosition(position);
                downloadData.setPath(aD);
                downloadData.setStatus(3);
                return downloadData;
            }
            DownloadData downloadData2 = new DownloadData(key, name, url, new com.baidu.tbadk.download.a());
            downloadData2.setNotifyId(AF);
            downloadData2.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
            downloadData2.setType(12);
            downloadData2.setPath(aD);
            downloadData2.setPosition(position);
            return downloadData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public void onPostExecute(DownloadData downloadData) {
            super.onPostExecute(downloadData);
            b.this.apH = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    b.this.e(downloadData);
                    UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
                } else {
                    downloadData.setStatus(1);
                    b.this.e(downloadData);
                    d.AG().a(downloadData, 5);
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), null, 0, TbadkCoreApplication.m411getInst().getApp().getString(i.h.download_will_begin), downloadData.getName(), true);
                }
                b.apJ = null;
                if (!b.apK.isEmpty()) {
                    b.apK.remove(0);
                    b.this.AD();
                }
            }
        }
    }

    public void f(DownloadData downloadData) {
        if (downloadData != null) {
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
            int process = downloadData.getProcess();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(i.h.download_fail_tip), process, String.valueOf(process) + "%", string, false);
        }
    }

    public boolean eC(String str) {
        for (DownloadData downloadData : d.AG().md()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean eD(String str) {
        return (TextUtils.isEmpty(str) || n.cI(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }

    /* loaded from: classes.dex */
    public class c {
        private int apN;
        private String key;
        private String name;
        private int position;
        private String url;

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

        public int AF() {
            return this.apN;
        }

        public void dN(int i) {
            this.apN = i;
        }
    }
}
