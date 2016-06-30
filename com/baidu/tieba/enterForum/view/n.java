package com.baidu.tieba.enterForum.view;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m buR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.buR = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.buR.bfx;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.buR.bfx;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.buR.getData(), null, null));
        }
    }
}
