package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignAllForumActivity f1428a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(SignAllForumActivity signAllForumActivity) {
        this.f1428a = signAllForumActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        alertDialog = this.f1428a.c;
        alertDialog.dismiss();
    }
}
