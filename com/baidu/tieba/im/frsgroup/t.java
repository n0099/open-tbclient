package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ MembersActivity a;
    private final /* synthetic */ BdListView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MembersActivity membersActivity, BdListView bdListView) {
        this.a = membersActivity;
        this.b = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        af afVar;
        boolean h;
        com.baidu.tieba.im.model.u uVar;
        com.baidu.tieba.im.model.u uVar2;
        com.baidu.tieba.im.model.u uVar3;
        com.baidu.tieba.im.model.u uVar4;
        com.baidu.tieba.im.model.u uVar5;
        afVar = this.a.b;
        if (afVar.f().d()) {
            this.b.d();
            return;
        }
        h = this.a.h();
        if (h) {
            uVar = this.a.c;
            uVar2 = this.a.c;
            long f = uVar2.f();
            uVar3 = this.a.c;
            int d = uVar3.d();
            uVar4 = this.a.c;
            int e = uVar4.e();
            uVar5 = this.a.c;
            uVar.a(f, d, e, uVar5.a());
            return;
        }
        this.a.f();
    }
}
