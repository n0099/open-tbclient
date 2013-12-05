package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import java.util.List;
/* loaded from: classes.dex */
class o implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f1716a;
    final /* synthetic */ n b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, List list) {
        this.b = nVar;
        this.f1716a = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.h hVar;
        MembersActivity membersActivity = this.b.f1715a;
        hVar = this.b.f1715a.c;
        membersActivity.a(hVar.g(), this.f1716a);
    }
}
