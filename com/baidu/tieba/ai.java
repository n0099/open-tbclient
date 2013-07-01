package com.baidu.tieba;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MainTabActivity f691a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(MainTabActivity mainTabActivity) {
        this.f691a = mainTabActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        if (i != -2) {
            alertDialog = this.f691a.y;
            alertDialog.dismiss();
            TiebaApplication.f().a(false, false);
            return;
        }
        this.f691a.a(false);
        TiebaApplication.f().a(true, false);
    }
}
