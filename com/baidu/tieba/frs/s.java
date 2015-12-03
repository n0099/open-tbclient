package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.RecommendForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class s implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity bag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.bag = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        dw dwVar;
        com.baidu.tieba.frs.b.l lVar;
        dw dwVar2;
        com.baidu.tieba.tbadkCore.p pVar;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.tbadkCore.p pVar3;
        this.bag.setSwipeBackEnabled(false);
        cd cdVar = this.bag.aZq;
        dwVar = this.bag.aZt;
        cdVar.a(dwVar);
        lVar = this.bag.aZG;
        dwVar2 = this.bag.aZt;
        lVar.a(dwVar2);
        TiebaStatic.eventStat(this.bag.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        pVar = this.bag.aZs;
        if (pVar != null) {
            pVar2 = this.bag.aZs;
            if (pVar2.ajy() != null) {
                pVar3 = this.bag.aZs;
                ArrayList<RecommendForumData> recommendForumData = pVar3.ajy().getRecommendForumData();
                if (recommendForumData != null) {
                    Iterator<RecommendForumData> it = recommendForumData.iterator();
                    while (it.hasNext()) {
                        TiebaStatic.eventStat(this.bag.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().mParam);
                    }
                }
            }
        }
    }
}
