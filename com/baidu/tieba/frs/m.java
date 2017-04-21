package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class m extends a {
    final /* synthetic */ FrsActivity bQa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(FrsActivity frsActivity, int i, int i2) {
        super(i, i2);
        this.bQa = frsActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.frs.g.ao aoVar;
        com.baidu.tieba.frs.g.ao aoVar2;
        if (responsedMessage instanceof ResponseSetCommForumStateHttpMessage) {
            if (((ResponseSetCommForumStateHttpMessage) responsedMessage).getError() == 0) {
                this.bQa.bOV.rO(1 - this.bQa.bOV.bhn());
                com.baidu.tieba.frs.f.t.g(this.bQa.bOV);
            } else {
                this.bQa.showToast(w.l.setdefualt_error);
            }
            aoVar2 = this.bQa.bPh;
            aoVar2.ew(this.bQa.bOV.bhn() == 1);
        } else if (responsedMessage instanceof ResponseSetCommForumStateSocketMessage) {
            if (((ResponseSetCommForumStateSocketMessage) responsedMessage).getError() == 0) {
                this.bQa.bOV.rO(1 - this.bQa.bOV.bhn());
                com.baidu.tieba.frs.f.t.g(this.bQa.bOV);
            } else {
                this.bQa.showToast(w.l.setdefualt_error);
            }
            aoVar = this.bQa.bPh;
            aoVar.ew(this.bQa.bOV.bhn() == 1);
        }
    }
}
