package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i aNG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.aNG = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aNG.aMt;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aNG.aMt;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
        }
    }
}
