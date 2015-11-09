package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.RecommendForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class u implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.aUS = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        bs bsVar;
        dg dgVar;
        com.baidu.tieba.frs.b.l lVar;
        dg dgVar2;
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        this.aUS.setSwipeBackEnabled(false);
        bsVar = this.aUS.aUc;
        dgVar = this.aUS.aUf;
        bsVar.a(dgVar);
        lVar = this.aUS.aUt;
        dgVar2 = this.aUS.aUf;
        lVar.a(dgVar2);
        TiebaStatic.eventStat(this.aUS.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        oVar = this.aUS.aUe;
        if (oVar != null) {
            oVar2 = this.aUS.aUe;
            if (oVar2.afg() != null) {
                oVar3 = this.aUS.aUe;
                ArrayList<RecommendForumData> recommendForumData = oVar3.afg().getRecommendForumData();
                if (recommendForumData != null) {
                    Iterator<RecommendForumData> it = recommendForumData.iterator();
                    while (it.hasNext()) {
                        TiebaStatic.eventStat(this.aUS.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().mParam);
                    }
                }
            }
        }
    }
}
