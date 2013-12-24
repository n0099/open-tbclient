package com.baidu.tieba.im.groupUpdates;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ UpdatesActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(UpdatesActivity updatesActivity) {
        this.a = updatesActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        com.baidu.tieba.im.a aVar;
        m mVar;
        n nVar;
        m mVar2;
        n nVar2;
        aVar = this.a.d;
        m.b(aVar);
        mVar = this.a.j;
        mVar.b();
        nVar = this.a.b;
        mVar2 = this.a.j;
        nVar.a(mVar2.d());
        nVar2 = this.a.b;
        nVar2.f();
        this.a.a(false);
    }
}
