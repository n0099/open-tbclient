package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c cBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cBV = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter Fw;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter Fw2;
        eVar = this.cBV.cBP;
        if (eVar != null) {
            Fw = this.cBV.Fw();
            if (Fw != null) {
                eVar2 = this.cBV.cBP;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                Fw2 = this.cBV.Fw();
                Fw2.dispatchMvcEvent(bVar);
            }
        }
    }
}
