package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e aNF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aNF = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter oM;
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new h(((Integer) tag).intValue(), this.aNF.getData()), null, null);
            bVar.setUniqueId(this.aNF.getUniqueId());
            oM = this.aNF.oM();
            oM.dispatchMvcEvent(bVar);
        }
    }
}
