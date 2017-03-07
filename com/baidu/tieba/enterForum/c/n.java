package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m bGj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bGj = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bGj.bEQ;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bGj.bEQ;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.bGj.getData(), null, null));
        }
    }
}
