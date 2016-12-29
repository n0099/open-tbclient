package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ UpdateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        boolean z3;
        this.this$0.aPd.JS();
        UpdateDialog updateDialog = this.this$0;
        z = this.this$0.aOY;
        z2 = this.this$0.aOZ;
        z3 = this.this$0.aPa;
        updateDialog.c(z, z2, z3);
    }
}
