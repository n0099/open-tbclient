package com.baidu.tieba.frs.frsgood;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ FrsGoodActivity baf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsGoodActivity frsGoodActivity) {
        this.baf = frsGoodActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u aA = this.baf.aZZ.Nb().aA(((Integer) view.getTag()).intValue());
        if (aA instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) aA;
            if (!bVar.rp()) {
                return;
            }
            this.baf.a(bVar);
        }
    }
}
