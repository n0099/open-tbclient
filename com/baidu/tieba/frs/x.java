package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.RecommendForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class x implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsActivity frsActivity) {
        this.bgz = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        eb ebVar;
        com.baidu.tieba.frs.c.l lVar;
        eb ebVar2;
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        this.bgz.setSwipeBackEnabled(false);
        cn cnVar = this.bgz.bfD;
        ebVar = this.bgz.bfG;
        cnVar.a(ebVar);
        lVar = this.bgz.bfT;
        ebVar2 = this.bgz.bfG;
        lVar.a(ebVar2);
        TiebaStatic.eventStat(this.bgz.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        oVar = this.bgz.bfF;
        if (oVar != null) {
            oVar2 = this.bgz.bfF;
            if (oVar2.aoE() != null) {
                oVar3 = this.bgz.bfF;
                ArrayList<RecommendForumData> recommendForumData = oVar3.aoE().getRecommendForumData();
                if (recommendForumData != null) {
                    Iterator<RecommendForumData> it = recommendForumData.iterator();
                    while (it.hasNext()) {
                        TiebaStatic.eventStat(this.bgz.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().mParam);
                    }
                }
            }
        }
    }
}
