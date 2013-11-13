package com.baidu.tieba.account.forbid;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class d implements j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1069a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f1069a = cVar;
    }

    @Override // com.baidu.tieba.account.forbid.j
    public void a(ForbidResultData forbidResultData) {
        this.f1069a.f1068a.showToast(this.f1069a.f1068a.getString(R.string.forbid_success));
        this.f1069a.f1068a.finish();
    }

    @Override // com.baidu.tieba.account.forbid.j
    public void b(ForbidResultData forbidResultData) {
        this.f1069a.f1068a.showToast(this.f1069a.f1068a.getString(R.string.forbid_failure));
    }
}
