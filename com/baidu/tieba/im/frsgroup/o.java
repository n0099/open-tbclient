package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import java.util.List;
/* loaded from: classes.dex */
class o implements DialogInterface.OnClickListener {
    final /* synthetic */ List a;
    final /* synthetic */ n b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, List list) {
        this.b = nVar;
        this.a = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.m mVar;
        MembersActivity membersActivity = this.b.a;
        mVar = this.b.a.c;
        membersActivity.a(mVar.f(), this.a);
    }
}
