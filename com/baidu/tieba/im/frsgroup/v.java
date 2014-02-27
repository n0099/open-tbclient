package com.baidu.tieba.im.frsgroup;

import android.content.DialogInterface;
import java.util.List;
/* loaded from: classes.dex */
final class v implements DialogInterface.OnClickListener {
    final /* synthetic */ u a;
    private final /* synthetic */ List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, List list) {
        this.a = uVar;
        this.b = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        MembersActivity membersActivity;
        MembersActivity membersActivity2;
        com.baidu.tieba.im.model.l lVar;
        membersActivity = this.a.a;
        membersActivity2 = this.a.a;
        lVar = membersActivity2.c;
        MembersActivity.a(membersActivity, lVar.f(), this.b);
    }
}
