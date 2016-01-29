package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.bgz = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u aG = this.bgz.bfD.Qi().aG(((Integer) view.getTag()).intValue());
        if (aG instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aG;
            if (!cVar.rO()) {
                return;
            }
            this.bgz.b(cVar);
        }
    }
}
