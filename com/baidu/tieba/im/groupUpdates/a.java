package com.baidu.tieba.im.groupUpdates;
/* loaded from: classes.dex */
final class a implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ UpdatesActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(UpdatesActivity updatesActivity) {
        this.a = updatesActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        com.baidu.tieba.im.a aVar;
        m mVar;
        q qVar;
        m mVar2;
        q qVar2;
        aVar = this.a.d;
        m.a(aVar);
        mVar = this.a.j;
        mVar.b();
        qVar = this.a.b;
        mVar2 = this.a.j;
        qVar.a(mVar2.c());
        qVar2 = this.a.b;
        qVar2.d();
        this.a.a(false);
    }
}
