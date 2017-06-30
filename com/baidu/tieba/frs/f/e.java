package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d cpC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.cpC = dVar;
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
        rVar = this.cpC.cdv;
        if (rVar != null) {
            entelechyPullUpRefreshView = this.cpC.cpx;
            if (view != entelechyPullUpRefreshView) {
                entelechyPullUpRefreshView2 = this.cpC.cpy;
                if (view != entelechyPullUpRefreshView2) {
                    return;
                }
            }
            rVar2 = this.cpC.cdv;
            TiebaStatic.eventStat(rVar2.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            rVar3 = this.cpC.cdv;
            if (!rVar3.ael()) {
                rVar4 = this.cpC.cdv;
                if (rVar4.adU() != null) {
                    au auVar = new au("c11752");
                    rVar5 = this.cpC.cdv;
                    TiebaStatic.log(auVar.Z("fid", rVar5.getFid()).Z("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    rVar6 = this.cpC.cdv;
                    rVar6.adU().startPullRefresh();
                }
            }
        }
    }
}
