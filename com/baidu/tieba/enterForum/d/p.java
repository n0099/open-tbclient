package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.v aMf;
    final /* synthetic */ o aNx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, com.baidu.tieba.tbadkCore.v vVar) {
        this.aNx = oVar;
        this.aMf = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.aNx.aLU;
        if (viewEventCenter != null) {
            if (this.aMf.getType() == 0) {
                viewEventCenter3 = this.aNx.aLU;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.aMf, null, null));
            } else if (this.aMf.getType() == 1) {
                TiebaStatic.eventStat(this.aNx.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.aNx.aLU;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
