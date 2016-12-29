package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c ctv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.ctv = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter lI;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter lI2;
        eVar = this.ctv.ctp;
        if (eVar != null) {
            lI = this.ctv.lI();
            if (lI != null) {
                eVar2 = this.ctv.ctp;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                lI2 = this.ctv.lI();
                lI2.dispatchMvcEvent(bVar);
            }
        }
    }
}
