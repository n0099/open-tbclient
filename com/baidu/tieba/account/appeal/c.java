package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.account.appeal.f;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class c implements f.b {
    final /* synthetic */ b aVv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aVv = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.aVv.aVu;
        appealActivity2 = this.aVv.aVu;
        appealActivity.w(appealActivity2.getPageContext().getString(r.j.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.aVv.aVu;
        if (ax.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.aVv.aVu;
            string = appealActivity2.getPageContext().getString(r.j.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.w(string, false);
    }
}
