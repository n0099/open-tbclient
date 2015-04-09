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
    final /* synthetic */ FrsActivity aJQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsActivity frsActivity) {
        this.aJQ = frsActivity;
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
        bfVar = this.aJQ.aJa;
        if (view != bfVar.Kd()) {
            bfVar2 = this.aJQ.aJa;
            if (view == bfVar2.JZ()) {
                bfVar13 = this.aJQ.aJa;
                bfVar13.bO(this.aJQ.oi().KR());
                TiebaStatic.eventStat(this.aJQ.getPageContext().getPageActivity(), "frs_forum_name", "frsclick", 1, new Object[0]);
            } else {
                bfVar3 = this.aJQ.aJa;
                if (view != bfVar3.Ke()) {
                    bfVar4 = this.aJQ.aJa;
                    if (view == bfVar4.getMoreButton()) {
                        bfVar11 = this.aJQ.aJa;
                        cfVar = this.aJQ.aJf;
                        bfVar11.a(cfVar);
                        kVar3 = this.aJQ.aJu;
                        cfVar2 = this.aJQ.aJf;
                        kVar3.a(cfVar2);
                        TiebaStatic.eventStat(this.aJQ.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                        bfVar12 = this.aJQ.aJa;
                        bfVar12.Kn();
                        FrsActivityStatic.aJY = false;
                        kVar4 = this.aJQ.aJu;
                        kVar4.showMenu(true);
                    } else {
                        bfVar5 = this.aJQ.aJa;
                        if (view == bfVar5.Ka()) {
                            bfVar10 = this.aJQ.aJa;
                            bfVar10.JY();
                            kVar2 = this.aJQ.aJu;
                            kVar2.Ls();
                            if (this.aJQ.oi().KR()) {
                                this.aJQ.stopVoice();
                                this.aJQ.oi().KN();
                            }
                        } else {
                            bfVar6 = this.aJQ.aJa;
                            if (view != bfVar6.Kb()) {
                                bfVar7 = this.aJQ.aJa;
                                if (view == bfVar7.Kc()) {
                                    TiebaStatic.eventStat(this.aJQ.getPageContext().getPageActivity(), "frs_add_shortcut", "frsclick", 1, new Object[0]);
                                    bfVar8 = this.aJQ.aJa;
                                    bfVar8.JY();
                                    FrsActivity frsActivity = this.aJQ;
                                    FrsActivity frsActivity2 = this.aJQ;
                                    str = this.aJQ.aIS;
                                    frsActivity.aJo = new ag(frsActivity2, str);
                                    agVar = this.aJQ.aJo;
                                    agVar.setSelfExecute(true);
                                    agVar2 = this.aJQ.aJo;
                                    agVar2.execute(new String[0]);
                                }
                            } else {
                                TiebaStatic.eventStat(this.aJQ.getPageContext().getPageActivity(), "frs_good_threads", "frsclick", 1, new Object[0]);
                                bfVar9 = this.aJQ.aJa;
                                bfVar9.JY();
                                kVar = this.aJQ.aJu;
                                kVar.Ls();
                                if (!this.aJQ.oi().KR()) {
                                    this.aJQ.stopVoice();
                                    this.aJQ.oi().eR(0);
                                }
                            }
                        }
                    }
                } else {
                    this.aJQ.closeActivity();
                }
            }
        } else {
            TiebaStatic.eventStat(this.aJQ.getPageContext().getPageActivity(), "frs_post_thread", "frsclick", 1, new Object[0]);
            this.aJQ.eF(0);
        }
        int id = view.getId();
        if (id == com.baidu.tieba.v.refresh_layout) {
            TiebaStatic.eventStat(this.aJQ.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            bfVar14 = this.aJQ.aJa;
            bfVar14.mX();
        } else if (id == com.baidu.tieba.v.nb_item_live_text_btn) {
            TiebaStatic.eventStat(this.aJQ.getPageContext().getPageActivity(), "frs_broadcast_btn", "click", 1, new Object[0]);
            if (Build.VERSION.SDK_INT >= 9) {
                wVar = this.aJQ.aJd;
                if (wVar != null) {
                    wVar2 = this.aJQ.aJd;
                    if (wVar2.Za() != null) {
                        wVar3 = this.aJQ.aJd;
                        if (wVar3.Za().getAnchorPower() != null) {
                            wVar4 = this.aJQ.aJd;
                            if (wVar4.Za().getAnchorPower().have_power.intValue() == 1) {
                                com.baidu.tbadk.core.k.A(this.aJQ.getBaseContext(), "start_live_bt");
                                MessageManager messageManager = MessageManager.getInstance();
                                Activity pageActivity = this.aJQ.getPageContext().getPageActivity();
                                wVar6 = this.aJQ.aJd;
                                int i = com.baidu.adp.lib.g.c.toInt(wVar6.Za().getId(), 0);
                                wVar7 = this.aJQ.aJd;
                                messageManager.sendMessage(new CustomMessage(2002001, new LiveRoomEntranceActivityConfig(pageActivity, i, wVar7.Za().getName())));
                                return;
                            }
                            FrsActivity frsActivity3 = this.aJQ;
                            wVar5 = this.aJQ.aJd;
                            frsActivity3.showToast(wVar5.Za().getAnchorPower().anchor_message);
                            return;
                        }
                        this.aJQ.showToast(com.baidu.tieba.y.error);
                        return;
                    }
                    return;
                }
                return;
            }
            this.aJQ.showToast(com.baidu.tieba.y.live_error_system_not_support);
        }
    }
}
