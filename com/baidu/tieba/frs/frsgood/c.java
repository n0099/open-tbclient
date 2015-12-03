package com.baidu.tieba.frs.frsgood;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ FrsGoodActivity bgy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsGoodActivity frsGoodActivity) {
        this.bgy = frsGoodActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u aB = this.bgy.bgr.OD().aB(((Integer) view.getTag()).intValue());
        if (aB instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) aB;
            if (!bVar.rD()) {
                return;
            }
            this.bgy.a(bVar);
        }
    }
}
