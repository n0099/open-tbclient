package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class k implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        bp bpVar;
        cy cyVar;
        boolean z;
        boolean z2;
        boolean z3;
        bp bpVar2;
        com.baidu.tieba.tbadkCore.e eVar;
        bpVar = this.aDW.aCY;
        cyVar = this.aDW.aDl;
        z = FrsActivity.aCN;
        z2 = FrsActivity.aCO;
        z3 = FrsActivity.aCP;
        bpVar.a(cyVar, z, z2, z3);
        bpVar2 = this.aDW.aCY;
        bpVar2.FH();
        TiebaStatic.eventStat(this.aDW.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        eVar = this.aDW.aDi;
        ArrayList<com.baidu.tbadk.core.data.s> recommendForumData = eVar.aeN().getRecommendForumData();
        if (recommendForumData != null) {
            Iterator<com.baidu.tbadk.core.data.s> it = recommendForumData.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(this.aDW.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().Ep);
            }
        }
    }
}
