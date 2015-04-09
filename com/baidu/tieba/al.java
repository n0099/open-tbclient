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
        abVar = this.this$0.aus;
        abVar.Ec();
        UpdateDialog updateDialog = this.this$0;
        z = this.this$0.aun;
        z2 = this.this$0.auo;
        z3 = this.this$0.aup;
        updateDialog.b(z, z2, z3);
    }
}
