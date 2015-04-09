package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ FrsActivity aJQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.aJQ = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bf bfVar;
        int intValue = ((Integer) view.getTag()).intValue();
        bfVar = this.aJQ.aJa;
        com.baidu.adp.widget.ListView.ai aA = bfVar.Kr().aA(intValue);
        if (aA instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aA;
            int i = cVar.OX;
            if (i == 0) {
                if (com.baidu.adp.lib.util.k.iH() && !com.baidu.adp.lib.util.k.iI()) {
                    this.aJQ.a(cVar, intValue);
                } else {
                    this.aJQ.a(cVar, "btn_download");
                    this.aJQ.b(cVar, "download");
                    this.aJQ.b((com.baidu.tbadk.core.data.c) aA, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.F(this.aJQ.getPageContext().getPageActivity(), cVar.Pd);
            }
            TiebaStatic.eventStat(this.aJQ.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
