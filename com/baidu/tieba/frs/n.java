package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bq bqVar;
        int intValue = ((Integer) view.getTag()).intValue();
        bqVar = this.aCV.aBX;
        com.baidu.adp.widget.ListView.am ay = bqVar.GO().ay(intValue);
        if (ay instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) ay;
            int i = cVar.Dk;
            if (i == 0) {
                if (com.baidu.adp.lib.util.i.fg() && !com.baidu.adp.lib.util.i.fh()) {
                    this.aCV.a(cVar, intValue);
                } else {
                    this.aCV.a(cVar, "btn_download");
                    this.aCV.b(cVar, "download");
                    this.aCV.b((com.baidu.tbadk.core.data.c) ay, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.utils.a.G(this.aCV.getPageContext().getPageActivity(), cVar.Dq);
            }
            TiebaStatic.eventStat(this.aCV.getPageContext().getPageActivity(), "frs_tb_btc", "");
        }
    }
}
