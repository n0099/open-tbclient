package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    final /* synthetic */ v aOp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.aOp = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        viewEventCenter = this.aOp.aMG;
        if (viewEventCenter != null) {
            TiebaStatic.eventStat(this.aOp.getActivity(), "find_more_symbol_click", null);
            viewEventCenter2 = this.aOp.aMG;
            viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
        }
    }
}
