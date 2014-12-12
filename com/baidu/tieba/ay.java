package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnClickListener {
    final /* synthetic */ UpdateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        af afVar;
        boolean z;
        boolean z2;
        boolean z3;
        afVar = this.this$0.alF;
        afVar.An();
        UpdateDialog updateDialog = this.this$0;
        z = this.this$0.alA;
        z2 = this.this$0.alB;
        z3 = this.this$0.alC;
        updateDialog.b(z, z2, z3);
    }
}
