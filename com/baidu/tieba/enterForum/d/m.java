package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ l aGl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.aGl = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aGl.aEU;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aGl.aEU;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.aGl.getData(), null, null));
        }
    }
}
