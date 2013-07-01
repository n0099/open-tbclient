package com.baidu.tieba;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MainTabActivity f690a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(MainTabActivity mainTabActivity) {
        this.f690a = mainTabActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        if (i != -2) {
            alertDialog = this.f690a.x;
            alertDialog.dismiss();
            TiebaApplication.f().a(false, true);
            return;
        }
        this.f690a.a(true);
        TiebaApplication.f().a(true, true);
    }
}
