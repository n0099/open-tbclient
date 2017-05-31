package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.account.appeal.f;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements f.b {
    final /* synthetic */ b aUb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aUb = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.aUb.aUa;
        appealActivity2 = this.aUb.aUa;
        appealActivity.t(appealActivity2.getPageContext().getString(w.l.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.aUb.aUa;
        if (au.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.aUb.aUa;
            string = appealActivity2.getPageContext().getString(w.l.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.t(string, false);
    }
}
