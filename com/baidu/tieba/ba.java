package com.baidu.tieba;

import android.app.Dialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdateDialog f1078a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(UpdateDialog updateDialog) {
        this.f1078a = updateDialog;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        Dialog dialog;
        Dialog dialog2;
        if (i == -1) {
            dialog2 = this.f1078a.d;
            dialog2.dismiss();
            this.f1078a.b();
        } else if (i == -2) {
            dialog = this.f1078a.d;
            dialog.dismiss();
            this.f1078a.c();
        }
        MainTabActivity.a(this.f1078a, 200);
    }
}
