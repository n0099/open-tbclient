package com.baidu.tieba;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements DialogInterface.OnDismissListener {
    final /* synthetic */ UpdateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        ab abVar;
        abVar = this.this$0.auk;
        abVar.dismiss();
        this.this$0.mHandler.postDelayed(new aj(this), 100L);
    }
}
