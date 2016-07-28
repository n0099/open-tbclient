package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ g cwK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.cwK = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter kK;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter kK2;
        eVar = this.cwK.cwx;
        if (eVar != null) {
            kK = this.cwK.kK();
            if (kK != null) {
                eVar2 = this.cwK.cwx;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                kK2 = this.cwK.kK();
                kK2.dispatchMvcEvent(bVar);
            }
        }
    }
}
