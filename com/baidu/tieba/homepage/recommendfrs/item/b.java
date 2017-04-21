package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ a cCH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cCH = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter FU;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter FU2;
        eVar = this.cCH.cCF;
        if (eVar != null) {
            FU = this.cCH.FU();
            if (FU != null) {
                eVar2 = this.cCH.cCF;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                FU2 = this.cCH.FU();
                FU2.dispatchMvcEvent(bVar);
            }
        }
    }
}
