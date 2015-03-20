package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.aJG = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aJG.oi().AI();
    }
}
