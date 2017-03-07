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
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements BdSwitchView.a {
    final /* synthetic */ ao cdy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ao aoVar) {
        this.cdy = aoVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        cn cnVar;
        cn cnVar2;
        cn cnVar3;
        cn cnVar4;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        com.baidu.adp.base.g gVar;
        cnVar = this.cdy.cds;
        if (cnVar != null) {
            cnVar2 = this.cdy.cds;
            if (view != cnVar2.aak()) {
                cnVar3 = this.cdy.cds;
                if (view != cnVar3.aal()) {
                    cnVar4 = this.cdy.cds;
                    if (view == cnVar4.aam()) {
                        com.baidu.tbadk.core.sharedPref.b.uo().putBoolean(com.baidu.tbadk.core.sharedPref.b.cI("frs_guess_like_switch"), switchState == BdSwitchView.SwitchState.ON);
                        return;
                    }
                    return;
                } else if (!com.baidu.adp.lib.util.i.he()) {
                    frsActivity = this.cdy.bTf;
                    frsActivity.showToast(w.l.neterror);
                    return;
                } else {
                    RequestSetCommForumStateNetMessage requestSetCommForumStateNetMessage = new RequestSetCommForumStateNetMessage();
                    frsActivity2 = this.cdy.bTf;
                    requestSetCommForumStateNetMessage.setForumId(com.baidu.adp.lib.g.b.c(frsActivity2.getForumId(), 0L));
                    if (switchState == BdSwitchView.SwitchState.ON) {
                        requestSetCommForumStateNetMessage.setOperation(1);
                    } else {
                        requestSetCommForumStateNetMessage.setOperation(0);
                    }
                    frsActivity3 = this.cdy.bTf;
                    frsActivity3.sendMessage(requestSetCommForumStateNetMessage);
                    return;
                }
            }
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TbadkCoreApplication.m9getInst().getSkinType() != 1) {
                    TiebaStatic.eventStat(this.cdy.getPageContext().getPageActivity(), "frs_night_mode", "frsclick", 1, new Object[0]);
                    TbadkCoreApplication.m9getInst().setSkinType(1);
                    gVar = this.cdy.mContext;
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
