package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ a cOl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cOl = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter lI;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter lI2;
        eVar = this.cOl.cOj;
        if (eVar != null) {
            lI = this.cOl.lI();
            if (lI != null) {
                eVar2 = this.cOl.cOj;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                lI2 = this.cOl.lI();
                lI2.dispatchMvcEvent(bVar);
            }
        }
    }
}
