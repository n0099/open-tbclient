package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class aq extends CustomMessageListener {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(FrsActivity frsActivity, int i) {
        super(i);
        this.bed = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.tbadkCore.p pVar;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.frs.b.a aVar;
        com.baidu.tieba.tbadkCore.p pVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.y)) {
            pVar = this.bed.bdo;
            if (pVar != null) {
                pVar2 = this.bed.bdo;
                pVar2.c((com.baidu.tieba.tbadkCore.y) customResponsedMessage.getData());
                aVar = this.bed.bdB;
                pVar3 = this.bed.bdo;
                aVar.d(pVar3);
            }
        }
    }
}
