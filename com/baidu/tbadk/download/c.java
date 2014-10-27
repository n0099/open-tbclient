package com.baidu.tbadk.download;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.y;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<e, DownloadData, DownloadData> {
    final /* synthetic */ b Rc;

    private c(b bVar) {
        this.Rc = bVar;
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
        if (ay.aA(key) || ay.aA(name)) {
            return null;
        }
        String str = String.valueOf(key.replace(".", "_")) + ".apk";
        aq = this.Rc.aq(str);
        if (s.br(str) != null) {
            DownloadData downloadData = new DownloadData(key);
            downloadData.setName(str);
            downloadData.setPosition(position);
            downloadData.setPath(aq);
            downloadData.setStatus(3);
            return downloadData;
        }
        DownloadData downloadData2 = new DownloadData(key, name, url, new a());
        b bVar = this.Rc;
        i = bVar.Rb;
        bVar.Rb = i + 1;
        i2 = this.Rc.Rb;
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
        this.Rc.QX = null;
        if (downloadData != null) {
            if (downloadData.getStatus() == 3) {
                this.Rc.a(downloadData);
                UtilHelper.install_apk(TbadkApplication.m251getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
            } else {
                downloadData.setStatus(1);
                this.Rc.a(downloadData);
                g.rk().a(downloadData, 5);
                NotificationHelper.showProgressNotification(TbadkApplication.m251getInst().getApp(), downloadData.getNotifyId(), null, 0, TbadkApplication.m251getInst().getApp().getString(y.download_will_begin), downloadData.getName(), false);
            }
            b.QZ = null;
            list = b.Ra;
            if (!list.isEmpty()) {
                list2 = b.Ra;
                list2.remove(0);
                this.Rc.ri();
            }
        }
    }
}
