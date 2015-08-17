package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ FrsGoodActivity aZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsGoodActivity frsGoodActivity) {
        this.aZp = frsGoodActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        com.baidu.adp.widget.ListView.u aA = this.aZp.aZj.MO().aA(intValue);
        if (aA instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aA;
            int i = cVar.Ug;
            if (i == 0) {
                if (com.baidu.adp.lib.util.i.iO() && !com.baidu.adp.lib.util.i.iP()) {
                    this.aZp.a(cVar, intValue);
                } else {
                    this.aZp.a(cVar, "btn_download");
                    this.aZp.b(cVar, "download");
                    this.aZp.b((com.baidu.tbadk.core.data.c) aA, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.I(this.aZp.getPageContext().getPageActivity(), cVar.Um);
            }
            TiebaStatic.eventStat(this.aZp.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
