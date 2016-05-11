package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class cx implements View.OnClickListener {
    final /* synthetic */ FrsMoreFeedForumsActivity bkA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(FrsMoreFeedForumsActivity frsMoreFeedForumsActivity) {
        this.bkA = frsMoreFeedForumsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        int id = view.getId();
        view2 = this.bkA.bjF;
        if (id == view2.getId()) {
            this.bkA.finish();
        }
    }
}
