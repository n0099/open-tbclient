package com.baidu.tieba;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f1079a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(UpdateDialog updateDialog) {
        this.f1079a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        Dialog dialog2;
        if (i == -1) {
            dialog2 = this.f1079a.d;
            dialog2.dismiss();
            this.f1079a.b();
        } else if (i == -2) {
            dialog = this.f1079a.d;
            dialog.dismiss();
            this.f1079a.c();
        }
    }
}
