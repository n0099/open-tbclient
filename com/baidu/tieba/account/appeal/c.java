package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.account.appeal.f;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class c implements f.b {
    final /* synthetic */ b aUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aUM = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.aUM.aUL;
        appealActivity2 = this.aUM.aUL;
        appealActivity.w(appealActivity2.getPageContext().getString(r.j.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.aUM.aUL;
        if (av.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.aUM.aUL;
            string = appealActivity2.getPageContext().getString(r.j.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.w(string, false);
    }
}
