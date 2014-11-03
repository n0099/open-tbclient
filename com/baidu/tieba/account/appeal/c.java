package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class c implements h {
    final /* synthetic */ b agc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.agc = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.agc.agb;
        appealActivity2 = this.agc.agb;
        appealActivity.r(appealActivity2.getString(y.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.h
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.agc.agb;
        if (az.aA(appealData.errMsg)) {
            appealActivity2 = this.agc.agb;
            string = appealActivity2.getString(y.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.r(string, false);
    }
}
