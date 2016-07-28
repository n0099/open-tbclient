package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.account.appeal.f;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class c implements f.b {
    final /* synthetic */ b aNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aNq = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.aNq.aNp;
        appealActivity2 = this.aNq.aNp;
        appealActivity.u(appealActivity2.getPageContext().getString(u.j.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.aNq.aNp;
        if (ba.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.aNq.aNp;
            string = appealActivity2.getPageContext().getString(u.j.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.u(string, false);
    }
}
