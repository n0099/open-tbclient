package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnLongClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.u bEV;
    final /* synthetic */ o bGn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, com.baidu.tieba.tbadkCore.u uVar) {
        this.bGn = oVar;
        this.bEV = uVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.bGn.bEJ;
        if (viewEventCenter == null || this.bEV.getType() != 0) {
            return false;
        }
        viewEventCenter2 = this.bGn.bEJ;
        i = this.bGn.position;
        return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.f(i), null, null));
    }
}
