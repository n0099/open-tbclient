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
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsActivity frsActivity) {
        this.aJG = frsActivity;
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
        cf cfVar;
        com.baidu.tieba.frs.c.k kVar3;
        cf cfVar2;
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
        bfVar = this.aJG.aIS;
        if (view != bfVar.JW()) {
            bfVar2 = this.aJG.aIS;
            if (view == bfVar2.JS()) {
                bfVar13 = this.aJG.aIS;
                bfVar13.bQ(this.aJG.oi().KF());
                TiebaStatic.eventStat(this.aJG.getPageContext().getPageActivity(), "frs_forum_name", "frsclick", 1, new Object[0]);
            } else {
                bfVar3 = this.aJG.aIS;
                if (view != bfVar3.JX()) {
                    bfVar4 = this.aJG.aIS;
                    if (view == bfVar4.getMoreButton()) {
                        bfVar11 = this.aJG.aIS;
                        cfVar = this.aJG.aIX;
                        bfVar11.a(cfVar);
                        kVar3 = this.aJG.aJm;
                        cfVar2 = this.aJG.aIX;
                        kVar3.a(cfVar2);
                        TiebaStatic.eventStat(this.aJG.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                        bfVar12 = this.aJG.aIS;
                        bfVar12.Kg();
                        FrsActivityStatic.aJO = false;
                        kVar4 = this.aJG.aJm;
                        kVar4.showMenu(true);
                    } else {
                        bfVar5 = this.aJG.aIS;
                        if (view == bfVar5.JT()) {
                            bfVar10 = this.aJG.aIS;
                            bfVar10.JR();
                            kVar2 = this.aJG.aJm;
                            kVar2.Lg();
                            if (this.aJG.oi().KF()) {
                                this.aJG.stopVoice();
                                this.aJG.oi().KB();
                            }
                        } else {
                            bfVar6 = this.aJG.aIS;
                            if (view != bfVar6.JU()) {
                                bfVar7 = this.aJG.aIS;
                                if (view == bfVar7.JV()) {
                                    TiebaStatic.eventStat(this.aJG.getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
                                    bfVar8 = this.aJG.aIS;
                                    bfVar8.JR();
                                    FrsActivity frsActivity = this.aJG;
                                    FrsActivity frsActivity2 = this.aJG;
                                    str = this.aJG.aIK;
                                    frsActivity.aJg = new ag(frsActivity2, str);
                                    agVar = this.aJG.aJg;
                                    agVar.setSelfExecute(true);
                                    agVar2 = this.aJG.aJg;
                                    agVar2.execute(new String[0]);
                                }
                            } else {
                                TiebaStatic.eventStat(this.aJG.getPageContext().getPageActivity(), "frs_good_threads", "frsclick", 1, new Object[0]);
                                bfVar9 = this.aJG.aIS;
                                bfVar9.JR();
                                kVar = this.aJG.aJm;
                                kVar.Lg();
                                if (!this.aJG.oi().KF()) {
                                    this.aJG.stopVoice();
                                    this.aJG.oi().eQ(0);
                                }
                            }
                        }
                    }
                } else {
                    this.aJG.closeActivity();
                }
            }
        } else {
            TiebaStatic.eventStat(this.aJG.getPageContext().getPageActivity(), "frs_post_thread", "frsclick", 1, new Object[0]);
            this.aJG.eF(0);
        }
        int id = view.getId();
        if (id == com.baidu.tieba.v.refresh_layout) {
            TiebaStatic.eventStat(this.aJG.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            bfVar14 = this.aJG.aIS;
            bfVar14.mX();
        } else if (id == com.baidu.tieba.v.nb_item_live_text_btn) {
            TiebaStatic.eventStat(this.aJG.getPageContext().getPageActivity(), "frs_broadcast_btn", "click", 1, new Object[0]);
            if (Build.VERSION.SDK_INT >= 9) {
                wVar = this.aJG.aIV;
                if (wVar != null) {
                    wVar2 = this.aJG.aIV;
                    if (wVar2.YO() != null) {
                        wVar3 = this.aJG.aIV;
                        if (wVar3.YO().getAnchorPower() != null) {
                            wVar4 = this.aJG.aIV;
                            if (wVar4.YO().getAnchorPower().have_power.intValue() == 1) {
                                com.baidu.tbadk.core.k.A(this.aJG.getBaseContext(), "start_live_bt");
                                MessageManager messageManager = MessageManager.getInstance();
                                Activity pageActivity = this.aJG.getPageContext().getPageActivity();
                                wVar6 = this.aJG.aIV;
                                int i = com.baidu.adp.lib.g.c.toInt(wVar6.YO().getId(), 0);
                                wVar7 = this.aJG.aIV;
                                messageManager.sendMessage(new CustomMessage(2002001, new LiveRoomEntranceActivityConfig(pageActivity, i, wVar7.YO().getName())));
                                return;
                            }
                            FrsActivity frsActivity3 = this.aJG;
                            wVar5 = this.aJG.aIV;
                            frsActivity3.showToast(wVar5.YO().getAnchorPower().anchor_message);
                            return;
                        }
                        this.aJG.showToast(com.baidu.tieba.y.error);
                        return;
                    }
                    return;
                }
                return;
            }
            this.aJG.showToast(com.baidu.tieba.y.live_error_system_not_support);
        }
    }
}
