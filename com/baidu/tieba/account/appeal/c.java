package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c implements h {
    final /* synthetic */ b ayb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ayb = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.ayb.aya;
        appealActivity2 = this.ayb.aya;
        appealActivity.r(appealActivity2.getPageContext().getString(t.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.ayb.aya;
        if (bb.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.ayb.aya;
            string = appealActivity2.getPageContext().getString(t.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.r(string, false);
    }
}
