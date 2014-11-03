package com.baidu.tbadk.download;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.y;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<e, DownloadData, DownloadData> {
    final /* synthetic */ b Rg;

    private c(b bVar) {
        this.Rg = bVar;
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
        String aq;
        int i;
        int i2;
        e eVar = eVarArr[0];
        String key = eVar.getKey();
        String name = eVar.getName();
        String url = eVar.getUrl();
        int position = eVar.getPosition();
        if (az.aA(key) || az.aA(name)) {
            return null;
        }
        String str = String.valueOf(key.replace(".", "_")) + ".apk";
        aq = this.Rg.aq(str);
        if (s.br(str) != null) {
            DownloadData downloadData = new DownloadData(key);
            downloadData.setName(str);
            downloadData.setPosition(position);
            downloadData.setPath(aq);
            downloadData.setStatus(3);
            return downloadData;
        }
        DownloadData downloadData2 = new DownloadData(key, name, url, new a());
        b bVar = this.Rg;
        i = bVar.Rf;
        bVar.Rf = i + 1;
        i2 = this.Rg.Rf;
        downloadData2.setNotifyId(i2);
        downloadData2.setStatusMsg(TbadkApplication.getCurrentAccount());
        downloadData2.setType(12);
        downloadData2.setPath(aq);
        downloadData2.setPosition(position);
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
        this.Rg.Rb = null;
        if (downloadData != null) {
            if (downloadData.getStatus() == 3) {
                this.Rg.a(downloadData);
                UtilHelper.install_apk(TbadkApplication.m251getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
            } else {
                downloadData.setStatus(1);
                this.Rg.a(downloadData);
                g.rm().a(downloadData, 5);
                NotificationHelper.showProgressNotification(TbadkApplication.m251getInst().getApp(), downloadData.getNotifyId(), null, 0, TbadkApplication.m251getInst().getApp().getString(y.download_will_begin), downloadData.getName(), false);
            }
            b.Rd = null;
            list = b.Re;
            if (!list.isEmpty()) {
                list2 = b.Re;
                list2.remove(0);
                this.Rg.rk();
            }
        }
    }
}
