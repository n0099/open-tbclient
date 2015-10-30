package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ FrsGoodActivity aZM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsGoodActivity frsGoodActivity) {
        this.aZM = frsGoodActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        com.baidu.adp.widget.ListView.u aA = this.aZM.aZG.MJ().aA(intValue);
        if (aA instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) aA;
            int i = bVar.TU;
            if (i == 0) {
                if (com.baidu.adp.lib.util.i.iM() && !com.baidu.adp.lib.util.i.iN()) {
                    this.aZM.a(bVar, intValue);
                } else {
                    this.aZM.a(bVar, "btn_download");
                    this.aZM.b(bVar, "download");
                    this.aZM.b((com.baidu.tbadk.core.data.b) aA, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.H(this.aZM.getPageContext().getPageActivity(), bVar.Ua);
            }
            TiebaStatic.eventStat(this.aZM.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
