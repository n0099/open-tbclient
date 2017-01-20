package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class aa implements View.OnLongClickListener {
    final /* synthetic */ y bzH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.bzH = yVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.bzH.bxK;
        if (viewEventCenter == null || this.bzH.getData() == null || this.bzH.getData().getType() != 0) {
            return false;
        }
        viewEventCenter2 = this.bzH.bxK;
        i = this.bzH.position;
        return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.f(i), null, null));
    }
}
