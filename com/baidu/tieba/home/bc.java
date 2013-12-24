package com.baidu.tieba.home;
/* loaded from: classes.dex */
class bc implements x {
    final /* synthetic */ SignAllForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(SignAllForumActivity signAllForumActivity) {
        this.a = signAllForumActivity;
    }

    @Override // com.baidu.tieba.home.x
    public void a(t tVar) {
        bs bsVar;
        bs bsVar2;
        bsVar = this.a.a;
        bsVar.e();
        m k = tVar.k();
        if (k != null && k.a() == 0) {
            bsVar2 = this.a.a;
            bsVar2.a(tVar);
            return;
        }
        this.a.showToast(k.b());
        this.a.finish();
    }

    @Override // com.baidu.tieba.home.x
    public void a(String str) {
        this.a.showToast(str);
        this.a.finish();
    }
}
