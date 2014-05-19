package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.adp.widget.ListView.d {
    final /* synthetic */ MembersActivity a;
    private final /* synthetic */ BdListView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(MembersActivity membersActivity, BdListView bdListView) {
        this.a = membersActivity;
        this.b = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.d
    public void a(boolean z) {
        ah ahVar;
        boolean i;
        com.baidu.tieba.im.model.ad adVar;
        com.baidu.tieba.im.model.ad adVar2;
        com.baidu.tieba.im.model.ad adVar3;
        com.baidu.tieba.im.model.ad adVar4;
        com.baidu.tieba.im.model.ad adVar5;
        ahVar = this.a.b;
        if (ahVar.f().d()) {
            this.b.c();
            return;
        }
        i = this.a.i();
        if (i) {
            adVar = this.a.c;
            adVar2 = this.a.c;
            long f = adVar2.f();
            adVar3 = this.a.c;
            int d = adVar3.d();
            adVar4 = this.a.c;
            int e = adVar4.e();
            adVar5 = this.a.c;
            adVar.a(f, d, e, adVar5.a());
            return;
        }
        this.a.g();
    }
}
