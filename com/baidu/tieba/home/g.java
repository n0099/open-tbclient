package com.baidu.tieba.home;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.im.pushNotify.m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1451a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EnterForumActivity enterForumActivity) {
        this.f1451a = enterForumActivity;
    }

    @Override // com.baidu.tieba.im.pushNotify.m
    public void a(GroupNewsPojo groupNewsPojo) {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        oVar = this.f1451a.c;
        if (oVar != null) {
            oVar2 = this.f1451a.c;
            if (oVar2.f1459a != null) {
                if (this.f1451a.a()) {
                    oVar4 = this.f1451a.c;
                    oVar4.f1459a.f1477a.b();
                    return;
                }
                oVar3 = this.f1451a.c;
                oVar3.f1459a.c = true;
            }
        }
    }
}
