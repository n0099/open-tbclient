package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.adkiller.SubmitCloseNetMessage;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FrsActivity frsActivity) {
        this.bhl = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cn cnVar;
        int intValue = ((Integer) view.getTag()).intValue();
        cnVar = this.bhl.bgo;
        com.baidu.adp.widget.ListView.v at = cnVar.Ra().at(intValue);
        if (at instanceof com.baidu.tbadk.core.data.c) {
            SubmitCloseNetMessage submitCloseNetMessage = new SubmitCloseNetMessage();
            submitCloseNetMessage.setKillTag(((com.baidu.tbadk.core.data.c) at).Nf);
            submitCloseNetMessage.setType(2);
            this.bhl.sendMessage(submitCloseNetMessage);
        }
    }
}
