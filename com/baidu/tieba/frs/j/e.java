package com.baidu.tieba.frs.j;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d cjA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.cjA = dVar;
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
        frsActivity = this.cjA.bTA;
        if (frsActivity != null) {
            entelechyPullUpRefreshView = this.cjA.cjv;
            if (view != entelechyPullUpRefreshView) {
                entelechyPullUpRefreshView2 = this.cjA.cjw;
                if (view != entelechyPullUpRefreshView2) {
                    entelechyPullUpRefreshView3 = this.cjA.cjx;
                    if (view == entelechyPullUpRefreshView3) {
                        frsActivity7 = this.cjA.bTA;
                        if (frsActivity7.abL() != null) {
                            frsActivity8 = this.cjA.bTA;
                            frsActivity8.abL().ahN();
                            av avVar = new av("c11752");
                            frsActivity9 = this.cjA.bTA;
                            TiebaStatic.log(avVar.ab("fid", frsActivity9.getFid()).ab("obj_locate", "2"));
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            frsActivity2 = this.cjA.bTA;
            TiebaStatic.eventStat(frsActivity2.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            frsActivity3 = this.cjA.bTA;
            if (!frsActivity3.acs()) {
                frsActivity4 = this.cjA.bTA;
                if (frsActivity4.abZ() != null) {
                    av avVar2 = new av("c11752");
                    frsActivity5 = this.cjA.bTA;
                    TiebaStatic.log(avVar2.ab("fid", frsActivity5.getFid()).ab("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    frsActivity6 = this.cjA.bTA;
                    frsActivity6.abZ().kv();
                }
            }
        }
    }
}
