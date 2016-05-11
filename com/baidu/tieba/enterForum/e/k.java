package com.baidu.tieba.enterForum.e;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i aYU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.aYU = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aYU.aXs;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aYU.aXs;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
        }
    }
}
