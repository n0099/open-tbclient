package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ ac bzR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar) {
        this.bzR = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bzR.bxK;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bzR.bxK;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(9, null, null, null));
        }
    }
}
