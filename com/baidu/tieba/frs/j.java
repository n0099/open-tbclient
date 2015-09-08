package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ FrsActivity aVz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.aVz = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        int intValue = ((Integer) view.getTag()).intValue();
        biVar = this.aVz.aUL;
        com.baidu.adp.widget.ListView.u aA = biVar.Ma().aA(intValue);
        if (aA instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aA;
            if (!cVar.rw()) {
                return;
            }
            this.aVz.a(cVar);
        }
    }
}
