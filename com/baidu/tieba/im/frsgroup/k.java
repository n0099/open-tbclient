package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.b {
    final /* synthetic */ BdListView a;
    final /* synthetic */ MembersActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(MembersActivity membersActivity, BdListView bdListView) {
        this.b = membersActivity;
        this.a = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        aa aaVar;
        boolean i;
        com.baidu.tieba.im.model.m mVar;
        com.baidu.tieba.im.model.m mVar2;
        com.baidu.tieba.im.model.m mVar3;
        com.baidu.tieba.im.model.m mVar4;
        com.baidu.tieba.im.model.m mVar5;
        aaVar = this.b.b;
        if (!aaVar.i().d()) {
            i = this.b.i();
            if (i) {
                mVar = this.b.c;
                mVar2 = this.b.c;
                long f = mVar2.f();
                mVar3 = this.b.c;
                int d = mVar3.d();
                mVar4 = this.b.c;
                int e = mVar4.e();
                mVar5 = this.b.c;
                mVar.a(f, d, e, mVar5.a());
                return;
            }
            this.b.g();
            return;
        }
        this.a.a();
    }
}
