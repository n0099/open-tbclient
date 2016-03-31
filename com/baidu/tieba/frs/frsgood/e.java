package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class e implements View.OnClickListener {
    final /* synthetic */ FrsGoodActivity bsj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FrsGoodActivity frsGoodActivity) {
        this.bsj = frsGoodActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        com.baidu.adp.widget.ListView.u aF = this.bsj.bsd.SM().aF(intValue);
        if (aF instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aF;
            int i = cVar.RY;
            if (i == 0) {
                if (com.baidu.adp.lib.util.i.jf() && !com.baidu.adp.lib.util.i.jg()) {
                    this.bsj.a(cVar, intValue, false);
                } else {
                    this.bsj.a(cVar, "btn_download");
                    this.bsj.d(cVar, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.E(this.bsj.getPageContext().getPageActivity(), cVar.Se);
            }
            TiebaStatic.eventStat(this.bsj.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
