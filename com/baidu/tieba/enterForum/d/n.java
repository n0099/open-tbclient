package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m aNm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.aNm = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aNm.aLU;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aNm.aLU;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.aNm.getData(), null, null));
        }
    }
}
