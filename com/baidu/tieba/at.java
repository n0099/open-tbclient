package com.baidu.tieba;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f944a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(UpdateDialog updateDialog) {
        this.f944a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        Dialog dialog2;
        if (i == -1) {
            dialog2 = this.f944a.d;
            dialog2.dismiss();
            this.f944a.b();
        } else if (i == -2) {
            dialog = this.f944a.d;
            dialog.dismiss();
            this.f944a.c();
        }
        MainTabActivity.a(this.f944a, 200);
    }
}
