package com.baidu.tieba.home;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.pushNotify.m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EnterForumActivity f1356a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EnterForumActivity enterForumActivity) {
        this.f1356a = enterForumActivity;
    }

    @Override // com.baidu.tieba.im.pushNotify.m
    public void a(GroupNewsPojo groupNewsPojo) {
        n nVar;
        n nVar2;
        n nVar3;
        n nVar4;
        n nVar5;
        nVar = this.f1356a.c;
        if (nVar != null) {
            nVar2 = this.f1356a.c;
            if (nVar2.d != null) {
                nVar3 = this.f1356a.c;
                if (nVar3.d.f1381a != null) {
                    if (this.f1356a.b()) {
                        nVar5 = this.f1356a.c;
                        nVar5.d.f1381a.b();
                        return;
                    }
                    nVar4 = this.f1356a.c;
                    nVar4.d.c = true;
                }
            }
        }
    }
}
