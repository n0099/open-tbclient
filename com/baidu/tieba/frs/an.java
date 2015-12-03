package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class an extends CustomMessageListener {
    final /* synthetic */ FrsActivity bag;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(FrsActivity frsActivity, int i) {
        super(i);
        this.bag = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.tbadkCore.p pVar;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.frs.b.a aVar;
        com.baidu.tieba.tbadkCore.p pVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.y)) {
            pVar = this.bag.aZs;
            if (pVar != null) {
                pVar2 = this.bag.aZs;
                pVar2.c((com.baidu.tieba.tbadkCore.y) customResponsedMessage.getData());
                aVar = this.bag.aZF;
                pVar3 = this.bag.aZs;
                aVar.d(pVar3);
            }
        }
    }
}
