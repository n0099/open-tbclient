package com.baidu.tieba.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
/* loaded from: classes.dex */
final class ad implements DialogInterface.OnClickListener {
    final /* synthetic */ SignAllForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(SignAllForumActivity signAllForumActivity) {
        this.a = signAllForumActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AlertDialog alertDialog;
        alertDialog = this.a.c;
        alertDialog.dismiss();
    }
}
