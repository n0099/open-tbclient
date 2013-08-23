package com.baidu.tieba;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f926a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(UpdateDialog updateDialog) {
        this.f926a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        ae aeVar;
        aeVar = this.f926a.c;
        aeVar.dismiss();
    }
}
