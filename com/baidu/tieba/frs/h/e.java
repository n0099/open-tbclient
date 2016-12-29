package com.baidu.tieba.frs.h;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d bOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.bOG = dVar;
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
        frsActivity = this.bOG.bzH;
        if (frsActivity != null) {
            entelechyPullUpRefreshView = this.bOG.bOB;
            if (view != entelechyPullUpRefreshView) {
                entelechyPullUpRefreshView2 = this.bOG.bOC;
                if (view != entelechyPullUpRefreshView2) {
                    entelechyPullUpRefreshView3 = this.bOG.bOD;
                    if (view == entelechyPullUpRefreshView3) {
                        frsActivity7 = this.bOG.bzH;
                        if (frsActivity7.Wa() != null) {
                            frsActivity8 = this.bOG.bzH;
                            frsActivity8.Wa().ack();
                            at atVar = new at("c11752");
                            frsActivity9 = this.bOG.bzH;
                            TiebaStatic.log(atVar.ab("fid", frsActivity9.getFid()).ab("obj_locate", "2"));
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            frsActivity2 = this.bOG.bzH;
            TiebaStatic.eventStat(frsActivity2.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            frsActivity3 = this.bOG.bzH;
            if (!frsActivity3.WG()) {
                frsActivity4 = this.bOG.bzH;
                if (frsActivity4.Wo() != null) {
                    at atVar2 = new at("c11752");
                    frsActivity5 = this.bOG.bzH;
                    TiebaStatic.log(atVar2.ab("fid", frsActivity5.getFid()).ab("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    frsActivity6 = this.bOG.bzH;
                    frsActivity6.Wo().kv();
                }
            }
        }
    }
}
