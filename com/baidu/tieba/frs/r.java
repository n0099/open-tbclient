package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class r implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity aLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.aLY = frsActivity;
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
        this.aLY.setSwipeBackEnabled(false);
        bfVar = this.aLY.aLj;
        ceVar = this.aLY.aLo;
        bfVar.a(ceVar);
        kVar = this.aLY.aLC;
        ceVar2 = this.aLY.aLo;
        kVar.a(ceVar2);
        TiebaStatic.eventStat(this.aLY.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        wVar = this.aLY.aLm;
        if (wVar != null) {
            wVar2 = this.aLY.aLm;
            if (wVar2.aas() != null) {
                wVar3 = this.aLY.aLm;
                ArrayList<com.baidu.tbadk.core.data.r> recommendForumData = wVar3.aas().getRecommendForumData();
                if (recommendForumData != null) {
                    Iterator<com.baidu.tbadk.core.data.r> it = recommendForumData.iterator();
                    while (it.hasNext()) {
                        TiebaStatic.eventStat(this.aLY.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().Qv);
                    }
                }
            }
        }
    }
}
