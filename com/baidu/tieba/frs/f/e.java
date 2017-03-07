package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d ccv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ccv = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        EntelechyPullUpRefreshView entelechyPullUpRefreshView;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        EntelechyPullUpRefreshView entelechyPullUpRefreshView2;
        EntelechyPullUpRefreshView entelechyPullUpRefreshView3;
        FrsActivity frsActivity7;
        FrsActivity frsActivity8;
        FrsActivity frsActivity9;
        frsActivity = this.ccv.bOq;
        if (frsActivity != null) {
            entelechyPullUpRefreshView = this.ccv.ccq;
            if (view != entelechyPullUpRefreshView) {
                entelechyPullUpRefreshView2 = this.ccv.ccr;
                if (view != entelechyPullUpRefreshView2) {
                    entelechyPullUpRefreshView3 = this.ccv.ccs;
                    if (view == entelechyPullUpRefreshView3) {
                        frsActivity7 = this.ccv.bOq;
                        if (frsActivity7.Yq() != null) {
                            frsActivity8 = this.ccv.bOq;
                            frsActivity8.Yq().aet();
                            com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11752");
                            frsActivity9 = this.ccv.bOq;
                            TiebaStatic.log(asVar.Z("fid", frsActivity9.getFid()).Z("obj_locate", "2"));
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            frsActivity2 = this.ccv.bOq;
            TiebaStatic.eventStat(frsActivity2.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            frsActivity3 = this.ccv.bOq;
            if (!frsActivity3.YW()) {
                frsActivity4 = this.ccv.bOq;
                if (frsActivity4.YE() != null) {
                    com.baidu.tbadk.core.util.as asVar2 = new com.baidu.tbadk.core.util.as("c11752");
                    frsActivity5 = this.ccv.bOq;
                    TiebaStatic.log(asVar2.Z("fid", frsActivity5.getFid()).Z("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    frsActivity6 = this.ccv.bOq;
                    frsActivity6.YE().startPullRefresh();
                }
            }
        }
    }
}
