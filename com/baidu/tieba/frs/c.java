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
public final class c extends BdAsyncTask<e, com.baidu.tieba.d.a, com.baidu.tieba.d.a> {
    final /* synthetic */ b a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.d.a a(e... eVarArr) {
        int i;
        int i2;
        e eVar = eVarArr[0];
        String a = eVar.a();
        String c = eVar.c();
        String b = eVar.b();
        int d = eVar.d();
        if (com.baidu.tieba.util.bs.c(a) || com.baidu.tieba.util.bs.c(c)) {
            return null;
        }
        b bVar = this.a;
        String a2 = b.a(b);
        String a3 = b.a(this.a, a2);
        if (com.baidu.tieba.util.af.d(a2) != null) {
            com.baidu.tieba.d.a aVar = new com.baidu.tieba.d.a(a);
            aVar.a(a2);
            aVar.e(d);
            aVar.c(a3);
            aVar.a(3);
            return aVar;
        }
        com.baidu.tieba.d.a aVar2 = new com.baidu.tieba.d.a(a, c, b, new a());
        b bVar2 = this.a;
        i = bVar2.j;
        bVar2.j = i + 1;
        i2 = this.a.j;
        aVar2.f(i2);
        aVar2.e(TiebaApplication.v());
        aVar2.b(12);
        aVar2.c(a3);
        aVar2.e(d);
        return aVar2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.d.a aVar) {
        int i;
        Notification notification;
        Notification notification2;
        Notification notification3;
        NotificationManager notificationManager;
        Notification notification4;
        List list;
        List list2;
        com.baidu.tieba.d.a aVar2 = aVar;
        super.a((c) aVar2);
        this.a.d = null;
        if (aVar2 != null) {
            if (aVar2.f() == 3) {
                b bVar = this.a;
                b.a(aVar2);
                UtilHelper.a(TiebaApplication.g().b(), aVar2.b());
            } else {
                aVar2.a(1);
                b bVar2 = this.a;
                b.a(aVar2);
                com.baidu.tieba.d.g a = com.baidu.tieba.d.g.a();
                i = this.a.b;
                a.a(aVar2, i);
                notification = this.a.g;
                notification.contentView.setTextViewText(R.id.info, aVar2.b());
                notification2 = this.a.g;
                notification2.contentView.setTextViewText(R.id.schedule, TiebaApplication.g().b().getString(R.string.download_will_begin));
                notification3 = this.a.g;
                notification3.contentView.setProgressBar(R.id.progress, 100, 0, false);
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
