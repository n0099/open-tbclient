package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c cAu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cAu = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter FU;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter FU2;
        eVar = this.cAu.cAo;
        if (eVar != null) {
            FU = this.cAu.FU();
            if (FU != null) {
                eVar2 = this.cAu.cAo;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                FU2 = this.cAu.FU();
                FU2.dispatchMvcEvent(bVar);
            }
        }
    }
}
