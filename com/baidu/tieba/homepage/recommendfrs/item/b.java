package com.baidu.tieba.homepage.recommendfrs.item;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ a cIW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cIW = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        ViewEventCenter lF;
        com.baidu.tieba.homepage.recommendfrs.data.e eVar2;
        ViewEventCenter lF2;
        eVar = this.cIW.cIU;
        if (eVar != null) {
            lF = this.cIW.lF();
            if (lF != null) {
                eVar2 = this.cIW.cIU;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, eVar2, null, null);
                lF2 = this.cIW.lF();
                lF2.dispatchMvcEvent(bVar);
            }
        }
    }
}
