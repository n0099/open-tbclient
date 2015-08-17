package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnLongClickListener {
    final /* synthetic */ y aOf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.aOf = yVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.aOf.aMt;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aOf.aMt;
            i = this.aOf.position;
            return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.d(i), null, null));
        }
        return false;
    }
}
