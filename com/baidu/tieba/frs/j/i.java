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
public class i implements View.OnClickListener {
    final /* synthetic */ f cjT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.cjT = fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009a  */
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
        boolean z;
        FrsActivity frsActivity14;
        FrsActivity frsActivity15;
        FrsActivity frsActivity16;
        frsActivity = this.cjT.bTA;
        if (frsActivity != null) {
            if (view == this.cjT.cjD) {
                frsActivity13 = this.cjT.bTA;
                if (frsActivity13.acr() != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    frsActivity14 = this.cjT.bTA;
                    if (frsActivity14.acr().aOk() != null) {
                        frsActivity15 = this.cjT.bTA;
                        if (frsActivity15.acr().aOk().getAnchorPower() != null) {
                            frsActivity16 = this.cjT.bTA;
                            if (frsActivity16.acr().aOk().getAnchorPower().can_add_live_post.intValue() != 2) {
                                z = true;
                                boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
                                boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteVoteActivityConfig.class);
                                boolean appResponseToIntentClass2 = TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
                                if (!this.cjT.cjB.gf(1)) {
                                    this.cjT.a(z, showXiaoyingTool, appResponseToIntentClass, appResponseToIntentClass2);
                                    this.cjT.cjB.OF();
                                    return;
                                } else if (this.cjT.cjB.gf(3)) {
                                    this.cjT.cjB.OG();
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
                boolean appResponseToIntentClass3 = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteVoteActivityConfig.class);
                boolean appResponseToIntentClass22 = TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
                if (!this.cjT.cjB.gf(1)) {
                }
            } else if (view == this.cjT.cjE) {
                frsActivity10 = this.cjT.bTA;
                com.baidu.tieba.tbadkCore.p acr = frsActivity10.acr();
                frsActivity11 = this.cjT.bTA;
                TbPageContext pageContext = frsActivity11.getPageContext();
                frsActivity12 = this.cjT.bTA;
                com.baidu.tieba.frs.utils.w.b(acr, pageContext, frsActivity12.abS());
            } else if (view == this.cjT.cjF) {
                frsActivity7 = this.cjT.bTA;
                com.baidu.tieba.tbadkCore.p acr2 = frsActivity7.acr();
                frsActivity8 = this.cjT.bTA;
                TbPageContext pageContext2 = frsActivity8.getPageContext();
                frsActivity9 = this.cjT.bTA;
                com.baidu.tieba.frs.utils.w.a(acr2, pageContext2, frsActivity9.abS());
            } else if (view == this.cjT.cjG) {
                frsActivity5 = this.cjT.bTA;
                com.baidu.tieba.tbadkCore.p acr3 = frsActivity5.acr();
                frsActivity6 = this.cjT.bTA;
                com.baidu.tieba.frs.utils.w.b(acr3, frsActivity6.getPageContext());
            } else if (view == this.cjT.cjH) {
                frsActivity3 = this.cjT.bTA;
                com.baidu.tieba.tbadkCore.p acr4 = frsActivity3.acr();
                frsActivity4 = this.cjT.bTA;
                com.baidu.tieba.frs.utils.w.a(acr4, frsActivity4.getPageContext());
            } else if (view == this.cjT.cjI) {
                frsActivity2 = this.cjT.bTA;
                com.baidu.tieba.frs.utils.w.G(frsActivity2);
            }
        }
    }
}
