package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import java.util.List;
/* loaded from: classes.dex */
final class r implements DialogInterface.OnClickListener {
    final /* synthetic */ MembersActivity a;
    private final /* synthetic */ List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MembersActivity membersActivity, List list) {
        this.a = membersActivity;
        this.b = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        ah ahVar;
        ah ahVar2;
        ah ahVar3;
        com.baidu.tieba.im.model.z zVar;
        ah ahVar4;
        ahVar = this.a.b;
        ahVar.c(false);
        ahVar2 = this.a.b;
        ahVar2.h().d(false);
        ahVar3 = this.a.b;
        ahVar3.i();
        MembersActivity membersActivity = this.a;
        zVar = this.a.c;
        MembersActivity.a(membersActivity, zVar.f(), this.b);
        ahVar4 = this.a.b;
        ahVar4.d(true);
    }
}
