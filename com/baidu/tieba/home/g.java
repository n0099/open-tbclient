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
        com.baidu.tieba.c.g gVar;
        com.baidu.tieba.c.g gVar2;
        com.baidu.tieba.c.g gVar3;
        gVar = this.a.d;
        if (gVar.a() != 1) {
            gVar2 = this.a.d;
            if (gVar2.a() != 2 || !((Boolean) obj).booleanValue()) {
                return;
            }
            this.a.o();
            return;
        }
        if (((Boolean) obj).booleanValue()) {
            TiebaApplication.d().h(false);
            this.a.o();
        }
        t tVar = this.a.c;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        gVar3 = this.a.d;
        tVar.a(booleanValue, gVar3.c());
    }
}
