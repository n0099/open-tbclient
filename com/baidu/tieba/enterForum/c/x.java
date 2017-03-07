package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ w bGH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.bGH = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.bGH.bEQ;
        if (viewEventCenter != null) {
            TiebaStatic.eventStat(this.bGH.getActivity(), "find_more_symbol_click", null);
            viewEventCenter2 = this.bGH.bEQ;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
        }
    }
}
