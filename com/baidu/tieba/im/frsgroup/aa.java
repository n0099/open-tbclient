package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements DialogInterface.OnClickListener {
    final /* synthetic */ MembersActivity a;
    private final /* synthetic */ List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(MembersActivity membersActivity, List list) {
        this.a = membersActivity;
        this.b = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        af afVar;
        af afVar2;
        af afVar3;
        com.baidu.tieba.im.model.u uVar;
        af afVar4;
        afVar = this.a.b;
        afVar.c(false);
        afVar2 = this.a.b;
        afVar2.f().d(false);
        afVar3 = this.a.b;
        afVar3.g();
        MembersActivity membersActivity = this.a;
        uVar = this.a.c;
        membersActivity.a(uVar.f(), this.b);
        afVar4 = this.a.b;
        afVar4.d(true);
    }
}
