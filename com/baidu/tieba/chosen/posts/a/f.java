package com.baidu.tieba.chosen.posts.a;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ e aDw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aDw = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter AL;
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(4096, new h(((Integer) tag).intValue(), this.aDw.getData()), null, null);
            bVar.setUniqueId(this.aDw.getUniqueId());
            AL = this.aDw.AL();
            AL.dispatchMvcEvent(bVar);
        }
    }
}
