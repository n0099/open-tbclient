package com.baidu.tieba.home;

import android.content.DialogInterface;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ah implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ af f1447a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar) {
        this.f1447a = afVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        i2 = this.f1447a.f1445a.B;
        if (i2 == 0) {
            DatabaseService.q();
            this.f1447a.f1445a.f();
            return;
        }
        DatabaseService.r();
        this.f1447a.f1445a.h();
    }
}
