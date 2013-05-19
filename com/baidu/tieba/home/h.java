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
        com.baidu.tieba.c.ad adVar;
        com.baidu.tieba.c.g gVar;
        Boolean bool;
        int i;
        com.baidu.tieba.c.g gVar2;
        com.baidu.tieba.c.ad adVar2;
        boolean z = false;
        if (obj != null && (obj instanceof com.baidu.tieba.a.ac)) {
            z = true;
            gVar2 = this.a.d;
            adVar2 = this.a.e;
            gVar2.a(adVar2.d(), (com.baidu.tieba.a.ac) obj);
        }
        t tVar = this.a.c;
        adVar = this.a.e;
        tVar.b(z, adVar.c());
        if (z) {
            t tVar2 = this.a.c;
            gVar = this.a.d;
            bool = this.a.h;
            boolean booleanValue = bool.booleanValue();
            i = this.a.b;
            tVar2.a(gVar, booleanValue, i);
        }
    }
}
