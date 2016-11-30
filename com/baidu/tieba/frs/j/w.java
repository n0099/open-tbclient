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
public class w {
    private FrsActivity bZY;
    private com.baidu.tieba.frs.entelechy.b.g ckh;
    private boolean cki = false;
    private com.baidu.tieba.frs.entelechy.b.f cgN = new x(this);

    public w(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.g gVar) {
        this.bZY = frsActivity;
        this.ckh = gVar;
        gVar.a(this.cgN);
        gVar.t(frsActivity.getPageContext().getPageActivity());
    }

    public void a(Activity activity, View view, View view2) {
        this.ckh.a(activity, view, view2);
    }

    public void aeS() {
        this.ckh.aeS();
    }

    public void ei(boolean z) {
        this.ckh.ei(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeO() {
        ArrayList<RecommendForumData> recommendForumData;
        this.bZY.acz();
        this.bZY.setSwipeBackEnabled(false);
        this.bZY.aci();
        TiebaStatic.eventStat(this.bZY.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        com.baidu.tieba.tbadkCore.p acr = this.bZY.acr();
        if (acr != null && acr.aOk() != null && (recommendForumData = acr.aOk().getRecommendForumData()) != null) {
            Iterator<RecommendForumData> it = recommendForumData.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(this.bZY.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().mParam);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeP() {
        if (!TextUtils.isEmpty(this.bZY.getFrom()) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.bZY.getFrom())) {
            this.bZY.setSwipeBackEnabled(false);
        } else {
            this.bZY.setSwipeBackEnabled(true);
        }
        if (this.bZY.acx()) {
            this.bZY.dK(false);
            this.bZY.refresh();
        }
    }

    public boolean aeT() {
        return this.ckh.aeT() || this.cki;
    }

    public void ej(boolean z) {
        this.ckh.ej(z);
    }

    public void ek(boolean z) {
        this.ckh.ek(z);
    }
}
