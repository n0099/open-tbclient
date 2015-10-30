package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ FrsActivity aUK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.aUK = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bs bsVar;
        int intValue = ((Integer) view.getTag()).intValue();
        bsVar = this.aUK.aTU;
        com.baidu.adp.widget.ListView.u aA = bsVar.LV().aA(intValue);
        if (aA instanceof com.baidu.tbadk.core.data.b) {
            com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) aA;
            int i = bVar.TU;
            if (i == 0) {
                if (com.baidu.adp.lib.util.i.iM() && !com.baidu.adp.lib.util.i.iN()) {
                    this.aUK.a(bVar, intValue);
                } else {
                    this.aUK.a(bVar, "btn_download");
                    this.aUK.b(bVar, "download");
                    this.aUK.b((com.baidu.tbadk.core.data.b) aA, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.H(this.aUK.getPageContext().getPageActivity(), bVar.Ua);
            }
            TiebaStatic.eventStat(this.aUK.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
