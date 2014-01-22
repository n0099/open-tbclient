package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import java.util.List;
/* loaded from: classes.dex */
class q implements DialogInterface.OnClickListener {
    final /* synthetic */ List a;
    final /* synthetic */ p b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, List list) {
        this.b = pVar;
        this.a = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.n nVar;
        MembersActivity membersActivity = this.b.a;
        nVar = this.b.a.c;
        membersActivity.a(nVar.f(), this.a);
    }
}
