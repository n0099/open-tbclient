package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements DialogInterface.OnClickListener {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.u uVar;
        af afVar;
        int i2 = 0;
        switch (i) {
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
        }
        uVar = this.a.c;
        uVar.a(i2);
        afVar = this.a.b;
        afVar.c(i);
        this.a.f();
    }
}
