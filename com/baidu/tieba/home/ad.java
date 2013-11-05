package com.baidu.tieba.home;

import android.content.DialogInterface;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class ad implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ab f1330a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.f1330a = abVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        i2 = this.f1330a.f1328a.E;
        if (i2 == 0) {
            DatabaseService.q();
            this.f1330a.f1328a.n();
            return;
        }
        DatabaseService.r();
        this.f1330a.f1328a.p();
    }
}
