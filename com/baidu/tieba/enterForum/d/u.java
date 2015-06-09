package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class u implements View.OnClickListener {
    final /* synthetic */ t aGA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.aGA = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aGA.aEU;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aGA.aEU;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.aGA.getData(), null, null));
        }
    }
}
