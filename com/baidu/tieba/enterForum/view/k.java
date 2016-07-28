package com.baidu.tieba.enterForum.view;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j bxa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.bxa = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bxa.bgJ;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bxa.bgJ;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
        }
    }
}
