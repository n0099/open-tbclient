package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        i = this.aDT.aCP;
        if (i > 1) {
            FrsActivity frsActivity = this.aDT;
            i2 = frsActivity.aCP;
            frsActivity.aCP = i2 - 1;
            this.aDT.eJ(2);
        }
    }
}
