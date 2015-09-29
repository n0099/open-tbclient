package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnLongClickListener {
    final /* synthetic */ o aNe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.aNe = oVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.aNe.aLB;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aNe.aLB;
            i = this.aNe.position;
            return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.e(i), null, null));
        }
        return false;
    }
}
