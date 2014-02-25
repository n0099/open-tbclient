package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements DialogInterface.OnClickListener {
    final /* synthetic */ MembersActivity a;
    private final /* synthetic */ List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(MembersActivity membersActivity, List list) {
        this.a = membersActivity;
        this.b = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ae aeVar;
        ae aeVar2;
        ae aeVar3;
        com.baidu.tieba.im.model.l lVar;
        ae aeVar4;
        aeVar = this.a.b;
        aeVar.c(false);
        aeVar2 = this.a.b;
        aeVar2.i().d(false);
        aeVar3 = this.a.b;
        aeVar3.j();
        MembersActivity membersActivity = this.a;
        lVar = this.a.c;
        membersActivity.a(lVar.f(), this.b);
        aeVar4 = this.a.b;
        aeVar4.d(true);
    }
}
