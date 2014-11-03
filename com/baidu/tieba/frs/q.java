package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
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
            if (aVar.jH()) {
                this.aBu.a(aVar, "btn_click");
                this.aBu.b(aVar, "click");
                com.baidu.tbadk.core.util.bg.mR().b(this.aBu, new String[]{aVar.zj});
            }
        }
    }
}
