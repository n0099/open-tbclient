package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.aBu = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        i = this.aBu.aAz;
        if (i > 1) {
            FrsActivity frsActivity = this.aBu;
            i2 = frsActivity.aAz;
            frsActivity.aAz = i2 - 1;
            this.aBu.eF(2);
        }
    }
}
