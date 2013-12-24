package com.baidu.tieba.home;

import android.content.DialogInterface;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ah implements DialogInterface.OnClickListener {
    final /* synthetic */ af a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar) {
        this.a = afVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        i2 = this.a.a.B;
        if (i2 == 0) {
            DatabaseService.q();
            this.a.a.f();
            return;
        }
        DatabaseService.r();
        this.a.a.h();
    }
}
