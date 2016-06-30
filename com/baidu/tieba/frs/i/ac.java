package com.baidu.tieba.frs.i;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.RequestSetCommForumStateNetMessage;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements BdSwitchView.a {
    final /* synthetic */ aa bSu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar) {
        this.bSu = aaVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        if (!com.baidu.adp.lib.util.i.fr()) {
            frsActivity = this.bSu.bJR;
            frsActivity.showToast(u.j.neterror);
            return;
        }
        RequestSetCommForumStateNetMessage requestSetCommForumStateNetMessage = new RequestSetCommForumStateNetMessage();
        frsActivity2 = this.bSu.bJR;
        requestSetCommForumStateNetMessage.setForumId(com.baidu.adp.lib.h.b.c(frsActivity2.getForumId(), 0L));
        if (switchState == BdSwitchView.SwitchState.ON) {
            requestSetCommForumStateNetMessage.setOperation(1);
        } else {
            requestSetCommForumStateNetMessage.setOperation(0);
        }
        frsActivity3 = this.bSu.bJR;
        frsActivity3.sendMessage(requestSetCommForumStateNetMessage);
    }
}
