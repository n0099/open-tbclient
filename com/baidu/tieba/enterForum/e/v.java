package com.baidu.tieba.enterForum.e;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    final /* synthetic */ u aZq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.aZq = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aZq.aXs;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aZq.aXs;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.aZq.getData(), null, null));
        }
    }
}
