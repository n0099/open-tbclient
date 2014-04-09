package com.baidu.tieba.frs;

import android.app.Notification;
import android.app.NotificationManager;
import android.widget.RemoteViews;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends BdAsyncTask<e, com.baidu.tieba.download.a, com.baidu.tieba.download.a> {
    final /* synthetic */ b a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.download.a a(e... eVarArr) {
        int i;
        int i2;
        e eVar = eVarArr[0];
        String a = eVar.a();
        String c = eVar.c();
        String b = eVar.b();
        int d = eVar.d();
        if (com.baidu.tbadk.core.util.bc.c(a) || com.baidu.tbadk.core.util.bc.c(c)) {
            return null;
        }
        String replace = a.replace(".", "_");
        String a2 = b.a(this.a, replace);
        if (com.baidu.tbadk.core.util.w.d(replace) != null) {
            com.baidu.tieba.download.a aVar = new com.baidu.tieba.download.a(a);
            aVar.a(replace);
            aVar.e(d);
            aVar.c(a2);
            aVar.a(3);
            return aVar;
        }
        com.baidu.tieba.download.a aVar2 = new com.baidu.tieba.download.a(a, c, b, new a());
        b bVar = this.a;
        i = bVar.j;
        bVar.j = i + 1;
        i2 = this.a.j;
        aVar2.f(i2);
        aVar2.e(TbadkApplication.E());
        aVar2.b(12);
        aVar2.c(a2);
        aVar2.e(d);
        return aVar2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.download.a aVar) {
        Notification notification;
        Notification notification2;
        Notification notification3;
        NotificationManager notificationManager;
        Notification notification4;
        List list;
        List list2;
        com.baidu.tieba.download.a aVar2 = aVar;
        super.a((c) aVar2);
        this.a.d = null;
        if (aVar2 != null) {
            if (aVar2.f() == 3) {
                b bVar = this.a;
                b.a(aVar2);
                com.baidu.tieba.p.c();
                UtilHelper.b(com.baidu.tieba.p.d(), aVar2.a().replace(".", "_"));
            } else {
                aVar2.a(1);
                b bVar2 = this.a;
                b.a(aVar2);
                com.baidu.tieba.download.c.a().a(aVar2, 5);
                notification = this.a.g;
                notification.contentView.setTextViewText(com.baidu.tieba.a.h.info, aVar2.b());
                notification2 = this.a.g;
                RemoteViews remoteViews = notification2.contentView;
                int i = com.baidu.tieba.a.h.schedule;
                com.baidu.tieba.p.c();
                remoteViews.setTextViewText(i, com.baidu.tieba.p.d().getString(com.baidu.tieba.a.k.download_will_begin));
                notification3 = this.a.g;
                notification3.contentView.setProgressBar(com.baidu.tieba.a.h.progress, 100, 0, false);
                notificationManager = this.a.f;
                int o = aVar2.o();
                notification4 = this.a.g;
                notificationManager.notify(o, notification4);
            }
            b.h = null;
            list = b.i;
            if (list.isEmpty()) {
                return;
            }
            list2 = b.i;
            list2.remove(0);
            this.a.d();
        }
    }

    private c(b bVar) {
        this.a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(b bVar, byte b) {
        this(bVar);
    }
}
