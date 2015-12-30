package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.w aUF;
    final /* synthetic */ o aWE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, com.baidu.tieba.tbadkCore.w wVar) {
        this.aWE = oVar;
        this.aUF = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.aWE.aUs;
        if (viewEventCenter != null) {
            if (this.aUF.getType() == 0) {
                viewEventCenter3 = this.aWE.aUs;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.aUF, null, null));
            } else if (this.aUF.getType() == 1) {
                TiebaStatic.eventStat(this.aWE.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.aWE.aUs;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
