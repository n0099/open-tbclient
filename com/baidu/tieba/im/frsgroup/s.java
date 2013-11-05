package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import java.util.List;
/* loaded from: classes.dex */
class s implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f1574a;
    final /* synthetic */ r b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, List list) {
        this.b = rVar;
        this.f1574a = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.im.model.h hVar;
        MembersActivity membersActivity = this.b.f1573a;
        hVar = this.b.f1573a.b;
        membersActivity.a(hVar.g(), this.f1574a);
    }
}
