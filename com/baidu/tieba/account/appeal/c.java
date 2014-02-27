package com.baidu.tieba.account.appeal;

import com.baidu.tieba.util.bs;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class c implements h {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.tieba.account.appeal.h
    public final void a() {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        appealActivity = this.a.a;
        appealActivity2 = this.a.a;
        AppealActivity.a(appealActivity, appealActivity2.getString(R.string.appeal_post_success), true);
    }

    @Override // com.baidu.tieba.account.appeal.h
    public final void a(AppealData appealData) {
        AppealActivity appealActivity;
        AppealActivity appealActivity2;
        String string;
        appealActivity = this.a.a;
        if (bs.c(appealData.errMsg)) {
            appealActivity2 = this.a.a;
            string = appealActivity2.getString(R.string.appeal_post_failure);
        } else {
            string = appealData.errMsg;
        }
        AppealActivity.a(appealActivity, string, false);
    }
}
