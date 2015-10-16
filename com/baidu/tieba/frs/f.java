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
        if (view != bsVar.LL()) {
            bsVar2 = this.aUK.aTU;
            if (view != bsVar2.LM()) {
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
                    bsVar11.LV();
                    FrsActivityStatic.aVa = false;
                    kVar4 = this.aUK.aUl;
                    kVar4.showMenu(true);
                } else {
                    bsVar4 = this.aUK.aTU;
                    if (view == bsVar4.LI()) {
                        bsVar9 = this.aUK.aTU;
                        bsVar9.LH();
                        kVar2 = this.aUK.aUl;
                        kVar2.NM();
                        if (this.aUK.Lm().Nd()) {
                            this.aUK.stopVoice();
                            this.aUK.Lm().Na();
                        }
                    } else {
                        bsVar5 = this.aUK.aTU;
                        if (view != bsVar5.LJ()) {
                            bsVar6 = this.aUK.aTU;
                            if (view == bsVar6.LK()) {
                                this.aUK.Lb();
                                bsVar7 = this.aUK.aTU;
                                bsVar7.LH();
                            }
                        } else {
                            TiebaStatic.eventStat(this.aUK.getPageContext().getPageActivity(), "frs_good_threads", "frsclick", 1, new Object[0]);
                            bsVar8 = this.aUK.aTU;
                            bsVar8.LH();
                            kVar = this.aUK.aUl;
                            kVar.NM();
                            if (!this.aUK.Lm().Nd()) {
                                this.aUK.stopVoice();
                                this.aUK.Lm().fL(0);
                            }
                        }
                    }
                }
            } else {
                this.aUK.closeActivity();
            }
        } else {
            TiebaStatic.eventStat(this.aUK.getPageContext().getPageActivity(), "frs_post_thread", "frsclick", 1, new Object[0]);
            com.baidu.tbadk.core.sharedPref.b.tu().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frs_write_has_click", true);
            bsVar14 = this.aUK.aTU;
            bsVar14.LF();
            oVar = this.aUK.aTW;
            if (oVar != null) {
                oVar2 = this.aUK.aTW;
                if (oVar2.aeN() != null) {
                    oVar3 = this.aUK.aTW;
                    if (oVar3.aeN().getAnchorPower() != null) {
                        oVar4 = this.aUK.aTW;
                        if (oVar4.aeN().getAnchorPower().can_add_live_post.intValue() == 1) {
                            this.aUK.KX();
                        }
                    }
                }
            }
            this.aUK.KW();
        }
        if (view.getId() == i.f.refresh_layout) {
            TiebaStatic.eventStat(this.aUK.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            bsVar12 = this.aUK.aTU;
            if (!bsVar12.Li()) {
                bsVar13 = this.aUK.aTU;
                bsVar13.nw();
            }
        }
    }
}
