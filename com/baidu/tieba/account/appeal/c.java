package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class c implements h {
    final /* synthetic */ b afU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.afU = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.afU.afT;
        appealActivity2 = this.afU.afT;
        appealActivity.r(appealActivity2.getString(y.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.afU.afT;
        if (ay.aA(appealData.errMsg)) {
            appealActivity2 = this.afU.afT;
            string = appealActivity2.getString(y.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.r(string, false);
    }
}
