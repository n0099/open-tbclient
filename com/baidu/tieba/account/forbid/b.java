package com.baidu.tieba.account.forbid;

import com.baidu.tieba.y;
/* loaded from: classes.dex */
class b implements j {
    final /* synthetic */ a agr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.agr = aVar;
    }

    @Override // com.baidu.tieba.account.forbid.j
    public void a(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        ForbidActivity forbidActivity3;
        forbidActivity = this.agr.agq;
        forbidActivity2 = this.agr.agq;
        forbidActivity.showToast(forbidActivity2.getString(y.forbid_success));
        forbidActivity3 = this.agr.agq;
        forbidActivity3.finish();
    }

    @Override // com.baidu.tieba.account.forbid.j
    public void b(ForbidResultData forbidResultData) {
        ForbidActivity forbidActivity;
        ForbidActivity forbidActivity2;
        forbidActivity = this.agr.agq;
        forbidActivity2 = this.agr.agq;
        forbidActivity.showToast(forbidActivity2.getString(y.forbid_failure));
    }
}
