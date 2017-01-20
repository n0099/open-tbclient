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
    final /* synthetic */ i bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i iVar) {
        this.bVC = iVar;
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
        frsActivity = this.bVC.bHh;
        if (frsActivity != null && !this.bVC.acT()) {
            if (!this.bVC.bVi.gG(1) && this.bVC.bVw != null) {
                this.bVC.bVw.setVisibility(8);
            }
            if (view == this.bVC.bVk) {
                frsActivity14 = this.bVC.bHh;
                if (frsActivity14.XW() != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    frsActivity15 = this.bVC.bHh;
                    if (frsActivity15.XW().aJY() != null) {
                        frsActivity16 = this.bVC.bHh;
                        if (frsActivity16.XW().aJY().getAnchorPower() != null) {
                            frsActivity17 = this.bVC.bHh;
                            if (frsActivity17.XW().aJY().getAnchorPower().can_add_live_post.intValue() != 2) {
                                z = true;
                                boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
                                boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteVoteActivityConfig.class);
                                boolean appResponseToIntentClass2 = TbadkCoreApplication.m9getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class);
                                if (!this.bVC.bVi.gG(1)) {
                                    this.bVC.a(z, showXiaoyingTool, appResponseToIntentClass, appResponseToIntentClass2);
                                    this.bVC.bVi.QK();
                                    if (appResponseToIntentClass2) {
                                        this.bVC.ej(appResponseToIntentClass2);
                                    }
                                    TiebaStatic.log("c11837");
                                    return;
                                } else if (this.bVC.bVi.gG(3)) {
                                    if (this.bVC.bVw != null) {
                                        this.bVC.bVw.setVisibility(8);
                                    }
                                    this.bVC.bVi.QL();
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
                if (!this.bVC.bVi.gG(1)) {
                }
            } else if (view == this.bVC.bVl) {
                frsActivity11 = this.bVC.bHh;
                com.baidu.tieba.tbadkCore.n XW = frsActivity11.XW();
                frsActivity12 = this.bVC.bHh;
                TbPageContext pageContext = frsActivity12.getPageContext();
                frsActivity13 = this.bVC.bHh;
                com.baidu.tieba.frs.utils.u.b(XW, pageContext, frsActivity13.Xy());
            } else if (view == this.bVC.bVm) {
                frsActivity8 = this.bVC.bHh;
                com.baidu.tieba.tbadkCore.n XW2 = frsActivity8.XW();
                frsActivity9 = this.bVC.bHh;
                TbPageContext pageContext2 = frsActivity9.getPageContext();
                frsActivity10 = this.bVC.bHh;
                com.baidu.tieba.frs.utils.u.a(XW2, pageContext2, frsActivity10.Xy());
            } else if (view == this.bVC.bVn) {
                frsActivity6 = this.bVC.bHh;
                com.baidu.tieba.tbadkCore.n XW3 = frsActivity6.XW();
                frsActivity7 = this.bVC.bHh;
                com.baidu.tieba.frs.utils.u.c(XW3, frsActivity7.getPageContext());
            } else if (view == this.bVC.bVo) {
                frsActivity4 = this.bVC.bHh;
                com.baidu.tieba.tbadkCore.n XW4 = frsActivity4.XW();
                frsActivity5 = this.bVC.bHh;
                com.baidu.tieba.frs.utils.u.b(XW4, frsActivity5.getPageContext());
            } else if (view == this.bVC.bVp) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11839").ab(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                frsActivity2 = this.bVC.bHh;
                com.baidu.tieba.tbadkCore.n XW5 = frsActivity2.XW();
                frsActivity3 = this.bVC.bHh;
                com.baidu.tieba.frs.utils.u.a(XW5, frsActivity3.getPageContext());
            }
        }
    }
}
