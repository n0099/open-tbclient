package com.baidu.tieba.frs.i;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.RecommendForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class y {
    private FrsActivity bWH;
    private com.baidu.tieba.frs.entelechy.b.g cfu;
    private boolean cfv = false;
    private com.baidu.tieba.frs.entelechy.b.f ccY = new z(this);

    public y(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.g gVar) {
        this.bWH = frsActivity;
        this.cfu = gVar;
        gVar.a(this.ccY);
        gVar.t(frsActivity.getPageContext().getPageActivity());
    }

    public void a(Activity activity, View view, View view2) {
        this.cfu.a(activity, view, view2);
    }

    public void adB() {
        this.cfu.adB();
    }

    public void dX(boolean z) {
        this.cfu.dX(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOpened() {
        ArrayList<RecommendForumData> recommendForumData;
        this.bWH.abt();
        this.bWH.setSwipeBackEnabled(false);
        this.bWH.aaP();
        TiebaStatic.eventStat(this.bWH.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        com.baidu.tieba.tbadkCore.p abe = this.bWH.abe();
        if (abe != null && abe.aMr() != null && (recommendForumData = abe.aMr().getRecommendForumData()) != null) {
            Iterator<RecommendForumData> it = recommendForumData.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(this.bWH.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().mParam);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClosed() {
        if (!TextUtils.isEmpty(this.bWH.getFrom()) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.bWH.getFrom())) {
            this.bWH.setSwipeBackEnabled(false);
        } else {
            this.bWH.setSwipeBackEnabled(true);
        }
        if (this.bWH.abn()) {
            this.bWH.dF(false);
            this.bWH.refresh();
        }
    }

    public boolean isMenuShowing() {
        return this.cfu.isMenuShowing() || this.cfv;
    }

    public void dY(boolean z) {
        this.cfu.dY(z);
    }

    public void showContent(boolean z) {
        this.cfu.showContent(z);
    }
}
