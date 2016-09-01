package com.baidu.tieba.enterForum.e;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m bIt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bIt = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bIt.aOw;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bIt.aOw;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.bIt.getData(), null, null));
        }
    }
}
