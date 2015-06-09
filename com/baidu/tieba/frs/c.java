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
    final /* synthetic */ FrsActivity aLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsActivity frsActivity) {
        this.aLY = frsActivity;
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
        bfVar = this.aLY.aLj;
        if (view != bfVar.Lj()) {
            bfVar2 = this.aLY.aLj;
            if (view == bfVar2.Lf()) {
                bfVar13 = this.aLY.aLj;
                bfVar13.bX(this.aLY.oy().LX());
                TiebaStatic.eventStat(this.aLY.getPageContext().getPageActivity(), "frs_forum_name", "frsclick", 1, new Object[0]);
            } else {
                bfVar3 = this.aLY.aLj;
                if (view != bfVar3.Lk()) {
                    bfVar4 = this.aLY.aLj;
                    if (view == bfVar4.getMoreButton()) {
                        bfVar11 = this.aLY.aLj;
                        ceVar = this.aLY.aLo;
                        bfVar11.a(ceVar);
                        kVar3 = this.aLY.aLC;
                        ceVar2 = this.aLY.aLo;
                        kVar3.a(ceVar2);
                        TiebaStatic.eventStat(this.aLY.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                        bfVar12 = this.aLY.aLj;
                        bfVar12.Lt();
                        FrsActivityStatic.aMg = false;
                        kVar4 = this.aLY.aLC;
                        kVar4.showMenu(true);
                    } else {
                        bfVar5 = this.aLY.aLj;
                        if (view == bfVar5.Lg()) {
                            bfVar10 = this.aLY.aLj;
                            bfVar10.Le();
                            kVar2 = this.aLY.aLC;
                            kVar2.My();
                            if (this.aLY.oy().LX()) {
                                this.aLY.stopVoice();
                                this.aLY.oy().LT();
                            }
                        } else {
                            bfVar6 = this.aLY.aLj;
                            if (view != bfVar6.Lh()) {
                                bfVar7 = this.aLY.aLj;
                                if (view == bfVar7.Li()) {
                                    TiebaStatic.eventStat(this.aLY.getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
                                    bfVar8 = this.aLY.aLj;
                                    bfVar8.Le();
                                    FrsActivity frsActivity = this.aLY;
                                    FrsActivity frsActivity2 = this.aLY;
                                    str = this.aLY.aLc;
                                    frsActivity.aLx = new ag(frsActivity2, str);
                                    agVar = this.aLY.aLx;
                                    agVar.setSelfExecute(true);
                                    agVar2 = this.aLY.aLx;
                                    agVar2.execute(new String[0]);
                                }
                            } else {
                                TiebaStatic.eventStat(this.aLY.getPageContext().getPageActivity(), "frs_good_threads", "frsclick", 1, new Object[0]);
                                bfVar9 = this.aLY.aLj;
                                bfVar9.Le();
                                kVar = this.aLY.aLC;
                                kVar.My();
                                if (!this.aLY.oy().LX()) {
                                    this.aLY.stopVoice();
                                    this.aLY.oy().ff(0);
                                }
                            }
                        }
                    }
                } else {
                    this.aLY.closeActivity();
                }
            }
        } else {
            TiebaStatic.eventStat(this.aLY.getPageContext().getPageActivity(), "frs_post_thread", "frsclick", 1, new Object[0]);
            this.aLY.eT(0);
        }
        int id = view.getId();
        if (id == com.baidu.tieba.q.refresh_layout) {
            TiebaStatic.eventStat(this.aLY.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            bfVar14 = this.aLY.aLj;
            bfVar14.no();
        } else if (id == com.baidu.tieba.q.nb_item_live_text_btn && this.aLY.checkUpIsLogin()) {
            TiebaStatic.eventStat(this.aLY.getPageContext().getPageActivity(), "frs_broadcast_btn", "click", 1, new Object[0]);
            if (Build.VERSION.SDK_INT >= 9) {
                wVar = this.aLY.aLm;
                if (wVar != null) {
                    wVar2 = this.aLY.aLm;
                    if (wVar2.aas() != null) {
                        wVar3 = this.aLY.aLm;
                        if (wVar3.aas().getAnchorPower() != null) {
                            wVar4 = this.aLY.aLm;
                            if (wVar4.aas().getAnchorPower().have_power.intValue() == 1) {
                                com.baidu.tbadk.core.k.A(this.aLY.getBaseContext(), "start_live_bt");
                                MessageManager messageManager = MessageManager.getInstance();
                                Activity pageActivity = this.aLY.getPageContext().getPageActivity();
                                wVar6 = this.aLY.aLm;
                                int i = com.baidu.adp.lib.g.c.toInt(wVar6.aas().getId(), 0);
                                wVar7 = this.aLY.aLm;
                                messageManager.sendMessage(new CustomMessage(2002001, new LiveRoomEntranceActivityConfig(pageActivity, i, wVar7.aas().getName(), LiveRoomEntranceActivityConfig.FROM_FRS)));
                                return;
                            }
                            FrsActivity frsActivity3 = this.aLY;
                            wVar5 = this.aLY.aLm;
                            frsActivity3.showToast(wVar5.aas().getAnchorPower().anchor_message);
                            return;
                        }
                        this.aLY.showToast(com.baidu.tieba.t.error);
                        return;
                    }
                    return;
                }
                return;
            }
            this.aLY.showToast(com.baidu.tieba.t.live_error_system_not_support);
        }
    }
}
