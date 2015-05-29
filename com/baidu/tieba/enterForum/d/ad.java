package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ ac aGR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.aGR = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aGR.aET;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aGR.aET;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
        }
    }
}
