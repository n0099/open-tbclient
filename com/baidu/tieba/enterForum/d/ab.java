package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnLongClickListener {
    final /* synthetic */ z aNH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar) {
        this.aNH = zVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        int i;
        viewEventCenter = this.aNH.aLU;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aNH.aLU;
            i = this.aNH.position;
            return viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, new com.baidu.tieba.enterForum.b.e(i), null, null));
        }
        return false;
    }
}
