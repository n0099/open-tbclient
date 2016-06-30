package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class l extends a {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(FrsActivity frsActivity, int i, int i2) {
        super(i, i2);
        this.bDB = frsActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.frs.i.aa aaVar;
        com.baidu.tieba.tbadkCore.p pVar;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.tbadkCore.p pVar3;
        com.baidu.tieba.frs.i.aa aaVar2;
        com.baidu.tieba.tbadkCore.p pVar4;
        com.baidu.tieba.tbadkCore.p pVar5;
        com.baidu.tieba.tbadkCore.p pVar6;
        if (responsedMessage instanceof ResponseSetCommForumStateHttpMessage) {
            if (((ResponseSetCommForumStateHttpMessage) responsedMessage).getError() == 0) {
                pVar5 = this.bDB.bCF;
                pVar6 = this.bDB.bCF;
                pVar5.qs(1 - pVar6.bal());
                this.bDB.Vm();
            } else {
                this.bDB.showToast(u.j.setdefualt_error);
            }
            aaVar2 = this.bDB.bCS;
            pVar4 = this.bDB.bCF;
            aaVar2.dM(pVar4.bal() == 1);
        } else if (responsedMessage instanceof ResponseSetCommForumStateSocketMessage) {
            if (((ResponseSetCommForumStateSocketMessage) responsedMessage).getError() == 0) {
                pVar2 = this.bDB.bCF;
                pVar3 = this.bDB.bCF;
                pVar2.qs(1 - pVar3.bal());
                this.bDB.Vm();
            } else {
                this.bDB.showToast(u.j.setdefualt_error);
            }
            aaVar = this.bDB.bCS;
            pVar = this.bDB.bCF;
            aaVar.dM(pVar.bal() == 1);
        }
    }
}
