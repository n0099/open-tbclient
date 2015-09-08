package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ FrsActivity aVz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsActivity frsActivity) {
        this.aVz = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        bi biVar5;
        bi biVar6;
        bi biVar7;
        bi biVar8;
        com.baidu.tieba.frs.c.k kVar;
        bi biVar9;
        com.baidu.tieba.frs.c.k kVar2;
        bi biVar10;
        cr crVar;
        com.baidu.tieba.frs.c.k kVar3;
        cr crVar2;
        bi biVar11;
        com.baidu.tieba.frs.c.k kVar4;
        bi biVar12;
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.o oVar4;
        biVar = this.aVz.aUL;
        if (view != biVar.LM()) {
            biVar2 = this.aVz.aUL;
            if (view != biVar2.LN()) {
                biVar3 = this.aVz.aUL;
                if (view == biVar3.getMoreButton()) {
                    biVar10 = this.aVz.aUL;
                    crVar = this.aVz.aUO;
                    biVar10.a(crVar);
                    kVar3 = this.aVz.aVc;
                    crVar2 = this.aVz.aUO;
                    kVar3.a(crVar2);
                    TiebaStatic.eventStat(this.aVz.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                    biVar11 = this.aVz.aUL;
                    biVar11.LW();
                    FrsActivityStatic.aVH = false;
                    kVar4 = this.aVz.aVc;
                    kVar4.showMenu(true);
                } else {
                    biVar4 = this.aVz.aUL;
                    if (view == biVar4.LJ()) {
                        biVar9 = this.aVz.aUL;
                        biVar9.LI();
                        kVar2 = this.aVz.aVc;
                        kVar2.NM();
                        if (this.aVz.Lq().Ne()) {
                            this.aVz.stopVoice();
                            this.aVz.Lq().Nb();
                        }
                    } else {
                        biVar5 = this.aVz.aUL;
                        if (view != biVar5.LK()) {
                            biVar6 = this.aVz.aUL;
                            if (view == biVar6.LL()) {
                                this.aVz.Lf();
                                biVar7 = this.aVz.aUL;
                                biVar7.LI();
                            }
                        } else {
                            TiebaStatic.eventStat(this.aVz.getPageContext().getPageActivity(), "frs_good_threads", "frsclick", 1, new Object[0]);
                            biVar8 = this.aVz.aUL;
                            biVar8.LI();
                            kVar = this.aVz.aVc;
                            kVar.NM();
                            if (!this.aVz.Lq().Ne()) {
                                this.aVz.stopVoice();
                                this.aVz.Lq().fG(0);
                            }
                        }
                    }
                }
            } else {
                this.aVz.closeActivity();
            }
        } else {
            TiebaStatic.eventStat(this.aVz.getPageContext().getPageActivity(), "frs_post_thread", "frsclick", 1, new Object[0]);
            oVar = this.aVz.aUN;
            if (oVar != null) {
                oVar2 = this.aVz.aUN;
                if (oVar2.acP() != null) {
                    oVar3 = this.aVz.aUN;
                    if (oVar3.acP().getAnchorPower() != null) {
                        oVar4 = this.aVz.aUN;
                        if (oVar4.acP().getAnchorPower().can_add_live_post.intValue() == 1) {
                            this.aVz.Lc();
                        }
                    }
                }
            }
            this.aVz.fl(0);
        }
        if (view.getId() == i.f.refresh_layout) {
            TiebaStatic.eventStat(this.aVz.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            biVar12 = this.aVz.aUL;
            biVar12.nv();
        }
    }
}
