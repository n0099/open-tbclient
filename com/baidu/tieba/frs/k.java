package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ FrsActivity bag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.bag = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u aB = this.bag.aZq.NM().aB(((Integer) view.getTag()).intValue());
        if (aB instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) aB;
            if (!bVar.rD()) {
                return;
            }
            this.bag.a(bVar);
        }
    }
}
