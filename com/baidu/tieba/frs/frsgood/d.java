package com.baidu.tieba.frs.frsgood;

import android.view.View;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ FrsGoodActivity bsj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsGoodActivity frsGoodActivity) {
        this.bsj = frsGoodActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u aF = this.bsj.bsd.SM().aF(((Integer) view.getTag()).intValue());
        if (aF instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aF;
            if (!cVar.rm()) {
                return;
            }
            this.bsj.b(cVar);
        }
    }
}
