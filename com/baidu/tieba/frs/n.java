package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class n extends a {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(FrsActivity frsActivity, int i, int i2) {
        super(i, i2);
        this.bQi = frsActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.frs.i.aa aaVar;
        com.baidu.tieba.frs.i.aa aaVar2;
        if (responsedMessage instanceof ResponseSetCommForumStateHttpMessage) {
            if (((ResponseSetCommForumStateHttpMessage) responsedMessage).getError() == 0) {
                this.bQi.bPk.rC(1 - this.bQi.bPk.bhL());
                this.bQi.aaL();
            } else {
                this.bQi.showToast(r.j.setdefualt_error);
            }
            aaVar2 = this.bQi.bPv;
            aaVar2.ej(this.bQi.bPk.bhL() == 1);
        } else if (responsedMessage instanceof ResponseSetCommForumStateSocketMessage) {
            if (((ResponseSetCommForumStateSocketMessage) responsedMessage).getError() == 0) {
                this.bQi.bPk.rC(1 - this.bQi.bPk.bhL());
                this.bQi.aaL();
            } else {
                this.bQi.showToast(r.j.setdefualt_error);
            }
            aaVar = this.bQi.bPv;
            aaVar.ej(this.bQi.bPk.bhL() == 1);
        }
    }
}
