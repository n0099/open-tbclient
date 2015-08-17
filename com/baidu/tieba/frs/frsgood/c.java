package com.baidu.tieba.frs.frsgood;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ FrsGoodActivity aZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsGoodActivity frsGoodActivity) {
        this.aZp = frsGoodActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u aA = this.aZp.aZj.MO().aA(((Integer) view.getTag()).intValue());
        if (aA instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aA;
            if (!cVar.rx()) {
                return;
            }
            this.aZp.a(cVar);
        }
    }
}
