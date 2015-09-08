package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.account.appeal.f;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c implements f.b {
    final /* synthetic */ b aGp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aGp = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.aGp.aGo;
        appealActivity2 = this.aGp.aGo;
        appealActivity.t(appealActivity2.getPageContext().getString(i.h.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.aGp.aGo;
        if (aq.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.aGp.aGo;
            string = appealActivity2.getPageContext().getString(i.h.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.t(string, false);
    }
}
