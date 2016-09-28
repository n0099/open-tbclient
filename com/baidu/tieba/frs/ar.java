package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ar extends CustomMessageListener {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(FrsActivity frsActivity, int i) {
        super(i);
        this.bQi = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.i.p pVar;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        bm bmVar;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.y) && this.bQi.bPk != null) {
            this.bQi.bPk.c((com.baidu.tieba.tbadkCore.y) customResponsedMessage.getData());
            pVar = this.bQi.bPu;
            pVar.f(this.bQi.bPk);
            dVar = this.bQi.bPy;
            bmVar = this.bQi.bPi;
            dVar.a(bmVar.abN(), this.bQi.bPk, this.bQi.bPt.afi());
        }
    }
}
