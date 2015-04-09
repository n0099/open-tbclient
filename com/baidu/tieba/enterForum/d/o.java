package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.ae aDc;
    final /* synthetic */ n aEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, com.baidu.tieba.tbadkCore.ae aeVar) {
        this.aEs = nVar;
        this.aDc = aeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.aEs.aCS;
        if (viewEventCenter != null) {
            if (this.aDc.getType() == 0) {
                viewEventCenter3 = this.aEs.aCS;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.aDc, null, null));
            } else if (this.aDc.getType() == 1) {
                TiebaStatic.eventStat(this.aEs.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.aEs.aCS;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
