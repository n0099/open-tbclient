package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.adkiller.SubmitCloseNetMessage;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.bgz = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u aG = this.bgz.bfD.Qi().aG(((Integer) view.getTag()).intValue());
        if (aG instanceof com.baidu.tbadk.core.data.c) {
            SubmitCloseNetMessage submitCloseNetMessage = new SubmitCloseNetMessage();
            submitCloseNetMessage.setKillTag(((com.baidu.tbadk.core.data.c) aG).UM);
            submitCloseNetMessage.setType(2);
            this.bgz.sendMessage(submitCloseNetMessage);
        }
    }
}
