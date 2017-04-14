package com.baidu.tieba.frs.g;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.RequestSetCommForumStateNetMessage;
import com.baidu.tieba.frs.cp;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements BdSwitchView.a {
    final /* synthetic */ ao cbZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ao aoVar) {
        this.cbZ = aoVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        cp cpVar;
        cp cpVar2;
        cp cpVar3;
        cp cpVar4;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        com.baidu.adp.base.g gVar;
        cpVar = this.cbZ.cbT;
        if (cpVar != null) {
            cpVar2 = this.cbZ.cbT;
            if (view != cpVar2.aaI()) {
                cpVar3 = this.cbZ.cbT;
                if (view != cpVar3.aaJ()) {
                    cpVar4 = this.cbZ.cbT;
                    if (view == cpVar4.aaK()) {
                        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean(com.baidu.tbadk.core.sharedPref.b.cP("frs_guess_like_switch"), switchState == BdSwitchView.SwitchState.ON);
                        return;
                    }
                    return;
                } else if (!com.baidu.adp.lib.util.i.hj()) {
                    frsActivity = this.cbZ.bST;
                    frsActivity.showToast(w.l.neterror);
                    return;
                } else {
                    RequestSetCommForumStateNetMessage requestSetCommForumStateNetMessage = new RequestSetCommForumStateNetMessage();
                    frsActivity2 = this.cbZ.bST;
                    requestSetCommForumStateNetMessage.setForumId(com.baidu.adp.lib.g.b.c(frsActivity2.getForumId(), 0L));
                    if (switchState == BdSwitchView.SwitchState.ON) {
                        requestSetCommForumStateNetMessage.setOperation(1);
                    } else {
                        requestSetCommForumStateNetMessage.setOperation(0);
                    }
                    frsActivity3 = this.cbZ.bST;
                    frsActivity3.sendMessage(requestSetCommForumStateNetMessage);
                    return;
                }
            }
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TbadkCoreApplication.m9getInst().getSkinType() != 1) {
                    TiebaStatic.eventStat(this.cbZ.getPageContext().getPageActivity(), "frs_night_mode", "frsclick", 1, new Object[0]);
                    TbadkCoreApplication.m9getInst().setSkinType(1);
                    gVar = this.cbZ.mContext;
                    TiebaStatic.eventStat(gVar.getPageActivity(), TbConfig.ST_TYPE_EYESHIELD_MODE, null, 1, new Object[0]);
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
