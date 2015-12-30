package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.RecommendForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class t implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.bed = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        dw dwVar;
        com.baidu.tieba.frs.b.l lVar;
        dw dwVar2;
        com.baidu.tieba.tbadkCore.p pVar;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.tbadkCore.p pVar3;
        this.bed.setSwipeBackEnabled(false);
        cg cgVar = this.bed.bdm;
        dwVar = this.bed.bdp;
        cgVar.a(dwVar);
        lVar = this.bed.bdC;
        dwVar2 = this.bed.bdp;
        lVar.a(dwVar2);
        TiebaStatic.eventStat(this.bed.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        pVar = this.bed.bdo;
        if (pVar != null) {
            pVar2 = this.bed.bdo;
            if (pVar2.akG() != null) {
                pVar3 = this.bed.bdo;
                ArrayList<RecommendForumData> recommendForumData = pVar3.akG().getRecommendForumData();
                if (recommendForumData != null) {
                    Iterator<RecommendForumData> it = recommendForumData.iterator();
                    while (it.hasNext()) {
                        TiebaStatic.eventStat(this.bed.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().mParam);
                    }
                }
            }
        }
    }
}
