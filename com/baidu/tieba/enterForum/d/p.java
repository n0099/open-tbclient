package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnLongClickListener {
    final /* synthetic */ n aEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.aEs = nVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aEs.aCS;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aEs.aCS;
            return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, null, null, null));
        }
        return false;
    }
}
