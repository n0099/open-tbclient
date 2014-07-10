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
        p pVar;
        t tVar;
        com.baidu.tieba.im.a aVar;
        pVar = this.a.j;
        pVar.b();
        tVar = this.a.b;
        tVar.d();
        this.a.a(false);
        aVar = this.a.d;
        p.b(aVar);
    }
}
