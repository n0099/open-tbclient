package com.baidu.tieba.frs.h;

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
    private FrsActivity bpj;
    private com.baidu.tieba.frs.entelechy.b.f bsC = new x(this);
    private com.baidu.tieba.frs.entelechy.b.g buC;

    public w(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.g gVar) {
        this.bpj = frsActivity;
        this.buC = gVar;
        gVar.a(this.bsC);
        gVar.n(frsActivity.getPageContext().getPageActivity());
    }

    public void a(Activity activity, View view, View view2) {
        this.buC.a(activity, view, view2);
    }

    public void SG() {
        this.buC.SG();
    }

    public void df(boolean z) {
        this.buC.df(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOpened() {
        ArrayList<RecommendForumData> recommendForumData;
        this.bpj.setSwipeBackEnabled(false);
        this.bpj.PH();
        TiebaStatic.eventStat(this.bpj.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        com.baidu.tieba.tbadkCore.o PZ = this.bpj.PZ();
        if (PZ != null && PZ.avD() != null && (recommendForumData = PZ.avD().getRecommendForumData()) != null) {
            Iterator<RecommendForumData> it = recommendForumData.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(this.bpj.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().mParam);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClosed() {
        if (!TextUtils.isEmpty(this.bpj.getFrom()) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.bpj.getFrom())) {
            this.bpj.setSwipeBackEnabled(false);
        } else {
            this.bpj.setSwipeBackEnabled(true);
        }
        if (this.bpj.Qi()) {
            this.bpj.cN(false);
            this.bpj.refresh();
        }
    }

    public boolean isMenuShowing() {
        return this.buC.isMenuShowing();
    }

    public void toggle(boolean z) {
        this.buC.toggle(z);
    }

    public void showContent(boolean z) {
        this.buC.showContent(z);
    }
}
