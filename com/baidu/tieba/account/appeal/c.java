package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.account.appeal.f;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements f.b {
    final /* synthetic */ b aVu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aVu = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.aVu.aVt;
        appealActivity2 = this.aVu.aVt;
        appealActivity.u(appealActivity2.getPageContext().getString(w.l.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.aVu.aVt;
        if (aw.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.aVu.aVt;
            string = appealActivity2.getPageContext().getString(w.l.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.u(string, false);
    }
}
