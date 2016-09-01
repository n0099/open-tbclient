package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ UpdateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        boolean z3;
        this.this$0.aMw.Jj();
        UpdateDialog updateDialog = this.this$0;
        z = this.this$0.aMr;
        z2 = this.this$0.aMs;
        z3 = this.this$0.aMt;
        updateDialog.c(z, z2, z3);
    }
}
