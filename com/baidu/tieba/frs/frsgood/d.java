package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ FrsGoodActivity bgy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsGoodActivity frsGoodActivity) {
        this.bgy = frsGoodActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        com.baidu.adp.widget.ListView.u aB = this.bgy.bgr.OD().aB(intValue);
        if (aB instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) aB;
            int i = bVar.Ul;
            if (i == 0) {
                if (com.baidu.adp.lib.util.i.iP() && !com.baidu.adp.lib.util.i.iQ()) {
                    this.bgy.a(bVar, intValue);
                } else {
                    this.bgy.a(bVar, "btn_download");
                    this.bgy.b(bVar, "download");
                    this.bgy.b((com.baidu.tbadk.core.data.b) aB, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.H(this.bgy.getPageContext().getPageActivity(), bVar.Ur);
            }
            TiebaStatic.eventStat(this.bgy.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
