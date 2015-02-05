package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bp bpVar;
        int intValue = ((Integer) view.getTag()).intValue();
        bpVar = this.aDT.aCV;
        com.baidu.adp.widget.ListView.am aD = bpVar.Hf().aD(intValue);
        if (aD instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) aD;
            if (cVar.mp()) {
                this.aDT.a(cVar, "btn_click");
                this.aDT.b(cVar, "click");
                com.baidu.tbadk.core.util.bm.pO().b(this.aDT.getPageContext(), new String[]{cVar.Dn});
            }
        }
    }
}
