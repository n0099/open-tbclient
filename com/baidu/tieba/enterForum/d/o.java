package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.ae aCU;
    final /* synthetic */ n aEk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, com.baidu.tieba.tbadkCore.ae aeVar) {
        this.aEk = nVar;
        this.aCU = aeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.aEk.aCK;
        if (viewEventCenter != null) {
            if (this.aCU.getType() == 0) {
                viewEventCenter3 = this.aEk.aCK;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.aCU, null, null));
            } else if (this.aCU.getType() == 1) {
                TiebaStatic.eventStat(this.aEk.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.aEk.aCK;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
