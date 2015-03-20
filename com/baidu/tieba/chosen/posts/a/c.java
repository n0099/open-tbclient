package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b aBs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aBs = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter zT;
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), this.aBs.getData()), null, null);
            bVar.setUniqueId(this.aBs.getUniqueId());
            zT = this.aBs.zT();
            zT.dispatchMvcEvent(bVar);
        }
    }
}
