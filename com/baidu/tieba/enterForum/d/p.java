package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnLongClickListener {
    final /* synthetic */ n aGw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.aGw = nVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.aGw.aEU;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aGw.aEU;
            i = this.aGw.position;
            return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.d(i), null, null));
        }
        return false;
    }
}
