package com.baidu.tieba;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f920a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(UpdateDialog updateDialog) {
        this.f920a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        Dialog dialog2;
        if (i == -1) {
            dialog2 = this.f920a.d;
            dialog2.dismiss();
            this.f920a.b();
        } else if (i == -2) {
            dialog = this.f920a.d;
            dialog.dismiss();
            this.f920a.c();
        }
    }
}
