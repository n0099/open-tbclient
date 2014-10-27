package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bu buVar;
        int intValue = ((Integer) view.getTag()).intValue();
        buVar = this.aBk.aAv;
        com.baidu.adp.widget.ListView.al ai = buVar.GH().ai(intValue);
        if (ai instanceof com.baidu.tbadk.core.data.a) {
            com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) ai;
            int i = aVar.zf;
            if (i == 0) {
                if (com.baidu.adp.lib.util.j.fh() && !com.baidu.adp.lib.util.j.fi()) {
                    this.aBk.a(aVar, intValue);
                } else {
                    this.aBk.a(aVar, "btn_download");
                    this.aBk.b(aVar, "download");
                    this.aBk.b((com.baidu.tbadk.core.data.a) ai, intValue);
                }
            } else if (i == 2) {
                com.baidu.tieba.frs.a.a.x(this.aBk, aVar.zl);
            }
            TiebaStatic.eventStat(this.aBk, "frs_tb_btc", "");
        }
    }
}
