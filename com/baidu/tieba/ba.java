package com.baidu.tieba;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f918a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(UpdateDialog updateDialog) {
        this.f918a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        am amVar;
        amVar = this.f918a.c;
        amVar.dismiss();
    }
}
