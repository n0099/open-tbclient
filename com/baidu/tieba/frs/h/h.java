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
public class h implements View.OnClickListener {
    final /* synthetic */ e bup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.bup = eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0176  */
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
        boolean z;
        FrsActivity frsActivity16;
        FrsActivity frsActivity17;
        FrsActivity frsActivity18;
        FrsActivity frsActivity19;
        frsActivity = this.bup.bjB;
        if (frsActivity != null) {
            if (view == this.bup.bub) {
                frsActivity15 = this.bup.bjB;
                if (frsActivity15.PZ() != null && TbadkCoreApplication.m11getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                    frsActivity17 = this.bup.bjB;
                    if (frsActivity17.PZ().avD() != null) {
                        frsActivity18 = this.bup.bjB;
                        if (frsActivity18.PZ().avD().getAnchorPower() != null) {
                            frsActivity19 = this.bup.bjB;
                            if (frsActivity19.PZ().avD().getAnchorPower().can_add_live_post.intValue() != 2) {
                                z = true;
                                boolean showXiaoyingTool = XiaoyingUtil.showXiaoyingTool();
                                boolean Fc = com.baidu.tbadk.plugins.g.Fc();
                                frsActivity16 = this.bup.bjB;
                                boolean z2 = frsActivity16.PZ().getUserData().canPostHi() ? Fc : false;
                                boolean appResponseToIntentClass = TbadkCoreApplication.m11getInst().appResponseToIntentClass(WriteVoteActivityConfig.class);
                                if (!this.bup.btZ.fr(1)) {
                                    this.bup.a(z, showXiaoyingTool, z2, appResponseToIntentClass);
                                    this.bup.btZ.JC();
                                    return;
                                } else if (this.bup.btZ.fr(3)) {
                                    this.bup.btZ.JD();
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
                boolean Fc2 = com.baidu.tbadk.plugins.g.Fc();
                frsActivity16 = this.bup.bjB;
                if (frsActivity16.PZ().getUserData().canPostHi()) {
                }
                boolean appResponseToIntentClass2 = TbadkCoreApplication.m11getInst().appResponseToIntentClass(WriteVoteActivityConfig.class);
                if (!this.bup.btZ.fr(1)) {
                }
            } else if (view == this.bup.buc) {
                frsActivity12 = this.bup.bjB;
                com.baidu.tieba.tbadkCore.o PZ = frsActivity12.PZ();
                frsActivity13 = this.bup.bjB;
                TbPageContext pageContext = frsActivity13.getPageContext();
                frsActivity14 = this.bup.bjB;
                com.baidu.tieba.frs.utils.b.b(PZ, pageContext, frsActivity14.Qd());
            } else if (view == this.bup.bud) {
                frsActivity9 = this.bup.bjB;
                com.baidu.tieba.tbadkCore.o PZ2 = frsActivity9.PZ();
                frsActivity10 = this.bup.bjB;
                TbPageContext pageContext2 = frsActivity10.getPageContext();
                frsActivity11 = this.bup.bjB;
                com.baidu.tieba.frs.utils.b.a(PZ2, pageContext2, frsActivity11.Qd());
            } else if (view == this.bup.bue) {
                frsActivity7 = this.bup.bjB;
                com.baidu.tieba.tbadkCore.o PZ3 = frsActivity7.PZ();
                frsActivity8 = this.bup.bjB;
                com.baidu.tieba.frs.utils.b.b(PZ3, frsActivity8.getPageContext());
            } else if (view == this.bup.buf) {
                frsActivity5 = this.bup.bjB;
                com.baidu.tieba.tbadkCore.o PZ4 = frsActivity5.PZ();
                frsActivity6 = this.bup.bjB;
                com.baidu.tieba.frs.utils.b.a(PZ4, frsActivity6.getPageContext());
            } else if (view == this.bup.bug) {
                frsActivity2 = this.bup.bjB;
                com.baidu.tieba.tbadkCore.o PZ5 = frsActivity2.PZ();
                frsActivity3 = this.bup.bjB;
                TbPageContext pageContext3 = frsActivity3.getPageContext();
                frsActivity4 = this.bup.bjB;
                com.baidu.tieba.frs.utils.b.c(PZ5, pageContext3, frsActivity4.Qd());
            }
        }
    }
}
