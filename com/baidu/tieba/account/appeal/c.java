package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class c implements h {
    final /* synthetic */ b awv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.awv = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.awv.awu;
        appealActivity2 = this.awv.awu;
        appealActivity.r(appealActivity2.getPageContext().getString(y.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.awv.awu;
        if (bd.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.awv.awu;
            string = appealActivity2.getPageContext().getString(y.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.r(string, false);
    }
}
