package com.baidu.tieba.im.groupUpdates;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ UpdatesActivity a;
    private final /* synthetic */ com.baidu.tieba.im.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(UpdatesActivity updatesActivity, com.baidu.tieba.im.a aVar) {
        this.a = updatesActivity;
        this.b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        p pVar;
        t tVar;
        pVar = this.a.i;
        pVar.b();
        tVar = this.a.b;
        tVar.d();
        this.a.a(false);
        p.b(this.b);
    }
}
