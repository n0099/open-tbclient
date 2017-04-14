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
    private FrsActivity bST;
    private com.baidu.tieba.frs.entelechy.b.g cbJ;
    private boolean cbK = false;
    private com.baidu.tieba.frs.entelechy.b.f bYx = new ae(this);

    public ad(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.g gVar) {
        this.bST = frsActivity;
        this.cbJ = gVar;
        gVar.a(this.bYx);
        gVar.t(frsActivity.getPageContext().getPageActivity());
    }

    public void a(Activity activity, View view, View view2) {
        this.cbJ.a(activity, view, view2);
    }

    public void abJ() {
        this.cbJ.abJ();
    }

    public void dZ(boolean z) {
        this.cbJ.dZ(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abF() {
        ArrayList<RecommendForumData> recommendForumData;
        this.bST.Zx();
        this.bST.setSwipeBackEnabled(false);
        this.bST.Zi();
        TiebaStatic.eventStat(this.bST.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        com.baidu.tieba.tbadkCore.n Zr = this.bST.Zr();
        if (Zr != null && Zr.aJw() != null && (recommendForumData = Zr.aJw().getRecommendForumData()) != null) {
            Iterator<RecommendForumData> it = recommendForumData.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(this.bST.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().mParam);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abG() {
        if (!TextUtils.isEmpty(this.bST.getFrom()) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.bST.getFrom())) {
            this.bST.setSwipeBackEnabled(false);
        } else {
            this.bST.setSwipeBackEnabled(true);
        }
        if (this.bST.Zw()) {
            this.bST.dB(false);
            this.bST.refresh();
        }
    }

    public boolean abK() {
        return this.cbJ.abK() || this.cbK;
    }

    public void ea(boolean z) {
        this.cbJ.ea(z);
    }

    public void eb(boolean z) {
        this.cbJ.eb(z);
    }
}
