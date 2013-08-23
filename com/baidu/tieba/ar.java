package com.baidu.tieba;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f928a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(UpdateDialog updateDialog) {
        this.f928a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        Dialog dialog2;
        if (i == -1) {
            dialog2 = this.f928a.d;
            dialog2.dismiss();
            this.f928a.b();
        } else if (i == -2) {
            dialog = this.f928a.d;
            dialog.dismiss();
            this.f928a.c();
        }
    }
}
