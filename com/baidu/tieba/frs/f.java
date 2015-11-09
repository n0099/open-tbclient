package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsActivity frsActivity) {
        this.aUS = frsActivity;
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
        com.baidu.tieba.frs.b.l lVar;
        bs bsVar9;
        com.baidu.tieba.frs.b.l lVar2;
        bs bsVar10;
        dg dgVar;
        com.baidu.tieba.frs.b.l lVar3;
        dg dgVar2;
        bs bsVar11;
        com.baidu.tieba.frs.b.l lVar4;
        bs bsVar12;
        bs bsVar13;
        bs bsVar14;
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.o oVar4;
        bsVar = this.aUS.aUc;
        if (view != bsVar.LX()) {
            bsVar2 = this.aUS.aUc;
            if (view != bsVar2.LY()) {
                bsVar3 = this.aUS.aUc;
                if (view == bsVar3.getMoreButton()) {
                    bsVar10 = this.aUS.aUc;
                    dgVar = this.aUS.aUf;
                    bsVar10.a(dgVar);
                    lVar3 = this.aUS.aUt;
                    dgVar2 = this.aUS.aUf;
                    lVar3.a(dgVar2);
                    TiebaStatic.eventStat(this.aUS.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                    bsVar11 = this.aUS.aUc;
                    bsVar11.Mh();
                    FrsActivityStatic.aVi = false;
                    lVar4 = this.aUS.aUt;
                    lVar4.showMenu(true);
                } else {
                    bsVar4 = this.aUS.aUc;
                    if (view == bsVar4.LU()) {
                        bsVar9 = this.aUS.aUc;
                        bsVar9.LT();
                        lVar2 = this.aUS.aUt;
                        lVar2.Oe();
                        if (this.aUS.Ly().Nr()) {
                            this.aUS.stopVoice();
                            this.aUS.Ly().No();
                        }
                    } else {
                        bsVar5 = this.aUS.aUc;
                        if (view != bsVar5.LV()) {
                            bsVar6 = this.aUS.aUc;
                            if (view == bsVar6.LW()) {
                                this.aUS.Ln();
                                bsVar7 = this.aUS.aUc;
                                bsVar7.LT();
                            }
                        } else {
                            TiebaStatic.eventStat(this.aUS.getPageContext().getPageActivity(), "frs_good_threads", "frsclick", 1, new Object[0]);
                            bsVar8 = this.aUS.aUc;
                            bsVar8.LT();
                            lVar = this.aUS.aUt;
                            lVar.Oe();
                            if (!this.aUS.Ly().Nr()) {
                                this.aUS.stopVoice();
                                this.aUS.Ly().fU(0);
                            }
                        }
                    }
                }
            } else {
                this.aUS.closeActivity();
            }
        } else {
            TiebaStatic.eventStat(this.aUS.getPageContext().getPageActivity(), "frs_post_thread", "frsclick", 1, new Object[0]);
            com.baidu.tbadk.core.sharedPref.b.tu().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frs_write_has_click", true);
            bsVar14 = this.aUS.aUc;
            bsVar14.LR();
            oVar = this.aUS.aUe;
            if (oVar != null) {
                oVar2 = this.aUS.aUe;
                if (oVar2.afg() != null) {
                    oVar3 = this.aUS.aUe;
                    if (oVar3.afg().getAnchorPower() != null) {
                        oVar4 = this.aUS.aUe;
                        if (oVar4.afg().getAnchorPower().can_add_live_post.intValue() == 1) {
                            this.aUS.Lj();
                        }
                    }
                }
            }
            this.aUS.Li();
        }
        if (view.getId() == i.f.refresh_layout) {
            TiebaStatic.eventStat(this.aUS.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            bsVar12 = this.aUS.aUc;
            if (!bsVar12.Lu()) {
                bsVar13 = this.aUS.aUc;
                bsVar13.nx();
            }
        }
    }
}
