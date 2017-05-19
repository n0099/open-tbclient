package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ o bIq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.bIq = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bIq.bGb;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bIq.bGb;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.bIq.getData(), null, null));
        }
    }
}
