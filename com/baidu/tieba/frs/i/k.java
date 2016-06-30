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
    final /* synthetic */ h bSd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.bSd = hVar;
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
        frsActivity = this.bSd.bET;
        if (frsActivity != null) {
            if (view == this.bSd.bRL) {
                frsActivity16 = this.bSd.bET;
                if (frsActivity16.VC() != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    frsActivity18 = this.bSd.bET;
                    if (frsActivity18.VC().aDN() != null) {
                        frsActivity19 = this.bSd.bET;
                        if (frsActivity19.VC().aDN().getAnchorPower() != null) {
                            frsActivity20 = this.bSd.bET;
                            if (frsActivity20.VC().aDN().getAnchorPower().can_add_live_post.intValue() != 2) {
                                z = true;
                                boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
                                boolean Fj = com.baidu.tbadk.plugins.d.Fj();
                                frsActivity17 = this.bSd.bET;
                                boolean z2 = frsActivity17.VC().getUserData().canPostHi() ? Fj : false;
                                boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteVoteActivityConfig.class);
                                boolean appResponseToIntentClass2 = TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
                                if (!this.bSd.bRJ.fD(1)) {
                                    this.bSd.b(z, showXiaoyingTool, z2, appResponseToIntentClass, appResponseToIntentClass2);
                                    this.bSd.bRJ.KA();
                                    return;
                                } else if (this.bSd.bRJ.fD(3)) {
                                    this.bSd.bRJ.KB();
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
                boolean Fj2 = com.baidu.tbadk.plugins.d.Fj();
                frsActivity17 = this.bSd.bET;
                if (frsActivity17.VC().getUserData().canPostHi()) {
                }
                boolean appResponseToIntentClass3 = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteVoteActivityConfig.class);
                boolean appResponseToIntentClass22 = TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
                if (!this.bSd.bRJ.fD(1)) {
                }
            } else if (view == this.bSd.bRM) {
                frsActivity13 = this.bSd.bET;
                com.baidu.tieba.tbadkCore.p VC = frsActivity13.VC();
                frsActivity14 = this.bSd.bET;
                TbPageContext pageContext = frsActivity14.getPageContext();
                frsActivity15 = this.bSd.bET;
                com.baidu.tieba.frs.utils.b.b(VC, pageContext, frsActivity15.VG());
            } else if (view == this.bSd.bRN) {
                frsActivity10 = this.bSd.bET;
                com.baidu.tieba.tbadkCore.p VC2 = frsActivity10.VC();
                frsActivity11 = this.bSd.bET;
                TbPageContext pageContext2 = frsActivity11.getPageContext();
                frsActivity12 = this.bSd.bET;
                com.baidu.tieba.frs.utils.b.a(VC2, pageContext2, frsActivity12.VG());
            } else if (view == this.bSd.bRO) {
                frsActivity8 = this.bSd.bET;
                com.baidu.tieba.tbadkCore.p VC3 = frsActivity8.VC();
                frsActivity9 = this.bSd.bET;
                com.baidu.tieba.frs.utils.b.b(VC3, frsActivity9.getPageContext());
            } else if (view == this.bSd.bRP) {
                frsActivity6 = this.bSd.bET;
                com.baidu.tieba.tbadkCore.p VC4 = frsActivity6.VC();
                frsActivity7 = this.bSd.bET;
                com.baidu.tieba.frs.utils.b.a(VC4, frsActivity7.getPageContext());
            } else if (view == this.bSd.bRQ) {
                frsActivity3 = this.bSd.bET;
                com.baidu.tieba.tbadkCore.p VC5 = frsActivity3.VC();
                frsActivity4 = this.bSd.bET;
                TbPageContext pageContext3 = frsActivity4.getPageContext();
                frsActivity5 = this.bSd.bET;
                com.baidu.tieba.frs.utils.b.c(VC5, pageContext3, frsActivity5.VG());
            } else if (view == this.bSd.bRR) {
                frsActivity2 = this.bSd.bET;
                com.baidu.tieba.frs.utils.b.P(frsActivity2);
            }
        }
    }
}
