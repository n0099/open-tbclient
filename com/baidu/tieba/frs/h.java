package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.aJG = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bf bfVar;
        int intValue = ((Integer) view.getTag()).intValue();
        bfVar = this.aJG.aIS;
        com.baidu.adp.widget.ListView.ai aA = bfVar.Kk().aA(intValue);
        if (aA instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aA;
            int i = cVar.OV;
            if (i == 0) {
                if (com.baidu.adp.lib.util.k.iH() && !com.baidu.adp.lib.util.k.iI()) {
                    this.aJG.a(cVar, intValue);
                } else {
                    this.aJG.a(cVar, "btn_download");
                    this.aJG.b(cVar, "download");
                    this.aJG.b((com.baidu.tbadk.core.data.c) aA, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.F(this.aJG.getPageContext().getPageActivity(), cVar.Pb);
            }
            TiebaStatic.eventStat(this.aJG.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
