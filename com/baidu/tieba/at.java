package com.baidu.tieba;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements DialogInterface.OnCancelListener {
    final /* synthetic */ UpdateDialog a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(UpdateDialog updateDialog) {
        this.a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ab abVar;
        abVar = this.a.h;
        abVar.dismiss();
        this.a.finish();
    }
}
