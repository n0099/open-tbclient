package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ UpdateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ab abVar;
        boolean z;
        boolean z2;
        boolean z3;
        abVar = this.this$0.auk;
        abVar.DW();
        UpdateDialog updateDialog = this.this$0;
        z = this.this$0.auf;
        z2 = this.this$0.aug;
        z3 = this.this$0.auh;
        updateDialog.b(z, z2, z3);
    }
}
