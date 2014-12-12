package com.baidu.tieba;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements DialogInterface.OnDismissListener {
    final /* synthetic */ UpdateDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(UpdateDialog updateDialog) {
        this.this$0 = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        af afVar;
        afVar = this.this$0.alF;
        afVar.dismiss();
        this.this$0.mHandler.postDelayed(new aw(this), 100L);
    }
}
