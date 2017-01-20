package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ a cAv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cAv = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter lA;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter lA2;
        eVar = this.cAv.cAt;
        if (eVar != null) {
            lA = this.cAv.lA();
            if (lA != null) {
                eVar2 = this.cAv.cAt;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                lA2 = this.cAv.lA();
                lA2.dispatchMvcEvent(bVar);
            }
        }
    }
}
