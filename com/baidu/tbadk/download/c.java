package com.baidu.tbadk.download;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.o;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<e, DownloadData, DownloadData> {
    final /* synthetic */ b aiT;

    private c(b bVar) {
        this.aiT = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(b bVar, c cVar) {
        this(bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public DownloadData doInBackground(e... eVarArr) {
        String aJ;
        e eVar = eVarArr[0];
        String key = eVar.getKey();
        String name = eVar.getName();
        String url = eVar.getUrl();
        int position = eVar.getPosition();
        int zi = eVar.zi();
        if (bb.isEmpty(key) || bb.isEmpty(name)) {
            return null;
        }
        String str = String.valueOf(key.replace(".", "_")) + ".apk";
        aJ = this.aiT.aJ(str);
        if (o.cB(str) != null) {
            DownloadData downloadData = new DownloadData(key);
            downloadData.setName(str);
            downloadData.setPosition(position);
            downloadData.setPath(aJ);
            downloadData.setStatus(3);
            return downloadData;
        }
        DownloadData downloadData2 = new DownloadData(key, name, url, new a());
        downloadData2.setNotifyId(zi);
        downloadData2.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
        downloadData2.setType(12);
        downloadData2.setPath(aJ);
        downloadData2.setPosition(position);
        return downloadData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public void onPostExecute(DownloadData downloadData) {
        List list;
        List list2;
        super.onPostExecute(downloadData);
        this.aiT.aiP = null;
        if (downloadData != null) {
            if (downloadData.getStatus() == 3) {
                this.aiT.e(downloadData);
                UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
            } else {
                downloadData.setStatus(1);
                this.aiT.e(downloadData);
                g.zj().a(downloadData, 5);
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), null, 0, TbadkCoreApplication.m411getInst().getApp().getString(t.download_will_begin), downloadData.getName(), true);
            }
            b.aiR = null;
            list = b.aiS;
            if (!list.isEmpty()) {
                list2 = b.aiS;
                list2.remove(0);
                this.aiT.zg();
            }
        }
    }
}
