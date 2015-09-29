package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.aUz = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bs bsVar;
        int intValue = ((Integer) view.getTag()).intValue();
        bsVar = this.aUz.aTJ;
        com.baidu.adp.widget.ListView.u aA = bsVar.LZ().aA(intValue);
        if (aA instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) aA;
            int i = bVar.TT;
            if (i == 0) {
                if (com.baidu.adp.lib.util.i.iM() && !com.baidu.adp.lib.util.i.iN()) {
                    this.aUz.a(bVar, intValue);
                } else {
                    this.aUz.a(bVar, "btn_download");
                    this.aUz.b(bVar, "download");
                    this.aUz.b((com.baidu.tbadk.core.data.b) aA, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.H(this.aUz.getPageContext().getPageActivity(), bVar.TZ);
            }
            TiebaStatic.eventStat(this.aUz.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
