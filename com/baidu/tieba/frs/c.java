package com.baidu.tieba.frs;

import android.app.Notification;
import android.app.NotificationManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<e, com.baidu.tieba.d.a, com.baidu.tieba.d.a> {
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
    public com.baidu.tieba.d.a a(e... eVarArr) {
        String b;
        int i;
        int i2;
        e eVar = eVarArr[0];
        String a = eVar.a();
        String c = eVar.c();
        String b2 = eVar.b();
        int d = eVar.d();
        if (com.baidu.tieba.util.bs.c(a) || com.baidu.tieba.util.bs.c(c)) {
            return null;
        }
        String a2 = this.a.a(b2);
        b = this.a.b(a2);
        if (com.baidu.tieba.util.af.d(a2) != null) {
            com.baidu.tieba.d.a aVar = new com.baidu.tieba.d.a(a);
            aVar.a(a2);
            aVar.e(d);
            aVar.c(b);
            aVar.a(3);
            return aVar;
        }
        com.baidu.tieba.d.a aVar2 = new com.baidu.tieba.d.a(a, c, b2, new a());
        b bVar = this.a;
        i = bVar.j;
        bVar.j = i + 1;
        i2 = this.a.j;
        aVar2.f(i2);
        aVar2.e(TiebaApplication.A());
        aVar2.b(12);
        aVar2.c(b);
        aVar2.e(d);
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.d.a aVar) {
        int i;
        Notification notification;
        Notification notification2;
        Notification notification3;
        NotificationManager notificationManager;
        Notification notification4;
        List list;
        List list2;
        super.a((c) aVar);
        this.a.d = null;
        if (aVar != null) {
            if (aVar.f() == 3) {
                this.a.a(aVar);
                UtilHelper.a(TiebaApplication.g().b(), aVar.b());
            } else {
                aVar.a(1);
                this.a.a(aVar);
                com.baidu.tieba.d.g a = com.baidu.tieba.d.g.a();
                i = this.a.b;
                a.a(aVar, i);
                notification = this.a.g;
                notification.contentView.setTextViewText(R.id.info, aVar.b());
                notification2 = this.a.g;
                notification2.contentView.setTextViewText(R.id.schedule, TiebaApplication.g().b().getString(R.string.download_will_begin));
                notification3 = this.a.g;
                notification3.contentView.setProgressBar(R.id.progress, 100, 0, false);
                notificationManager = this.a.f;
                int o = aVar.o();
                notification4 = this.a.g;
                notificationManager.notify(o, notification4);
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
