package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ UpdateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        boolean z2;
        boolean z3;
        this.this$0.aUk.Lm();
        UpdateDialog updateDialog = this.this$0;
        z = this.this$0.aUf;
        z2 = this.this$0.aUg;
        z3 = this.this$0.aUh;
        updateDialog.c(z, z2, z3);
    }
}
