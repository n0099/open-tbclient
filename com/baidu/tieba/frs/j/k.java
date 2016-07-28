package com.baidu.tieba.frs.j;

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
    final /* synthetic */ h bUd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.bUd = hVar;
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
        frsActivity = this.bUd.bGh;
        if (frsActivity != null) {
            if (view == this.bUd.bTL) {
                frsActivity16 = this.bUd.bGh;
                if (frsActivity16.VU() != null && TbadkCoreApplication.m10getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    frsActivity18 = this.bUd.bGh;
                    if (frsActivity18.VU().aGX() != null) {
                        frsActivity19 = this.bUd.bGh;
                        if (frsActivity19.VU().aGX().getAnchorPower() != null) {
                            frsActivity20 = this.bUd.bGh;
                            if (frsActivity20.VU().aGX().getAnchorPower().can_add_live_post.intValue() != 2) {
                                z = true;
                                boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
                                boolean Fk = com.baidu.tbadk.plugins.g.Fk();
                                frsActivity17 = this.bUd.bGh;
                                boolean z2 = frsActivity17.VU().getUserData().canPostHi() ? Fk : false;
                                boolean appResponseToIntentClass = TbadkCoreApplication.m10getInst().appResponseToIntentClass(WriteVoteActivityConfig.class);
                                boolean appResponseToIntentClass2 = TbadkCoreApplication.m10getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
                                if (!this.bUd.bTJ.fC(1)) {
                                    this.bUd.b(z, showXiaoyingTool, z2, appResponseToIntentClass, appResponseToIntentClass2);
                                    this.bUd.bTJ.Kz();
                                    return;
                                } else if (this.bUd.bTJ.fC(3)) {
                                    this.bUd.bTJ.KA();
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
                boolean Fk2 = com.baidu.tbadk.plugins.g.Fk();
                frsActivity17 = this.bUd.bGh;
                if (frsActivity17.VU().getUserData().canPostHi()) {
                }
                boolean appResponseToIntentClass3 = TbadkCoreApplication.m10getInst().appResponseToIntentClass(WriteVoteActivityConfig.class);
                boolean appResponseToIntentClass22 = TbadkCoreApplication.m10getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
                if (!this.bUd.bTJ.fC(1)) {
                }
            } else if (view == this.bUd.bTM) {
                frsActivity13 = this.bUd.bGh;
                com.baidu.tieba.tbadkCore.p VU = frsActivity13.VU();
                frsActivity14 = this.bUd.bGh;
                TbPageContext pageContext = frsActivity14.getPageContext();
                frsActivity15 = this.bUd.bGh;
                com.baidu.tieba.frs.utils.b.b(VU, pageContext, frsActivity15.VY());
            } else if (view == this.bUd.bTN) {
                frsActivity10 = this.bUd.bGh;
                com.baidu.tieba.tbadkCore.p VU2 = frsActivity10.VU();
                frsActivity11 = this.bUd.bGh;
                TbPageContext pageContext2 = frsActivity11.getPageContext();
                frsActivity12 = this.bUd.bGh;
                com.baidu.tieba.frs.utils.b.a(VU2, pageContext2, frsActivity12.VY());
            } else if (view == this.bUd.bTO) {
                frsActivity8 = this.bUd.bGh;
                com.baidu.tieba.tbadkCore.p VU3 = frsActivity8.VU();
                frsActivity9 = this.bUd.bGh;
                com.baidu.tieba.frs.utils.b.b(VU3, frsActivity9.getPageContext());
            } else if (view == this.bUd.bTP) {
                frsActivity6 = this.bUd.bGh;
                com.baidu.tieba.tbadkCore.p VU4 = frsActivity6.VU();
                frsActivity7 = this.bUd.bGh;
                com.baidu.tieba.frs.utils.b.a(VU4, frsActivity7.getPageContext());
            } else if (view == this.bUd.bTQ) {
                frsActivity3 = this.bUd.bGh;
                com.baidu.tieba.tbadkCore.p VU5 = frsActivity3.VU();
                frsActivity4 = this.bUd.bGh;
                TbPageContext pageContext3 = frsActivity4.getPageContext();
                frsActivity5 = this.bUd.bGh;
                com.baidu.tieba.frs.utils.b.c(VU5, pageContext3, frsActivity5.VY());
            } else if (view == this.bUd.bTR) {
                frsActivity2 = this.bUd.bGh;
                com.baidu.tieba.frs.utils.b.P(frsActivity2);
            }
        }
    }
}
