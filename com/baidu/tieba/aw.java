package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ab abVar;
        boolean z;
        boolean z2;
        boolean z3;
        abVar = this.a.h;
        abVar.a();
        UpdateDialog updateDialog = this.a;
        z = this.a.b;
        z2 = this.a.c;
        z3 = this.a.d;
        updateDialog.a(z, z2, z3);
    }
}
