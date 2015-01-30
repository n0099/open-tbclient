package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        i = this.aDW.aCS;
        if (i > 1) {
            FrsActivity frsActivity = this.aDW;
            i2 = frsActivity.aCS;
            frsActivity.aCS = i2 - 1;
            this.aDW.eJ(2);
        }
    }
}
