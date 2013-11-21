package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdListView f1645a;
    final /* synthetic */ MembersActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(MembersActivity membersActivity, BdListView bdListView) {
        this.b = membersActivity;
        this.f1645a = bdListView;
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
        aaVar = this.b.f1632a;
        if (!aaVar.i().d()) {
            i = this.b.i();
            if (i) {
                hVar = this.b.b;
                hVar2 = this.b.b;
                long g = hVar2.g();
                hVar3 = this.b.b;
                int e = hVar3.e();
                hVar4 = this.b.b;
                int f = hVar4.f();
                hVar5 = this.b.b;
                hVar.a(g, e, f, hVar5.b());
                return;
            }
            this.b.g();
            return;
        }
        this.f1645a.a();
    }
}
