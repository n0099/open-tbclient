package com.baidu.tieba;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f1119a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(UpdateDialog updateDialog) {
        this.f1119a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        ar arVar;
        arVar = this.f1119a.c;
        arVar.dismiss();
    }
}
