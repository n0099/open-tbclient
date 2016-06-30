package com.baidu.tieba.enterForum.view;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.x btB;
    final /* synthetic */ o bvb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, com.baidu.tieba.tbadkCore.x xVar) {
        this.bvb = oVar;
        this.btB = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.bvb.bfx;
        if (viewEventCenter != null) {
            if (this.btB.getType() == 0) {
                viewEventCenter3 = this.bvb.bfx;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.btB, null, null));
            } else if (this.btB.getType() == 1) {
                TiebaStatic.eventStat(this.bvb.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.bvb.bfx;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
