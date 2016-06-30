package com.baidu.tieba.enterForum.view;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ j buM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.buM = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.buM.bfx;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.buM.bfx;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
        }
    }
}
