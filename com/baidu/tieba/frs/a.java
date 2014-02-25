package com.baidu.tieba.frs;

import android.app.NotificationManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.d.f {
    private NotificationManager a = null;

    @Override // com.baidu.tieba.d.f
    public void c(com.baidu.tieba.d.a aVar) {
        if (aVar != null) {
            if (aVar.f() == 1) {
                b.a().b(aVar);
            }
            b.a().a(aVar);
        }
    }

    @Override // com.baidu.tieba.d.f
    public boolean d(com.baidu.tieba.d.a aVar) {
        if (aVar == null) {
            return false;
        }
        aVar.e((String) null);
        return true;
    }

    @Override // com.baidu.tieba.d.f
    public boolean b(com.baidu.tieba.d.a aVar) {
        if (aVar == null) {
            return false;
        }
        aVar.e((String) null);
        return true;
    }

    @Override // com.baidu.tieba.d.f
    public void a(com.baidu.tieba.d.a aVar) {
        if (this.a == null) {
            this.a = b.a().c();
        }
        this.a.cancel(aVar.o());
        UtilHelper.a(TiebaApplication.g().b(), b.a().a(aVar.e()));
    }

    @Override // com.baidu.tieba.d.f
    public void a(com.baidu.tieba.d.a aVar, int i, String str) {
        b.a().c(aVar);
    }
}
