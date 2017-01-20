package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ag extends CustomMessageListener {
    final /* synthetic */ FrsActivity bGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(FrsActivity frsActivity, int i) {
        super(i);
        this.bGL = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.frs.f.u uVar;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.v) && this.bGL.bFG != null) {
            this.bGL.bFG.c((com.baidu.tieba.tbadkCore.v) customResponsedMessage.getData());
            uVar = this.bGL.bFR;
            uVar.h(this.bGL.bFG);
            dVar = this.bGL.bFV;
            dVar.a(this.bGL.bFF.Iv(), this.bGL.bFG, this.bGL.bFQ.aca());
        }
    }
}
