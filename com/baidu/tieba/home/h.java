package com.baidu.tieba.home;

import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.model.w {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1357a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EnterForumActivity enterForumActivity) {
        this.f1357a = enterForumActivity;
    }

    @Override // com.baidu.tieba.model.w
    public void a(com.baidu.tieba.model.u uVar) {
        n nVar;
        n nVar2;
        n nVar3;
        n nVar4;
        com.baidu.tieba.model.t tVar;
        Boolean bool;
        n nVar5;
        n nVar6;
        UtilHelper.NetworkStateInfo i = UtilHelper.i(this.f1357a);
        if (i == UtilHelper.NetworkStateInfo.UNAVAIL) {
            nVar6 = this.f1357a.c;
            nVar6.o();
        }
        nVar = this.f1357a.c;
        nVar.a(true, "");
        if (uVar.b) {
            nVar4 = this.f1357a.c;
            tVar = this.f1357a.e;
            com.baidu.tieba.data.r a2 = tVar.a();
            bool = this.f1357a.j;
            nVar4.a(a2, bool.booleanValue());
            nVar5 = this.f1357a.c;
            nVar5.i();
        } else {
            nVar2 = this.f1357a.c;
            nVar2.f();
            if (uVar.f1960a != null && uVar.f1960a.equals("")) {
                this.f1357a.a(uVar.f1960a);
            }
        }
        if (uVar.c == 0 && i != UtilHelper.NetworkStateInfo.UNAVAIL) {
            nVar3 = this.f1357a.c;
            nVar3.e();
        }
    }
}
