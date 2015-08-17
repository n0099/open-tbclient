package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.this$0 = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        int intValue = ((Integer) view.getTag()).intValue();
        blVar = this.this$0.aUw;
        com.baidu.adp.widget.ListView.u aA = blVar.Mj().aA(intValue);
        if (aA instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aA;
            int i = cVar.Ug;
            if (i == 0) {
                if (com.baidu.adp.lib.util.i.iO() && !com.baidu.adp.lib.util.i.iP()) {
                    this.this$0.a(cVar, intValue);
                } else {
                    this.this$0.a(cVar, "btn_download");
                    this.this$0.b(cVar, "download");
                    this.this$0.b((com.baidu.tbadk.core.data.c) aA, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.I(this.this$0.getPageContext().getPageActivity(), cVar.Um);
            }
            TiebaStatic.eventStat(this.this$0.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
