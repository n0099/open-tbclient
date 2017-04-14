package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ a cAq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cAq = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter FU;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter FU2;
        eVar = this.cAq.cAo;
        if (eVar != null) {
            FU = this.cAq.FU();
            if (FU != null) {
                eVar2 = this.cAq.cAo;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                FU2 = this.cAq.FU();
                FU2.dispatchMvcEvent(bVar);
            }
        }
    }
}
