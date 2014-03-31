package com.baidu.tieba;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class ag implements DialogInterface.OnCancelListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        m mVar;
        mVar = this.a.c;
        mVar.dismiss();
        this.a.finish();
    }
}
