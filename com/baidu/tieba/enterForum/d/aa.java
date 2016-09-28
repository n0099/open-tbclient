package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class aa implements View.OnLongClickListener {
    final /* synthetic */ y bIZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.bIZ = yVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.bIZ.aPL;
        if (viewEventCenter == null || this.bIZ.getData() == null || this.bIZ.getData().getType() != 0) {
            return false;
        }
        viewEventCenter2 = this.bIZ.aPL;
        i = this.bIZ.position;
        return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.f(i), null, null));
    }
}
