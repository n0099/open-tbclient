package com.baidu.tieba.im.groupUpdates;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UpdatesActivity f1707a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(UpdatesActivity updatesActivity) {
        this.f1707a = updatesActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        com.baidu.tieba.im.a aVar;
        m mVar;
        n nVar;
        m mVar2;
        n nVar2;
        aVar = this.f1707a.d;
        m.b(aVar);
        mVar = this.f1707a.j;
        mVar.b();
        nVar = this.f1707a.b;
        mVar2 = this.f1707a.j;
        nVar.a(mVar2.d());
        nVar2 = this.f1707a.b;
        nVar2.f();
        this.f1707a.a(false);
    }
}
