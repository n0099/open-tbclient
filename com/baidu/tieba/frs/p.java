package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.blk = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u aF = this.blk.bko.Sb().aF(((Integer) view.getTag()).intValue());
        if (aF instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aF;
            if (!cVar.rm()) {
                return;
            }
            this.blk.b(cVar);
        }
    }
}
