package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.v bqj;
    final /* synthetic */ o brD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, com.baidu.tieba.tbadkCore.v vVar) {
        this.brD = oVar;
        this.bqj = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.brD.aRj;
        if (viewEventCenter != null) {
            if (this.bqj.getType() == 0) {
                viewEventCenter3 = this.brD.aRj;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bqj, null, null));
            } else if (this.bqj.getType() == 1) {
                TiebaStatic.eventStat(this.brD.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.brD.aRj;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
