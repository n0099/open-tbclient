package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ z aNz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.aNz = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aNz.aLM;
        if (viewEventCenter != null) {
            viewEventCenter2 = this.aNz.aLM;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.aNz.getData(), null, null));
        }
    }
}
