package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c cCL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cCL = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter FU;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter FU2;
        eVar = this.cCL.cCF;
        if (eVar != null) {
            FU = this.cCL.FU();
            if (FU != null) {
                eVar2 = this.cCL.cCF;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                FU2 = this.cCL.FU();
                FU2.dispatchMvcEvent(bVar);
            }
        }
    }
}
