package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c ctO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.ctO = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter kO;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter kO2;
        eVar = this.ctO.ctI;
        if (eVar != null) {
            kO = this.ctO.kO();
            if (kO != null) {
                eVar2 = this.ctO.ctI;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                kO2 = this.ctO.kO();
                kO2.dispatchMvcEvent(bVar);
            }
        }
    }
}
