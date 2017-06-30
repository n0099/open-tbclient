package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l bUT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bUT = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bUT.bSq;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.bUT.bSq;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(3, null, null, null));
        }
    }
}
