package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d chl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.chl = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.frs.r rVar;
        EntelechyPullUpRefreshView entelechyPullUpRefreshView;
        com.baidu.tieba.frs.r rVar2;
        com.baidu.tieba.frs.r rVar3;
        com.baidu.tieba.frs.r rVar4;
        com.baidu.tieba.frs.r rVar5;
        com.baidu.tieba.frs.r rVar6;
        EntelechyPullUpRefreshView entelechyPullUpRefreshView2;
        rVar = this.chl.bVm;
        if (rVar != null) {
            entelechyPullUpRefreshView = this.chl.chg;
            if (view != entelechyPullUpRefreshView) {
                entelechyPullUpRefreshView2 = this.chl.chh;
                if (view != entelechyPullUpRefreshView2) {
                    return;
                }
            }
            rVar2 = this.chl.bVm;
            TiebaStatic.eventStat(rVar2.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            rVar3 = this.chl.bVm;
            if (!rVar3.aav()) {
                rVar4 = this.chl.bVm;
                if (rVar4.aad() != null) {
                    as asVar = new as("c11752");
                    rVar5 = this.chl.bVm;
                    TiebaStatic.log(asVar.Z("fid", rVar5.getFid()).Z("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    rVar6 = this.chl.bVm;
                    rVar6.aad().startPullRefresh();
                }
            }
        }
    }
}
