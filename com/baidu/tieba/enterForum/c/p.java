package com.baidu.tieba.enterForum.c;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.u bxW;
    final /* synthetic */ o bzo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, com.baidu.tieba.tbadkCore.u uVar) {
        this.bzo = oVar;
        this.bxW = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.bzo.bxK;
        if (viewEventCenter != null) {
            if (this.bxW.getType() == 0) {
                viewEventCenter3 = this.bzo.bxK;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bxW, null, null));
            } else if (this.bxW.getType() == 1) {
                TiebaStatic.eventStat(this.bzo.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.bzo.bxK;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
