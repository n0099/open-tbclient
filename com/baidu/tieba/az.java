package com.baidu.tieba;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f1075a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(UpdateDialog updateDialog) {
        this.f1075a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        am amVar;
        amVar = this.f1075a.c;
        amVar.dismiss();
    }
}
