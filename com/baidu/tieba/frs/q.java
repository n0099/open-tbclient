package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
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
            if (aVar.jH()) {
                this.aBk.a(aVar, "btn_click");
                this.aBk.b(aVar, "click");
                com.baidu.tbadk.core.util.bf.mR().b(this.aBk, new String[]{aVar.zj});
            }
        }
    }
}
