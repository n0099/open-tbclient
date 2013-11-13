package com.baidu.tieba.account.appeal;

import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class d implements h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1045a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f1045a = cVar;
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void a(AppealData appealData) {
        this.f1045a.f1044a.a(this.f1045a.f1044a.getString(R.string.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void b(AppealData appealData) {
        this.f1045a.f1044a.a(!be.c(appealData.errMsg) ? appealData.errMsg : this.f1045a.f1044a.getString(R.string.appeal_post_failure), false);
    }
}
