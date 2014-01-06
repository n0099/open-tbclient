package com.baidu.tieba.account.appeal;

import com.baidu.tieba.util.bm;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class d implements h {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void a(AppealData appealData) {
        this.a.a.a(this.a.a.getString(R.string.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void b(AppealData appealData) {
        this.a.a.a(!bm.c(appealData.errMsg) ? appealData.errMsg : this.a.a.getString(R.string.appeal_post_failure), false);
    }
}
