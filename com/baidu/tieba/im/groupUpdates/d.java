package com.baidu.tieba.im.groupUpdates;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ UpdatesActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(UpdatesActivity updatesActivity) {
        this.a = updatesActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        com.baidu.tieba.im.a aVar;
        p pVar;
        t tVar;
        p pVar2;
        t tVar2;
        aVar = this.a.d;
        p.b(aVar);
        pVar = this.a.j;
        pVar.b();
        tVar = this.a.b;
        pVar2 = this.a.j;
        tVar.a(pVar2.d());
        tVar2 = this.a.b;
        tVar2.c();
        this.a.a(false);
    }
}
