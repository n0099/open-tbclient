package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bp bpVar;
        int intValue = ((Integer) view.getTag()).intValue();
        bpVar = this.aDW.aCY;
        com.baidu.adp.widget.ListView.am aD = bpVar.Hl().aD(intValue);
        if (aD instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aD;
            if (cVar.mw()) {
                this.aDW.a(cVar, "btn_click");
                this.aDW.b(cVar, "click");
                com.baidu.tbadk.core.util.bm.pV().b(this.aDW.getPageContext(), new String[]{cVar.Dq});
            }
        }
    }
}
