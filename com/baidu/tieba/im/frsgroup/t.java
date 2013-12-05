package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MembersActivity f1721a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MembersActivity membersActivity) {
        this.f1721a = membersActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.h hVar;
        aa aaVar;
        int i2 = 0;
        switch (i) {
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
        }
        hVar = this.f1721a.c;
        hVar.a(i2);
        aaVar = this.f1721a.b;
        aaVar.c(i);
        this.f1721a.g();
    }
}
