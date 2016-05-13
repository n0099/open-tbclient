package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.bhl = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cn cnVar;
        int intValue = ((Integer) view.getTag()).intValue();
        cnVar = this.bhl.bgo;
        com.baidu.adp.widget.ListView.v as = cnVar.Ra().as(intValue);
        if (as instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) as;
            if (!cVar.oH()) {
                return;
            }
            this.bhl.b(cVar);
        }
    }
}
