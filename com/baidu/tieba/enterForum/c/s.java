package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r bGD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.bGD = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bGD.bEQ;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bGD.bEQ;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(14, null, null, null));
        }
    }
}
