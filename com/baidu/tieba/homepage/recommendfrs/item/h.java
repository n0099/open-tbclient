package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ g cOv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.cOv = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter lI;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter lI2;
        eVar = this.cOv.cOj;
        if (eVar != null) {
            lI = this.cOv.lI();
            if (lI != null) {
                eVar2 = this.cOv.cOj;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                lI2 = this.cOv.lI();
                lI2.dispatchMvcEvent(bVar);
            }
        }
    }
}
