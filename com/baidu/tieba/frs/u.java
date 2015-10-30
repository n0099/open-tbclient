package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.RecommendForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class u implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity aUK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.aUK = frsActivity;
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
        this.aUK.setSwipeBackEnabled(false);
        bsVar = this.aUK.aTU;
        dgVar = this.aUK.aTX;
        bsVar.a(dgVar);
        kVar = this.aUK.aUl;
        dgVar2 = this.aUK.aTX;
        kVar.a(dgVar2);
        TiebaStatic.eventStat(this.aUK.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        oVar = this.aUK.aTW;
        if (oVar != null) {
            oVar2 = this.aUK.aTW;
            if (oVar2.aeJ() != null) {
                oVar3 = this.aUK.aTW;
                ArrayList<RecommendForumData> recommendForumData = oVar3.aeJ().getRecommendForumData();
                if (recommendForumData != null) {
                    Iterator<RecommendForumData> it = recommendForumData.iterator();
                    while (it.hasNext()) {
                        TiebaStatic.eventStat(this.aUK.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().mParam);
                    }
                }
            }
        }
    }
}
