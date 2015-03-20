package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ l aDZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.aDZ = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aDZ.aCK;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aDZ.aCK;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.aDZ.getData(), null, null));
        }
    }
}
