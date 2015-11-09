package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnLongClickListener {
    final /* synthetic */ o aNx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.aNx = oVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.aNx.aLU;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aNx.aLU;
            i = this.aNx.position;
            return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.e(i), null, null));
        }
        return false;
    }
}
