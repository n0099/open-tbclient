package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class cw implements View.OnClickListener {
    final /* synthetic */ FrsMoreFeedForumsActivity bjY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(FrsMoreFeedForumsActivity frsMoreFeedForumsActivity) {
        this.bjY = frsMoreFeedForumsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        int id = view.getId();
        view2 = this.bjY.bjm;
        if (id == view2.getId()) {
            this.bjY.finish();
        }
    }
}
