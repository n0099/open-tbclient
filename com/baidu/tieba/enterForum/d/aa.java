package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnLongClickListener {
    final /* synthetic */ y aEt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.aEt = yVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aEt.aCK;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aEt.aCK;
            return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, null, null, null));
        }
        return false;
    }
}
