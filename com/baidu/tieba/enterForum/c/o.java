package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class o implements View.OnClickListener {
    final /* synthetic */ n bUZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.bUZ = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bUZ.bSq;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bUZ.bSq;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.bUZ.getData(), null, null));
        }
    }
}
