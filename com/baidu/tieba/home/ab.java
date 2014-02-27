package com.baidu.tieba.home;
/* loaded from: classes.dex */
final class ab implements y {
    final /* synthetic */ SignAllForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(SignAllForumActivity signAllForumActivity) {
        this.a = signAllForumActivity;
    }

    @Override // com.baidu.tieba.home.y
    public final void a(u uVar) {
        as asVar;
        as asVar2;
        asVar = this.a.a;
        asVar.d();
        q k = uVar.k();
        if (k != null && k.a() == 0) {
            asVar2 = this.a.a;
            asVar2.a(uVar);
            return;
        }
        this.a.showToast(k.b());
        this.a.finish();
    }

    @Override // com.baidu.tieba.home.y
    public final void a(String str) {
        this.a.showToast(str);
        this.a.finish();
    }
}
