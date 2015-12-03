package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m aSr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.aSr = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aSr.aQB;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aSr.aQB;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.aSr.getData(), null, null));
        }
    }
}
