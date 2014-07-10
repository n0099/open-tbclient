package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements DialogInterface.OnClickListener {
    final /* synthetic */ MembersActivity a;
    private final /* synthetic */ List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(MembersActivity membersActivity, List list) {
        this.a = membersActivity;
        this.b = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ag agVar;
        ag agVar2;
        ag agVar3;
        com.baidu.tieba.im.model.ac acVar;
        ag agVar4;
        agVar = this.a.b;
        agVar.c(false);
        agVar2 = this.a.b;
        agVar2.f().d(false);
        agVar3 = this.a.b;
        agVar3.g();
        MembersActivity membersActivity = this.a;
        acVar = this.a.c;
        membersActivity.a(acVar.f(), this.b);
        agVar4 = this.a.b;
        agVar4.d(true);
    }
}
