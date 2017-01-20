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
    private FrsActivity bLZ;
    private com.baidu.tieba.frs.entelechy.b.g bVQ;
    private boolean bVR = false;
    private com.baidu.tieba.frs.entelechy.b.f bSK = new ae(this);

    public ad(FrsActivity frsActivity, com.baidu.tieba.frs.entelechy.b.g gVar) {
        this.bLZ = frsActivity;
        this.bVQ = gVar;
        gVar.a(this.bSK);
        gVar.t(frsActivity.getPageContext().getPageActivity());
    }

    public void a(Activity activity, View view, View view2) {
        this.bVQ.a(activity, view, view2);
    }

    public void aap() {
        this.bVQ.aap();
    }

    public void dX(boolean z) {
        this.bVQ.dX(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aal() {
        ArrayList<RecommendForumData> recommendForumData;
        this.bLZ.Yc();
        this.bLZ.setSwipeBackEnabled(false);
        this.bLZ.XN();
        TiebaStatic.eventStat(this.bLZ.getPageContext().getPageActivity(), "frs_total_more", "frsclick", 1, new Object[0]);
        com.baidu.tieba.tbadkCore.n XW = this.bLZ.XW();
        if (XW != null && XW.aJY() != null && (recommendForumData = XW.aJY().getRecommendForumData()) != null) {
            Iterator<RecommendForumData> it = recommendForumData.iterator();
            while (it.hasNext()) {
                TiebaStatic.eventStat(this.bLZ.getPageContext().getPageActivity(), "sidebar_show", "sidebar_click", 1, "st_param", it.next().mParam);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aam() {
        if (!TextUtils.isEmpty(this.bLZ.getFrom()) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.bLZ.getFrom())) {
            this.bLZ.setSwipeBackEnabled(false);
        } else {
            this.bLZ.setSwipeBackEnabled(true);
        }
        if (this.bLZ.Yb()) {
            this.bLZ.dz(false);
            this.bLZ.refresh();
        }
    }

    public boolean aaq() {
        return this.bVQ.aaq() || this.bVR;
    }

    public void dY(boolean z) {
        this.bVQ.dY(z);
    }

    public void dZ(boolean z) {
        this.bVQ.dZ(z);
    }
}
