package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.v aMR;
    final /* synthetic */ n aOj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, com.baidu.tieba.tbadkCore.v vVar) {
        this.aOj = nVar;
        this.aMR = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.aOj.aMG;
        if (viewEventCenter != null) {
            if (this.aMR.getType() == 0) {
                viewEventCenter3 = this.aOj.aMG;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.aMR, null, null));
            } else if (this.aMR.getType() == 1) {
                TiebaStatic.eventStat(this.aOj.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.aOj.aMG;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
