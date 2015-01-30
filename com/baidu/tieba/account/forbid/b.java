package com.baidu.tieba.account.forbid;

import com.baidu.tieba.z;
/* loaded from: classes.dex */
class b implements j {
    final /* synthetic */ a aoD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aoD = aVar;
    }

    @Override // com.baidu.tieba.account.forbid.j
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.aoD.aoC;
        forbidActivity2 = this.aoD.aoC;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(z.forbid_success));
        forbidActivity3 = this.aoD.aoC;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.account.forbid.j
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.aoD.aoC;
        forbidActivity2 = this.aoD.aoC;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(z.forbid_failure));
    }
}
