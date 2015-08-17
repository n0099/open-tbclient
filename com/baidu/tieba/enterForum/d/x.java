package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class x implements View.OnLongClickListener {
    final /* synthetic */ v aOc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar) {
        this.aOc = vVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.aOc.aMt;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aOc.aMt;
            i = this.aOc.position;
            return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.d(i), null, null));
        }
        return false;
    }
}
