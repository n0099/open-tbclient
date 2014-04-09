package com.baidu.tieba;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class ae implements DialogInterface.OnCancelListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        k kVar;
        kVar = this.a.c;
        kVar.dismiss();
        this.a.finish();
    }
}
