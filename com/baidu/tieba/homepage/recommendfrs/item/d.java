package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c cOp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cOp = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter lI;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter lI2;
        eVar = this.cOp.cOj;
        if (eVar != null) {
            lI = this.cOp.lI();
            if (lI != null) {
                eVar2 = this.cOp.cOj;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                lI2 = this.cOp.lI();
                lI2.dispatchMvcEvent(bVar);
            }
        }
    }
}
