package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ BdListView a;
    final /* synthetic */ MembersActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(MembersActivity membersActivity, BdListView bdListView) {
        this.b = membersActivity;
        this.a = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        ac acVar;
        boolean i;
        com.baidu.tieba.im.model.n nVar;
        com.baidu.tieba.im.model.n nVar2;
        com.baidu.tieba.im.model.n nVar3;
        com.baidu.tieba.im.model.n nVar4;
        com.baidu.tieba.im.model.n nVar5;
        acVar = this.b.b;
        if (!acVar.i().d()) {
            i = this.b.i();
            if (i) {
                nVar = this.b.c;
                nVar2 = this.b.c;
                long f = nVar2.f();
                nVar3 = this.b.c;
                int d = nVar3.d();
                nVar4 = this.b.c;
                int e = nVar4.e();
                nVar5 = this.b.c;
                nVar.a(f, d, e, nVar5.a());
                return;
            }
            this.b.g();
            return;
        }
        this.a.a();
    }
}
