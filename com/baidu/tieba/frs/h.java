package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ FrsActivity aLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.aLY = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bf bfVar;
        int intValue = ((Integer) view.getTag()).intValue();
        bfVar = this.aLY.aLj;
        com.baidu.adp.widget.ListView.ai ay = bfVar.Lx().ay(intValue);
        if (ay instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) ay;
            int i = cVar.Pr;
            if (i == 0) {
                if (com.baidu.adp.lib.util.k.iX() && !com.baidu.adp.lib.util.k.iY()) {
                    this.aLY.a(cVar, intValue);
                } else {
                    this.aLY.a(cVar, "btn_download");
                    this.aLY.b(cVar, "download");
                    this.aLY.b((com.baidu.tbadk.core.data.c) ay, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.G(this.aLY.getPageContext().getPageActivity(), cVar.Px);
            }
            TiebaStatic.eventStat(this.aLY.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
