package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {
    final /* synthetic */ UpdateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        ac acVar;
        z = this.this$0.acZ;
        if (z) {
            this.this$0.xb();
        }
        acVar = this.this$0.aeo;
        acVar.dismiss();
        this.this$0.finish();
    }
}
