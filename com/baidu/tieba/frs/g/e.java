package com.baidu.tieba.frs.g;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d caW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.caW = dVar;
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
        frsActivity = this.caW.bOf;
        if (frsActivity != null) {
            entelechyPullUpRefreshView = this.caW.caR;
            if (view != entelechyPullUpRefreshView) {
                entelechyPullUpRefreshView2 = this.caW.caS;
                if (view != entelechyPullUpRefreshView2) {
                    entelechyPullUpRefreshView3 = this.caW.caT;
                    if (view == entelechyPullUpRefreshView3) {
                        frsActivity7 = this.caW.bOf;
                        if (frsActivity7.YN() != null) {
                            frsActivity8 = this.caW.bOf;
                            frsActivity8.YN().aeo();
                            com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c11752");
                            frsActivity9 = this.caW.bOf;
                            TiebaStatic.log(asVar.aa("fid", frsActivity9.getFid()).aa("obj_locate", "2"));
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            frsActivity2 = this.caW.bOf;
            TiebaStatic.eventStat(frsActivity2.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            frsActivity3 = this.caW.bOf;
            if (!frsActivity3.Zs()) {
                frsActivity4 = this.caW.bOf;
                if (frsActivity4.Za() != null) {
                    com.baidu.tbadk.core.util.as asVar2 = new com.baidu.tbadk.core.util.as("c11752");
                    frsActivity5 = this.caW.bOf;
                    TiebaStatic.log(asVar2.aa("fid", frsActivity5.getFid()).aa("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    frsActivity6 = this.caW.bOf;
                    frsActivity6.Za().startPullRefresh();
                }
            }
        }
    }
}
