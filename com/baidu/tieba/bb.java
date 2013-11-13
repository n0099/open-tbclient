package com.baidu.tieba;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f1113a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(UpdateDialog updateDialog) {
        this.f1113a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        ao aoVar;
        aoVar = this.f1113a.c;
        aoVar.dismiss();
    }
}
