package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m aMT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.aMT = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aMT.aLB;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aMT.aLB;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.aMT.getData(), null, null));
        }
    }
}
