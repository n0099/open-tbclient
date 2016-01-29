package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.account.appeal.f;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c implements f.b {
    final /* synthetic */ b aJT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aJT = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.aJT.aJS;
        appealActivity2 = this.aJT.aJS;
        appealActivity.u(appealActivity2.getPageContext().getString(t.j.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.aJT.aJS;
        if (aw.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.aJT.aJS;
            string = appealActivity2.getPageContext().getString(t.j.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.u(string, false);
    }
}
