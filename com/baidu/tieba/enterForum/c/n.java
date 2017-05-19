package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ m bIk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.bIk = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bIk.bGb;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bIk.bGb;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
        }
    }
}
