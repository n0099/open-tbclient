package com.baidu.tieba.im.chat;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x f1612a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.f1612a = xVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        alertDialog = this.f1612a.o;
        alertDialog.dismiss();
    }
}
