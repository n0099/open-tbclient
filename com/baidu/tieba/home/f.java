package com.baidu.tieba.home;

import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.model.o {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1215a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EnterForumActivity enterForumActivity) {
        this.f1215a = enterForumActivity;
    }

    @Override // com.baidu.tieba.model.o
    public void a(com.baidu.tieba.model.m mVar) {
        k kVar;
        k kVar2;
        k kVar3;
        k kVar4;
        com.baidu.tieba.model.l lVar;
        Boolean bool;
        k kVar5;
        k kVar6;
        UtilHelper.NetworkStateInfo i = UtilHelper.i(this.f1215a);
        if (i == UtilHelper.NetworkStateInfo.UNAVAIL) {
            kVar6 = this.f1215a.f1185a;
            kVar6.l();
        }
        kVar = this.f1215a.f1185a;
        kVar.a(true, "");
        if (mVar.b) {
            kVar4 = this.f1215a.f1185a;
            lVar = this.f1215a.c;
            com.baidu.tieba.data.q a2 = lVar.a();
            bool = this.f1215a.f;
            kVar4.a(a2, bool.booleanValue());
            kVar5 = this.f1215a.f1185a;
            kVar5.f();
        } else {
            kVar2 = this.f1215a.f1185a;
            kVar2.c();
            if (mVar.f1450a != null && mVar.f1450a.equals("")) {
                this.f1215a.a(mVar.f1450a);
            }
        }
        if (mVar.c == 0 && i != UtilHelper.NetworkStateInfo.UNAVAIL) {
            kVar3 = this.f1215a.f1185a;
            kVar3.b();
        }
    }
}
