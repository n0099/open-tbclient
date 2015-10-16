package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ u aNu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.aNu = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aNu.aLM;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aNu.aLM;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.aNu.getData(), null, null));
        }
    }
}
