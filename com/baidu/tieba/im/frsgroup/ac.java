package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class ac implements DialogInterface.OnClickListener {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.y yVar;
        ah ahVar;
        int i2 = 0;
        switch (i) {
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
        }
        yVar = this.a.c;
        yVar.a(i2);
        ahVar = this.a.b;
        ahVar.c(i);
        MembersActivity.f(this.a);
    }
}
