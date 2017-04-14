package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ r bGw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.bGw = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bGw.bEJ;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bGw.bEJ;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
        }
    }
}
