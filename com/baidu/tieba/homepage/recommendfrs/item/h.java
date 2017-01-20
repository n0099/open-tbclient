package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ g cAF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.cAF = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter lA;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter lA2;
        eVar = this.cAF.cAt;
        if (eVar != null) {
            lA = this.cAF.lA();
            if (lA != null) {
                eVar2 = this.cAF.cAt;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                lA2 = this.cAF.lA();
                lA2.dispatchMvcEvent(bVar);
            }
        }
    }
}
