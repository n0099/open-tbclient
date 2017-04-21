package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ u bIO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.bIO = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bIO.bHa;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bIO.bHa;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.bIO.getData(), null, null));
        }
    }
}
