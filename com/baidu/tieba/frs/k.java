package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ FrsActivity aVz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.aVz = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        int intValue = ((Integer) view.getTag()).intValue();
        biVar = this.aVz.aUL;
        com.baidu.adp.widget.ListView.u aA = biVar.Ma().aA(intValue);
        if (aA instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aA;
            int i = cVar.Uh;
            if (i == 0) {
                if (com.baidu.adp.lib.util.i.iL() && !com.baidu.adp.lib.util.i.iM()) {
                    this.aVz.a(cVar, intValue);
                } else {
                    this.aVz.a(cVar, "btn_download");
                    this.aVz.b(cVar, "download");
                    this.aVz.b((com.baidu.tbadk.core.data.c) aA, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.I(this.aVz.getPageContext().getPageActivity(), cVar.Un);
            }
            TiebaStatic.eventStat(this.aVz.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
