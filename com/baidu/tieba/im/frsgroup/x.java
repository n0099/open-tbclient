package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import java.util.List;
/* loaded from: classes.dex */
class x implements DialogInterface.OnClickListener {
    final /* synthetic */ w a;
    private final /* synthetic */ List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, List list) {
        this.a = wVar;
        this.b = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        MembersActivity membersActivity;
        MembersActivity membersActivity2;
        com.baidu.tieba.im.model.ac acVar;
        membersActivity = this.a.a;
        membersActivity2 = this.a.a;
        acVar = membersActivity2.c;
        membersActivity.a(acVar.f(), this.b);
    }
}
