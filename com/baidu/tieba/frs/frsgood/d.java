package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ FrsGoodActivity aZI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsGoodActivity frsGoodActivity) {
        this.aZI = frsGoodActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        com.baidu.adp.widget.ListView.u aA = this.aZI.aZC.MO().aA(intValue);
        if (aA instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aA;
            int i = cVar.Uh;
            if (i == 0) {
                if (com.baidu.adp.lib.util.i.iL() && !com.baidu.adp.lib.util.i.iM()) {
                    this.aZI.a(cVar, intValue);
                } else {
                    this.aZI.a(cVar, "btn_download");
                    this.aZI.b(cVar, "download");
                    this.aZI.b((com.baidu.tbadk.core.data.c) aA, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.I(this.aZI.getPageContext().getPageActivity(), cVar.Un);
            }
            TiebaStatic.eventStat(this.aZI.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
