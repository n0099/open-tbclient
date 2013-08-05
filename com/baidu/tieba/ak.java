package com.baidu.tieba;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MainTabActivity f906a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(MainTabActivity mainTabActivity) {
        this.f906a = mainTabActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        boolean z;
        AlertDialog alertDialog;
        boolean z2;
        if (i == -2) {
            alertDialog = this.f906a.z;
            alertDialog.dismiss();
            TiebaApplication f = TiebaApplication.f();
            z2 = this.f906a.C;
            f.a(false, z2);
            return;
        }
        TiebaApplication f2 = TiebaApplication.f();
        z = this.f906a.C;
        f2.a(true, z);
    }
}
