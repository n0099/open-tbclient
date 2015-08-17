package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.RecommendForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class u implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.this$0 = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        bl blVar;
        cn cnVar;
        com.baidu.tieba.frs.c.k kVar;
        cn cnVar2;
        com.baidu.tieba.tbadkCore.n nVar;
        com.baidu.tieba.tbadkCore.n nVar2;
        com.baidu.tieba.tbadkCore.n nVar3;
        this.this$0.setSwipeBackEnabled(false);
        blVar = this.this$0.aUw;
        cnVar = this.this$0.aUz;
        blVar.a(cnVar);
        kVar = this.this$0.aUN;
        cnVar2 = this.this$0.aUz;
        kVar.a(cnVar2);
        TiebaStatic.eventStat(this.this$0.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        nVar = this.this$0.aUy;
        if (nVar != null) {
            nVar2 = this.this$0.aUy;
            if (nVar2.acG() != null) {
                nVar3 = this.this$0.aUy;
                ArrayList<RecommendForumData> recommendForumData = nVar3.acG().getRecommendForumData();
                if (recommendForumData != null) {
                    Iterator<RecommendForumData> it = recommendForumData.iterator();
                    while (it.hasNext()) {
                        TiebaStatic.eventStat(this.this$0.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().mParam);
                    }
                }
            }
        }
    }
}
