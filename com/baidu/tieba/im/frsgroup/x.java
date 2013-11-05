package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MembersActivity f1579a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(MembersActivity membersActivity) {
        this.f1579a = membersActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.h hVar;
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
        hVar = this.f1579a.b;
        hVar.a(i2);
        aeVar = this.f1579a.f1551a;
        aeVar.b(i);
        this.f1579a.n();
    }
}
