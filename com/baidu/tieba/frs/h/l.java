package com.baidu.tieba.frs.h;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ i bPb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.bPb = iVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
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
        boolean z;
        FrsActivity frsActivity13;
        FrsActivity frsActivity14;
        FrsActivity frsActivity15;
        frsActivity = this.bPb.bzH;
        if (frsActivity != null && !this.bPb.abM()) {
            if (view == this.bPb.bON) {
                frsActivity12 = this.bPb.bzH;
                if (frsActivity12.WF() != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    frsActivity13 = this.bPb.bzH;
                    if (frsActivity13.WF().aIk() != null) {
                        frsActivity14 = this.bPb.bzH;
                        if (frsActivity14.WF().aIk().getAnchorPower() != null) {
                            frsActivity15 = this.bPb.bzH;
                            if (frsActivity15.WF().aIk().getAnchorPower().can_add_live_post.intValue() != 2) {
                                z = true;
                                boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
                                boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteVoteActivityConfig.class);
                                if (!this.bPb.bOL.ge(1)) {
                                    this.bPb.d(z, showXiaoyingTool, appResponseToIntentClass);
                                    this.bPb.bOL.NR();
                                    return;
                                } else if (this.bPb.bOL.ge(3)) {
                                    this.bPb.bOL.NS();
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
                boolean appResponseToIntentClass2 = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteVoteActivityConfig.class);
                if (!this.bPb.bOL.ge(1)) {
                }
            } else if (view == this.bPb.bOO) {
                frsActivity9 = this.bPb.bzH;
                com.baidu.tieba.tbadkCore.o WF = frsActivity9.WF();
                frsActivity10 = this.bPb.bzH;
                TbPageContext pageContext = frsActivity10.getPageContext();
                frsActivity11 = this.bPb.bzH;
                com.baidu.tieba.frs.utils.u.b(WF, pageContext, frsActivity11.Wh());
            } else if (view == this.bPb.bOP) {
                frsActivity6 = this.bPb.bzH;
                com.baidu.tieba.tbadkCore.o WF2 = frsActivity6.WF();
                frsActivity7 = this.bPb.bzH;
                TbPageContext pageContext2 = frsActivity7.getPageContext();
                frsActivity8 = this.bPb.bzH;
                com.baidu.tieba.frs.utils.u.a(WF2, pageContext2, frsActivity8.Wh());
            } else if (view == this.bPb.bOQ) {
                frsActivity4 = this.bPb.bzH;
                com.baidu.tieba.tbadkCore.o WF3 = frsActivity4.WF();
                frsActivity5 = this.bPb.bzH;
                com.baidu.tieba.frs.utils.u.b(WF3, frsActivity5.getPageContext());
            } else if (view == this.bPb.bOR) {
                frsActivity2 = this.bPb.bzH;
                com.baidu.tieba.tbadkCore.o WF4 = frsActivity2.WF();
                frsActivity3 = this.bPb.bzH;
                com.baidu.tieba.frs.utils.u.a(WF4, frsActivity3.getPageContext());
            }
        }
    }
}
