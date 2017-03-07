package com.baidu.tieba.frs.f;

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
public class ad {
    private FrsActivity bTf;
    private com.baidu.tieba.frs.entelechy.b.g cdi;
    private boolean cdj = false;
    private com.baidu.tieba.frs.entelechy.b.f bZW = new ae(this);

    public ad(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.g gVar) {
        this.bTf = frsActivity;
        this.cdi = gVar;
        gVar.a(this.bZW);
        gVar.t(frsActivity.getPageContext().getPageActivity());
    }

    public void a(Activity activity, View view, View view2) {
        this.cdi.a(activity, view, view2);
    }

    public void abm() {
        this.cdi.abm();
    }

    public void dX(boolean z) {
        this.cdi.dX(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abi() {
        ArrayList<RecommendForumData> recommendForumData;
        this.bTf.Zb();
        this.bTf.setSwipeBackEnabled(false);
        this.bTf.YM();
        TiebaStatic.eventStat(this.bTf.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        com.baidu.tieba.tbadkCore.n YV = this.bTf.YV();
        if (YV != null && YV.aJp() != null && (recommendForumData = YV.aJp().getRecommendForumData()) != null) {
            Iterator<RecommendForumData> it = recommendForumData.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(this.bTf.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().mParam);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abj() {
        if (!TextUtils.isEmpty(this.bTf.getFrom()) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.bTf.getFrom())) {
            this.bTf.setSwipeBackEnabled(false);
        } else {
            this.bTf.setSwipeBackEnabled(true);
        }
        if (this.bTf.Za()) {
            this.bTf.dz(false);
            this.bTf.refresh();
        }
    }

    public boolean abn() {
        return this.cdi.abn() || this.cdj;
    }

    public void dY(boolean z) {
        this.cdi.dY(z);
    }

    public void dZ(boolean z) {
        this.cdi.dZ(z);
    }
}
