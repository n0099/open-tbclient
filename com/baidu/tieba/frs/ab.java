package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(FrsActivity frsActivity) {
        this.aBu = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        TiebaStatic.eventStat(this.aBu, "frs_nextpage", "frsclick", 1, new Object[0]);
        FrsActivity frsActivity = this.aBu;
        i = frsActivity.aAz;
        frsActivity.aAz = i + 1;
        this.aBu.eF(1);
    }
}
