package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        TiebaStatic.eventStat(this.aBk, "frs_nextpage", "frsclick", 1, new Object[0]);
        FrsActivity frsActivity = this.aBk;
        i = frsActivity.aAp;
        frsActivity.aAp = i + 1;
        this.aBk.eF(1);
    }
}
