package com.baidu.tieba.home;
/* loaded from: classes.dex */
class bh implements ac {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignAllForumActivity f1426a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(SignAllForumActivity signAllForumActivity) {
        this.f1426a = signAllForumActivity;
    }

    @Override // com.baidu.tieba.home.ac
    public void a(y yVar) {
        bx bxVar;
        bx bxVar2;
        bxVar = this.f1426a.f1394a;
        bxVar.e();
        r k = yVar.k();
        if (k != null && k.a() == 0) {
            bxVar2 = this.f1426a.f1394a;
            bxVar2.a(yVar);
            return;
        }
        this.f1426a.showToast(k.b());
        this.f1426a.finish();
    }

    @Override // com.baidu.tieba.home.ac
    public void a(String str) {
        this.f1426a.showToast(str);
        this.f1426a.finish();
    }
}
