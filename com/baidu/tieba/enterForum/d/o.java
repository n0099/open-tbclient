package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.u aME;
    final /* synthetic */ n aNW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, com.baidu.tieba.tbadkCore.u uVar) {
        this.aNW = nVar;
        this.aME = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.aNW.aMt;
        if (viewEventCenter != null) {
            if (this.aME.getType() == 0) {
                viewEventCenter3 = this.aNW.aMt;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.aME, null, null));
            } else if (this.aME.getType() == 1) {
                TiebaStatic.eventStat(this.aNW.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.aNW.aMt;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
