package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class r implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.aJG = frsActivity;
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
        this.aJG.setSwipeBackEnabled(false);
        bfVar = this.aJG.aIS;
        cfVar = this.aJG.aIX;
        bfVar.a(cfVar);
        kVar = this.aJG.aJm;
        cfVar2 = this.aJG.aIX;
        kVar.a(cfVar2);
        TiebaStatic.eventStat(this.aJG.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        wVar = this.aJG.aIV;
        if (wVar != null) {
            wVar2 = this.aJG.aIV;
            if (wVar2.YO() != null) {
                wVar3 = this.aJG.aIV;
                ArrayList<com.baidu.tbadk.core.data.r> recommendForumData = wVar3.YO().getRecommendForumData();
                if (recommendForumData != null) {
                    Iterator<com.baidu.tbadk.core.data.r> it = recommendForumData.iterator();
                    while (it.hasNext()) {
                        TiebaStatic.eventStat(this.aJG.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().PY);
                    }
                }
            }
        }
    }
}
