package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c cwD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cwD = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter kK;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter kK2;
        eVar = this.cwD.cwx;
        if (eVar != null) {
            kK = this.cwD.kK();
            if (kK != null) {
                eVar2 = this.cwD.cwx;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                kK2 = this.cwD.kK();
                kK2.dispatchMvcEvent(bVar);
            }
        }
    }
}
