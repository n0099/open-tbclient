package com.baidu.tieba.enterForum.view;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class aa implements View.OnLongClickListener {
    final /* synthetic */ y bxJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.bxJ = yVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.bxJ.bgJ;
        if (viewEventCenter == null || this.bxJ.getData() == null || this.bxJ.getData().getType() != 0) {
            return false;
        }
        viewEventCenter2 = this.bxJ.bgJ;
        i = this.bxJ.position;
        return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.f(i), null, null));
    }
}
