package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnLongClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.v aWO;
    final /* synthetic */ o aYS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, com.baidu.tieba.tbadkCore.v vVar) {
        this.aYS = oVar;
        this.aWO = vVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.aYS.aWA;
        if (viewEventCenter == null || this.aWO.getType() != 0) {
            return false;
        }
        viewEventCenter2 = this.aYS.aWA;
        i = this.aYS.position;
        return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.e(i), null, null));
    }
}
