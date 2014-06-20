package com.baidu.tieba.frs;

import android.app.Notification;
import android.app.NotificationManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<e, DownloadData, DownloadData> {
    final /* synthetic */ b a;

    private c(b bVar) {
        this.a = bVar;
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
        String d;
        int i;
        int i2;
        e eVar = eVarArr[0];
        String a = eVar.a();
        String c = eVar.c();
        String b = eVar.b();
        int d2 = eVar.d();
        if (com.baidu.tbadk.core.util.bg.c(a) || com.baidu.tbadk.core.util.bg.c(c)) {
            return null;
        }
        String str = String.valueOf(a.replace(".", "_")) + ".apk";
        d = this.a.d(str);
        if (com.baidu.tbadk.core.util.x.d(str) != null) {
            DownloadData downloadData = new DownloadData(a);
            downloadData.setName(str);
            downloadData.setPosition(d2);
            downloadData.setPath(d);
            downloadData.setStatus(3);
            return downloadData;
        }
        DownloadData downloadData2 = new DownloadData(a, c, b, new a());
        b bVar = this.a;
        i = bVar.j;
        bVar.j = i + 1;
        i2 = this.a.j;
        downloadData2.setNotifyId(i2);
        downloadData2.setStatusMsg(TbadkApplication.getCurrentAccount());
        downloadData2.setType(12);
        downloadData2.setPath(d);
        downloadData2.setPosition(d2);
        return downloadData2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(DownloadData downloadData) {
        Notification notification;
        Notification notification2;
        Notification notification3;
        NotificationManager notificationManager;
        Notification notification4;
        List list;
        List list2;
        super.onPostExecute(downloadData);
        this.a.d = null;
        if (downloadData != null) {
            if (downloadData.getStatus() == 3) {
                this.a.a(downloadData);
                UtilHelper.install_apk(com.baidu.tieba.ai.c().d(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
            } else {
                downloadData.setStatus(1);
                this.a.a(downloadData);
                com.baidu.tbadk.download.b.a().a(downloadData, 5);
                notification = this.a.g;
                notification.contentView.setTextViewText(com.baidu.tieba.v.info, downloadData.getName());
                notification2 = this.a.g;
                notification2.contentView.setTextViewText(com.baidu.tieba.v.schedule, com.baidu.tieba.ai.c().d().getString(com.baidu.tieba.y.download_will_begin));
                notification3 = this.a.g;
                notification3.contentView.setProgressBar(com.baidu.tieba.v.progress, 100, 0, false);
                notificationManager = this.a.f;
                int notifyId = downloadData.getNotifyId();
                notification4 = this.a.g;
                notificationManager.notify(notifyId, notification4);
            }
            b.h = null;
            list = b.i;
            if (!list.isEmpty()) {
                list2 = b.i;
                list2.remove(0);
                this.a.e();
            }
        }
    }
}
