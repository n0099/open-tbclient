package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.account.appeal.f;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class c implements f.b {
    final /* synthetic */ b aVO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aVO = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.aVO.aVN;
        appealActivity2 = this.aVO.aVN;
        appealActivity.w(appealActivity2.getPageContext().getString(w.l.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.aVO.aVN;
        if (au.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.aVO.aVN;
            string = appealActivity2.getPageContext().getString(w.l.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.w(string, false);
    }
}
