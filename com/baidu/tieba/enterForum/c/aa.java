package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class aa implements View.OnLongClickListener {
    final /* synthetic */ y bIX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.bIX = yVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.bIX.bHa;
        if (viewEventCenter == null || this.bIX.getData() == null || this.bIX.getData().getType() != 0) {
            return false;
        }
        viewEventCenter2 = this.bIX.bHa;
        i = this.bIX.position;
        return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.f(i), null, null));
    }
}
