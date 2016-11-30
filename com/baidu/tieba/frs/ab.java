package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ab extends CustomMessageListener {
    final /* synthetic */ FrsActivity bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(FrsActivity frsActivity, int i) {
        super(i);
        this.bTa = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.j.n nVar;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.y) && this.bTa.bRX != null) {
            this.bTa.bRX.c((com.baidu.tieba.tbadkCore.y) customResponsedMessage.getData());
            nVar = this.bTa.bSi;
            nVar.i(this.bTa.bRX);
            dVar = this.bTa.bSm;
            dVar.a(this.bTa.bRW.acW(), this.bTa.bRX, this.bTa.bSh.agx());
        }
    }
}
