package com.baidu.tieba.frs.i;

import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.RequestSetCommForumStateNetMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements BdSwitchView.a {
    final /* synthetic */ aa cfz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar) {
        this.cfz = aaVar;
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        if (!com.baidu.adp.lib.util.i.gm()) {
            frsActivity = this.cfz.bWH;
            frsActivity.showToast(r.j.neterror);
            return;
        }
        RequestSetCommForumStateNetMessage requestSetCommForumStateNetMessage = new RequestSetCommForumStateNetMessage();
        frsActivity2 = this.cfz.bWH;
        requestSetCommForumStateNetMessage.setForumId(com.baidu.adp.lib.h.b.c(frsActivity2.getForumId(), 0L));
        if (switchState == BdSwitchView.SwitchState.ON) {
            requestSetCommForumStateNetMessage.setOperation(1);
        } else {
            requestSetCommForumStateNetMessage.setOperation(0);
        }
        frsActivity3 = this.cfz.bWH;
        frsActivity3.sendMessage(requestSetCommForumStateNetMessage);
    }
}
