package com.baidu.tieba.frs.frsgood;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ FrsGoodActivity bnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsGoodActivity frsGoodActivity) {
        this.bnm = frsGoodActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u aG = this.bnm.bng.QY().aG(((Integer) view.getTag()).intValue());
        if (aG instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aG;
            if (!cVar.rO()) {
                return;
            }
            this.bnm.b(cVar);
        }
    }
}
