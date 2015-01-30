package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        TiebaStatic.eventStat(this.aDW.getPageContext().getPageActivity(), "frs_nextpage", "frsclick", 1, new Object[0]);
        FrsActivity frsActivity = this.aDW;
        i = frsActivity.aCS;
        frsActivity.aCS = i + 1;
        this.aDW.eJ(1);
    }
}
