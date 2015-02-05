package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        TiebaStatic.eventStat(this.aDT.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
        FrsActivity frsActivity = this.aDT;
        i = frsActivity.aCP;
        frsActivity.aCP = i + 1;
        this.aDT.eJ(1);
    }
}
