package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.account.appeal.f;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c implements f.b {
    final /* synthetic */ b aEn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aEn = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.aEn.aEm;
        appealActivity2 = this.aEn.aEm;
        appealActivity.s(appealActivity2.getPageContext().getString(i.h.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.aEn.aEm;
        if (as.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.aEn.aEm;
            string = appealActivity2.getPageContext().getString(i.h.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.s(string, false);
    }
}
