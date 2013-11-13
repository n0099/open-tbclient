package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f1664a;
    final /* synthetic */ MembersActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MembersActivity membersActivity, List list) {
        this.b = membersActivity;
        this.f1664a = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        aa aaVar;
        aa aaVar2;
        aa aaVar3;
        com.baidu.tieba.im.model.h hVar;
        aa aaVar4;
        aaVar = this.b.f1641a;
        aaVar.c(false);
        aaVar2 = this.b.f1641a;
        aaVar2.i().d(false);
        aaVar3 = this.b.f1641a;
        aaVar3.j();
        MembersActivity membersActivity = this.b;
        hVar = this.b.b;
        membersActivity.a(hVar.g(), this.f1664a);
        aaVar4 = this.b.f1641a;
        aaVar4.d(true);
    }
}
