package com.baidu.tieba.home;

import com.baidu.tieba.util.UtilHelper;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.model.m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1183a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(EnterForumActivity enterForumActivity) {
        this.f1183a = enterForumActivity;
    }

    @Override // com.baidu.tieba.model.m
    public void a(com.baidu.tieba.model.k kVar) {
        k kVar2;
        k kVar3;
        k kVar4;
        k kVar5;
        com.baidu.tieba.model.j jVar;
        Boolean bool;
        k kVar6;
        k kVar7;
        UtilHelper.NetworkStateInfo i = UtilHelper.i(this.f1183a);
        if (i == UtilHelper.NetworkStateInfo.UNAVAIL) {
            kVar7 = this.f1183a.f1138a;
            kVar7.k();
        }
        kVar2 = this.f1183a.f1138a;
        kVar2.a(true, "");
        if (kVar.b) {
            kVar5 = this.f1183a.f1138a;
            jVar = this.f1183a.c;
            com.baidu.tieba.data.q a2 = jVar.a();
            bool = this.f1183a.f;
            kVar5.a(a2, bool.booleanValue());
            kVar6 = this.f1183a.f1138a;
            kVar6.e();
        } else {
            kVar3 = this.f1183a.f1138a;
            kVar3.c();
            if (kVar.f1409a != null && kVar.f1409a.equals("")) {
                this.f1183a.a(kVar.f1409a);
            }
        }
        if (kVar.c == 0 && i != UtilHelper.NetworkStateInfo.UNAVAIL) {
            kVar4 = this.f1183a.f1138a;
            kVar4.b();
        }
    }
}
