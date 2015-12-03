package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class cm implements View.OnClickListener {
    final /* synthetic */ FrsMoreFeedForumsActivity bdj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(FrsMoreFeedForumsActivity frsMoreFeedForumsActivity) {
        this.bdj = frsMoreFeedForumsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2;
        int id = view.getId();
        view2 = this.bdj.bcC;
        if (id == view2.getId()) {
            this.bdj.finish();
        }
    }
}
