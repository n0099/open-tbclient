package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import java.util.List;
/* loaded from: classes.dex */
class w implements DialogInterface.OnClickListener {
    final /* synthetic */ v a;
    private final /* synthetic */ List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, List list) {
        this.a = vVar;
        this.b = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        MembersActivity membersActivity;
        MembersActivity membersActivity2;
        com.baidu.tieba.im.model.u uVar;
        membersActivity = this.a.a;
        membersActivity2 = this.a.a;
        uVar = membersActivity2.c;
        membersActivity.a(uVar.f(), this.b);
    }
}
