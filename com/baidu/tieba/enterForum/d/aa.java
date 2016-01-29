package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class aa implements View.OnLongClickListener {
    final /* synthetic */ y aZh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.aZh = yVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.aZh.aWA;
        if (viewEventCenter == null || this.aZh.getData() == null || this.aZh.getData().getType() != 0) {
            return false;
        }
        viewEventCenter2 = this.aZh.aWA;
        i = this.aZh.position;
        return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.e(i), null, null));
    }
}
