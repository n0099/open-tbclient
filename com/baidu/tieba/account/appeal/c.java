package com.baidu.tieba.account.appeal;

import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.account.appeal.f;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class c implements f.b {
    final /* synthetic */ b aMP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aMP = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.aMP.aMO;
        appealActivity2 = this.aMP.aMO;
        appealActivity.t(appealActivity2.getPageContext().getString(t.j.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.f.b
    public void b(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.aMP.aMO;
        if (ay.isEmpty(appealData.errMsg)) {
            appealActivity2 = this.aMP.aMO;
            string = appealActivity2.getPageContext().getString(t.j.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        appealActivity.t(string, false);
    }
}
