package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e aKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aKU = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter oH;
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new h(((Integer) tag).intValue(), this.aKU.getData()), null, null);
            bVar.setUniqueId(this.aKU.getUniqueId());
            oH = this.aKU.oH();
            oH.dispatchMvcEvent(bVar);
        }
    }
}
