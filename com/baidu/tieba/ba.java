package com.baidu.tieba;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f920a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(UpdateDialog updateDialog) {
        this.f920a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        am amVar;
        amVar = this.f920a.c;
        amVar.dismiss();
    }
}
