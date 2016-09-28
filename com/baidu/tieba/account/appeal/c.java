package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.account.appeal.f;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class c implements f.b {
    final /* synthetic */ b aTu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aTu = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.aTu.aTt;
        appealActivity2 = this.aTu.aTt;
        appealActivity.w(appealActivity2.getPageContext().getString(r.j.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.aTu.aTt;
        if (az.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.aTu.aTt;
            string = appealActivity2.getPageContext().getString(r.j.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.w(string, false);
    }
}
