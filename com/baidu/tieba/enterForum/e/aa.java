package com.baidu.tieba.enterForum.e;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class aa implements View.OnLongClickListener {
    final /* synthetic */ y bIY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.bIY = yVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.bIY.aOw;
        if (viewEventCenter == null || this.bIY.getData() == null || this.bIY.getData().getType() != 0) {
            return false;
        }
        viewEventCenter2 = this.bIY.aOw;
        i = this.bIY.position;
        return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.f(i), null, null));
    }
}
