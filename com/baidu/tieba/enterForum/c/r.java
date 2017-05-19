package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ q bIs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.bIs = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bIs.bGb;
        if (viewEventCenter != null) {
            TiebaStatic.log("c10362");
            viewEventCenter2 = this.bIs.bGb;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(7, null, null, null));
        }
    }
}
