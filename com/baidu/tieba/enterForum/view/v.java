package com.baidu.tieba.enterForum.view;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ u bxA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.bxA = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bxA.bgJ;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bxA.bgJ;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.bxA.getData(), null, null));
        }
    }
}
