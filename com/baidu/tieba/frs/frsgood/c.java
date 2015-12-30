package com.baidu.tieba.frs.frsgood;

import android.view.View;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ FrsGoodActivity bkp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsGoodActivity frsGoodActivity) {
        this.bkp = frsGoodActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u au = this.bkp.bkj.OV().au(((Integer) view.getTag()).intValue());
        if (au instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) au;
            if (!bVar.rm()) {
                return;
            }
            this.bkp.b(bVar);
        }
    }
}
