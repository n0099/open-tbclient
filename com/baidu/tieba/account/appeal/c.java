package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.account.appeal.f;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class c implements f.b {
    final /* synthetic */ b aFi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aFi = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.aFi.aFh;
        appealActivity2 = this.aFi.aFh;
        appealActivity.u(appealActivity2.getPageContext().getString(i.h.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.aFi.aFh;
        if (ar.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.aFi.aFh;
            string = appealActivity2.getPageContext().getString(i.h.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.u(string, false);
    }
}
