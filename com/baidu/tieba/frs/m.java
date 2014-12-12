package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bq bqVar;
        int intValue = ((Integer) view.getTag()).intValue();
        bqVar = this.aCV.aBX;
        com.baidu.adp.widget.ListView.am ay = bqVar.GO().ay(intValue);
        if (ay instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) ay;
            if (cVar.mw()) {
                this.aCV.a(cVar, "btn_click");
                this.aCV.b(cVar, "click");
                com.baidu.tbadk.core.util.bh.pK().b(this.aCV.getPageContext(), new String[]{cVar.Do});
            }
        }
    }
}
