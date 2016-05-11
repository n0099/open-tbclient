package com.baidu.tieba.enterForum.e;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ m aYZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.aYZ = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aYZ.aXs;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aYZ.aXs;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(4, this.aYZ.getData(), null, null));
        }
    }
}
