package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class p implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.aBk = frsActivity;
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
        buVar = this.aBk.aAv;
        czVar = this.aBk.aAH;
        z = FrsActivity.aAk;
        z2 = FrsActivity.aAl;
        z3 = FrsActivity.aAm;
        buVar.a(czVar, z, z2, z3);
        buVar2 = this.aBk.aAv;
        buVar2.EP();
        TiebaStatic.eventStat(this.aBk, "frs_total_more", "frsclick", 1, new Object[0]);
        bVar = this.aBk.azE;
        ArrayList<com.baidu.tbadk.core.data.n> recommendForumData = bVar.zJ().getRecommendForumData();
        if (recommendForumData != null) {
            Iterator<com.baidu.tbadk.core.data.n> it = recommendForumData.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(this.aBk, "sidebar_show", "sidebar_click", 1, "st_param", it.next().Aa);
            }
        }
    }
}
