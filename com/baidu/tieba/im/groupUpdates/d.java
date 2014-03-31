package com.baidu.tieba.im.groupUpdates;
/* loaded from: classes.dex */
final class d implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ UpdatesActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(UpdatesActivity updatesActivity) {
        this.a = updatesActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        com.baidu.tieba.im.a aVar;
        p pVar;
        t tVar;
        p pVar2;
        t tVar2;
        aVar = this.a.d;
        p.a(aVar);
        pVar = this.a.j;
        pVar.b();
        tVar = this.a.b;
        pVar2 = this.a.j;
        tVar.a(pVar2.c());
        tVar2 = this.a.b;
        tVar2.d();
        this.a.a(false);
    }
}
