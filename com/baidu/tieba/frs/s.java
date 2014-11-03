package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.aBu = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bu buVar;
        int intValue = ((Integer) view.getTag()).intValue();
        buVar = this.aBu.aAF;
        com.baidu.adp.widget.ListView.al ai = buVar.GJ().ai(intValue);
        if (ai instanceof com.baidu.tbadk.core.data.a) {
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) ai;
            int i = aVar.zf;
            if (i == 0) {
                if (com.baidu.adp.lib.util.j.fh() && !com.baidu.adp.lib.util.j.fi()) {
                    this.aBu.a(aVar, intValue);
                } else {
                    this.aBu.a(aVar, "btn_download");
                    this.aBu.b(aVar, "download");
                    this.aBu.b((com.baidu.tbadk.core.data.a) ai, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.a.a.x(this.aBu, aVar.zl);
            }
            TiebaStatic.eventStat(this.aBu, "frs_tb_btc", "");
        }
    }
}
