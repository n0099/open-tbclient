package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ FrsActivity aLX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.aLX = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bf bfVar;
        int intValue = ((Integer) view.getTag()).intValue();
        bfVar = this.aLX.aLi;
        com.baidu.adp.widget.ListView.ai ay = bfVar.Lw().ay(intValue);
        if (ay instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) ay;
            if (!cVar.qw()) {
                return;
            }
            this.aLX.a(cVar);
        }
    }
}
