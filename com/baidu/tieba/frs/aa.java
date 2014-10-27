package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2;
        i = this.aBk.aAp;
        if (i > 1) {
            FrsActivity frsActivity = this.aBk;
            i2 = frsActivity.aAp;
            frsActivity.aAp = i2 - 1;
            this.aBk.eF(2);
        }
    }
}
