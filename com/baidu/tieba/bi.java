package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements View.OnClickListener {
    final /* synthetic */ UpdateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ac acVar;
        boolean z;
        boolean z2;
        boolean z3;
        acVar = this.this$0.aeo;
        acVar.we();
        UpdateDialog updateDialog = this.this$0;
        z = this.this$0.aej;
        z2 = this.this$0.aek;
        z3 = this.this$0.ael;
        updateDialog.b(z, z2, z3);
    }
}
