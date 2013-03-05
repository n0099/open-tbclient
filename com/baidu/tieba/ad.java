package com.baidu.tieba;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ad implements DialogInterface.OnCancelListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.a.finish();
    }
}
