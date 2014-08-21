package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.slidingmenu.lib.SlidingMenu;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class w implements SlidingMenu.OnOpenedListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // com.slidingmenu.lib.SlidingMenu.OnOpenedListener
    public void onOpened() {
        g gVar;
        TiebaStatic.eventStat(this.a, "frs_total_more", "frsclick", 1, new Object[0]);
        gVar = this.a.N;
        ArrayList<com.baidu.tbadk.core.data.m> recommendForumData = gVar.i().getRecommendForumData();
        if (recommendForumData != null) {
            Iterator<com.baidu.tbadk.core.data.m> it = recommendForumData.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(this.a, "sidebar_show", "sidebar_click", 1, "st_param", it.next().d);
            }
        }
    }
}
