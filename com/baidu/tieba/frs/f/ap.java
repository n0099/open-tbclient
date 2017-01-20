package com.baidu.tieba.frs.f;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.RequestSetCommForumStateNetMessage;
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements BdSwitchView.a {
    final /* synthetic */ am bWd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(am amVar) {
        this.bWd = amVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        cn cnVar;
        cn cnVar2;
        cn cnVar3;
        cn cnVar4;
        cn cnVar5;
        com.baidu.adp.base.g gVar;
        com.baidu.adp.base.g gVar2;
        cn cnVar6;
        com.baidu.adp.base.g gVar3;
        com.baidu.adp.base.g gVar4;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        com.baidu.adp.base.g gVar5;
        cnVar = this.bWd.bVX;
        if (cnVar != null) {
            cnVar2 = this.bWd.bVX;
            if (view != cnVar2.Zl()) {
                cnVar3 = this.bWd.bVX;
                if (view != cnVar3.Zm()) {
                    cnVar4 = this.bWd.bVX;
                    if (view != cnVar4.Zo()) {
                        cnVar5 = this.bWd.bVX;
                        if (view == cnVar5.Zn()) {
                            com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean(com.baidu.tbadk.core.sharedPref.b.cP("frs_guess_like_switch"), switchState == BdSwitchView.SwitchState.ON);
                            return;
                        }
                        return;
                    }
                    if (switchState == BdSwitchView.SwitchState.ON) {
                        gVar3 = this.bWd.mContext;
                        StringBuilder sb = new StringBuilder(String.valueOf(gVar3.getString(r.l.image_show_setting)));
                        gVar4 = this.bWd.mContext;
                        view.setContentDescription(sb.append(gVar4.getString(r.l.now_state_on)).toString());
                        com.baidu.tbadk.core.l.oC().bD(0);
                        com.baidu.tbadk.core.l.oC().ak(true);
                    } else {
                        gVar = this.bWd.mContext;
                        StringBuilder sb2 = new StringBuilder(String.valueOf(gVar.getString(r.l.image_show_setting)));
                        gVar2 = this.bWd.mContext;
                        view.setContentDescription(sb2.append(gVar2.getString(r.l.now_state_off)).toString());
                        com.baidu.tbadk.core.l.oC().ak(false);
                    }
                    TiebaStatic.log("c11672");
                    cnVar6 = this.bWd.bVX;
                    cnVar6.dQ(true);
                    return;
                } else if (!com.baidu.adp.lib.util.i.gk()) {
                    frsActivity = this.bWd.bLZ;
                    frsActivity.showToast(r.l.neterror);
                    return;
                } else {
                    RequestSetCommForumStateNetMessage requestSetCommForumStateNetMessage = new RequestSetCommForumStateNetMessage();
                    frsActivity2 = this.bWd.bLZ;
                    requestSetCommForumStateNetMessage.setForumId(com.baidu.adp.lib.g.b.c(frsActivity2.getForumId(), 0L));
                    if (switchState == BdSwitchView.SwitchState.ON) {
                        requestSetCommForumStateNetMessage.setOperation(1);
                    } else {
                        requestSetCommForumStateNetMessage.setOperation(0);
                    }
                    frsActivity3 = this.bWd.bLZ;
                    frsActivity3.sendMessage(requestSetCommForumStateNetMessage);
                    return;
                }
            }
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TbadkCoreApplication.m9getInst().getSkinType() != 1) {
                    TiebaStatic.eventStat(this.bWd.getPageContext().getPageActivity(), "frs_night_mode", "frsclick", 1, new Object[0]);
                    TbadkCoreApplication.m9getInst().setSkinType(1);
                    gVar5 = this.bWd.mContext;
                    TiebaStatic.eventStat(gVar5.getPageActivity(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
                } else {
                    return;
                }
            } else if (TbadkCoreApplication.m9getInst().getSkinType() != 0) {
                TbadkCoreApplication.m9getInst().setSkinType(0);
            } else {
                return;
            }
            BitmapHelper.clearCashBitmap();
        }
    }
}
