package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ g cAA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.cAA = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter FU;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter FU2;
        eVar = this.cAA.cAo;
        if (eVar != null) {
            FU = this.cAA.FU();
            if (FU != null) {
                eVar2 = this.cAA.cAo;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                FU2 = this.cAA.FU();
                FU2.dispatchMvcEvent(bVar);
            }
        }
    }
}
