package com.baidu.tieba.home;
/* loaded from: classes.dex */
class bd implements y {
    final /* synthetic */ SignAllForumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(SignAllForumActivity signAllForumActivity) {
        this.a = signAllForumActivity;
    }

    @Override // com.baidu.tieba.home.y
    public void a(u uVar) {
        bu buVar;
        bu buVar2;
        buVar = this.a.a;
        buVar.e();
        n k = uVar.k();
        if (k != null && k.a() == 0) {
            buVar2 = this.a.a;
            buVar2.a(uVar);
            return;
        }
        this.a.showToast(k.b());
        this.a.finish();
    }

    @Override // com.baidu.tieba.home.y
    public void a(String str) {
        this.a.showToast(str);
        this.a.finish();
    }
}
