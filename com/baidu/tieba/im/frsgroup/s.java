package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
final class s implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ MembersActivity a;
    private final /* synthetic */ BdListView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MembersActivity membersActivity, BdListView bdListView) {
        this.a = membersActivity;
        this.b = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public final void a(boolean z) {
        ae aeVar;
        boolean e;
        com.baidu.tieba.im.model.l lVar;
        com.baidu.tieba.im.model.l lVar2;
        com.baidu.tieba.im.model.l lVar3;
        com.baidu.tieba.im.model.l lVar4;
        com.baidu.tieba.im.model.l lVar5;
        aeVar = this.a.b;
        if (aeVar.h().d()) {
            this.b.a();
            return;
        }
        e = this.a.e();
        if (e) {
            lVar = this.a.c;
            lVar2 = this.a.c;
            long f = lVar2.f();
            lVar3 = this.a.c;
            int d = lVar3.d();
            lVar4 = this.a.c;
            int e2 = lVar4.e();
            lVar5 = this.a.c;
            lVar.a(f, d, e2, lVar5.a());
            return;
        }
        this.a.d();
    }
}
