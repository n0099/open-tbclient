package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
class c implements h {
    final /* synthetic */ b aol;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aol = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.aol.aok;
        appealActivity2 = this.aol.aok;
        appealActivity.q(appealActivity2.getPageContext().getString(z.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.aol.aok;
        if (bf.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.aol.aok;
            string = appealActivity2.getPageContext().getString(z.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.q(string, false);
    }
}
