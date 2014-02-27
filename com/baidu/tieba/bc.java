package com.baidu.tieba;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class bc implements DialogInterface.OnCancelListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        an anVar;
        anVar = this.a.c;
        anVar.dismiss();
        this.a.finish();
    }
}
