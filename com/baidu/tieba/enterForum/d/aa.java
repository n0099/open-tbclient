package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class aa implements View.OnLongClickListener {
    final /* synthetic */ y aWT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.aWT = yVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.aWT.aUs;
        if (viewEventCenter == null || this.aWT.getData() == null || this.aWT.getData().getType() != 0) {
            return false;
        }
        viewEventCenter2 = this.aWT.aUs;
        i = this.aWT.position;
        return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.e(i), null, null));
    }
}
