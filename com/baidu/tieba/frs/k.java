package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class k implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        bq bqVar;
        cx cxVar;
        boolean z;
        boolean z2;
        boolean z3;
        bq bqVar2;
        com.baidu.tieba.tbadkCore.e eVar;
        bqVar = this.aCV.aBX;
        cxVar = this.aCV.aCk;
        z = FrsActivity.aBM;
        z2 = FrsActivity.aBN;
        z3 = FrsActivity.aBO;
        bqVar.a(cxVar, z, z2, z3);
        bqVar2 = this.aCV.aBX;
        bqVar2.Fj();
        TiebaStatic.eventStat(this.aCV.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        eVar = this.aCV.aCh;
        ArrayList<com.baidu.tbadk.core.data.r> recommendForumData = eVar.aej().getRecommendForumData();
        if (recommendForumData != null) {
            Iterator<com.baidu.tbadk.core.data.r> it = recommendForumData.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(this.aCV.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().El);
            }
        }
    }
}
