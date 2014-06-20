package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ac acVar;
        boolean z;
        boolean z2;
        boolean z3;
        acVar = this.a.h;
        acVar.a();
        UpdateDialog updateDialog = this.a;
        z = this.a.b;
        z2 = this.a.c;
        z3 = this.a.d;
        updateDialog.a(z, z2, z3);
    }
}
