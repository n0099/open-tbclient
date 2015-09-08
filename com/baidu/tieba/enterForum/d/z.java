package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ y aOs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.aOs = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aOs.aMG;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aOs.aMG;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.aOs.getData(), null, null));
        }
    }
}
