package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ MembersActivity a;
    private final /* synthetic */ BdListView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MembersActivity membersActivity, BdListView bdListView) {
        this.a = membersActivity;
        this.b = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        ag agVar;
        boolean h;
        com.baidu.tieba.im.model.ac acVar;
        com.baidu.tieba.im.model.ac acVar2;
        com.baidu.tieba.im.model.ac acVar3;
        com.baidu.tieba.im.model.ac acVar4;
        com.baidu.tieba.im.model.ac acVar5;
        agVar = this.a.b;
        if (agVar.f().d()) {
            this.b.d();
            return;
        }
        h = this.a.h();
        if (h) {
            acVar = this.a.c;
            acVar2 = this.a.c;
            long f = acVar2.f();
            acVar3 = this.a.c;
            int d = acVar3.d();
            acVar4 = this.a.c;
            int e = acVar4.e();
            acVar5 = this.a.c;
            acVar.a(f, d, e, acVar5.a());
            return;
        }
        this.a.f();
    }
}
