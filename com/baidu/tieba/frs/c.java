package com.baidu.tieba.frs;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LiveRoomEntranceActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ FrsActivity aLX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsActivity frsActivity) {
        this.aLX = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        bf bfVar4;
        bf bfVar5;
        bf bfVar6;
        bf bfVar7;
        bf bfVar8;
        String str;
        ag agVar;
        ag agVar2;
        bf bfVar9;
        com.baidu.tieba.frs.c.k kVar;
        bf bfVar10;
        com.baidu.tieba.frs.c.k kVar2;
        bf bfVar11;
        ce ceVar;
        com.baidu.tieba.frs.c.k kVar3;
        ce ceVar2;
        bf bfVar12;
        com.baidu.tieba.frs.c.k kVar4;
        bf bfVar13;
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.tbadkCore.w wVar4;
        com.baidu.tieba.tbadkCore.w wVar5;
        com.baidu.tieba.tbadkCore.w wVar6;
        com.baidu.tieba.tbadkCore.w wVar7;
        bf bfVar14;
        bfVar = this.aLX.aLi;
        if (view != bfVar.Li()) {
            bfVar2 = this.aLX.aLi;
            if (view == bfVar2.Le()) {
                bfVar13 = this.aLX.aLi;
                bfVar13.bX(this.aLX.oy().LW());
                TiebaStatic.eventStat(this.aLX.getPageContext().getPageActivity(), "frs_forum_name", "frsclick", 1, new Object[0]);
            } else {
                bfVar3 = this.aLX.aLi;
                if (view != bfVar3.Lj()) {
                    bfVar4 = this.aLX.aLi;
                    if (view == bfVar4.getMoreButton()) {
                        bfVar11 = this.aLX.aLi;
                        ceVar = this.aLX.aLn;
                        bfVar11.a(ceVar);
                        kVar3 = this.aLX.aLB;
                        ceVar2 = this.aLX.aLn;
                        kVar3.a(ceVar2);
                        TiebaStatic.eventStat(this.aLX.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                        bfVar12 = this.aLX.aLi;
                        bfVar12.Ls();
                        FrsActivityStatic.aMf = false;
                        kVar4 = this.aLX.aLB;
                        kVar4.showMenu(true);
                    } else {
                        bfVar5 = this.aLX.aLi;
                        if (view == bfVar5.Lf()) {
                            bfVar10 = this.aLX.aLi;
                            bfVar10.Ld();
                            kVar2 = this.aLX.aLB;
                            kVar2.Mx();
                            if (this.aLX.oy().LW()) {
                                this.aLX.stopVoice();
                                this.aLX.oy().LS();
                            }
                        } else {
                            bfVar6 = this.aLX.aLi;
                            if (view != bfVar6.Lg()) {
                                bfVar7 = this.aLX.aLi;
                                if (view == bfVar7.Lh()) {
                                    TiebaStatic.eventStat(this.aLX.getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
                                    bfVar8 = this.aLX.aLi;
                                    bfVar8.Ld();
                                    FrsActivity frsActivity = this.aLX;
                                    FrsActivity frsActivity2 = this.aLX;
                                    str = this.aLX.aLb;
                                    frsActivity.aLw = new ag(frsActivity2, str);
                                    agVar = this.aLX.aLw;
                                    agVar.setSelfExecute(true);
                                    agVar2 = this.aLX.aLw;
                                    agVar2.execute(new String[0]);
                                }
                            } else {
                                TiebaStatic.eventStat(this.aLX.getPageContext().getPageActivity(), "frs_good_threads", "frsclick", 1, new Object[0]);
                                bfVar9 = this.aLX.aLi;
                                bfVar9.Ld();
                                kVar = this.aLX.aLB;
                                kVar.Mx();
                                if (!this.aLX.oy().LW()) {
                                    this.aLX.stopVoice();
                                    this.aLX.oy().ff(0);
                                }
                            }
                        }
                    }
                } else {
                    this.aLX.closeActivity();
                }
            }
        } else {
            TiebaStatic.eventStat(this.aLX.getPageContext().getPageActivity(), "frs_post_thread", "frsclick", 1, new Object[0]);
            this.aLX.eT(0);
        }
        int id = view.getId();
        if (id == com.baidu.tieba.q.refresh_layout) {
            TiebaStatic.eventStat(this.aLX.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            bfVar14 = this.aLX.aLi;
            bfVar14.no();
        } else if (id == com.baidu.tieba.q.nb_item_live_text_btn && this.aLX.checkUpIsLogin()) {
            TiebaStatic.eventStat(this.aLX.getPageContext().getPageActivity(), "frs_broadcast_btn", "click", 1, new Object[0]);
            if (Build.VERSION.SDK_INT >= 9) {
                wVar = this.aLX.aLl;
                if (wVar != null) {
                    wVar2 = this.aLX.aLl;
                    if (wVar2.aar() != null) {
                        wVar3 = this.aLX.aLl;
                        if (wVar3.aar().getAnchorPower() != null) {
                            wVar4 = this.aLX.aLl;
                            if (wVar4.aar().getAnchorPower().have_power.intValue() == 1) {
                                com.baidu.tbadk.core.k.A(this.aLX.getBaseContext(), "start_live_bt");
                                MessageManager messageManager = MessageManager.getInstance();
                                Activity pageActivity = this.aLX.getPageContext().getPageActivity();
                                wVar6 = this.aLX.aLl;
                                int i = com.baidu.adp.lib.g.c.toInt(wVar6.aar().getId(), 0);
                                wVar7 = this.aLX.aLl;
                                messageManager.sendMessage(new CustomMessage(2002001, new LiveRoomEntranceActivityConfig(pageActivity, i, wVar7.aar().getName(), LiveRoomEntranceActivityConfig.FROM_FRS)));
                                return;
                            }
                            FrsActivity frsActivity3 = this.aLX;
                            wVar5 = this.aLX.aLl;
                            frsActivity3.showToast(wVar5.aar().getAnchorPower().anchor_message);
                            return;
                        }
                        this.aLX.showToast(com.baidu.tieba.t.error);
                        return;
                    }
                    return;
                }
                return;
            }
            this.aLX.showToast(com.baidu.tieba.t.live_error_system_not_support);
        }
    }
}
