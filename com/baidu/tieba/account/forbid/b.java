package com.baidu.tieba.account.forbid;

import com.baidu.tieba.z;
/* loaded from: classes.dex */
class b implements j {
    final /* synthetic */ a aoA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aoA = aVar;
    }

    @Override // com.baidu.tieba.account.forbid.j
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.aoA.aoz;
        forbidActivity2 = this.aoA.aoz;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(z.forbid_success));
        forbidActivity3 = this.aoA.aoz;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.account.forbid.j
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.aoA.aoz;
        forbidActivity2 = this.aoA.aoz;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(z.forbid_failure));
    }
}
