package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m brs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.brs = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.brs.aRj;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.brs.aRj;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.brs.getData(), null, null));
        }
    }
}
