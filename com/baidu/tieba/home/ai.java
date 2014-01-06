package com.baidu.tieba.home;

import android.content.DialogInterface;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ai implements DialogInterface.OnClickListener {
    final /* synthetic */ ag a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar) {
        this.a = agVar;
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
