package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.aUS = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bs bsVar;
        int intValue = ((Integer) view.getTag()).intValue();
        bsVar = this.aUS.aUc;
        com.baidu.adp.widget.ListView.u aA = bsVar.Ml().aA(intValue);
        if (aA instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) aA;
            if (!bVar.rp()) {
                return;
            }
            this.aUS.a(bVar);
        }
    }
}
