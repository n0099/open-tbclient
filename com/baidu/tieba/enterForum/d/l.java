package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ i aYC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.aYC = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aYC.aWA;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aYC.aWA;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
        }
    }
}
