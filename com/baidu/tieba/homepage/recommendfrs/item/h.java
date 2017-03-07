package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ g cCb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.cCb = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter Fw;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter Fw2;
        eVar = this.cCb.cBP;
        if (eVar != null) {
            Fw = this.cCb.Fw();
            if (Fw != null) {
                eVar2 = this.cCb.cBP;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                Fw2 = this.cCb.Fw();
                Fw2.dispatchMvcEvent(bVar);
            }
        }
    }
}
