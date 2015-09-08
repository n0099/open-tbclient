package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class x implements View.OnLongClickListener {
    final /* synthetic */ v aOp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar) {
        this.aOp = vVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.aOp.aMG;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aOp.aMG;
            i = this.aOp.position;
            return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.d(i), null, null));
        }
        return false;
    }
}
