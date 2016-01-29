package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ FrsGoodActivity bnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FrsGoodActivity frsGoodActivity) {
        this.bnm = frsGoodActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        com.baidu.adp.widget.ListView.u aG = this.bnm.bng.QY().aG(intValue);
        if (aG instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aG;
            int i = cVar.Us;
            if (i == 0) {
                if (com.baidu.adp.lib.util.i.iZ() && !com.baidu.adp.lib.util.i.ja()) {
                    this.bnm.a(cVar, intValue, false);
                } else {
                    this.bnm.a(cVar, "btn_download");
                    this.bnm.b(cVar, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.N(this.bnm.getPageContext().getPageActivity(), cVar.Uy);
            }
            TiebaStatic.eventStat(this.bnm.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
