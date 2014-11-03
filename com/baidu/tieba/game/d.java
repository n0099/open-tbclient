package com.baidu.tieba.game;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<f, DownloadData, DownloadData> {
    final /* synthetic */ c aGR;

    private d(c cVar) {
        this.aGR = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(c cVar, d dVar) {
        this(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public DownloadData doInBackground(f... fVarArr) {
        String aq;
        f fVar = fVarArr[0];
        String key = fVar.getKey();
        String name = fVar.getName();
        String url = fVar.getUrl();
        String tag = fVar.getTag();
        if (com.baidu.tbadk.core.util.az.aA(key) || com.baidu.tbadk.core.util.az.aA(name)) {
            return null;
        }
        String str = String.valueOf(key) + ".apk";
        aq = this.aGR.aq(str);
        if (com.baidu.tbadk.core.util.s.br(str) != null) {
            DownloadData downloadData = new DownloadData(key);
            downloadData.setName(str);
            downloadData.setPath(aq);
            downloadData.setStatus(3);
            downloadData.setTag(tag);
            return downloadData;
        }
        DownloadData downloadData2 = new DownloadData(key, name, url, new b());
        downloadData2.setNotifyId((int) com.baidu.adp.lib.g.c.a(downloadData2.getId(), 0L));
        downloadData2.setStatusMsg(TbadkApplication.getCurrentAccount());
        downloadData2.setType(12);
        downloadData2.setPath(aq);
        downloadData2.setTag(tag);
        return downloadData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(DownloadData downloadData) {
        List list;
        List list2;
        super.onPostExecute(downloadData);
        this.aGR.aGO = null;
        if (downloadData != null) {
            if (downloadData.getStatus() == 3) {
                this.aGR.a(downloadData);
                UtilHelper.install_apk(com.baidu.tieba.aj.wm().getApp(), String.valueOf(downloadData.getId()) + ".apk");
            } else {
                com.baidu.tbadk.download.g.rm().a(downloadData, 10);
                NotificationHelper.showProgressNotification(com.baidu.tieba.aj.wm().getApp(), downloadData.getNotifyId(), null, 0, com.baidu.tieba.aj.wm().getApp().getString(com.baidu.tieba.y.download_will_begin), downloadData.getName(), false);
            }
            c.aGQ = null;
            list = c.Re;
            if (!list.isEmpty()) {
                list2 = c.Re;
                list2.remove(0);
                this.aGR.rk();
            }
        }
    }
}
