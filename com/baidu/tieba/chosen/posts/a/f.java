package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e aJZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aJZ = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter oF;
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new h(((Integer) tag).intValue(), this.aJZ.getData()), null, null);
            bVar.setUniqueId(this.aJZ.getUniqueId());
            oF = this.aJZ.oF();
            oF.dispatchMvcEvent(bVar);
        }
    }
}
