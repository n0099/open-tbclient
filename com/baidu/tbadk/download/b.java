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
    private static b anU = null;
    private static c anY = null;
    private static List<c> anZ = new LinkedList();
    private final int max = 5;
    private int anV = 0;
    private a anW = null;
    private C0046b anX = null;

    private b() {
    }

    public static b Ap() {
        synchronized (b.class) {
            if (anU == null) {
                anU = new b();
            }
        }
        return anU;
    }

    public void a(String str, String str2, String str3, int i, int i2) {
        if (this.anV >= 5) {
            Toast.makeText(TbadkCoreApplication.m411getInst(), i.C0057i.download_fail_over_max, 0).show();
            return;
        }
        DownloadData downloadData = new DownloadData(str);
        downloadData.setType(12);
        this.anV++;
        downloadData.setStatus(1);
        downloadData.setStatusMsg(null);
        downloadData.setNotifyId(i2);
        e(downloadData);
        c cVar = new c();
        cVar.setKey(str);
        cVar.setUrl(str2);
        cVar.setName(str3);
        cVar.setPosition(i);
        cVar.dF(i2);
        anZ.add(cVar);
        Aq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aq() {
        if (anY == null && !anZ.isEmpty()) {
            anY = anZ.get(0);
            if (anY != null) {
                this.anW = new a(this, null);
                this.anW.setPriority(3);
                this.anW.execute(anY);
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
            this.anV--;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void m(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void p(ArrayList<com.baidu.tbadk.core.data.c> arrayList) {
        this.anX = new C0046b(this, null);
        this.anX.execute(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tbadk.download.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0046b extends BdAsyncTask<ArrayList<com.baidu.tbadk.core.data.c>, List<DownloadData>, List<DownloadData>> {
        ArrayList<com.baidu.tbadk.core.data.c> aob;

        private C0046b() {
            this.aob = null;
        }

        /* synthetic */ C0046b(b bVar, C0046b c0046b) {
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
            this.aob = arrayList;
            Iterator<com.baidu.tbadk.core.data.c> it = arrayList.iterator();
            while (it.hasNext()) {
                com.baidu.tbadk.core.data.c next = it.next();
                String str = next.Um;
                if (n.cC(b.this.getFileOfUrl(next.Ul)) != null) {
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
        /* renamed from: n */
        public void onPostExecute(List<DownloadData> list) {
            super.onPostExecute(list);
            if (list == null) {
                list = new LinkedList<>();
            }
            for (DownloadData downloadData : d.At().mg()) {
                Iterator<com.baidu.tbadk.core.data.c> it = this.aob.iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().Um, downloadData.getId())) {
                        list.add(downloadData);
                    }
                }
            }
            b.this.m(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aD(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(n.tA());
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
            int As = cVar.As();
            if (aq.isEmpty(key) || aq.isEmpty(name)) {
                return null;
            }
            String str = String.valueOf(key.replace(".", "_")) + ".apk";
            String aD = b.this.aD(str);
            if (n.cC(str) != null) {
                DownloadData downloadData = new DownloadData(key);
                downloadData.setName(str);
                downloadData.setPosition(position);
                downloadData.setPath(aD);
                downloadData.setStatus(3);
                return downloadData;
            }
            DownloadData downloadData2 = new DownloadData(key, name, url, new com.baidu.tbadk.download.a());
            downloadData2.setNotifyId(As);
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
            b.this.anW = null;
            if (downloadData != null) {
                if (downloadData.getStatus() == 3) {
                    b.this.e(downloadData);
                    UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
                } else {
                    downloadData.setStatus(1);
                    b.this.e(downloadData);
                    d.At().a(downloadData, 5);
                    NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), null, 0, TbadkCoreApplication.m411getInst().getApp().getString(i.C0057i.download_will_begin), downloadData.getName(), true);
                }
                b.anY = null;
                if (!b.anZ.isEmpty()) {
                    b.anZ.remove(0);
                    b.this.Aq();
                }
            }
        }
    }

    public void f(DownloadData downloadData) {
        if (downloadData != null) {
            int process = downloadData.getProcess();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(i.C0057i.download_will_begin), process, String.valueOf(process) + "%", downloadData.getName(), true);
        }
    }

    public void g(DownloadData downloadData) {
        String string;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.m411getInst().getString(i.C0057i.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m411getInst().getString(i.C0057i.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m411getInst().getString(i.C0057i.download_fail_tip_net);
                    break;
            }
            int process = downloadData.getProcess();
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(i.C0057i.download_fail_tip), process, String.valueOf(process) + "%", string, false);
        }
    }

    public boolean eu(String str) {
        for (DownloadData downloadData : d.At().mg()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean ev(String str) {
        return (TextUtils.isEmpty(str) || n.cC(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }

    /* loaded from: classes.dex */
    public class c {
        private int aoc;
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

        public int As() {
            return this.aoc;
        }

        public void dF(int i) {
            this.aoc = i;
        }
    }
}
