package com.baidu.tieba.im.groupActivity;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class p implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupActivityActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(GroupActivityActivity groupActivityActivity) {
        this.a = groupActivityActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        r rVar;
        r rVar2;
        r rVar3;
        this.a.showProgressBar();
        rVar = this.a.b;
        rVar2 = this.a.b;
        long c = rVar2.c();
        rVar3 = this.a.b;
        rVar.a(c, rVar3.b());
    }
}
