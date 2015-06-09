package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ UpdateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        w wVar;
        boolean z;
        boolean z2;
        boolean z3;
        wVar = this.this$0.avW;
        wVar.ER();
        UpdateDialog updateDialog = this.this$0;
        z = this.this$0.avR;
        z2 = this.this$0.avS;
        z3 = this.this$0.avT;
        updateDialog.b(z, z2, z3);
    }
}
