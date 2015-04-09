package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class x implements View.OnLongClickListener {
    final /* synthetic */ v aEy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar) {
        this.aEy = vVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aEy.aCS;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aEy.aCS;
            return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, null, null, null));
        }
        return false;
    }
}
