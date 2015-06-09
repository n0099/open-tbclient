package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c implements h {
    final /* synthetic */ b ayc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ayc = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.ayc.ayb;
        appealActivity2 = this.ayc.ayb;
        appealActivity.r(appealActivity2.getPageContext().getString(t.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.ayc.ayb;
        if (bb.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.ayc.ayb;
            string = appealActivity2.getPageContext().getString(t.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.r(string, false);
    }
}
