package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import java.util.List;
/* loaded from: classes.dex */
class z implements DialogInterface.OnClickListener {
    final /* synthetic */ y a;
    private final /* synthetic */ List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, List list) {
        this.a = yVar;
        this.b = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        MembersActivity membersActivity;
        MembersActivity membersActivity2;
        com.baidu.tieba.im.model.ad adVar;
        membersActivity = this.a.a;
        membersActivity2 = this.a.a;
        adVar = membersActivity2.c;
        membersActivity.a(adVar.f(), this.b);
    }
}
