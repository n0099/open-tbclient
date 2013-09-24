package com.baidu.tieba;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f943a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(UpdateDialog updateDialog) {
        this.f943a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        ah ahVar;
        ahVar = this.f943a.c;
        ahVar.dismiss();
    }
}
