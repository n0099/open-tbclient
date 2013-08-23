package com.baidu.tieba;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f927a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(UpdateDialog updateDialog) {
        this.f927a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        Dialog dialog2;
        if (i == -1) {
            dialog2 = this.f927a.d;
            dialog2.dismiss();
            this.f927a.b();
        } else if (i == -2) {
            dialog = this.f927a.d;
            dialog.dismiss();
            this.f927a.c();
        }
        MainTabActivity.a(this.f927a, 200);
    }
}
