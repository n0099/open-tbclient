package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class p implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.aBu = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        bu buVar;
        cz czVar;
        boolean z;
        boolean z2;
        boolean z3;
        bu buVar2;
        b bVar;
        buVar = this.aBu.aAF;
        czVar = this.aBu.aAR;
        z = FrsActivity.aAu;
        z2 = FrsActivity.aAv;
        z3 = FrsActivity.aAw;
        buVar.a(czVar, z, z2, z3);
        buVar2 = this.aBu.aAF;
        buVar2.ER();
        TiebaStatic.eventStat(this.aBu, "frs_total_more", "frsclick", 1, new Object[0]);
        bVar = this.aBu.azN;
        ArrayList<com.baidu.tbadk.core.data.n> recommendForumData = bVar.zL().getRecommendForumData();
        if (recommendForumData != null) {
            Iterator<com.baidu.tbadk.core.data.n> it = recommendForumData.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(this.aBu, "sidebar_show", "sidebar_click", 1, "st_param", it.next().Aa);
            }
        }
    }
}
