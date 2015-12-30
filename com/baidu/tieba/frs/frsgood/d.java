package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ FrsGoodActivity bkp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsGoodActivity frsGoodActivity) {
        this.bkp = frsGoodActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        com.baidu.adp.widget.ListView.u au = this.bkp.bkj.OV().au(intValue);
        if (au instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) au;
            int i = bVar.UL;
            if (i == 0) {
                if (com.baidu.adp.lib.util.i.iQ() && !com.baidu.adp.lib.util.i.iR()) {
                    this.bkp.a(bVar, intValue, false);
                } else {
                    this.bkp.a(bVar, "btn_download");
                    this.bkp.a(bVar, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.H(this.bkp.getPageContext().getPageActivity(), bVar.US);
            }
            TiebaStatic.eventStat(this.bkp.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
