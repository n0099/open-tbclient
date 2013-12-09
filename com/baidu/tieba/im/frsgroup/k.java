package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdListView f1713a;
    final /* synthetic */ MembersActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(MembersActivity membersActivity, BdListView bdListView) {
        this.b = membersActivity;
        this.f1713a = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        aa aaVar;
        boolean i;
        com.baidu.tieba.im.model.h hVar;
        com.baidu.tieba.im.model.h hVar2;
        com.baidu.tieba.im.model.h hVar3;
        com.baidu.tieba.im.model.h hVar4;
        com.baidu.tieba.im.model.h hVar5;
        aaVar = this.b.b;
        if (!aaVar.i().d()) {
            i = this.b.i();
            if (i) {
                hVar = this.b.c;
                hVar2 = this.b.c;
                long g = hVar2.g();
                hVar3 = this.b.c;
                int e = hVar3.e();
                hVar4 = this.b.c;
                int f = hVar4.f();
                hVar5 = this.b.c;
                hVar.a(g, e, f, hVar5.b());
                return;
            }
            this.b.g();
            return;
        }
        this.f1713a.a();
    }
}
