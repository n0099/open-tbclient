package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.adkiller.SubmitCloseNetMessage;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.blk = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u aF = this.blk.bko.Sb().aF(((Integer) view.getTag()).intValue());
        if (aF instanceof com.baidu.tbadk.core.data.c) {
            SubmitCloseNetMessage submitCloseNetMessage = new SubmitCloseNetMessage();
            submitCloseNetMessage.setKillTag(((com.baidu.tbadk.core.data.c) aF).Sr);
            submitCloseNetMessage.setType(2);
            this.blk.sendMessage(submitCloseNetMessage);
        }
    }
}
