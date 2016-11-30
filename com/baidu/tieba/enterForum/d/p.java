package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.w bKf;
    final /* synthetic */ o bLz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, com.baidu.tieba.tbadkCore.w wVar) {
        this.bLz = oVar;
        this.bKf = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.bLz.aRS;
        if (viewEventCenter != null) {
            if (this.bKf.getType() == 0) {
                viewEventCenter3 = this.bLz.aRS;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.bKf, null, null));
            } else if (this.bKf.getType() == 1) {
                TiebaStatic.eventStat(this.bLz.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.bLz.aRS;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
