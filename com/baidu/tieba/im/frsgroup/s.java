package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ MembersActivity a;
    private final /* synthetic */ BdListView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MembersActivity membersActivity, BdListView bdListView) {
        this.a = membersActivity;
        this.b = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        ae aeVar;
        boolean i;
        com.baidu.tieba.im.model.l lVar;
        com.baidu.tieba.im.model.l lVar2;
        com.baidu.tieba.im.model.l lVar3;
        com.baidu.tieba.im.model.l lVar4;
        com.baidu.tieba.im.model.l lVar5;
        aeVar = this.a.b;
        if (aeVar.i().d()) {
            this.b.a();
            return;
        }
        i = this.a.i();
        if (i) {
            lVar = this.a.c;
            lVar2 = this.a.c;
            long f = lVar2.f();
            lVar3 = this.a.c;
            int d = lVar3.d();
            lVar4 = this.a.c;
            int e = lVar4.e();
            lVar5 = this.a.c;
            lVar.a(f, d, e, lVar5.a());
            return;
        }
        this.a.g();
    }
}
