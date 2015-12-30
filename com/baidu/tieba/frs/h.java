package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.bed = frsActivity;
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
        if (view != this.bed.bdm.NR()) {
            if (view != this.bed.bdm.NS()) {
                if (view == this.bed.bdm.getMoreButton()) {
                    cg cgVar = this.bed.bdm;
                    dwVar = this.bed.bdp;
                    cgVar.a(dwVar);
                    lVar3 = this.bed.bdC;
                    dwVar2 = this.bed.bdp;
                    lVar3.a(dwVar2);
                    TiebaStatic.log("c10529");
                    TiebaStatic.eventStat(this.bed.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                    this.bed.bdm.Ob();
                    FrsActivityStatic.bex = false;
                    lVar4 = this.bed.bdC;
                    lVar4.showMenu(true);
                } else if (view == this.bed.bdm.NO()) {
                    this.bed.bdm.NN();
                    lVar2 = this.bed.bdC;
                    lVar2.Qc();
                    if (this.bed.Nr().Pp()) {
                        this.bed.stopVoice();
                        this.bed.Nr().Pm();
                    }
                } else if (view != this.bed.bdm.NP()) {
                    if (view == this.bed.bdm.NQ()) {
                        this.bed.Nh();
                        this.bed.bdm.NN();
                    }
                } else {
                    TiebaStatic.eventStat(this.bed.getPageContext().getPageActivity(), "frs_good_threads", "frsclick", 1, new Object[0]);
                    this.bed.bdm.NN();
                    lVar = this.bed.bdC;
                    lVar.Qc();
                    if (!this.bed.Nr().Pp()) {
                        this.bed.stopVoice();
                        this.bed.Nr().gj(0);
                    }
                }
            } else {
                this.bed.closeActivity();
            }
        } else {
            TiebaStatic.eventStat(this.bed.getPageContext().getPageActivity(), "frs_post_thread", "frsclick", 1, new Object[0]);
            com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frs_write_has_click", true);
            this.bed.bdm.NL();
            pVar = this.bed.bdo;
            if (pVar != null && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                pVar2 = this.bed.bdo;
                if (pVar2.akG() != null) {
                    pVar3 = this.bed.bdo;
                    if (pVar3.akG().getAnchorPower() != null) {
                        pVar4 = this.bed.bdo;
                        if (pVar4.akG().getAnchorPower().can_add_live_post.intValue() != 2) {
                            this.bed.Nc();
                        }
                    }
                }
            }
            this.bed.Nb();
        }
        if (view.getId() == n.g.refresh_layout) {
            TiebaStatic.eventStat(this.bed.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            if (!this.bed.bdm.No()) {
                this.bed.bdm.nb();
            }
        }
    }
}
