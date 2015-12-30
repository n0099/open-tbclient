package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class cp implements View.OnClickListener {
    final /* synthetic */ FrsMoreFeedForumsActivity bhj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(FrsMoreFeedForumsActivity frsMoreFeedForumsActivity) {
        this.bhj = frsMoreFeedForumsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        int id = view.getId();
        view2 = this.bhj.bgC;
        if (id == view2.getId()) {
            this.bhj.finish();
        }
    }
}
