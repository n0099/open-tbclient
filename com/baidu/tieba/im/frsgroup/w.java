package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
final class w implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ MembersActivity a;
    private final /* synthetic */ BdListView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(MembersActivity membersActivity, BdListView bdListView) {
        this.a = membersActivity;
        this.b = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public final void a(boolean z) {
        ah ahVar;
        boolean d;
        com.baidu.tieba.im.model.z zVar;
        com.baidu.tieba.im.model.z zVar2;
        com.baidu.tieba.im.model.z zVar3;
        com.baidu.tieba.im.model.z zVar4;
        com.baidu.tieba.im.model.z zVar5;
        ahVar = this.a.b;
        if (ahVar.h().d()) {
            this.b.b();
            return;
        }
        d = this.a.d();
        if (d) {
            zVar = this.a.c;
            zVar2 = this.a.c;
            long f = zVar2.f();
            zVar3 = this.a.c;
            int d2 = zVar3.d();
            zVar4 = this.a.c;
            int e = zVar4.e();
            zVar5 = this.a.c;
            zVar.a(f, d2, e, zVar5.a());
            return;
        }
        MembersActivity.f(this.a);
    }
}
