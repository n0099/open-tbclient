package com.baidu.tieba.enterForum.view;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.x bvP;
    final /* synthetic */ o bxp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, com.baidu.tieba.tbadkCore.x xVar) {
        this.bxp = oVar;
        this.bvP = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.bxp.bgJ;
        if (viewEventCenter != null) {
            if (this.bvP.getType() == 0) {
                viewEventCenter3 = this.bxp.bgJ;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bvP, null, null));
            } else if (this.bvP.getType() == 1) {
                TiebaStatic.eventStat(this.bxp.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.bxp.bgJ;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
