package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.account.appeal.f;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class c implements f.b {
    final /* synthetic */ b aQc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aQc = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.aQc.aQb;
        appealActivity2 = this.aQc.aQb;
        appealActivity.w(appealActivity2.getPageContext().getString(r.l.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.aQc.aQb;
        if (at.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.aQc.aQb;
            string = appealActivity2.getPageContext().getString(r.l.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.w(string, false);
    }
}
