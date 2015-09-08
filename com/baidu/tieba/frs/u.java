package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.RecommendForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class u implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity aVz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.aVz = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        bi biVar;
        cr crVar;
        com.baidu.tieba.frs.c.k kVar;
        cr crVar2;
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        this.aVz.setSwipeBackEnabled(false);
        biVar = this.aVz.aUL;
        crVar = this.aVz.aUO;
        biVar.a(crVar);
        kVar = this.aVz.aVc;
        crVar2 = this.aVz.aUO;
        kVar.a(crVar2);
        TiebaStatic.eventStat(this.aVz.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        oVar = this.aVz.aUN;
        if (oVar != null) {
            oVar2 = this.aVz.aUN;
            if (oVar2.acP() != null) {
                oVar3 = this.aVz.aUN;
                ArrayList<RecommendForumData> recommendForumData = oVar3.acP().getRecommendForumData();
                if (recommendForumData != null) {
                    Iterator<RecommendForumData> it = recommendForumData.iterator();
                    while (it.hasNext()) {
                        TiebaStatic.eventStat(this.aVz.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().mParam);
                    }
                }
            }
        }
    }
}
