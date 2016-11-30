package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class j extends a {
    final /* synthetic */ FrsActivity bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(FrsActivity frsActivity, int i, int i2) {
        super(i, i2);
        this.bTa = frsActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.frs.j.af afVar;
        com.baidu.tieba.frs.j.af afVar2;
        if (responsedMessage instanceof ResponseSetCommForumStateHttpMessage) {
            if (((ResponseSetCommForumStateHttpMessage) responsedMessage).getError() == 0) {
                this.bTa.bRX.rV(1 - this.bTa.bRX.bkg());
                com.baidu.tieba.frs.utils.u.h(this.bTa.bRX);
            } else {
                this.bTa.showToast(r.j.setdefualt_error);
            }
            afVar2 = this.bTa.bSj;
            afVar2.ey(this.bTa.bRX.bkg() == 1);
        } else if (responsedMessage instanceof ResponseSetCommForumStateSocketMessage) {
            if (((ResponseSetCommForumStateSocketMessage) responsedMessage).getError() == 0) {
                this.bTa.bRX.rV(1 - this.bTa.bRX.bkg());
                com.baidu.tieba.frs.utils.u.h(this.bTa.bRX);
            } else {
                this.bTa.showToast(r.j.setdefualt_error);
            }
            afVar = this.bTa.bSj;
            afVar.ey(this.bTa.bRX.bkg() == 1);
        }
    }
}
