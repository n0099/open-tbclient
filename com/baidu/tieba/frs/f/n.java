package com.baidu.tieba.frs.f;

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
    final /* synthetic */ i ccU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar) {
        this.ccU = iVar;
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
        frsActivity = this.ccU.bOq;
        if (frsActivity != null && !this.ccU.adT()) {
            if (!this.ccU.ccA.gD(1) && this.ccU.ccO != null) {
                this.ccU.ccO.setVisibility(8);
            }
            if (view == this.ccU.ccC) {
                frsActivity14 = this.ccU.bOq;
                if (frsActivity14.YV() != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    frsActivity15 = this.ccU.bOq;
                    if (frsActivity15.YV().aJp() != null) {
                        frsActivity16 = this.ccU.bOq;
                        if (frsActivity16.YV().aJp().getAnchorPower() != null) {
                            frsActivity17 = this.ccU.bOq;
                            if (frsActivity17.YV().aJp().getAnchorPower().can_add_live_post.intValue() != 2) {
                                z = true;
                                boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
                                boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteVoteActivityConfig.class);
                                boolean appResponseToIntentClass2 = TbadkCoreApplication.m9getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class);
                                if (!this.ccU.ccA.gD(1)) {
                                    this.ccU.a(z, showXiaoyingTool, appResponseToIntentClass, appResponseToIntentClass2);
                                    this.ccU.ccA.RC();
                                    if (appResponseToIntentClass2) {
                                        this.ccU.ej(appResponseToIntentClass2);
                                    }
                                    TiebaStatic.log("c11837");
                                    return;
                                } else if (this.ccU.ccA.gD(3)) {
                                    if (this.ccU.ccO != null) {
                                        this.ccU.ccO.setVisibility(8);
                                    }
                                    this.ccU.ccA.RD();
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
                if (!this.ccU.ccA.gD(1)) {
                }
            } else if (view == this.ccU.ccD) {
                frsActivity11 = this.ccU.bOq;
                com.baidu.tieba.tbadkCore.n YV = frsActivity11.YV();
                frsActivity12 = this.ccU.bOq;
                TbPageContext pageContext = frsActivity12.getPageContext();
                frsActivity13 = this.ccU.bOq;
                com.baidu.tieba.frs.utils.u.b(YV, pageContext, frsActivity13.Yx());
            } else if (view == this.ccU.ccE) {
                frsActivity8 = this.ccU.bOq;
                com.baidu.tieba.tbadkCore.n YV2 = frsActivity8.YV();
                frsActivity9 = this.ccU.bOq;
                TbPageContext pageContext2 = frsActivity9.getPageContext();
                frsActivity10 = this.ccU.bOq;
                com.baidu.tieba.frs.utils.u.a(YV2, pageContext2, frsActivity10.Yx());
            } else if (view == this.ccU.ccF) {
                frsActivity6 = this.ccU.bOq;
                com.baidu.tieba.tbadkCore.n YV3 = frsActivity6.YV();
                frsActivity7 = this.ccU.bOq;
                com.baidu.tieba.frs.utils.u.c(YV3, frsActivity7.getPageContext());
                this.ccU.ccA.RD();
            } else if (view == this.ccU.ccG) {
                frsActivity4 = this.ccU.bOq;
                com.baidu.tieba.tbadkCore.n YV4 = frsActivity4.YV();
                frsActivity5 = this.ccU.bOq;
                com.baidu.tieba.frs.utils.u.b(YV4, frsActivity5.getPageContext());
            } else if (view == this.ccU.ccH) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11839").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                frsActivity2 = this.ccU.bOq;
                com.baidu.tieba.tbadkCore.n YV5 = frsActivity2.YV();
                frsActivity3 = this.ccU.bOq;
                com.baidu.tieba.frs.utils.u.a(YV5, frsActivity3.getPageContext());
            }
        }
    }
}
