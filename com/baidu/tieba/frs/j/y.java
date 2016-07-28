package com.baidu.tieba.frs.j;

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
    private FrsActivity bLx;
    private com.baidu.tieba.frs.entelechy.b.g bUp;
    private boolean bUq = false;
    private com.baidu.tieba.frs.entelechy.b.f bRU = new z(this);

    public y(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.g gVar) {
        this.bLx = frsActivity;
        this.bUp = gVar;
        gVar.a(this.bRU);
        gVar.p(frsActivity.getPageContext().getPageActivity());
    }

    public void a(Activity activity, View view, View view2) {
        this.bUp.a(activity, view, view2);
    }

    public void YB() {
        this.bUp.YB();
    }

    public void dA(boolean z) {
        this.bUp.dA(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOpened() {
        ArrayList<RecommendForumData> recommendForumData;
        this.bLx.Wk();
        this.bLx.setSwipeBackEnabled(false);
        this.bLx.VG();
        TiebaStatic.eventStat(this.bLx.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        com.baidu.tieba.tbadkCore.p VU = this.bLx.VU();
        if (VU != null && VU.aGX() != null && (recommendForumData = VU.aGX().getRecommendForumData()) != null) {
            Iterator<RecommendForumData> it = recommendForumData.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(this.bLx.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().mParam);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClosed() {
        if (!TextUtils.isEmpty(this.bLx.getFrom()) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.bLx.getFrom())) {
            this.bLx.setSwipeBackEnabled(false);
        } else {
            this.bLx.setSwipeBackEnabled(true);
        }
        if (this.bLx.We()) {
            this.bLx.dg(false);
            this.bLx.refresh();
        }
    }

    public boolean isMenuShowing() {
        return this.bUp.isMenuShowing() || this.bUq;
    }

    public void dB(boolean z) {
        this.bUp.dB(z);
    }

    public void showContent(boolean z) {
        this.bUp.showContent(z);
    }
}
