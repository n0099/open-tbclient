package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class y implements View.OnLongClickListener {
    final /* synthetic */ w aNE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.aNE = wVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.aNE.aLU;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aNE.aLU;
            i = this.aNE.position;
            return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.e(i), null, null));
        }
        return false;
    }
}
