package com.baidu.tieba.account.forbid;

import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class d implements j {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1083a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f1083a = cVar;
    }

    @Override // com.baidu.tieba.account.forbid.j
    public void a(ForbidResultData forbidResultData) {
        this.f1083a.f1082a.showToast(this.f1083a.f1082a.getString(R.string.forbid_success));
        this.f1083a.f1082a.finish();
    }

    @Override // com.baidu.tieba.account.forbid.j
    public void b(ForbidResultData forbidResultData) {
        this.f1083a.f1082a.showToast(this.f1083a.f1082a.getString(R.string.forbid_failure));
    }
}
