package com.baidu.tieba.enterForum.view;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ ac bvF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar) {
        this.bvF = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bvF.bfx;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bvF.bfx;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
        }
    }
}
