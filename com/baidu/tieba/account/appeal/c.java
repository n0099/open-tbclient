package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.account.appeal.f;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class c implements f.b {
    final /* synthetic */ b aHm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aHm = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.aHm.aHl;
        appealActivity2 = this.aHm.aHl;
        appealActivity.t(appealActivity2.getPageContext().getString(n.i.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.aHm.aHl;
        if (ax.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.aHm.aHl;
            string = appealActivity2.getPageContext().getString(n.i.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.t(string, false);
    }
}
