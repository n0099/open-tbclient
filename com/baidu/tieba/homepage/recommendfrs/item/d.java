package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c cAz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cAz = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter lA;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter lA2;
        eVar = this.cAz.cAt;
        if (eVar != null) {
            lA = this.cAz.lA();
            if (lA != null) {
                eVar2 = this.cAz.cAt;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                lA2 = this.cAz.lA();
                lA2.dispatchMvcEvent(bVar);
            }
        }
    }
}
