package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ FrsActivity aUK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.aUK = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bs bsVar;
        int intValue = ((Integer) view.getTag()).intValue();
        bsVar = this.aUK.aTU;
        com.baidu.adp.widget.ListView.u aA = bsVar.LV().aA(intValue);
        if (aA instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) aA;
            if (!bVar.ro()) {
                return;
            }
            this.aUK.a(bVar);
        }
    }
}
