package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.account.appeal.f;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c implements f.b {
    final /* synthetic */ b aIZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aIZ = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.aIZ.aIY;
        appealActivity2 = this.aIZ.aIY;
        appealActivity.u(appealActivity2.getPageContext().getString(t.j.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.aIZ.aIY;
        if (ay.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.aIZ.aIY;
            string = appealActivity2.getPageContext().getString(t.j.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.u(string, false);
    }
}
