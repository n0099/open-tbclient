package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ UpdateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        z = this.this$0.aTn;
        if (z) {
            this.this$0.KQ();
        }
        this.this$0.aTT.dismiss();
        this.this$0.finish();
    }
}
