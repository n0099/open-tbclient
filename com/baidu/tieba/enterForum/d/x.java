package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ w aSL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.aSL = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aSL.aQB;
        if (viewEventCenter != null) {
            TiebaStatic.eventStat(this.aSL.getActivity(), "find_more_symbol_click", null);
            viewEventCenter2 = this.aSL.aQB;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
        }
    }
}
