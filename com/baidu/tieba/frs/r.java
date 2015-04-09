package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class r implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity aJQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.aJQ = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        bf bfVar;
        cf cfVar;
        com.baidu.tieba.frs.c.k kVar;
        cf cfVar2;
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        this.aJQ.setSwipeBackEnabled(false);
        bfVar = this.aJQ.aJa;
        cfVar = this.aJQ.aJf;
        bfVar.a(cfVar);
        kVar = this.aJQ.aJu;
        cfVar2 = this.aJQ.aJf;
        kVar.a(cfVar2);
        TiebaStatic.eventStat(this.aJQ.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        wVar = this.aJQ.aJd;
        if (wVar != null) {
            wVar2 = this.aJQ.aJd;
            if (wVar2.Za() != null) {
                wVar3 = this.aJQ.aJd;
                ArrayList<com.baidu.tbadk.core.data.r> recommendForumData = wVar3.Za().getRecommendForumData();
                if (recommendForumData != null) {
                    Iterator<com.baidu.tbadk.core.data.r> it = recommendForumData.iterator();
                    while (it.hasNext()) {
                        TiebaStatic.eventStat(this.aJQ.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().Qa);
                    }
                }
            }
        }
    }
}
