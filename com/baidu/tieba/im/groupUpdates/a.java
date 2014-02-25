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
        q qVar;
        m mVar2;
        q qVar2;
        aVar = this.a.d;
        m.b(aVar);
        mVar = this.a.j;
        mVar.b();
        qVar = this.a.b;
        mVar2 = this.a.j;
        qVar.a(mVar2.d());
        qVar2 = this.a.b;
        qVar2.f();
        this.a.a(false);
    }
}
