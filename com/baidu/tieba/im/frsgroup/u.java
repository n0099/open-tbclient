package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements DialogInterface.OnClickListener {
    final /* synthetic */ List a;
    final /* synthetic */ MembersActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MembersActivity membersActivity, List list) {
        this.b = membersActivity;
        this.a = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        aa aaVar;
        aa aaVar2;
        aa aaVar3;
        com.baidu.tieba.im.model.m mVar;
        aa aaVar4;
        aaVar = this.b.b;
        aaVar.c(false);
        aaVar2 = this.b.b;
        aaVar2.i().d(false);
        aaVar3 = this.b.b;
        aaVar3.j();
        MembersActivity membersActivity = this.b;
        mVar = this.b.c;
        membersActivity.a(mVar.f(), this.a);
        aaVar4 = this.b.b;
        aaVar4.d(true);
    }
}
