package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ v aEq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.aEq = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aEq.aCK;
        if (viewEventCenter != null) {
            TiebaStatic.eventStat(this.aEq.getActivity(), "find_more_symbol_click", null);
            viewEventCenter2 = this.aEq.aCK;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
        }
    }
}
