package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.RecommendForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class y implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.blk = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        ei eiVar;
        com.baidu.tieba.frs.c.l lVar;
        ei eiVar2;
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        this.blk.setSwipeBackEnabled(false);
        cs csVar = this.blk.bko;
        eiVar = this.blk.bkr;
        csVar.a(eiVar);
        lVar = this.blk.bkE;
        eiVar2 = this.blk.bkr;
        lVar.a(eiVar2);
        TiebaStatic.eventStat(this.blk.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        oVar = this.blk.bkq;
        if (oVar != null) {
            oVar2 = this.blk.bkq;
            if (oVar2.avu() != null) {
                oVar3 = this.blk.bkq;
                ArrayList<RecommendForumData> recommendForumData = oVar3.avu().getRecommendForumData();
                if (recommendForumData != null) {
                    Iterator<RecommendForumData> it = recommendForumData.iterator();
                    while (it.hasNext()) {
                        TiebaStatic.eventStat(this.blk.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().mParam);
                    }
                }
            }
        }
    }
}
