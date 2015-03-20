package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.aJG = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bf bfVar;
        int intValue = ((Integer) view.getTag()).intValue();
        bfVar = this.aJG.aIS;
        com.baidu.adp.widget.ListView.ai aA = bfVar.Kk().aA(intValue);
        if (aA instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aA;
            if (!cVar.pQ()) {
                return;
            }
            this.aJG.a(cVar);
        }
    }
}
