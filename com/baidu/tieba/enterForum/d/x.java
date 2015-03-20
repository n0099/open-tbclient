package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class x implements View.OnLongClickListener {
    final /* synthetic */ v aEq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar) {
        this.aEq = vVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aEq.aCK;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aEq.aCK;
            return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, null, null, null));
        }
        return false;
    }
}
