package com.baidu.tieba.account.forbid;

import com.baidu.tieba.z;
/* loaded from: classes.dex */
class b implements j {
    final /* synthetic */ a anI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.anI = aVar;
    }

    @Override // com.baidu.tieba.account.forbid.j
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.anI.anH;
        forbidActivity2 = this.anI.anH;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(z.forbid_success));
        forbidActivity3 = this.anI.anH;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.account.forbid.j
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.anI.anH;
        forbidActivity2 = this.anI.anH;
        forbidActivity.showToast(forbidActivity2.getPageContext().getString(z.forbid_failure));
    }
}
