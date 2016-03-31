package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ ac bdX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.bdX = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bdX.bbj;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bdX.bbj;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(8, null, null, null));
        }
    }
}
