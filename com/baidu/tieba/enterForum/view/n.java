package com.baidu.tieba.enterForum.view;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m bxf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bxf = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bxf.bgJ;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bxf.bgJ;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.bxf.getData(), null, null));
        }
    }
}
