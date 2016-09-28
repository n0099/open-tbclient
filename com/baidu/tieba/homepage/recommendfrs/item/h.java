package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ g cJg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.cJg = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter lF;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter lF2;
        eVar = this.cJg.cIU;
        if (eVar != null) {
            lF = this.cJg.lF();
            if (lF != null) {
                eVar2 = this.cJg.cIU;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                lF2 = this.cJg.lF();
                lF2.dispatchMvcEvent(bVar);
            }
        }
    }
}
