package com.baidu.tieba.enterForum.e;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.w bHd;
    final /* synthetic */ o bIE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, com.baidu.tieba.tbadkCore.w wVar) {
        this.bIE = oVar;
        this.bHd = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.bIE.aOw;
        if (viewEventCenter != null) {
            if (this.bHd.getType() == 0) {
                viewEventCenter3 = this.bIE.aOw;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bHd, null, null));
            } else if (this.bHd.getType() == 1) {
                TiebaStatic.eventStat(this.bIE.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.bIE.aOw;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
