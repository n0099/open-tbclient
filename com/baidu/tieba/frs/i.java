package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.bgz = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.frs.c.l lVar;
        com.baidu.tieba.frs.c.l lVar2;
        eb ebVar;
        com.baidu.tieba.frs.c.l lVar3;
        eb ebVar2;
        com.baidu.tieba.frs.c.l lVar4;
        com.baidu.tieba.tbadkCore.o oVar;
        if (view != this.bgz.bfD.PR()) {
            if (view != this.bgz.bfD.PT()) {
                if (view == this.bgz.bfD.PS()) {
                    cn cnVar = this.bgz.bfD;
                    ebVar = this.bgz.bfG;
                    cnVar.a(ebVar);
                    lVar3 = this.bgz.bfT;
                    ebVar2 = this.bgz.bfG;
                    lVar3.a(ebVar2);
                    TiebaStatic.log("c10529");
                    TiebaStatic.eventStat(this.bgz.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                    this.bgz.bfD.Qb();
                    FrsActivityStatic.bgR = false;
                    lVar4 = this.bgz.bfT;
                    lVar4.showMenu(true);
                } else if (view == this.bgz.bfD.PO()) {
                    this.bgz.bfD.PN();
                    lVar2 = this.bgz.bfT;
                    lVar2.Sg();
                    if (this.bgz.Po().Rt()) {
                        this.bgz.Oy();
                        this.bgz.Po().Rq();
                    }
                } else if (view != this.bgz.bfD.PP()) {
                    if (view == this.bgz.bfD.PQ()) {
                        this.bgz.Pe();
                        this.bgz.bfD.PN();
                    }
                } else {
                    TiebaStatic.eventStat(this.bgz.getPageContext().getPageActivity(), "frs_good_threads", "frsclick", 1, new Object[0]);
                    this.bgz.bfD.PN();
                    lVar = this.bgz.bfT;
                    lVar.Sg();
                    if (!this.bgz.Po().Rt()) {
                        this.bgz.Oy();
                        this.bgz.Po().gG(0);
                    }
                }
            } else {
                this.bgz.closeActivity();
            }
        } else {
            TiebaStatic.eventStat(this.bgz.getPageContext().getPageActivity(), "frs_post_thread", "frsclick", 1, new Object[0]);
            com.baidu.tbadk.core.sharedPref.b.uO().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frs_write_has_click", true);
            this.bgz.bfD.PK();
            this.bgz.Pb();
        }
        if (view.getId() == t.g.refresh_layout) {
            TiebaStatic.eventStat(this.bgz.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            if (!this.bgz.bfD.Pl()) {
                this.bgz.bfD.ns();
            } else {
                return;
            }
        }
        if (view.getId() == t.g.game_activity_egg_layout && com.baidu.adp.lib.util.k.jq()) {
            TiebaStatic.log("c10853");
            if (this.bgz.bfD.Qf()) {
                this.bgz.bfD.Qg();
                return;
            }
            oVar = this.bgz.bfF;
            String activityUrl = oVar.aoE().getYuleData().ud().getActivityUrl();
            if (!StringUtils.isNull(activityUrl)) {
                com.baidu.tbadk.browser.f.C(this.bgz.getPageContext().getPageActivity(), activityUrl);
            }
        }
    }
}
