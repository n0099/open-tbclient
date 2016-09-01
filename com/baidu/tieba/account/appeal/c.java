package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.account.appeal.f;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c implements f.b {
    final /* synthetic */ b aSK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aSK = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.aSK.aSJ;
        appealActivity2 = this.aSK.aSJ;
        appealActivity.v(appealActivity2.getPageContext().getString(t.j.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.aSK.aSJ;
        if (ba.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.aSK.aSJ;
            string = appealActivity2.getPageContext().getString(t.j.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.v(string, false);
    }
}
