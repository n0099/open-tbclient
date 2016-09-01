package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ g cIp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.cIp = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter lF;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter lF2;
        eVar = this.cIp.cIc;
        if (eVar != null) {
            lF = this.cIp.lF();
            if (lF != null) {
                eVar2 = this.cIp.cIc;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                lF2 = this.cIp.lF();
                lF2.dispatchMvcEvent(bVar);
            }
        }
    }
}
