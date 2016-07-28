package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ar extends CustomMessageListener {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(FrsActivity frsActivity, int i) {
        super(i);
        this.bEL = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.j.p pVar;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        bq bqVar;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.z) && this.bEL.bDM != null) {
            this.bEL.bDM.c((com.baidu.tieba.tbadkCore.z) customResponsedMessage.getData());
            pVar = this.bEL.bDY;
            pVar.f(this.bEL.bDM);
            dVar = this.bEL.bEc;
            bqVar = this.bEL.bDK;
            dVar.a(bqVar.getListView(), this.bEL.bDM, this.bEL.bDX.aaj());
        }
    }
}
