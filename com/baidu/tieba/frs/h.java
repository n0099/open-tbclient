package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ FrsActivity aLX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.aLX = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bf bfVar;
        int intValue = ((Integer) view.getTag()).intValue();
        bfVar = this.aLX.aLi;
        com.baidu.adp.widget.ListView.ai ay = bfVar.Lw().ay(intValue);
        if (ay instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) ay;
            int i = cVar.Pr;
            if (i == 0) {
                if (com.baidu.adp.lib.util.k.iX() && !com.baidu.adp.lib.util.k.iY()) {
                    this.aLX.a(cVar, intValue);
                } else {
                    this.aLX.a(cVar, "btn_download");
                    this.aLX.b(cVar, "download");
                    this.aLX.b((com.baidu.tbadk.core.data.c) ay, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.G(this.aLX.getPageContext().getPageActivity(), cVar.Px);
            }
            TiebaStatic.eventStat(this.aLX.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
