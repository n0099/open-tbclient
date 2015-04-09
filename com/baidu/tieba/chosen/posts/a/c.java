package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b aBA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.aBA = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter zZ;
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new d(((Integer) tag).intValue(), this.aBA.getData()), null, null);
            bVar.setUniqueId(this.aBA.getUniqueId());
            zZ = this.aBA.zZ();
            zZ.dispatchMvcEvent(bVar);
        }
    }
}
