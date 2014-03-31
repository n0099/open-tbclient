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
        com.baidu.tieba.im.model.y yVar;
        com.baidu.tieba.im.model.y yVar2;
        com.baidu.tieba.im.model.y yVar3;
        com.baidu.tieba.im.model.y yVar4;
        com.baidu.tieba.im.model.y yVar5;
        ahVar = this.a.b;
        if (ahVar.h().d()) {
            this.b.b();
            return;
        }
        d = this.a.d();
        if (d) {
            yVar = this.a.c;
            yVar2 = this.a.c;
            long f = yVar2.f();
            yVar3 = this.a.c;
            int d2 = yVar3.d();
            yVar4 = this.a.c;
            int e = yVar4.e();
            yVar5 = this.a.c;
            yVar.a(f, d2, e, yVar5.a());
            return;
        }
        MembersActivity.f(this.a);
    }
}
