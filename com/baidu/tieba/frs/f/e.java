package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.entelechy.view.EntelechyPullUpRefreshView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d bVd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.bVd = dVar;
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
        frsActivity = this.bVd.bHh;
        if (frsActivity != null) {
            entelechyPullUpRefreshView = this.bVd.bUY;
            if (view != entelechyPullUpRefreshView) {
                entelechyPullUpRefreshView2 = this.bVd.bUZ;
                if (view != entelechyPullUpRefreshView2) {
                    entelechyPullUpRefreshView3 = this.bVd.bVa;
                    if (view == entelechyPullUpRefreshView3) {
                        frsActivity7 = this.bVd.bHh;
                        if (frsActivity7.Xr() != null) {
                            frsActivity8 = this.bVd.bHh;
                            frsActivity8.Xr().adt();
                            com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c11752");
                            frsActivity9 = this.bVd.bHh;
                            TiebaStatic.log(arVar.ab("fid", frsActivity9.getFid()).ab("obj_locate", "2"));
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            frsActivity2 = this.bVd.bHh;
            TiebaStatic.eventStat(frsActivity2.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            frsActivity3 = this.bVd.bHh;
            if (!frsActivity3.XX()) {
                frsActivity4 = this.bVd.bHh;
                if (frsActivity4.XF() != null) {
                    com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar("c11752");
                    frsActivity5 = this.bVd.bHh;
                    TiebaStatic.log(arVar2.ab("fid", frsActivity5.getFid()).ab("obj_locate", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
                    frsActivity6 = this.bVd.bHh;
                    frsActivity6.XF().startPullRefresh();
                }
            }
        }
    }
}
