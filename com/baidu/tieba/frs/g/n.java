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
    final /* synthetic */ i cdM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar) {
        this.cdM = iVar;
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
        frsActivity = this.cdM.bQw;
        if (frsActivity != null && !this.cdM.aeP()) {
            if (!this.cdM.cds.gM(1) && this.cdM.cdG != null) {
                this.cdM.cdG.setVisibility(8);
            }
            if (view == this.cdM.cdu) {
                frsActivity14 = this.cdM.bQw;
                if (frsActivity14.aas() != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    frsActivity15 = this.cdM.bQw;
                    if (frsActivity15.aas().aKx() != null) {
                        frsActivity16 = this.cdM.bQw;
                        if (frsActivity16.aas().aKx().getAnchorPower() != null) {
                            frsActivity17 = this.cdM.bQw;
                            if (frsActivity17.aas().aKx().getAnchorPower().can_add_live_post.intValue() != 2) {
                                z = true;
                                boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
                                boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteVoteActivityConfig.class);
                                boolean appResponseToIntentClass2 = TbadkCoreApplication.m9getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class);
                                if (!this.cdM.cds.gM(1)) {
                                    this.cdM.a(z, showXiaoyingTool, appResponseToIntentClass, appResponseToIntentClass2);
                                    this.cdM.cds.Tc();
                                    if (appResponseToIntentClass2) {
                                        this.cdM.et(appResponseToIntentClass2);
                                    }
                                    TiebaStatic.log("c11837");
                                    return;
                                } else if (this.cdM.cds.gM(3)) {
                                    if (this.cdM.cdG != null) {
                                        this.cdM.cdG.setVisibility(8);
                                    }
                                    this.cdM.cds.Td();
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
                if (!this.cdM.cds.gM(1)) {
                }
            } else if (view == this.cdM.cdv) {
                frsActivity11 = this.cdM.bQw;
                com.baidu.tieba.tbadkCore.n aas = frsActivity11.aas();
                frsActivity12 = this.cdM.bQw;
                TbPageContext pageContext = frsActivity12.getPageContext();
                frsActivity13 = this.cdM.bQw;
                com.baidu.tieba.frs.f.u.b(aas, pageContext, frsActivity13.ZU());
            } else if (view == this.cdM.cdw) {
                frsActivity8 = this.cdM.bQw;
                com.baidu.tieba.tbadkCore.n aas2 = frsActivity8.aas();
                frsActivity9 = this.cdM.bQw;
                TbPageContext pageContext2 = frsActivity9.getPageContext();
                frsActivity10 = this.cdM.bQw;
                com.baidu.tieba.frs.f.u.a(aas2, pageContext2, frsActivity10.ZU());
            } else if (view == this.cdM.cdx) {
                frsActivity6 = this.cdM.bQw;
                com.baidu.tieba.tbadkCore.n aas3 = frsActivity6.aas();
                frsActivity7 = this.cdM.bQw;
                com.baidu.tieba.frs.f.u.c(aas3, frsActivity7.getPageContext());
                this.cdM.cds.Td();
            } else if (view == this.cdM.cdy) {
                frsActivity4 = this.cdM.bQw;
                com.baidu.tieba.tbadkCore.n aas4 = frsActivity4.aas();
                frsActivity5 = this.cdM.bQw;
                com.baidu.tieba.frs.f.u.b(aas4, frsActivity5.getPageContext());
            } else if (view == this.cdM.cdz) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11839").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                frsActivity2 = this.cdM.bQw;
                com.baidu.tieba.tbadkCore.n aas5 = frsActivity2.aas();
                frsActivity3 = this.cdM.bQw;
                com.baidu.tieba.frs.f.u.a(aas5, frsActivity3.getPageContext());
            }
        }
    }
}
