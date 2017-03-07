package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ u bGE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.bGE = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bGE.bEQ;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bGE.bEQ;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.bGE.getData(), null, null));
        }
    }
}
