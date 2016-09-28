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
    final /* synthetic */ h cfi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar) {
        this.cfi = hVar;
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
        frsActivity = this.cfi.bRi;
        if (frsActivity != null) {
            if (view == this.cfi.ceS) {
                frsActivity13 = this.cfi.bRi;
                if (frsActivity13.abe() != null && TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    frsActivity14 = this.cfi.bRi;
                    if (frsActivity14.abe().aMr() != null) {
                        frsActivity15 = this.cfi.bRi;
                        if (frsActivity15.abe().aMr().getAnchorPower() != null) {
                            frsActivity16 = this.cfi.bRi;
                            if (frsActivity16.abe().aMr().getAnchorPower().can_add_live_post.intValue() != 2) {
                                z = true;
                                boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
                                boolean appResponseToIntentClass = TbadkCoreApplication.m9getInst().appResponseToIntentClass(WriteVoteActivityConfig.class);
                                boolean appResponseToIntentClass2 = TbadkCoreApplication.m9getInst().appResponseToIntentClass(EcommPersonManagerActivityConfig.class);
                                if (!this.cfi.ceQ.gf(1)) {
                                    this.cfi.a(z, showXiaoyingTool, appResponseToIntentClass, appResponseToIntentClass2);
                                    this.cfi.ceQ.NC();
                                    return;
                                } else if (this.cfi.ceQ.gf(3)) {
                                    this.cfi.ceQ.ND();
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
                if (!this.cfi.ceQ.gf(1)) {
                }
            } else if (view == this.cfi.ceT) {
                frsActivity10 = this.cfi.bRi;
                com.baidu.tieba.tbadkCore.p abe = frsActivity10.abe();
                frsActivity11 = this.cfi.bRi;
                TbPageContext pageContext = frsActivity11.getPageContext();
                frsActivity12 = this.cfi.bRi;
                com.baidu.tieba.frs.utils.b.b(abe, pageContext, frsActivity12.abi());
            } else if (view == this.cfi.ceU) {
                frsActivity7 = this.cfi.bRi;
                com.baidu.tieba.tbadkCore.p abe2 = frsActivity7.abe();
                frsActivity8 = this.cfi.bRi;
                TbPageContext pageContext2 = frsActivity8.getPageContext();
                frsActivity9 = this.cfi.bRi;
                com.baidu.tieba.frs.utils.b.a(abe2, pageContext2, frsActivity9.abi());
            } else if (view == this.cfi.ceV) {
                frsActivity5 = this.cfi.bRi;
                com.baidu.tieba.tbadkCore.p abe3 = frsActivity5.abe();
                frsActivity6 = this.cfi.bRi;
                com.baidu.tieba.frs.utils.b.b(abe3, frsActivity6.getPageContext());
            } else if (view == this.cfi.ceW) {
                frsActivity3 = this.cfi.bRi;
                com.baidu.tieba.tbadkCore.p abe4 = frsActivity3.abe();
                frsActivity4 = this.cfi.bRi;
                com.baidu.tieba.frs.utils.b.a(abe4, frsActivity4.getPageContext());
            } else if (view == this.cfi.ceX) {
                frsActivity2 = this.cfi.bRi;
                com.baidu.tieba.frs.utils.b.O(frsActivity2);
            }
        }
    }
}
