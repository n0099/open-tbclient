package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bp bpVar;
        int intValue = ((Integer) view.getTag()).intValue();
        bpVar = this.aDW.aCY;
        com.baidu.adp.widget.ListView.am aD = bpVar.Hl().aD(intValue);
        if (aD instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aD;
            int i = cVar.Dm;
            if (i == 0) {
                if (com.baidu.adp.lib.util.i.ff() && !com.baidu.adp.lib.util.i.fg()) {
                    this.aDW.a(cVar, intValue);
                } else {
                    this.aDW.a(cVar, "btn_download");
                    this.aDW.b(cVar, "download");
                    this.aDW.b((com.baidu.tbadk.core.data.c) aD, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.F(this.aDW.getPageContext().getPageActivity(), cVar.Ds);
            }
            TiebaStatic.eventStat(this.aDW.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
