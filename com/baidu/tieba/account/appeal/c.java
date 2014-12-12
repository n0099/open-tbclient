package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class c implements h {
    final /* synthetic */ b ant;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ant = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.ant.ans;
        appealActivity2 = this.ant.ans;
        appealActivity.q(appealActivity2.getPageContext().getString(z.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.ant.ans;
        if (ba.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.ant.ans;
            string = appealActivity2.getPageContext().getString(z.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.q(string, false);
    }
}
