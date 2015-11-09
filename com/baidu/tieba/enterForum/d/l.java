package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ i aNh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.aNh = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aNh.aLU;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aNh.aLU;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(6, null, null, null));
        }
    }
}
