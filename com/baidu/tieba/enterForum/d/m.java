package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ l aGk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.aGk = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aGk.aET;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aGk.aET;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.aGk.getData(), null, null));
        }
    }
}
