package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.this$0 = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        int intValue = ((Integer) view.getTag()).intValue();
        blVar = this.this$0.aUw;
        com.baidu.adp.widget.ListView.u aA = blVar.Mj().aA(intValue);
        if (aA instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aA;
            if (!cVar.rx()) {
                return;
            }
            this.this$0.a(cVar);
        }
    }
}
