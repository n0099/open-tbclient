package com.baidu.tieba.account.forbid;

import com.baidu.tieba.y;
/* loaded from: classes.dex */
class b implements j {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.account.forbid.j
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.a.a;
        forbidActivity2 = this.a.a;
        forbidActivity.showToast(forbidActivity2.getString(y.forbid_success));
        forbidActivity3 = this.a.a;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.account.forbid.j
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.a.a;
        forbidActivity2 = this.a.a;
        forbidActivity.showToast(forbidActivity2.getString(y.forbid_failure));
    }
}
