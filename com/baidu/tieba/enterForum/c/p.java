package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.u bFc;
    final /* synthetic */ o bGu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, com.baidu.tieba.tbadkCore.u uVar) {
        this.bGu = oVar;
        this.bFc = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.bGu.bEQ;
        if (viewEventCenter != null) {
            if (this.bFc.getType() == 0) {
                viewEventCenter3 = this.bGu.bEQ;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bFc, null, null));
            } else if (this.bFc.getType() == 1) {
                TiebaStatic.eventStat(this.bGu.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.bGu.bEQ;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
