package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m bzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bzd = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bzd.bxK;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bzd.bxK;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.bzd.getData(), null, null));
        }
    }
}
