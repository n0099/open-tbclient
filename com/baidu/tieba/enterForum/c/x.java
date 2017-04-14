package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ w bGA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.bGA = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bGA.bEJ;
        if (viewEventCenter != null) {
            TiebaStatic.eventStat(this.bGA.getActivity(), "find_more_symbol_click", null);
            viewEventCenter2 = this.bGA.bEJ;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
        }
    }
}
