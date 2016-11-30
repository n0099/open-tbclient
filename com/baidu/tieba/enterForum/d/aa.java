package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class aa implements View.OnLongClickListener {
    final /* synthetic */ y bLS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.bLS = yVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.bLS.aRS;
        if (viewEventCenter == null || this.bLS.getData() == null || this.bLS.getData().getType() != 0) {
            return false;
        }
        viewEventCenter2 = this.bLS.aRS;
        i = this.bLS.position;
        return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.f(i), null, null));
    }
}
