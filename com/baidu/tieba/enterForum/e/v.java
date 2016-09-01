package com.baidu.tieba.enterForum.e;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ u bIP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.bIP = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bIP.aOw;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bIP.aOw;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.bIP.getData(), null, null));
        }
    }
}
