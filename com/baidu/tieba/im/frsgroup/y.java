package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f1580a;
    final /* synthetic */ MembersActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MembersActivity membersActivity, List list) {
        this.b = membersActivity;
        this.f1580a = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ae aeVar;
        ae aeVar2;
        ae aeVar3;
        com.baidu.tieba.im.model.h hVar;
        ae aeVar4;
        aeVar = this.b.f1551a;
        aeVar.c(false);
        aeVar2 = this.b.f1551a;
        aeVar2.i().d(false);
        aeVar3 = this.b.f1551a;
        aeVar3.j();
        MembersActivity membersActivity = this.b;
        hVar = this.b.b;
        membersActivity.a(hVar.g(), this.f1580a);
        aeVar4 = this.b.f1551a;
        aeVar4.d(true);
    }
}
