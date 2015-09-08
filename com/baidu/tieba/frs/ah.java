package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ah extends CustomMessageListener {
    final /* synthetic */ FrsActivity aVz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(FrsActivity frsActivity, int i) {
        super(i);
        this.aVz = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.frs.c.a aVar;
        com.baidu.tieba.tbadkCore.o oVar3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.x)) {
            oVar = this.aVz.aUN;
            if (oVar != null) {
                oVar2 = this.aVz.aUN;
                oVar2.b((com.baidu.tieba.tbadkCore.x) customResponsedMessage.getData());
                aVar = this.aVz.aVb;
                oVar3 = this.aVz.aUN;
                aVar.c(oVar3);
            }
        }
    }
}
