package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class l extends a {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(FrsActivity frsActivity, int i, int i2) {
        super(i, i2);
        this.bEL = frsActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.frs.j.aa aaVar;
        com.baidu.tieba.frs.j.aa aaVar2;
        if (responsedMessage instanceof ResponseSetCommForumStateHttpMessage) {
            if (((ResponseSetCommForumStateHttpMessage) responsedMessage).getError() == 0) {
                this.bEL.bDM.qN(1 - this.bEL.bDM.bdz());
                this.bEL.VC();
            } else {
                this.bEL.showToast(u.j.setdefualt_error);
            }
            aaVar2 = this.bEL.bDZ;
            aaVar2.dM(this.bEL.bDM.bdz() == 1);
        } else if (responsedMessage instanceof ResponseSetCommForumStateSocketMessage) {
            if (((ResponseSetCommForumStateSocketMessage) responsedMessage).getError() == 0) {
                this.bEL.bDM.qN(1 - this.bEL.bDM.bdz());
                this.bEL.VC();
            } else {
                this.bEL.showToast(u.j.setdefualt_error);
            }
            aaVar = this.bEL.bDZ;
            aaVar.dM(this.bEL.bDM.bdz() == 1);
        }
    }
}
