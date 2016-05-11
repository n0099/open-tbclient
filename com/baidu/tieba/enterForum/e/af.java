package com.baidu.tieba.enterForum.e;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ ac aZL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ac acVar) {
        this.aZL = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aZL.aXs;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aZL.aXs;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
        }
    }
}
