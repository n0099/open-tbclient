package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class n extends a {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(FrsActivity frsActivity, int i, int i2) {
        super(i, i2);
        this.bQp = frsActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.frs.i.aa aaVar;
        com.baidu.tieba.frs.i.aa aaVar2;
        if (responsedMessage instanceof ResponseSetCommForumStateHttpMessage) {
            if (((ResponseSetCommForumStateHttpMessage) responsedMessage).getError() == 0) {
                this.bQp.bPq.ro(1 - this.bQp.bPq.bhd());
                this.bQp.aax();
            } else {
                this.bQp.showToast(t.j.setdefualt_error);
            }
            aaVar2 = this.bQp.bPD;
            aaVar2.ei(this.bQp.bPq.bhd() == 1);
        } else if (responsedMessage instanceof ResponseSetCommForumStateSocketMessage) {
            if (((ResponseSetCommForumStateSocketMessage) responsedMessage).getError() == 0) {
                this.bQp.bPq.ro(1 - this.bQp.bPq.bhd());
                this.bQp.aax();
            } else {
                this.bQp.showToast(t.j.setdefualt_error);
            }
            aaVar = this.bQp.bPD;
            aaVar.ei(this.bQp.bPq.bhd() == 1);
        }
    }
}
