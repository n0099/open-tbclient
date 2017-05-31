package com.baidu.tieba.enterForum.a;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a bLR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bLR = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bLR.bLQ;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bLR.bLQ;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, null, null, null));
        }
    }
}
