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
    private FrsActivity bJR;
    private com.baidu.tieba.frs.entelechy.b.g bSp;
    private boolean bSq = false;
    private com.baidu.tieba.frs.entelechy.b.f bQh = new z(this);

    public y(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.g gVar) {
        this.bJR = frsActivity;
        this.bSp = gVar;
        gVar.a(this.bQh);
        gVar.p(frsActivity.getPageContext().getPageActivity());
    }

    public void a(Activity activity, View view, View view2) {
        this.bSp.a(activity, view, view2);
    }

    public void Yh() {
        this.bSp.Yh();
    }

    public void dC(boolean z) {
        this.bSp.dC(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOpened() {
        ArrayList<RecommendForumData> recommendForumData;
        this.bJR.VR();
        this.bJR.setSwipeBackEnabled(false);
        this.bJR.Vq();
        TiebaStatic.eventStat(this.bJR.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        com.baidu.tieba.tbadkCore.p VC = this.bJR.VC();
        if (VC != null && VC.aDN() != null && (recommendForumData = VC.aDN().getRecommendForumData()) != null) {
            Iterator<RecommendForumData> it = recommendForumData.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(this.bJR.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().mParam);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClosed() {
        if (!TextUtils.isEmpty(this.bJR.getFrom()) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.bJR.getFrom())) {
            this.bJR.setSwipeBackEnabled(false);
        } else {
            this.bJR.setSwipeBackEnabled(true);
        }
        if (this.bJR.VL()) {
            this.bJR.dj(false);
            this.bJR.refresh();
        }
    }

    public boolean isMenuShowing() {
        return this.bSp.isMenuShowing() || this.bSq;
    }

    public void dD(boolean z) {
        this.bSp.dD(z);
    }

    public void showContent(boolean z) {
        this.bSp.showContent(z);
    }
}
