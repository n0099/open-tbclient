package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class db implements View.OnClickListener {
    final /* synthetic */ FrsMoreFeedForumsActivity bph;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(FrsMoreFeedForumsActivity frsMoreFeedForumsActivity) {
        this.bph = frsMoreFeedForumsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        int id = view.getId();
        view2 = this.bph.bow;
        if (id == view2.getId()) {
            this.bph.finish();
        }
    }
}
