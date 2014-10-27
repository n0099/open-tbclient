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
        boolean z;
        ac acVar;
        z = this.this$0.acU;
        if (z) {
            this.this$0.wZ();
        }
        acVar = this.this$0.aeg;
        acVar.dismiss();
        this.this$0.finish();
    }
}
