package com.baidu.tieba.frs;

import android.app.NotificationManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public final class a implements com.baidu.tieba.d.f {
    private NotificationManager a = null;

    @Override // com.baidu.tieba.d.f
    public final void c(com.baidu.tieba.d.a aVar) {
        if (aVar != null) {
            if (aVar.f() == 1) {
                b.a().b(aVar);
            }
            b.a();
            b.a(aVar);
        }
    }

    @Override // com.baidu.tieba.d.f
    public final boolean d(com.baidu.tieba.d.a aVar) {
        if (aVar == null) {
            return false;
        }
        aVar.e((String) null);
        return true;
    }

    @Override // com.baidu.tieba.d.f
    public final boolean b(com.baidu.tieba.d.a aVar) {
        if (aVar == null) {
            return false;
        }
        aVar.e((String) null);
        return true;
    }

    @Override // com.baidu.tieba.d.f
    public final void a(com.baidu.tieba.d.a aVar) {
        if (this.a == null) {
            this.a = b.a().b();
        }
        this.a.cancel(aVar.o());
        b.a();
        UtilHelper.a(TiebaApplication.g().b(), b.a(aVar.e()));
    }

    @Override // com.baidu.tieba.d.f
    public final void a(com.baidu.tieba.d.a aVar, int i) {
        b.a().c(aVar);
    }
}
