package com.baidu.tieba.enterForum.e;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.w aXG;
    final /* synthetic */ o aZj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, com.baidu.tieba.tbadkCore.w wVar) {
        this.aZj = oVar;
        this.aXG = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter viewEventCenter;
        ViewEventCenter viewEventCenter2;
        ViewEventCenter viewEventCenter3;
        viewEventCenter = this.aZj.aXs;
        if (viewEventCenter != null) {
            if (this.aXG.getType() == 0) {
                viewEventCenter3 = this.aZj.aXs;
                viewEventCenter3.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(1, this.aXG, null, null));
            } else if (this.aXG.getType() == 1) {
                TiebaStatic.eventStat(this.aZj.getActivity(), "find_more_text_click", null);
                viewEventCenter2 = this.aZj.aXs;
                viewEventCenter2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(13, null, null, null));
            }
        }
    }
}
