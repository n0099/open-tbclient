package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements DialogInterface.OnClickListener {
    final /* synthetic */ List a;
    final /* synthetic */ MembersActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(MembersActivity membersActivity, List list) {
        this.b = membersActivity;
        this.a = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ac acVar;
        ac acVar2;
        ac acVar3;
        com.baidu.tieba.im.model.n nVar;
        ac acVar4;
        acVar = this.b.b;
        acVar.c(false);
        acVar2 = this.b.b;
        acVar2.i().d(false);
        acVar3 = this.b.b;
        acVar3.j();
        MembersActivity membersActivity = this.b;
        nVar = this.b.c;
        membersActivity.a(nVar.f(), this.a);
        acVar4 = this.b.b;
        acVar4.d(true);
    }
}
