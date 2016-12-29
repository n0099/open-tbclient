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
public class ab {
    private FrsActivity bFI;
    private com.baidu.tieba.frs.entelechy.b.g bPq;
    private boolean bPr = false;
    private com.baidu.tieba.frs.entelechy.b.f bMw = new ac(this);

    public ab(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.g gVar) {
        this.bFI = frsActivity;
        this.bPq = gVar;
        gVar.a(this.bMw);
        gVar.t(frsActivity.getPageContext().getPageActivity());
    }

    public void a(Activity activity, View view, View view2) {
        this.bPq.a(activity, view, view2);
    }

    public void Zn() {
        this.bPq.Zn();
    }

    public void dS(boolean z) {
        this.bPq.dS(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zj() {
        ArrayList<RecommendForumData> recommendForumData;
        this.bFI.WM();
        this.bFI.setSwipeBackEnabled(false);
        this.bFI.Ww();
        TiebaStatic.eventStat(this.bFI.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        com.baidu.tieba.tbadkCore.o WF = this.bFI.WF();
        if (WF != null && WF.aIk() != null && (recommendForumData = WF.aIk().getRecommendForumData()) != null) {
            Iterator<RecommendForumData> it = recommendForumData.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(this.bFI.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().mParam);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zk() {
        if (!TextUtils.isEmpty(this.bFI.getFrom()) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.bFI.getFrom())) {
            this.bFI.setSwipeBackEnabled(false);
        } else {
            this.bFI.setSwipeBackEnabled(true);
        }
        if (this.bFI.WK()) {
            this.bFI.ds(false);
            this.bFI.refresh();
        }
    }

    public boolean Zo() {
        return this.bPq.Zo() || this.bPr;
    }

    public void dT(boolean z) {
        this.bPq.dT(z);
    }

    public void dU(boolean z) {
        this.bPq.dU(z);
    }
}
