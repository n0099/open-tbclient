package com.baidu.tieba.home;
/* loaded from: classes.dex */
class bc implements x {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignAllForumActivity f1467a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(SignAllForumActivity signAllForumActivity) {
        this.f1467a = signAllForumActivity;
    }

    @Override // com.baidu.tieba.home.x
    public void a(t tVar) {
        bs bsVar;
        bs bsVar2;
        bsVar = this.f1467a.f1439a;
        bsVar.e();
        m k = tVar.k();
        if (k != null && k.a() == 0) {
            bsVar2 = this.f1467a.f1439a;
            bsVar2.a(tVar);
            return;
        }
        this.f1467a.showToast(k.b());
        this.f1467a.finish();
    }

    @Override // com.baidu.tieba.home.x
    public void a(String str) {
        this.f1467a.showToast(str);
        this.f1467a.finish();
    }
}
