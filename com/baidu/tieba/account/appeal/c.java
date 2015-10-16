package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.account.appeal.f;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c implements f.b {
    final /* synthetic */ b aFt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aFt = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.aFt.aFs;
        appealActivity2 = this.aFt.aFs;
        appealActivity.u(appealActivity2.getPageContext().getString(i.h.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.aFt.aFs;
        if (as.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.aFt.aFs;
            string = appealActivity2.getPageContext().getString(i.h.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.u(string, false);
    }
}
