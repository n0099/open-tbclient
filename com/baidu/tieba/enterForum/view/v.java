package com.baidu.tieba.enterForum.view;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ u bvm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.bvm = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bvm.bfx;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bvm.bfx;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.bvm.getData(), null, null));
        }
    }
}
