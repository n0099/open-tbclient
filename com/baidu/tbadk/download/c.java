package com.baidu.tbadk.download;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.z;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<e, DownloadData, DownloadData> {
    final /* synthetic */ b XF;

    private c(b bVar) {
        this.XF = bVar;
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
        String at;
        e eVar = eVarArr[0];
        String key = eVar.getKey();
        String name = eVar.getName();
        String url = eVar.getUrl();
        int position = eVar.getPosition();
        int uY = eVar.uY();
        if (bf.isEmpty(key) || bf.isEmpty(name)) {
            return null;
        }
        String str = String.valueOf(key.replace(".", "_")) + ".apk";
        at = this.XF.at(str);
        if (s.ce(str) != null) {
            DownloadData downloadData = new DownloadData(key);
            downloadData.setName(str);
            downloadData.setPosition(position);
            downloadData.setPath(at);
            downloadData.setStatus(3);
            return downloadData;
        }
        DownloadData downloadData2 = new DownloadData(key, name, url, new a());
        downloadData2.setNotifyId(uY);
        downloadData2.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
        downloadData2.setType(12);
        downloadData2.setPath(at);
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
        this.XF.XB = null;
        if (downloadData != null) {
            if (downloadData.getStatus() == 3) {
                this.XF.e(downloadData);
                UtilHelper.install_apk(TbadkCoreApplication.m255getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
            } else {
                downloadData.setStatus(1);
                this.XF.e(downloadData);
                g.uZ().a(downloadData, 5);
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m255getInst().getApp(), downloadData.getNotifyId(), null, 0, TbadkCoreApplication.m255getInst().getApp().getString(z.download_will_begin), downloadData.getName(), false);
            }
            b.XD = null;
            list = b.XE;
            if (!list.isEmpty()) {
                list2 = b.XE;
                list2.remove(0);
                this.XF.uW();
            }
        }
    }
}
