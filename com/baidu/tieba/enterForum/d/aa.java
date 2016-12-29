package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class aa implements View.OnLongClickListener {
    final /* synthetic */ y brW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.brW = yVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.brW.aRj;
        if (viewEventCenter == null || this.brW.getData() == null || this.brW.getData().getType() != 0) {
            return false;
        }
        viewEventCenter2 = this.brW.aRj;
        i = this.brW.position;
        return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.f(i), null, null));
    }
}
