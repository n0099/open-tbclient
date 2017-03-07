package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class m extends a {
    final /* synthetic */ FrsActivity bNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(FrsActivity frsActivity, int i, int i2) {
        super(i, i2);
        this.bNU = frsActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.frs.f.ao aoVar;
        com.baidu.tieba.frs.f.ao aoVar2;
        if (responsedMessage instanceof ResponseSetCommForumStateHttpMessage) {
            if (((ResponseSetCommForumStateHttpMessage) responsedMessage).getError() == 0) {
                this.bNU.bMO.rK(1 - this.bNU.bMO.bfx());
                com.baidu.tieba.frs.utils.t.g(this.bNU.bMO);
            } else {
                this.bNU.showToast(w.l.setdefualt_error);
            }
            aoVar2 = this.bNU.bNa;
            aoVar2.em(this.bNU.bMO.bfx() == 1);
        } else if (responsedMessage instanceof ResponseSetCommForumStateSocketMessage) {
            if (((ResponseSetCommForumStateSocketMessage) responsedMessage).getError() == 0) {
                this.bNU.bMO.rK(1 - this.bNU.bMO.bfx());
                com.baidu.tieba.frs.utils.t.g(this.bNU.bMO);
            } else {
                this.bNU.showToast(w.l.setdefualt_error);
            }
            aoVar = this.bNU.bNa;
            aoVar.em(this.bNU.bMO.bfx() == 1);
        }
    }
}
