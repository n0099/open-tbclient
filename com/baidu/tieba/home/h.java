package com.baidu.tieba.home;
/* loaded from: classes.dex */
class h extends com.baidu.adp.a.e {
    final /* synthetic */ EnterForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EnterForumActivity enterForumActivity) {
        this.a = enterForumActivity;
    }

    @Override // com.baidu.adp.a.e
    public void a(Object obj) {
        com.baidu.tieba.c.ag agVar;
        com.baidu.tieba.c.j jVar;
        Boolean bool;
        int i;
        com.baidu.tieba.c.j jVar2;
        com.baidu.tieba.c.ag agVar2;
        boolean z = false;
        if (obj != null && (obj instanceof com.baidu.tieba.a.ac)) {
            z = true;
            jVar2 = this.a.d;
            agVar2 = this.a.e;
            jVar2.a(agVar2.d(), (com.baidu.tieba.a.ac) obj);
        }
        t tVar = this.a.c;
        agVar = this.a.e;
        tVar.b(z, agVar.c());
        if (z) {
            t tVar2 = this.a.c;
            jVar = this.a.d;
            bool = this.a.h;
            boolean booleanValue = bool.booleanValue();
            i = this.a.b;
            tVar2.a(jVar, booleanValue, i);
        }
    }
}
