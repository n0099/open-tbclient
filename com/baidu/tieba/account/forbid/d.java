package com.baidu.tieba.account.forbid;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class d implements j {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.tieba.account.forbid.j
    public void a(ForbidResultData forbidResultData) {
        this.a.a.showToast(this.a.a.getString(R.string.forbid_success));
        this.a.a.finish();
    }

    @Override // com.baidu.tieba.account.forbid.j
    public void b(ForbidResultData forbidResultData) {
        this.a.a.showToast(this.a.a.getString(R.string.forbid_failure));
    }
}
