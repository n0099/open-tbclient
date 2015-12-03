package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class g implements View.OnClickListener {
    final /* synthetic */ FrsActivity bag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.bag = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.frs.b.l lVar;
        com.baidu.tieba.frs.b.l lVar2;
        dw dwVar;
        com.baidu.tieba.frs.b.l lVar3;
        dw dwVar2;
        com.baidu.tieba.frs.b.l lVar4;
        com.baidu.tieba.tbadkCore.p pVar;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.tbadkCore.p pVar3;
        com.baidu.tieba.tbadkCore.p pVar4;
        if (view != this.bag.aZq.Ny()) {
            if (view != this.bag.aZq.Nz()) {
                if (view == this.bag.aZq.getMoreButton()) {
                    cd cdVar = this.bag.aZq;
                    dwVar = this.bag.aZt;
                    cdVar.a(dwVar);
                    lVar3 = this.bag.aZG;
                    dwVar2 = this.bag.aZt;
                    lVar3.a(dwVar2);
                    TiebaStatic.eventStat(this.bag.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                    this.bag.aZq.NI();
                    FrsActivityStatic.bay = false;
                    lVar4 = this.bag.aZG;
                    lVar4.showMenu(true);
                } else if (view == this.bag.aZq.Nv()) {
                    this.bag.aZq.Nu();
                    lVar2 = this.bag.aZG;
                    lVar2.PK();
                    if (this.bag.MX().OX()) {
                        this.bag.stopVoice();
                        this.bag.MX().OU();
                    }
                } else if (view != this.bag.aZq.Nw()) {
                    if (view == this.bag.aZq.Nx()) {
                        this.bag.MN();
                        this.bag.aZq.Nu();
                    }
                } else {
                    TiebaStatic.eventStat(this.bag.getPageContext().getPageActivity(), "frs_good_threads", "frsclick", 1, new Object[0]);
                    this.bag.aZq.Nu();
                    lVar = this.bag.aZG;
                    lVar.PK();
                    if (!this.bag.MX().OX()) {
                        this.bag.stopVoice();
                        this.bag.MX().gq(0);
                    }
                }
            } else {
                this.bag.closeActivity();
            }
        } else {
            TiebaStatic.eventStat(this.bag.getPageContext().getPageActivity(), "frs_post_thread", "frsclick", 1, new Object[0]);
            com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frs_write_has_click", true);
            this.bag.aZq.Ns();
            pVar = this.bag.aZs;
            if (pVar != null) {
                pVar2 = this.bag.aZs;
                if (pVar2.ajy() != null) {
                    pVar3 = this.bag.aZs;
                    if (pVar3.ajy().getAnchorPower() != null) {
                        pVar4 = this.bag.aZs;
                        if (pVar4.ajy().getAnchorPower().can_add_live_post.intValue() == 1 && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                            this.bag.MJ();
                        }
                    }
                }
            }
            this.bag.MI();
        }
        if (view.getId() == n.f.refresh_layout) {
            TiebaStatic.eventStat(this.bag.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            if (!this.bag.aZq.MU()) {
                this.bag.aZq.nD();
            }
        }
    }
}
