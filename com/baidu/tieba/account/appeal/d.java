package com.baidu.tieba.account.appeal;

import com.baidu.tieba.util.bb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class d implements h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1057a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f1057a = cVar;
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void a(AppealData appealData) {
        this.f1057a.f1056a.a(this.f1057a.f1056a.getString(R.string.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void b(AppealData appealData) {
        this.f1057a.f1056a.a(!bb.c(appealData.errMsg) ? appealData.errMsg : this.f1057a.f1056a.getString(R.string.appeal_post_failure), false);
    }
}
