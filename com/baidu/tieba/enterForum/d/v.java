package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ u bdI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.bdI = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bdI.bbj;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bdI.bbj;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.bdI.getData(), null, null));
        }
    }
}
