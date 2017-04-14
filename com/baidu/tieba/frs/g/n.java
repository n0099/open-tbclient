package com.baidu.tieba.frs.g;

import android.view.View;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ i cbv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar) {
        this.cbv = iVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c7  */
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
        boolean z;
        FrsActivity frsActivity15;
        FrsActivity frsActivity16;
        FrsActivity frsActivity17;
        frsActivity = this.cbv.bOf;
        if (frsActivity != null && !this.cbv.adO()) {
            if (!this.cbv.cbb.gG(1) && this.cbv.cbp != null) {
                this.cbv.cbp.setVisibility(8);
            }
            if (view == this.cbv.cbd) {
                frsActivity14 = this.cbv.bOf;
                if (frsActivity14.Zr() != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    frsActivity15 = this.cbv.bOf;
                    if (frsActivity15.Zr().aJw() != null) {
                        frsActivity16 = this.cbv.bOf;
                        if (frsActivity16.Zr().aJw().getAnchorPower() != null) {
                            frsActivity17 = this.cbv.bOf;
                            if (frsActivity17.Zr().aJw().getAnchorPower().can_add_live_post.intValue() != 2) {
                                z = true;
                                boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
                                boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteVoteActivityConfig.class);
                                boolean appResponseToIntentClass2 = TbadkCoreApplication.m9getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class);
                                if (!this.cbv.cbb.gG(1)) {
                                    this.cbv.a(z, showXiaoyingTool, appResponseToIntentClass, appResponseToIntentClass2);
                                    this.cbv.cbb.Sa();
                                    if (appResponseToIntentClass2) {
                                        this.cbv.ej(appResponseToIntentClass2);
                                    }
                                    TiebaStatic.log("c11837");
                                    return;
                                } else if (this.cbv.cbb.gG(3)) {
                                    if (this.cbv.cbp != null) {
                                        this.cbv.cbp.setVisibility(8);
                                    }
                                    this.cbv.cbb.Sb();
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
                boolean appResponseToIntentClass22 = TbadkCoreApplication.m9getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class);
                if (!this.cbv.cbb.gG(1)) {
                }
            } else if (view == this.cbv.cbe) {
                frsActivity11 = this.cbv.bOf;
                com.baidu.tieba.tbadkCore.n Zr = frsActivity11.Zr();
                frsActivity12 = this.cbv.bOf;
                TbPageContext pageContext = frsActivity12.getPageContext();
                frsActivity13 = this.cbv.bOf;
                com.baidu.tieba.frs.f.u.b(Zr, pageContext, frsActivity13.YT());
            } else if (view == this.cbv.cbf) {
                frsActivity8 = this.cbv.bOf;
                com.baidu.tieba.tbadkCore.n Zr2 = frsActivity8.Zr();
                frsActivity9 = this.cbv.bOf;
                TbPageContext pageContext2 = frsActivity9.getPageContext();
                frsActivity10 = this.cbv.bOf;
                com.baidu.tieba.frs.f.u.a(Zr2, pageContext2, frsActivity10.YT());
            } else if (view == this.cbv.cbg) {
                frsActivity6 = this.cbv.bOf;
                com.baidu.tieba.tbadkCore.n Zr3 = frsActivity6.Zr();
                frsActivity7 = this.cbv.bOf;
                com.baidu.tieba.frs.f.u.c(Zr3, frsActivity7.getPageContext());
                this.cbv.cbb.Sb();
            } else if (view == this.cbv.cbh) {
                frsActivity4 = this.cbv.bOf;
                com.baidu.tieba.tbadkCore.n Zr4 = frsActivity4.Zr();
                frsActivity5 = this.cbv.bOf;
                com.baidu.tieba.frs.f.u.b(Zr4, frsActivity5.getPageContext());
            } else if (view == this.cbv.cbi) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11839").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                frsActivity2 = this.cbv.bOf;
                com.baidu.tieba.tbadkCore.n Zr5 = frsActivity2.Zr();
                frsActivity3 = this.cbv.bOf;
                com.baidu.tieba.frs.f.u.a(Zr5, frsActivity3.getPageContext());
            }
        }
    }
}
