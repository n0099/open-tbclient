package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements DialogInterface.OnClickListener {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.n nVar;
        ac acVar;
        int i2 = 0;
        switch (i) {
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
        }
        nVar = this.a.c;
        nVar.a(i2);
        acVar = this.a.b;
        acVar.c(i);
        this.a.g();
    }
}
