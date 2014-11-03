package com.baidu.tieba.im.groupActivity;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class p implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupActivityActivity aZn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(GroupActivityActivity groupActivityActivity) {
        this.aZn = groupActivityActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        r rVar;
        r rVar2;
        r rVar3;
        this.aZn.showProgressBar();
        rVar = this.aZn.aZm;
        rVar2 = this.aZn.aZm;
        long Ok = rVar2.Ok();
        rVar3 = this.aZn.aZm;
        rVar.a(Ok, rVar3.Oj());
    }
}
