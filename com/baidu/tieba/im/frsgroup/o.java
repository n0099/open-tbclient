package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.adp.widget.ListView.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdListView f1570a;
    final /* synthetic */ MembersActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(MembersActivity membersActivity, BdListView bdListView) {
        this.b = membersActivity;
        this.f1570a = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.b
    public void a(boolean z) {
        ae aeVar;
        boolean p;
        com.baidu.tieba.im.model.h hVar;
        com.baidu.tieba.im.model.h hVar2;
        com.baidu.tieba.im.model.h hVar3;
        com.baidu.tieba.im.model.h hVar4;
        com.baidu.tieba.im.model.h hVar5;
        aeVar = this.b.f1551a;
        if (!aeVar.i().d()) {
            p = this.b.p();
            if (p) {
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
            this.b.n();
            return;
        }
        this.f1570a.a();
    }
}
