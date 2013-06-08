package com.baidu.tieba.home;

import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class g extends com.baidu.adp.a.e {
    final /* synthetic */ EnterForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EnterForumActivity enterForumActivity) {
        this.a = enterForumActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        com.baidu.tieba.c.j jVar;
        com.baidu.tieba.c.j jVar2;
        com.baidu.tieba.c.j jVar3;
        jVar = this.a.d;
        if (jVar.a() != 1) {
            jVar2 = this.a.d;
            if (jVar2.a() != 2 || !((Boolean) obj).booleanValue()) {
                return;
            }
            this.a.o();
            return;
        }
        if (((Boolean) obj).booleanValue()) {
            TiebaApplication.d().i(false);
            this.a.o();
        }
        t tVar = this.a.c;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        jVar3 = this.a.d;
        tVar.a(booleanValue, jVar3.c());
    }
}
