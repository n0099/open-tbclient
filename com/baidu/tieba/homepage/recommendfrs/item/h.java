package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ g ctV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.ctV = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter kO;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter kO2;
        eVar = this.ctV.ctI;
        if (eVar != null) {
            kO = this.ctV.kO();
            if (kO != null) {
                eVar2 = this.ctV.ctI;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                kO2 = this.ctV.kO();
                kO2.dispatchMvcEvent(bVar);
            }
        }
    }
}
