package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class r implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity aLX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.aLX = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        bf bfVar;
        ce ceVar;
        com.baidu.tieba.frs.c.k kVar;
        ce ceVar2;
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        this.aLX.setSwipeBackEnabled(false);
        bfVar = this.aLX.aLi;
        ceVar = this.aLX.aLn;
        bfVar.a(ceVar);
        kVar = this.aLX.aLB;
        ceVar2 = this.aLX.aLn;
        kVar.a(ceVar2);
        TiebaStatic.eventStat(this.aLX.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        wVar = this.aLX.aLl;
        if (wVar != null) {
            wVar2 = this.aLX.aLl;
            if (wVar2.aar() != null) {
                wVar3 = this.aLX.aLl;
                ArrayList<com.baidu.tbadk.core.data.r> recommendForumData = wVar3.aar().getRecommendForumData();
                if (recommendForumData != null) {
                    Iterator<com.baidu.tbadk.core.data.r> it = recommendForumData.iterator();
                    while (it.hasNext()) {
                        TiebaStatic.eventStat(this.aLX.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().Qv);
                    }
                }
            }
        }
    }
}
