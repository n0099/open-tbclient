package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ar extends CustomMessageListener {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(FrsActivity frsActivity, int i) {
        super(i);
        this.bQp = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.i.p pVar;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        bm bmVar;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.y) && this.bQp.bPq != null) {
            this.bQp.bPq.c((com.baidu.tieba.tbadkCore.y) customResponsedMessage.getData());
            pVar = this.bQp.bPC;
            pVar.f(this.bQp.bPq);
            dVar = this.bQp.bPG;
            bmVar = this.bQp.bPo;
            dVar.a(bmVar.getListView(), this.bQp.bPq, this.bQp.bPB.aeU());
        }
    }
}
