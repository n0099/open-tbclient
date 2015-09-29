package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.RecommendForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class u implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.aUz = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        bs bsVar;
        dg dgVar;
        com.baidu.tieba.frs.b.k kVar;
        dg dgVar2;
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        this.aUz.setSwipeBackEnabled(false);
        bsVar = this.aUz.aTJ;
        dgVar = this.aUz.aTM;
        bsVar.a(dgVar);
        kVar = this.aUz.aUa;
        dgVar2 = this.aUz.aTM;
        kVar.a(dgVar2);
        TiebaStatic.eventStat(this.aUz.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        oVar = this.aUz.aTL;
        if (oVar != null) {
            oVar2 = this.aUz.aTL;
            if (oVar2.aeN() != null) {
                oVar3 = this.aUz.aTL;
                ArrayList<RecommendForumData> recommendForumData = oVar3.aeN().getRecommendForumData();
                if (recommendForumData != null) {
                    Iterator<RecommendForumData> it = recommendForumData.iterator();
                    while (it.hasNext()) {
                        TiebaStatic.eventStat(this.aUz.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().mParam);
                    }
                }
            }
        }
    }
}
