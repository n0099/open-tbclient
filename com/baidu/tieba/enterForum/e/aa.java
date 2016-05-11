package com.baidu.tieba.enterForum.e;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class aa implements View.OnLongClickListener {
    final /* synthetic */ y aZz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.aZz = yVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.aZz.aXs;
        if (viewEventCenter == null || this.aZz.getData() == null || this.aZz.getData().getType() != 0) {
            return false;
        }
        viewEventCenter2 = this.aZz.aXs;
        i = this.aZz.position;
        return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.e(i), null, null));
    }
}
