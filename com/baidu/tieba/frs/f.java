package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsActivity frsActivity) {
        this.aUz = frsActivity;
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
        bsVar = this.aUz.aTJ;
        if (view != bsVar.LL()) {
            bsVar2 = this.aUz.aTJ;
            if (view != bsVar2.LM()) {
                bsVar3 = this.aUz.aTJ;
                if (view == bsVar3.getMoreButton()) {
                    bsVar10 = this.aUz.aTJ;
                    dgVar = this.aUz.aTM;
                    bsVar10.a(dgVar);
                    kVar3 = this.aUz.aUa;
                    dgVar2 = this.aUz.aTM;
                    kVar3.a(dgVar2);
                    TiebaStatic.eventStat(this.aUz.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                    bsVar11 = this.aUz.aTJ;
                    bsVar11.LV();
                    FrsActivityStatic.aUP = false;
                    kVar4 = this.aUz.aUa;
                    kVar4.showMenu(true);
                } else {
                    bsVar4 = this.aUz.aTJ;
                    if (view == bsVar4.LI()) {
                        bsVar9 = this.aUz.aTJ;
                        bsVar9.LH();
                        kVar2 = this.aUz.aUa;
                        kVar2.NM();
                        if (this.aUz.Lm().Nd()) {
                            this.aUz.stopVoice();
                            this.aUz.Lm().Na();
                        }
                    } else {
                        bsVar5 = this.aUz.aTJ;
                        if (view != bsVar5.LJ()) {
                            bsVar6 = this.aUz.aTJ;
                            if (view == bsVar6.LK()) {
                                this.aUz.Lb();
                                bsVar7 = this.aUz.aTJ;
                                bsVar7.LH();
                            }
                        } else {
                            TiebaStatic.eventStat(this.aUz.getPageContext().getPageActivity(), "frs_good_threads", "frsclick", 1, new Object[0]);
                            bsVar8 = this.aUz.aTJ;
                            bsVar8.LH();
                            kVar = this.aUz.aUa;
                            kVar.NM();
                            if (!this.aUz.Lm().Nd()) {
                                this.aUz.stopVoice();
                                this.aUz.Lm().fL(0);
                            }
                        }
                    }
                }
            } else {
                this.aUz.closeActivity();
            }
        } else {
            TiebaStatic.eventStat(this.aUz.getPageContext().getPageActivity(), "frs_post_thread", "frsclick", 1, new Object[0]);
            com.baidu.tbadk.core.sharedPref.b.tu().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frs_write_has_click", true);
            bsVar14 = this.aUz.aTJ;
            bsVar14.LF();
            oVar = this.aUz.aTL;
            if (oVar != null) {
                oVar2 = this.aUz.aTL;
                if (oVar2.aeN() != null) {
                    oVar3 = this.aUz.aTL;
                    if (oVar3.aeN().getAnchorPower() != null) {
                        oVar4 = this.aUz.aTL;
                        if (oVar4.aeN().getAnchorPower().can_add_live_post.intValue() == 1) {
                            this.aUz.KX();
                        }
                    }
                }
            }
            this.aUz.KW();
        }
        if (view.getId() == i.f.refresh_layout) {
            TiebaStatic.eventStat(this.aUz.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            bsVar12 = this.aUz.aTJ;
            if (!bsVar12.Li()) {
                bsVar13 = this.aUz.aTJ;
                bsVar13.nw();
            }
        }
    }
}
