package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bp bpVar;
        int intValue = ((Integer) view.getTag()).intValue();
        bpVar = this.aDT.aCV;
        com.baidu.adp.widget.ListView.am aD = bpVar.Hf().aD(intValue);
        if (aD instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aD;
            int i = cVar.Dj;
            if (i == 0) {
                if (com.baidu.adp.lib.util.i.ff() && !com.baidu.adp.lib.util.i.fg()) {
                    this.aDT.a(cVar, intValue);
                } else {
                    this.aDT.a(cVar, "btn_download");
                    this.aDT.b(cVar, "download");
                    this.aDT.b((com.baidu.tbadk.core.data.c) aD, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.F(this.aDT.getPageContext().getPageActivity(), cVar.Dp);
            }
            TiebaStatic.eventStat(this.aDT.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
