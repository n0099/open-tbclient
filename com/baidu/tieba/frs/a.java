package com.baidu.tieba.frs;

import android.app.NotificationManager;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public final class a implements com.baidu.tieba.download.b {
    private NotificationManager a = null;

    @Override // com.baidu.tieba.download.b
    public final void a(com.baidu.tieba.download.a aVar) {
        if (aVar != null) {
            if (aVar.f() == 1) {
                b.a().b(aVar);
            }
            b.a();
            b.a(aVar);
        }
    }

    @Override // com.baidu.tieba.download.b
    public final boolean b(com.baidu.tieba.download.a aVar) {
        if (aVar == null) {
            return false;
        }
        aVar.e((String) null);
        return true;
    }

    @Override // com.baidu.tieba.download.b
    public final boolean c(com.baidu.tieba.download.a aVar) {
        if (aVar == null) {
            return false;
        }
        aVar.e((String) null);
        return true;
    }

    @Override // com.baidu.tieba.download.b
    public final void d(com.baidu.tieba.download.a aVar) {
        if (this.a == null) {
            this.a = b.a().b();
        }
        this.a.cancel(aVar.o());
        b.a();
        String a = b.a(aVar.e());
        com.baidu.tieba.r.c();
        UtilHelper.b(com.baidu.tieba.r.d(), a);
    }

    @Override // com.baidu.tieba.download.b
    public final void a(com.baidu.tieba.download.a aVar, int i) {
        b.a().c(aVar);
    }
}
