package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements DialogInterface.OnClickListener {
    final /* synthetic */ MembersActivity a;
    private final /* synthetic */ List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MembersActivity membersActivity, List list) {
        this.a = membersActivity;
        this.b = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ah ahVar;
        ah ahVar2;
        ah ahVar3;
        com.baidu.tieba.im.model.ad adVar;
        ah ahVar4;
        ahVar = this.a.b;
        ahVar.c(false);
        ahVar2 = this.a.b;
        ahVar2.f().d(false);
        ahVar3 = this.a.b;
        ahVar3.g();
        MembersActivity membersActivity = this.a;
        adVar = this.a.c;
        membersActivity.a(adVar.f(), this.b);
        ahVar4 = this.a.b;
        ahVar4.d(true);
    }
}
