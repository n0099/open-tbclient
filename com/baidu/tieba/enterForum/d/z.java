package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ y aGE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.aGE = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aGE.aET;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aGE.aET;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.aGE.getData(), null, null));
        }
    }
}
