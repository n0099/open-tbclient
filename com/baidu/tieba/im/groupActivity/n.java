package com.baidu.tieba.im.groupActivity;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class n implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupActivityActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(GroupActivityActivity groupActivityActivity) {
        this.a = groupActivityActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        q qVar;
        q qVar2;
        q qVar3;
        this.a.showProgressBar();
        qVar = this.a.b;
        qVar2 = this.a.b;
        long c = qVar2.c();
        qVar3 = this.a.b;
        qVar.a(c, qVar3.b());
    }
}
