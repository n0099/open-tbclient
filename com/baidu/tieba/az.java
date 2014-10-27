package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    final /* synthetic */ UpdateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ac acVar;
        boolean z;
        boolean z2;
        boolean z3;
        acVar = this.this$0.aeg;
        acVar.wc();
        UpdateDialog updateDialog = this.this$0;
        z = this.this$0.aeb;
        z2 = this.this$0.aec;
        z3 = this.this$0.aed;
        updateDialog.b(z, z2, z3);
    }
}
