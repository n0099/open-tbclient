package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnClickListener {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MembersActivity membersActivity) {
        this.a = membersActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.l lVar;
        ae aeVar;
        int i2 = 0;
        switch (i) {
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
        }
        lVar = this.a.c;
        lVar.a(i2);
        aeVar = this.a.b;
        aeVar.c(i);
        this.a.g();
    }
}
