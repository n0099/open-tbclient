package com.baidu.tieba;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements DialogInterface.OnDismissListener {
    final /* synthetic */ UpdateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.this$0.aIo.dismiss();
        this.this$0.mHandler.postDelayed(new ae(this), 100L);
    }
}
