package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements View.OnClickListener {
    final /* synthetic */ UpdateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ai aiVar;
        boolean z;
        boolean z2;
        boolean z3;
        aiVar = this.this$0.amz;
        aiVar.AL();
        UpdateDialog updateDialog = this.this$0;
        z = this.this$0.amu;
        z2 = this.this$0.amv;
        z3 = this.this$0.amw;
        updateDialog.b(z, z2, z3);
    }
}
