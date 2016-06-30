package com.baidu.tieba.enterForum.view;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnLongClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.x btB;
    final /* synthetic */ o bvb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, com.baidu.tieba.tbadkCore.x xVar) {
        this.bvb = oVar;
        this.btB = xVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.bvb.bfx;
        if (viewEventCenter == null || this.btB.getType() != 0) {
            return false;
        }
        viewEventCenter2 = this.bvb.bfx;
        i = this.bvb.position;
        return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.f(i), null, null));
    }
}
