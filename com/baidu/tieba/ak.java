package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ UpdateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        ab abVar;
        z = this.this$0.atI;
        if (z) {
            this.this$0.Eb();
        }
        abVar = this.this$0.auk;
        abVar.dismiss();
        this.this$0.finish();
    }
}
