package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class aa implements View.OnLongClickListener {
    final /* synthetic */ y bGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.bGG = yVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.bGG.bEJ;
        if (viewEventCenter == null || this.bGG.getData() == null || this.bGG.getData().getType() != 0) {
            return false;
        }
        viewEventCenter2 = this.bGG.bEJ;
        i = this.bGG.position;
        return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.f(i), null, null));
    }
}
