package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ FrsActivity aUK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsActivity frsActivity) {
        this.aUK = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        bs bsVar4;
        bs bsVar5;
        bs bsVar6;
        bs bsVar7;
        bs bsVar8;
        com.baidu.tieba.frs.b.k kVar;
        bs bsVar9;
        com.baidu.tieba.frs.b.k kVar2;
        bs bsVar10;
        dg dgVar;
        com.baidu.tieba.frs.b.k kVar3;
        dg dgVar2;
        bs bsVar11;
        com.baidu.tieba.frs.b.k kVar4;
        bs bsVar12;
        bs bsVar13;
        bs bsVar14;
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.o oVar4;
        bsVar = this.aUK.aTU;
        if (view != bsVar.LH()) {
            bsVar2 = this.aUK.aTU;
            if (view != bsVar2.LI()) {
                bsVar3 = this.aUK.aTU;
                if (view == bsVar3.getMoreButton()) {
                    bsVar10 = this.aUK.aTU;
                    dgVar = this.aUK.aTX;
                    bsVar10.a(dgVar);
                    kVar3 = this.aUK.aUl;
                    dgVar2 = this.aUK.aTX;
                    kVar3.a(dgVar2);
                    TiebaStatic.eventStat(this.aUK.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                    bsVar11 = this.aUK.aTU;
                    bsVar11.LR();
                    FrsActivityStatic.aVa = false;
                    kVar4 = this.aUK.aUl;
                    kVar4.showMenu(true);
                } else {
                    bsVar4 = this.aUK.aTU;
                    if (view == bsVar4.LE()) {
                        bsVar9 = this.aUK.aTU;
                        bsVar9.LD();
                        kVar2 = this.aUK.aUl;
                        kVar2.NI();
                        if (this.aUK.Li().MZ()) {
                            this.aUK.stopVoice();
                            this.aUK.Li().MW();
                        }
                    } else {
                        bsVar5 = this.aUK.aTU;
                        if (view != bsVar5.LF()) {
                            bsVar6 = this.aUK.aTU;
                            if (view == bsVar6.LG()) {
                                this.aUK.KX();
                                bsVar7 = this.aUK.aTU;
                                bsVar7.LD();
                            }
                        } else {
                            TiebaStatic.eventStat(this.aUK.getPageContext().getPageActivity(), "frs_good_threads", "frsclick", 1, new Object[0]);
                            bsVar8 = this.aUK.aTU;
                            bsVar8.LD();
                            kVar = this.aUK.aUl;
                            kVar.NI();
                            if (!this.aUK.Li().MZ()) {
                                this.aUK.stopVoice();
                                this.aUK.Li().fL(0);
                            }
                        }
                    }
                }
            } else {
                this.aUK.closeActivity();
            }
        } else {
            TiebaStatic.eventStat(this.aUK.getPageContext().getPageActivity(), "frs_post_thread", "frsclick", 1, new Object[0]);
            com.baidu.tbadk.core.sharedPref.b.tr().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frs_write_has_click", true);
            bsVar14 = this.aUK.aTU;
            bsVar14.LB();
            oVar = this.aUK.aTW;
            if (oVar != null) {
                oVar2 = this.aUK.aTW;
                if (oVar2.aeJ() != null) {
                    oVar3 = this.aUK.aTW;
                    if (oVar3.aeJ().getAnchorPower() != null) {
                        oVar4 = this.aUK.aTW;
                        if (oVar4.aeJ().getAnchorPower().can_add_live_post.intValue() == 1) {
                            this.aUK.KT();
                        }
                    }
                }
            }
            this.aUK.KS();
        }
        if (view.getId() == i.f.refresh_layout) {
            TiebaStatic.eventStat(this.aUK.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            bsVar12 = this.aUK.aTU;
            if (!bsVar12.Le()) {
                bsVar13 = this.aUK.aTU;
                bsVar13.nw();
            }
        }
    }
}
