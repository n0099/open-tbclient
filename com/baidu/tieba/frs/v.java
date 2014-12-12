package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        i = this.aCV.aBR;
        if (i > 1) {
            FrsActivity frsActivity = this.aCV;
            i2 = frsActivity.aBR;
            frsActivity.aBR = i2 - 1;
            this.aCV.eD(2);
        }
    }
}
