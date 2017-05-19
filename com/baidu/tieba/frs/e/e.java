package com.baidu.tieba.frs.e;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d cba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.cba = dVar;
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
        rVar = this.cba.bPw;
        if (rVar != null) {
            entelechyPullUpRefreshView = this.cba.caV;
            if (view != entelechyPullUpRefreshView) {
                entelechyPullUpRefreshView2 = this.cba.caW;
                if (view != entelechyPullUpRefreshView2) {
                    return;
                }
            }
            rVar2 = this.cba.bPw;
            TiebaStatic.eventStat(rVar2.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            rVar3 = this.cba.bPw;
            if (!rVar3.Zr()) {
                rVar4 = this.cba.bPw;
                if (rVar4.YZ() != null) {
                    as asVar = new as("c11752");
                    rVar5 = this.cba.bPw;
                    TiebaStatic.log(asVar.aa("fid", rVar5.getFid()).aa("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    rVar6 = this.cba.bPw;
                    rVar6.YZ().startPullRefresh();
                }
            }
        }
    }
}
