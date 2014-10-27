package com.baidu.tieba.im.groupActivity;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class p implements DialogInterface.OnClickListener {
    final /* synthetic */ GroupActivityActivity aZa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(GroupActivityActivity groupActivityActivity) {
        this.aZa = groupActivityActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        r rVar;
        r rVar2;
        r rVar3;
        this.aZa.showProgressBar();
        rVar = this.aZa.aYZ;
        rVar2 = this.aZa.aYZ;
        long Oh = rVar2.Oh();
        rVar3 = this.aZa.aYZ;
        rVar.a(Oh, rVar3.Og());
    }
}
