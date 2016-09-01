package com.baidu.tieba.frs.i;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EcommPersonManagerActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ h cfl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.cfl = hVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0191  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        FrsActivity frsActivity7;
        FrsActivity frsActivity8;
        FrsActivity frsActivity9;
        FrsActivity frsActivity10;
        FrsActivity frsActivity11;
        FrsActivity frsActivity12;
        FrsActivity frsActivity13;
        FrsActivity frsActivity14;
        FrsActivity frsActivity15;
        FrsActivity frsActivity16;
        boolean z;
        FrsActivity frsActivity17;
        FrsActivity frsActivity18;
        FrsActivity frsActivity19;
        FrsActivity frsActivity20;
        frsActivity = this.cfl.bRp;
        if (frsActivity != null) {
            if (view == this.cfl.ceT) {
                frsActivity16 = this.cfl.bRp;
                if (frsActivity16.aaR() != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    frsActivity18 = this.cfl.bRp;
                    if (frsActivity18.aaR().aLP() != null) {
                        frsActivity19 = this.cfl.bRp;
                        if (frsActivity19.aaR().aLP().getAnchorPower() != null) {
                            frsActivity20 = this.cfl.bRp;
                            if (frsActivity20.aaR().aLP().getAnchorPower().can_add_live_post.intValue() != 2) {
                                z = true;
                                boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
                                boolean GE = com.baidu.tbadk.plugins.g.GE();
                                frsActivity17 = this.cfl.bRp;
                                boolean z2 = frsActivity17.aaR().getUserData().canPostHi() ? GE : false;
                                boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteVoteActivityConfig.class);
                                boolean appResponseToIntentClass2 = TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
                                if (!this.cfl.ceR.ga(1)) {
                                    this.cfl.b(z, showXiaoyingTool, z2, appResponseToIntentClass, appResponseToIntentClass2);
                                    this.cfl.ceR.Nb();
                                    return;
                                } else if (this.cfl.ceR.ga(3)) {
                                    this.cfl.ceR.Nc();
                                    return;
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                }
                z = false;
                boolean showXiaoyingTool2 = XiaoyingUtil.showXiaoyingTool();
                boolean GE2 = com.baidu.tbadk.plugins.g.GE();
                frsActivity17 = this.cfl.bRp;
                if (frsActivity17.aaR().getUserData().canPostHi()) {
                }
                boolean appResponseToIntentClass3 = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteVoteActivityConfig.class);
                boolean appResponseToIntentClass22 = TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
                if (!this.cfl.ceR.ga(1)) {
                }
            } else if (view == this.cfl.ceU) {
                frsActivity13 = this.cfl.bRp;
                com.baidu.tieba.tbadkCore.p aaR = frsActivity13.aaR();
                frsActivity14 = this.cfl.bRp;
                TbPageContext pageContext = frsActivity14.getPageContext();
                frsActivity15 = this.cfl.bRp;
                com.baidu.tieba.frs.utils.b.b(aaR, pageContext, frsActivity15.aaV());
            } else if (view == this.cfl.ceV) {
                frsActivity10 = this.cfl.bRp;
                com.baidu.tieba.tbadkCore.p aaR2 = frsActivity10.aaR();
                frsActivity11 = this.cfl.bRp;
                TbPageContext pageContext2 = frsActivity11.getPageContext();
                frsActivity12 = this.cfl.bRp;
                com.baidu.tieba.frs.utils.b.a(aaR2, pageContext2, frsActivity12.aaV());
            } else if (view == this.cfl.ceW) {
                frsActivity8 = this.cfl.bRp;
                com.baidu.tieba.tbadkCore.p aaR3 = frsActivity8.aaR();
                frsActivity9 = this.cfl.bRp;
                com.baidu.tieba.frs.utils.b.b(aaR3, frsActivity9.getPageContext());
            } else if (view == this.cfl.ceX) {
                frsActivity6 = this.cfl.bRp;
                com.baidu.tieba.tbadkCore.p aaR4 = frsActivity6.aaR();
                frsActivity7 = this.cfl.bRp;
                com.baidu.tieba.frs.utils.b.a(aaR4, frsActivity7.getPageContext());
            } else if (view == this.cfl.ceY) {
                frsActivity3 = this.cfl.bRp;
                com.baidu.tieba.tbadkCore.p aaR5 = frsActivity3.aaR();
                frsActivity4 = this.cfl.bRp;
                TbPageContext pageContext3 = frsActivity4.getPageContext();
                frsActivity5 = this.cfl.bRp;
                com.baidu.tieba.frs.utils.b.c(aaR5, pageContext3, frsActivity5.aaV());
            } else if (view == this.cfl.ceZ) {
                frsActivity2 = this.cfl.bRp;
                com.baidu.tieba.frs.utils.b.M(frsActivity2);
            }
        }
    }
}
