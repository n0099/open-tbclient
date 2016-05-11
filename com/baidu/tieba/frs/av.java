package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.view.BdExpandListView;
/* loaded from: classes.dex */
class av extends CustomMessageListener {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av(FrsActivity frsActivity, int i) {
        super(i);
        this.bhl = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.frs.h.m mVar;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.frs.entelechy.b.d dVar;
        cn cnVar;
        com.baidu.tieba.tbadkCore.o oVar4;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.y)) {
            oVar = this.bhl.bgq;
            if (oVar != null) {
                oVar2 = this.bhl.bgq;
                oVar2.c((com.baidu.tieba.tbadkCore.y) customResponsedMessage.getData());
                mVar = this.bhl.bgE;
                oVar3 = this.bhl.bgq;
                mVar.e(oVar3);
                dVar = this.bhl.bgI;
                cnVar = this.bhl.bgo;
                BdExpandListView QR = cnVar.QR();
                oVar4 = this.bhl.bgq;
                dVar.a(QR, oVar4);
            }
        }
    }
}
