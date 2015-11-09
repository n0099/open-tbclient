package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
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
            int i = bVar.TV;
            if (i == 0) {
                if (com.baidu.adp.lib.util.i.iN() && !com.baidu.adp.lib.util.i.iO()) {
                    this.aUS.a(bVar, intValue);
                } else {
                    this.aUS.a(bVar, "btn_download");
                    this.aUS.b(bVar, "download");
                    this.aUS.b((com.baidu.tbadk.core.data.b) aA, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.H(this.aUS.getPageContext().getPageActivity(), bVar.Ub);
            }
            TiebaStatic.eventStat(this.aUS.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
