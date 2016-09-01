package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c cIi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cIi = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter lF;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter lF2;
        eVar = this.cIi.cIc;
        if (eVar != null) {
            lF = this.cIi.lF();
            if (lF != null) {
                eVar2 = this.cIi.cIc;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                lF2 = this.cIi.lF();
                lF2.dispatchMvcEvent(bVar);
            }
        }
    }
}
