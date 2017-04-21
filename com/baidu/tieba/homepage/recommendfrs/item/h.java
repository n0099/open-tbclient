package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ g cCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.cCR = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter FU;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter FU2;
        eVar = this.cCR.cCF;
        if (eVar != null) {
            FU = this.cCR.FU();
            if (FU != null) {
                eVar2 = this.cCR.cCF;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                FU2 = this.cCR.FU();
                FU2.dispatchMvcEvent(bVar);
            }
        }
    }
}
