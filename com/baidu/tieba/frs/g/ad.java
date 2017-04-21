package com.baidu.tieba.frs.g;

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
    private FrsActivity bVk;
    private com.baidu.tieba.frs.entelechy.b.g cea;
    private boolean ceb = false;
    private com.baidu.tieba.frs.entelechy.b.f caO = new ae(this);

    public ad(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.g gVar) {
        this.bVk = frsActivity;
        this.cea = gVar;
        gVar.a(this.caO);
        gVar.t(frsActivity.getPageContext().getPageActivity());
    }

    public void a(Activity activity, View view, View view2) {
        this.cea.a(activity, view, view2);
    }

    public void acK() {
        this.cea.acK();
    }

    public void ej(boolean z) {
        this.cea.ej(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acG() {
        ArrayList<RecommendForumData> recommendForumData;
        this.bVk.aay();
        this.bVk.setSwipeBackEnabled(false);
        this.bVk.aaj();
        TiebaStatic.eventStat(this.bVk.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        com.baidu.tieba.tbadkCore.n aas = this.bVk.aas();
        if (aas != null && aas.aKx() != null && (recommendForumData = aas.aKx().getRecommendForumData()) != null) {
            Iterator<RecommendForumData> it = recommendForumData.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(this.bVk.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().mParam);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acH() {
        if (!TextUtils.isEmpty(this.bVk.getFrom()) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.bVk.getFrom())) {
            this.bVk.setSwipeBackEnabled(false);
        } else {
            this.bVk.setSwipeBackEnabled(true);
        }
        if (this.bVk.aax()) {
            this.bVk.dL(false);
            this.bVk.refresh();
        }
    }

    public boolean acL() {
        return this.cea.acL() || this.ceb;
    }

    public void ek(boolean z) {
        this.cea.ek(z);
    }

    public void el(boolean z) {
        this.cea.el(z);
    }
}
