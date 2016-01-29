package com.baidu.tieba.enterForum.d;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.v aWO;
    final /* synthetic */ o aYS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, com.baidu.tieba.tbadkCore.v vVar) {
        this.aYS = oVar;
        this.aWO = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.aYS.aWA;
        if (viewEventCenter != null) {
            if (this.aWO.getType() == 0) {
                viewEventCenter3 = this.aYS.aWA;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.aWO, null, null));
            } else if (this.aWO.getType() == 1) {
                TiebaStatic.eventStat(this.aYS.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.aYS.aWA;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
