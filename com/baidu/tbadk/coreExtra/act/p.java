package com.baidu.tbadk.coreExtra.act;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class p implements DialogInterface.OnClickListener {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.a = oVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        LoginActivity loginActivity;
        loginActivity = this.a.a;
        LoginActivity.o(loginActivity);
    }
}
