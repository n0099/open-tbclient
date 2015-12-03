package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ u aSI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.aSI = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aSI.aQB;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aSI.aQB;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.aSI.getData(), null, null));
        }
    }
}
