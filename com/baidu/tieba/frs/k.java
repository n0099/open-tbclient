package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class k implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.aDT = frsActivity;
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
        bpVar = this.aDT.aCV;
        cyVar = this.aDT.aDi;
        z = FrsActivity.aCK;
        z2 = FrsActivity.aCL;
        z3 = FrsActivity.aCM;
        bpVar.a(cyVar, z, z2, z3);
        bpVar2 = this.aDT.aCV;
        bpVar2.FB();
        TiebaStatic.eventStat(this.aDT.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        eVar = this.aDT.aDf;
        ArrayList<com.baidu.tbadk.core.data.s> recommendForumData = eVar.aeI().getRecommendForumData();
        if (recommendForumData != null) {
            Iterator<com.baidu.tbadk.core.data.s> it = recommendForumData.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(this.aDT.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().Em);
            }
        }
    }
}
