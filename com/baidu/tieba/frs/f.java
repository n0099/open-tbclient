package com.baidu.tieba.frs;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FrsActivity frsActivity) {
        this.this$0 = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bl blVar5;
        bl blVar6;
        bl blVar7;
        bl blVar8;
        com.baidu.tieba.frs.c.k kVar;
        bl blVar9;
        com.baidu.tieba.frs.c.k kVar2;
        bl blVar10;
        cn cnVar;
        com.baidu.tieba.frs.c.k kVar3;
        cn cnVar2;
        bl blVar11;
        com.baidu.tieba.frs.c.k kVar4;
        com.baidu.tieba.tbadkCore.n nVar;
        com.baidu.tieba.tbadkCore.n nVar2;
        com.baidu.tieba.tbadkCore.n nVar3;
        com.baidu.tieba.tbadkCore.n nVar4;
        com.baidu.tieba.tbadkCore.n nVar5;
        com.baidu.tieba.tbadkCore.n nVar6;
        com.baidu.tieba.tbadkCore.n nVar7;
        bl blVar12;
        blVar = this.this$0.aUw;
        if (view != blVar.LV()) {
            blVar2 = this.this$0.aUw;
            if (view != blVar2.LW()) {
                blVar3 = this.this$0.aUw;
                if (view == blVar3.getMoreButton()) {
                    blVar10 = this.this$0.aUw;
                    cnVar = this.this$0.aUz;
                    blVar10.a(cnVar);
                    kVar3 = this.this$0.aUN;
                    cnVar2 = this.this$0.aUz;
                    kVar3.a(cnVar2);
                    TiebaStatic.eventStat(this.this$0.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                    blVar11 = this.this$0.aUw;
                    blVar11.Mf();
                    FrsActivityStatic.aVs = false;
                    kVar4 = this.this$0.aUN;
                    kVar4.showMenu(true);
                } else {
                    blVar4 = this.this$0.aUw;
                    if (view == blVar4.LS()) {
                        blVar9 = this.this$0.aUw;
                        blVar9.LR();
                        kVar2 = this.this$0.aUN;
                        kVar2.NL();
                        if (this.this$0.Lz().Nd()) {
                            this.this$0.stopVoice();
                            this.this$0.Lz().Na();
                        }
                    } else {
                        blVar5 = this.this$0.aUw;
                        if (view != blVar5.LT()) {
                            blVar6 = this.this$0.aUw;
                            if (view == blVar6.LU()) {
                                this.this$0.Lq();
                                blVar7 = this.this$0.aUw;
                                blVar7.LR();
                            }
                        } else {
                            TiebaStatic.eventStat(this.this$0.getPageContext().getPageActivity(), "frs_good_threads", "frsclick", 1, new Object[0]);
                            blVar8 = this.this$0.aUw;
                            blVar8.LR();
                            kVar = this.this$0.aUN;
                            kVar.NL();
                            if (!this.this$0.Lz().Nd()) {
                                this.this$0.stopVoice();
                                this.this$0.Lz().fx(0);
                            }
                        }
                    }
                }
            } else {
                this.this$0.closeActivity();
            }
        } else {
            TiebaStatic.eventStat(this.this$0.getPageContext().getPageActivity(), "frs_post_thread", "frsclick", 1, new Object[0]);
            this.this$0.fe(0);
        }
        int id = view.getId();
        if (id == i.f.refresh_layout) {
            TiebaStatic.eventStat(this.this$0.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            blVar12 = this.this$0.aUw;
            blVar12.ny();
        } else if (id == i.f.nb_item_live_text_btn && this.this$0.checkUpIsLogin()) {
            TiebaStatic.eventStat(this.this$0.getPageContext().getPageActivity(), "frs_broadcast_btn", "click", 1, new Object[0]);
            if (Build.VERSION.SDK_INT >= 9) {
                nVar = this.this$0.aUy;
                if (nVar != null) {
                    nVar2 = this.this$0.aUy;
                    if (nVar2.acG() != null) {
                        nVar3 = this.this$0.aUy;
                        if (nVar3.acG().getAnchorPower() != null) {
                            nVar4 = this.this$0.aUy;
                            if (nVar4.acG().getAnchorPower().have_power.intValue() == 1) {
                                TiebaStatic.log("start_live_bt");
                                MessageManager messageManager = MessageManager.getInstance();
                                Activity pageActivity = this.this$0.getPageContext().getPageActivity();
                                nVar6 = this.this$0.aUy;
                                int g = com.baidu.adp.lib.g.b.g(nVar6.acG().getId(), 0);
                                nVar7 = this.this$0.aUy;
                                messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new LiveRoomEntranceActivityConfig(pageActivity, g, nVar7.acG().getName(), LiveRoomEntranceActivityConfig.FROM_FRS)));
                                return;
                            }
                            FrsActivity frsActivity = this.this$0;
                            nVar5 = this.this$0.aUy;
                            frsActivity.showToast(nVar5.acG().getAnchorPower().anchor_message);
                            return;
                        }
                        this.this$0.showToast(i.C0057i.error);
                        return;
                    }
                    return;
                }
                return;
            }
            this.this$0.showToast(i.C0057i.live_error_system_not_support);
        }
    }
}
