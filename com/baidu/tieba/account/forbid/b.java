package com.baidu.tieba.account.forbid;
/* loaded from: classes.dex */
final class b implements j {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.account.forbid.j
    public final void a() {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.a.a;
        forbidActivity2 = this.a.a;
        forbidActivity.showToast(forbidActivity2.getString(com.baidu.tieba.a.k.forbid_success));
        forbidActivity3 = this.a.a;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.account.forbid.j
    public final void b() {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.a.a;
        forbidActivity2 = this.a.a;
        forbidActivity.showToast(forbidActivity2.getString(com.baidu.tieba.a.k.forbid_failure));
    }
}
