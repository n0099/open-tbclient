package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ FrsGoodActivity baf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsGoodActivity frsGoodActivity) {
        this.baf = frsGoodActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        com.baidu.adp.widget.ListView.u aA = this.baf.aZZ.Nb().aA(intValue);
        if (aA instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) aA;
            int i = bVar.TV;
            if (i == 0) {
                if (com.baidu.adp.lib.util.i.iN() && !com.baidu.adp.lib.util.i.iO()) {
                    this.baf.a(bVar, intValue);
                } else {
                    this.baf.a(bVar, "btn_download");
                    this.baf.b(bVar, "download");
                    this.baf.b((com.baidu.tbadk.core.data.b) aA, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.H(this.baf.getPageContext().getPageActivity(), bVar.Ub);
            }
            TiebaStatic.eventStat(this.baf.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
