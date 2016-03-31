package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.blk = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.frs.c.l lVar;
        com.baidu.tieba.frs.c.l lVar2;
        ei eiVar;
        com.baidu.tieba.frs.c.l lVar3;
        ei eiVar2;
        com.baidu.tieba.frs.c.l lVar4;
        com.baidu.tieba.tbadkCore.o oVar;
        if (view != this.blk.bko.RK()) {
            if (view != this.blk.bko.RM()) {
                if (view == this.blk.bko.RL()) {
                    cs csVar = this.blk.bko;
                    eiVar = this.blk.bkr;
                    csVar.a(eiVar);
                    lVar3 = this.blk.bkE;
                    eiVar2 = this.blk.bkr;
                    lVar3.a(eiVar2);
                    TiebaStatic.log("c10529");
                    TiebaStatic.eventStat(this.blk.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                    this.blk.bko.RU();
                    FrsActivityStatic.blC = false;
                    lVar4 = this.blk.bkE;
                    lVar4.showMenu(true);
                } else if (view == this.blk.bko.RH()) {
                    this.blk.bko.RG();
                    lVar2 = this.blk.bkE;
                    lVar2.TV();
                    if (this.blk.Rd().Tg()) {
                        this.blk.Qn();
                        this.blk.Rd().Td();
                    }
                } else if (view != this.blk.bko.RI()) {
                    if (view == this.blk.bko.RJ()) {
                        this.blk.QT();
                        this.blk.bko.RG();
                    }
                } else {
                    TiebaStatic.eventStat(this.blk.getPageContext().getPageActivity(), "frs_good_threads", "frsclick", 1, new Object[0]);
                    this.blk.bko.RG();
                    lVar = this.blk.bkE;
                    lVar.TV();
                    if (!this.blk.Rd().Tg()) {
                        this.blk.Qn();
                        this.blk.Rd().gX(0);
                    }
                }
            } else {
                this.blk.closeActivity();
            }
        } else {
            TiebaStatic.eventStat(this.blk.getPageContext().getPageActivity(), "frs_post_thread", "frsclick", 1, new Object[0]);
            com.baidu.tbadk.core.sharedPref.b.vk().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frs_write_has_click", true);
            this.blk.bko.RD();
            this.blk.QQ();
        }
        if (view.getId() == t.g.refresh_layout) {
            TiebaStatic.eventStat(this.blk.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            if (!this.blk.bko.Ra()) {
                this.blk.bko.nk();
            } else {
                return;
            }
        }
        if (view.getId() == t.g.game_activity_egg_layout && com.baidu.adp.lib.util.k.jw()) {
            TiebaStatic.log("c10853");
            if (this.blk.bko.RY()) {
                this.blk.bko.RZ();
                return;
            }
            oVar = this.blk.bkq;
            String activityUrl = oVar.avu().getYuleData().uj().getActivityUrl();
            if (!StringUtils.isNull(activityUrl)) {
                com.baidu.tbadk.browser.f.t(this.blk.getPageContext().getPageActivity(), activityUrl);
            }
        }
    }
}
